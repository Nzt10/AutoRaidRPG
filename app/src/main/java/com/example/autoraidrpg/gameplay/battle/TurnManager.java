package com.example.autoraidrpg.gameplay.battle;

import com.example.autoraidrpg.gameplay.entity.Entity;
import com.example.autoraidrpg.gameplay.formation.BattleFormation;
import com.example.autoraidrpg.gameplay.global.BattleInformationObserver;
import com.example.autoraidrpg.gameplay.observer.BattleRoundObserver;
import com.example.autoraidrpg.gameplay.subject.BattleSubject;

public class TurnManager {

    private Entity e;

    // observers
    private BattleSubject battleSubject;
    private BattleRoundObserver roundObserver;

    public TurnManager() {
        // set global observer
        battleSubject = BattleInformationObserver.getInstance();
    }

    // prepare entity
    public void prepareTurn(Entity e) { 
        this.e = e;
    }

    // start of the turn
    public boolean startTurn() {
        if(e.isDead()) return false;

        // start create new observer & update
        roundObserver = new BattleRoundObserver(battleSubject);
        roundObserver.addDescription(String.format("%s's turn.", e.getName()), e.getRoleImage(), e.getRoleImage());

        e.getSkillManager().applyPassives(); // activate conditional passives
        e.getSkillManager().reduceAllCooldown(); // reduce all cooldown
        return e.reduceBuffTurns(); // trigger and reduce buff turns
    }

    // during the turn
    public void mainTurn(BattleFormation leftFormation, BattleFormation rightFormation) {
        switch(e.getFormationType()) {
            case LEFT: rightFormation.moveBy(e, leftFormation.getParty()); break;
            case RIGHT: leftFormation.moveBy(e, rightFormation.getParty()); break;
        }
    }

    // end of the turn
    public void endTurn(double maxSpeedMeter) {
        e.resetMove(e.getSpeedMeter() - maxSpeedMeter);
        battleSubject.notifyObserver(); // notify
    }
    
}
