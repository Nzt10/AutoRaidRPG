package com.example.autoraidrpg.gameplay.battle;

import android.content.Context;

import com.example.autoraidrpg.database.DatabaseHelper;
import com.example.autoraidrpg.database.dao.cloud.StageCloudDAO;
import com.example.autoraidrpg.database.dao.cloud.UserCloudDAO;
import com.example.autoraidrpg.database.dao.local.StageLocalDAO;
import com.example.autoraidrpg.database.dao.local.UserLocalDAO;
import com.example.autoraidrpg.gameplay.entity.Entity;
import com.example.autoraidrpg.gameplay.formation.BattleFormation;
import com.example.autoraidrpg.gameplay.global.BattleInformationObserver;
import com.example.autoraidrpg.gameplay.global.StageObserver;
import com.example.autoraidrpg.gameplay.inspector.DeathInspector;
import com.example.autoraidrpg.gameplay.stage.Stage;
import com.example.autoraidrpg.gameplay.subject.BattleSubject;
import com.example.autoraidrpg.model.User;

import java.util.List;
import java.util.Queue;
import java.util.function.BiConsumer;

public class Battle {

    private final int MAX_ROUND = 200;

    private BattleFormation leftFormation, rightFormation;
    private List<Entity> leftParty, rightParty;
    private DeathInspector leftDeathInspector, rightDeathInspector;
    private SpeedGauge speedGauge;
    private TurnManager turnManager;
    private Thread thread;
    private List<Thread> threads;
    private BiConsumer<String, String> biConsumer;
    private String result = "";
    private boolean win = false;
    private DatabaseHelper databaseHelper;
    private User user;

    // observers
    private final BattleSubject battleSubject;
    
    public Battle(BattleFormation leftFormation, BattleFormation rightFormation) {
        this.leftFormation = leftFormation;
        this.rightFormation = rightFormation;
        
        // set global observer
        battleSubject = BattleInformationObserver.getInstance();
    }

    public void dao(DatabaseHelper databaseHelper, User user) {
        this.databaseHelper = databaseHelper;
        this.user = user;
    }

    public void setFinishedBiConsumer(BiConsumer<String, String> biConsumer) {
        this.biConsumer = biConsumer;
    }

    public void setThread(Thread thread) { this.thread = thread; }

    public void setThreads(List<Thread> threads) {
        this.threads = threads;
    }

    public void setSpeedGauge(SpeedGauge speedGauge) {
        this.speedGauge = speedGauge;

        // set formation
        leftParty = leftFormation.setAndGetParty();
        rightParty = rightFormation.setAndGetParty();
        turnManager = new TurnManager();

        // deploy
        deploy(leftParty);
        deploy(rightParty);

        leftDeathInspector = new DeathInspector(leftFormation, leftParty);
        rightDeathInspector = new DeathInspector(rightFormation, rightParty);

        this.speedGauge.init();
    }

    // deploy all parties in speed gauge
    private void deploy(List<Entity> party) {
        party.stream().forEach(e -> {
            if(e != null) {
                speedGauge.add(e);
                e.getSkillManager().initializePassives();
            }
        }); 
    }

    // start the battle
    public void startBattle() {

        if(speedGauge != null) {

            Queue<Entity> readyEntities;
            Entity e;

            outer: while(true) {

                speedGauge.start();
                readyEntities = speedGauge.moveAndQueue();

                while((e = readyEntities.poll()) != null) {

                    turnManager.prepareTurn(e); // prepare for a turn

                    if(turnManager.startTurn()) // start a turn
                        turnManager.mainTurn(leftFormation, rightFormation); // make a turn if able to move

                    turnManager.endTurn(speedGauge.getMaxSpeedMeter()); // end turn
                }

                leftDeathInspector.inspect();
                rightDeathInspector.inspect();

                if(battleSubject.getCurrentObserver().getRound() > MAX_ROUND) {
                    result += "You LOSE! Finished " + MAX_ROUND + " rounds.";
                    win = false;
                    break outer;
                }

                if(leftDeathInspector.isAllDead()) {
                    result += "You LOSE this battle! please try again.";
                    win = false;
                    break outer;
                }

                if(rightDeathInspector.isAllDead()) {
                    result += "You WIN this battle! Congratulations!";
                    win = true;
                    break outer;
                }

                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }

            }

            endBattle();

        }

    }

    // end the battle
    private void endBattle() {
        if(thread != null) {
            thread.interrupt();
            threads.forEach(t -> t.interrupt());
            threads.clear(); // removed all finished threads

            // trigger ending results
            Stage stage = StageObserver.getInstance();
            Stage.Reward reward = new Stage.Reward(0, 0, 0);
            String rewardCoins = "";
            String rewardExp = "";
            String rewardDiamonds = "";

            if(win) {
                switch (stage.getState()) {
                    case CAMPAIGN:
                        reward = stage.getReward();
                        break;
                    case PVP:
                        // set pvp rewards
                        reward = new Stage.Reward(0, 0, 1);
                        break;
                }

                rewardCoins = reward.getCoin() + " coins";
                rewardExp = reward.getExp() + " exp";
                rewardDiamonds = reward.getDiamond() <= 0 ? "" : reward.getDiamond() + " diamonds";

                // update stage
                com.example.autoraidrpg.model.Stage stageData = new com.example.autoraidrpg.model.Stage(user.getId(), stage.getLevel()); // new stage
                com.example.autoraidrpg.model.Stage retrievedStage = StageLocalDAO.retrieve(databaseHelper, user.getId());
                // com.example.autoraidrpg.model.Stage retrievedStage = new StageCloudDAO(context).retrieveByUserID(user.getFirebaseID());

                // check if the stage played was the latest
                if(stageData.getValue() >= retrievedStage.getValue()) {
                    stageData.increment();
                    StageLocalDAO.update(databaseHelper, stageData);
                    // new StageCloudDAO(context).put(stageData.getUserFirebaseID(), stageData);
                } else {
                    switch (stage.getState()) {
                        case CAMPAIGN:
                            rewardCoins = reward.getHalfCoin() + " coins";
                            rewardExp = reward.getHalfExp() + " exp \n(Only 50%! You've already received the reward.)";
                            rewardDiamonds = reward.getDiamond() <= 0 ? "" : "You've already received the diamond reward.";
                            break;
                        case PVP:
                            // set pvp rewards
                            rewardCoins = "";
                            rewardExp = "";
                            rewardDiamonds = reward.getDiamond() + " diamond";
                            break;
                    }
                }

                // update user resource
                user.addGold(reward.getCoin());
                user.addExp(reward.getExp());
                user.addDiamond(reward.getDiamond());
                UserLocalDAO.update(databaseHelper, user);
                // new UserCloudDAO(context).put(user.getFirebaseID(), user);
            }

            this.biConsumer.accept(result,  String.format("%s%n%s%n%s", rewardCoins, rewardExp, rewardDiamonds));
        }
    }

}
