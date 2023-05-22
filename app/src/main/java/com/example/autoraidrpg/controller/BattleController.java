package com.example.autoraidrpg.controller;

import android.content.Intent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ProgressBar;

import com.example.autoraidrpg.BattleActivity;
import com.example.autoraidrpg.BattleResultActivity;
import com.example.autoraidrpg.IView;
import com.example.autoraidrpg.R;
import com.example.autoraidrpg.adapter.PreparationUnitInfoAdapter;
import com.example.autoraidrpg.database.DatabaseHelper;
import com.example.autoraidrpg.database.dao.local.BagLocalDAO;
import com.example.autoraidrpg.database.dao.local.InventoryLocalDAO;
import com.example.autoraidrpg.database.dao.local.ItemLocalDAO;
import com.example.autoraidrpg.executors.LoadImageTask;
import com.example.autoraidrpg.executors.SetImageTask;
import com.example.autoraidrpg.gameplay.bag.Inventory;
import com.example.autoraidrpg.gameplay.bag.Item;
import com.example.autoraidrpg.gameplay.bag.ItemFactory;
import com.example.autoraidrpg.gameplay.battle.Battle;
import com.example.autoraidrpg.gameplay.battle.SpeedGauge;
import com.example.autoraidrpg.gameplay.entity.Entity;
import com.example.autoraidrpg.gameplay.entity.role.RoleFactory;
import com.example.autoraidrpg.gameplay.formation.BattleFormation;
import com.example.autoraidrpg.gameplay.formation.battleFormationTypes.FormationType;
import com.example.autoraidrpg.gameplay.formation.battleFormationTypes.RoleFormation;
import com.example.autoraidrpg.gameplay.global.BattleInformationObserver;
import com.example.autoraidrpg.gameplay.global.StageObserver;
import com.example.autoraidrpg.gameplay.global.StageState;
import com.example.autoraidrpg.gameplay.observer.BattleRoundObserver;
import com.example.autoraidrpg.gameplay.stage.Stage;
import com.example.autoraidrpg.gameplay.subject.BattleSubject;
import com.example.autoraidrpg.model.Bag;
import com.example.autoraidrpg.model.RoleCollection;
import com.example.autoraidrpg.model.User;
import com.example.autoraidrpg.utils.StarUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.BiConsumer;

public class BattleController extends Controller {

    private BattleActivity activity;
    private List<View> frontlinerLeftViews, backlinerLeftViews, frontlinerRightViews, backlinerRightViews;
    private List<PreparationUnitInfoAdapter> preparedUnits;

    private List<Thread> threads;
    private DatabaseHelper databaseHelper;
    private User user;
    private ExecutorService executor;

    public BattleController(IView view) {
        super(view);
    }

    @Override
    public void init() {
        activity = (BattleActivity) view;
        executor = Executors.newFixedThreadPool(LoadImageTask.NUMBER_OF_THREADS);

        Intent intent = activity.getIntent();
        threads = new ArrayList<>();

        // retrieve authenticated user session
        databaseHelper = new DatabaseHelper(activity.getApplicationContext());
        user = user(activity, databaseHelper);

        // set up names
        preparedUnits = (List<PreparationUnitInfoAdapter>) intent.getSerializableExtra("preparedUnits");

        // entities & views
        frontlinerRightViews = new ArrayList<>();
        backlinerRightViews = new ArrayList<>();
        frontlinerLeftViews = new ArrayList<>();
        backlinerLeftViews = new ArrayList<>();

        setBattleSlot();
        setBattleFormation();
    }

    @Override
    public void setRecyclerViews() {}

    // set battle slot
    private void setBattleSlot() {

        // set up battle slots
        frontlinerLeftViews.add(activity.findViewById(R.id.leftFrontliner1));
        frontlinerLeftViews.add(activity.findViewById(R.id.leftFrontliner2));
        frontlinerLeftViews.add(activity.findViewById(R.id.leftFrontliner3));

        backlinerLeftViews.add(activity.findViewById(R.id.leftBackliner1));
        backlinerLeftViews.add(activity.findViewById(R.id.leftBackliner2));
        backlinerLeftViews.add(activity.findViewById(R.id.leftBackliner3));

        frontlinerRightViews.add(activity.findViewById(R.id.rightFrontliner1));
        frontlinerRightViews.add(activity.findViewById(R.id.rightFrontliner2));
        frontlinerRightViews.add(activity.findViewById(R.id.rightFrontliner3));

        backlinerRightViews.add(activity.findViewById(R.id.rightBackliner1));
        backlinerRightViews.add(activity.findViewById(R.id.rightBackliner2));
        backlinerRightViews.add(activity.findViewById(R.id.rightBackliner3));

    }

    // set battle formation
    private void setBattleFormation() {

        // set global observer
        BattleSubject battleSubject = BattleInformationObserver.getInstance().setTextViewBiConsumer((round, descriptions) -> {

            Thread newThread = new Thread(new Runnable() {

                @Override
                public void run() {

                    try {
                        synchronized (this) {
                            wait(1000);

                            activity.runOnUiThread(() -> {

                                String title = "";
                                StringBuilder info = new StringBuilder();

                                for(int i = 0; i < descriptions.size(); i++) {
                                    if(i == 0) title = descriptions.get(i);
                                    else info.append(descriptions.get(i)).append("\n");
                                }

                                activity.getRoundNum().setText(String.valueOf(round));
                                activity.getRoundGauge().setProgress(round);
                                activity.getUnitTurn().setText(title);
                                activity.getTurnDescription().setText(info.toString());

                            });

                        }

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            });

            threads.add(newThread);
            newThread.start();

        });

        new BattleRoundObserver(battleSubject); // get new observer

        // setup formation
        BattleFormation allies = new RoleFormation(FormationType.LEFT); // your party
        BattleFormation hostiles = new RoleFormation(FormationType.RIGHT); // hostile party

        // setup allies
        for(int i = 0; i < preparedUnits.size(); i++) {
            PreparationUnitInfoAdapter unitInfo = preparedUnits.get(i);
            Entity unit = RoleFactory.makeRole(unitInfo.getRole().getName());

            // set stats
            RoleCollection roleCollection = unitInfo.getRoleCollection();
            int level = roleCollection.getLevel();
            int rating = roleCollection.getRating();
            unit.setLevel(level).setRating(rating);

            // equip items
            Bag currentBag = BagLocalDAO.retrieve(databaseHelper, roleCollection.getId());
            Inventory inventory = unit.getInventory();

            // set existing items at the bag
            equipItem(inventory, currentBag.getInventoryID_A(), 0);
            equipItem(inventory, currentBag.getInventoryID_B(), 1);
            equipItem(inventory, currentBag.getInventoryID_C(), 2);
            equipItem(inventory, currentBag.getInventoryID_D(), 3);
            equipItem(inventory, currentBag.getInventoryID_E(), 4);
            equipItem(inventory, currentBag.getInventoryID_F(), 5);
            equipItem(inventory, currentBag.getInventoryID_G(), 6);
            equipItem(inventory, currentBag.getInventoryID_H(), 7);
            equipItem(inventory, currentBag.getInventoryID_I(), 8);
            equipItem(inventory, currentBag.getInventoryID_G(), 9);
            equipItem(inventory, currentBag.getInventoryID_K(), 10);
            equipItem(inventory, currentBag.getInventoryID_L(), 11);

            unit.initStats();

            if(unitInfo.getPosition().isFront()) allies.addToFront(unitInfo.getPosition().getIndex(), unit, getBasedBattleUnitConsumer(frontlinerLeftViews), getBattleUnitConsumer(frontlinerLeftViews));
            else allies.addToBack(unitInfo.getPosition().getIndex(), unit, getBasedBattleUnitConsumer(backlinerLeftViews), getBattleUnitConsumer(backlinerLeftViews));
        }

        // setup hostile formation by staging
        Stage stage = StageObserver.getInstance();
        stage.setState(StageState.CAMPAIGN);

        for(int i = 0; i < stage.getHostiles().size(); i++) {
            Entity hostile = stage.getHostiles().get(i);
            Stage.Position position = stage.getPositions().get(i);
            hostile.initStats();

            if(position.isFront()) hostiles.addToFront(position.getIndex(), hostile, getBasedBattleUnitConsumer(frontlinerRightViews), getBattleUnitConsumer(frontlinerRightViews));
            else hostiles.addToBack(position.getIndex(), hostile, getBasedBattleUnitConsumer(backlinerRightViews), getBattleUnitConsumer(backlinerRightViews));
        }

        // speed gauge
        SpeedGauge speedGauge = new SpeedGauge();

        // battle
        Battle battle = new Battle(allies, hostiles);
        battle.dao(databaseHelper, user);
        battle.setFinishedBiConsumer((result, reward) -> {
            Intent intent = new Intent(activity.getApplicationContext(), BattleResultActivity.class);
            intent.putExtra("result", result);
            intent.putExtra("reward", reward);
            activity.startActivity(intent);
        });

        // battle start
        // threads
        Thread thread = new Thread(battle::startBattle);

        battle.setThread(thread);
        battle.setThreads(threads);
        battle.setSpeedGauge(speedGauge);

        // battle start
        thread.start();

    }

    // equip existing items
    private void equipItem(Inventory inventory, int inventoryID, int index) {
        com.example.autoraidrpg.model.Inventory tempInventory = InventoryLocalDAO.retrieve(databaseHelper, user.getId(), inventoryID);

        if(tempInventory != null) {
            com.example.autoraidrpg.model.Item tempItem = ItemLocalDAO.retrieve(databaseHelper, tempInventory.getItemID());
            Item item = ItemFactory.makeItem(tempItem.getName());
            inventory.equip(item, index); // equip inventory
        }
    }

    // health based battle unit
    private BiConsumer<Integer, Entity> getBasedBattleUnitConsumer(List<View> unitViews) {

        // setup view functional interface
        return (i, e) -> {
            View unitView = unitViews.get(i);
            ImageButton unitImageBtn = unitView.findViewById(R.id.unitImageBtn);
            ProgressBar healthBar = unitView.findViewById(R.id.healthBar);

            // set unit in an empty slot
            setImageAndRating(unitImageBtn, e.getRoleImage(), unitView, e.getRating());
            healthBar.setMax((int) e.getBasedHp());
            healthBar.setProgress((int) e.getHp());
        };

    }

    // actual health battle unit
    private BiConsumer<Integer, Entity> getBattleUnitConsumer(List<View> unitViews) {

        // setup view functional interface
        return (i, e) -> {
            View unitView = unitViews.get(i);
            ImageButton unitImageBtn = unitView.findViewById(R.id.unitImageBtn);
            ProgressBar healthBar = unitView.findViewById(R.id.healthBar);

            // set event when the slot has unit for erasure
            if(!e.isDead()) {
                healthBar.setProgress((int) e.getHp());
                setImageAndRating(unitImageBtn, e.getRoleImage(), unitView, e.getRating());
            } else {
                // set all to 0
                setImageAndRating(unitImageBtn, R.color.dark_gray, unitView, 0);
                healthBar.setProgress(0);
            }
        };

    }

    // setting image resource bypassing thread error
    private void setImageAndRating(ImageButton unitImageBtn, int resource, View ratingView, int rating) {

        Thread newThread = new Thread(() -> activity.runOnUiThread(() -> {
            StarUtils.rewriteStar(ratingView, rating); // set rating
            executor.execute(new SetImageTask(activity, unitImageBtn, resource));
        })
        );

        threads.add(newThread);
        newThread.start();
    }

}
