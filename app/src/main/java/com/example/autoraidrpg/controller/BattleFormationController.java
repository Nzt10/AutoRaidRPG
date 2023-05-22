package com.example.autoraidrpg.controller;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.autoraidrpg.BattleActivity;
import com.example.autoraidrpg.BattleFormationActivity;
import com.example.autoraidrpg.IView;
import com.example.autoraidrpg.R;
import com.example.autoraidrpg.adapter.PreparationCharacterCardAdapter;
import com.example.autoraidrpg.adapter.PreparationUnitInfoAdapter;
import com.example.autoraidrpg.adapter.SkillCardAdapter;
import com.example.autoraidrpg.database.DatabaseHelper;
import com.example.autoraidrpg.database.dao.local.BagLocalDAO;
import com.example.autoraidrpg.database.dao.local.FormationLocalDAO;
import com.example.autoraidrpg.database.dao.local.InventoryLocalDAO;
import com.example.autoraidrpg.database.dao.local.ItemLocalDAO;
import com.example.autoraidrpg.database.dao.local.PositionLocalDAO;
import com.example.autoraidrpg.database.dao.local.RoleCollectionLocalDAO;
import com.example.autoraidrpg.database.dao.local.RoleLocalDAO;
import com.example.autoraidrpg.executors.LoadImageTask;
import com.example.autoraidrpg.executors.SetImageTask;
import com.example.autoraidrpg.gameplay.bag.Inventory;
import com.example.autoraidrpg.gameplay.bag.Item;
import com.example.autoraidrpg.gameplay.bag.ItemFactory;
import com.example.autoraidrpg.gameplay.entity.Entity;
import com.example.autoraidrpg.gameplay.entity.role.RoleFactory;
import com.example.autoraidrpg.gameplay.formation.BattleFormation;
import com.example.autoraidrpg.gameplay.formation.battleFormationTypes.FormationType;
import com.example.autoraidrpg.gameplay.formation.battleFormationTypes.RoleFormation;
import com.example.autoraidrpg.model.Bag;
import com.example.autoraidrpg.model.Formation;
import com.example.autoraidrpg.model.Position;
import com.example.autoraidrpg.model.Role;
import com.example.autoraidrpg.model.RoleCollection;
import com.example.autoraidrpg.model.User;
import com.example.autoraidrpg.population.RolePopulation;
import com.example.autoraidrpg.utils.StarUtils;
import com.example.autoraidrpg.utils.UnitUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class BattleFormationController extends Controller {

    private BattleFormationActivity activity;
    private Entity currentEntity;
    private Role currentRole;
    private Formation currentFormation;
    private RoleCollection currentRoleCollection;
    private BattleFormation allies;
    private List<Entity> entities;
    private List<RoleCollection> roleCollections;
    private List<Role> roles;
    private List<Formation> formations;
    private Map<String, PreparationUnitInfoAdapter> mapNames;
    private Map<Integer, List<PreparationUnitInfoAdapter>> mapNamesList;

    // view list
    private List<View> frontlinerViews;
    private List<View> backlinerViews;

    // database helper
    private DatabaseHelper databaseHelper;
    private ExecutorService executors;
    private User user;

    public BattleFormationController(IView view) {
        super(view);
    }

    @Override
    public void init() {
        activity = (BattleFormationActivity) view;
        executors = Executors.newFixedThreadPool(LoadImageTask.NUMBER_OF_THREADS);

        // retrieve authenticated user session
        databaseHelper = new DatabaseHelper(activity.getApplicationContext());
        user = user(activity, databaseHelper);

        setAuthHeader(activity.getMainHeader(), "Prepare for Battle! Set up your OWN formation!");

        // entities & views
        entities = new ArrayList<>();
        mapNames = new HashMap<>();
        mapNamesList = new HashMap<>();

        frontlinerViews = new ArrayList<>();
        backlinerViews = new ArrayList<>();

        // retrieve authenticated user session
        databaseHelper = new DatabaseHelper(activity.getApplicationContext());
        User user = user(activity, databaseHelper);
        roleCollections = RoleCollectionLocalDAO.all(databaseHelper, user.getId());
        roles = RoleLocalDAO.allByRoleCollections(databaseHelper, roleCollections);

        RolePopulation.roleCollection(roles, entities);

        // init stats
        AtomicInteger rcIndex = new AtomicInteger(0);

        roleCollections.forEach(rc -> {
            Entity tempEntity = entities.get(rcIndex.getAndIncrement());
            tempEntity.setLevel(rc.getLevel()).setRating(rc.getRating());

            // equip items
            Bag currentBag = BagLocalDAO.retrieve(databaseHelper, rc.getId());
            Inventory inventory = tempEntity.getInventory();

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

            tempEntity.initStats();
        });
        // OrderUtils.sortByNames(entities);

        // retrieve battle formation
        formations = FormationLocalDAO.all(databaseHelper, user.getId());
        AtomicInteger formationCount = new AtomicInteger(0);

        // formation retrieval functionality
        formations.forEach(formation -> {
            int index = formationCount.getAndIncrement();

            // get all positions
            List<Position> positions = new ArrayList<>();
            positions.add(PositionLocalDAO.getByID(databaseHelper, formation.getPositionID_A()));
            positions.add(PositionLocalDAO.getByID(databaseHelper, formation.getPositionID_B()));
            positions.add(PositionLocalDAO.getByID(databaseHelper, formation.getPositionID_C()));
            positions.add(PositionLocalDAO.getByID(databaseHelper, formation.getPositionID_D()));
            positions.add(PositionLocalDAO.getByID(databaseHelper, formation.getPositionID_E()));

            // set role collections
            List<RoleCollection> roleCollectionList = new ArrayList<>();
            positions.forEach(position -> {
                if(position.getIndex() != -1) roleCollectionList.add(RoleCollectionLocalDAO.retrieve(databaseHelper, user.getId(), position.getRoleCollectionID()));
                else roleCollectionList.add(null);
            });

            // set prepared units
            List<PreparationUnitInfoAdapter> preparedUnitInfoList = new ArrayList<>();
            for(int i = 0; i < roleCollectionList.size(); i++) {
                RoleCollection tempRC = roleCollectionList.get(i);

                if(tempRC != null) {
                    preparedUnitInfoList.add(
                            new PreparationUnitInfoAdapter(
                                    RoleLocalDAO.retrieve(databaseHelper, tempRC.getRoleID()), tempRC, positions.get(i)
                            )
                    );
                }
            }

            // set it to the map names list
            mapNamesList.put(index, preparedUnitInfoList);
        });

        // set up battle slots
        frontlinerViews.add(activity.findViewById(R.id.leftFrontliner1));
        frontlinerViews.add(activity.findViewById(R.id.leftFrontliner2));
        frontlinerViews.add(activity.findViewById(R.id.leftFrontliner3));

        backlinerViews.add(activity.findViewById(R.id.leftBackliner1));
        backlinerViews.add(activity.findViewById(R.id.leftBackliner2));
        backlinerViews.add(activity.findViewById(R.id.leftBackliner3));

        // set up battle units
        allies = new RoleFormation(FormationType.LEFT);
        setUpBattleUnits(frontlinerViews, true);
        setUpBattleUnits(backlinerViews, false);
        mapNames = mapNamesList.get(0).stream().collect(Collectors.toMap(key -> key.getRole().getName(), value -> value));
        currentFormation = formations.get(0);
        setUpFormation();

        // recycler view current role collection
        setRecyclerViews();

        // set character description
        setDescription(0);

        setFormationOnClickListener(activity.getFormationA(), 0);
        setFormationOnClickListener(activity.getFormationB(), 1);
        setFormationOnClickListener(activity.getFormationC(), 2);
        setFormationOnClickListener(activity.getFormationD(), 3);
        setFormationOnClickListener(activity.getFormationE(), 4);

        activity.getBackBtn().setOnClickListener(v -> activity.finish());
        activity.getBattleBtn().setOnClickListener(v -> battleStart());
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

    @Override
    public void setRecyclerViews() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(activity, 2, LinearLayoutManager.VERTICAL, false);
        PreparationCharacterCardAdapter preparationCharacterCardAdapter = new PreparationCharacterCardAdapter(activity, entities, this::setDescription);
        setAdapter(activity.getRecyclerViewSide(), gridLayoutManager, preparationCharacterCardAdapter);
        preparationCharacterCardAdapter.notifyDataSetChanged();
    }

    @SuppressLint("NotifyDataSetChanged")
    private void setDescription(int index) {
        setCurrentUnit(index);

        // set description
        executors.execute(new SetImageTask(activity, activity.getUnitImageBtn(), currentEntity.getRoleImage()));
        activity.getRoleName().setText(currentEntity.getName());
        activity.getLevel().setText("Level " + String.valueOf(currentEntity.getLevel()));
        UnitUtils.setStats(currentEntity, activity);

        // recycler view role description
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false);
        SkillCardAdapter skillCardAdapter = new SkillCardAdapter(activity, UnitUtils.setAndGetSkills(currentEntity.getSkillManager()));

        activity.getRecyclerViewBottom().setLayoutManager(linearLayoutManager);
        activity.getRecyclerViewBottom().setAdapter(skillCardAdapter);
        skillCardAdapter.notifyDataSetChanged();
    }

    // formation buttons functionality
    private void setFormationOnClickListener(Button formationBtn, int formationIndex) {
        formationBtn.setOnClickListener(v -> {
            // set current formations
            mapNames = mapNamesList.get(formationIndex).stream().collect(Collectors.toMap(key -> key.getRole().getName(), value -> value));
            currentFormation = formations.get(formationIndex);

            // empty formation from front and back line
            AtomicInteger viewIndex = new AtomicInteger(0);

            // empty front
            frontlinerViews.forEach(frontlinerView -> {
                int index = viewIndex.getAndIncrement();
                ImageButton unitImageBtn = frontlinerView.findViewById(R.id.unitImageBtn);
                ProgressBar healthBar = frontlinerView.findViewById(R.id.healthBar);
                removeUnit(unitImageBtn, frontlinerView, healthBar, index, true);
            });

            viewIndex.set(0);

            // empty back
            backlinerViews.forEach(backlinerView -> {
                int index = viewIndex.getAndIncrement();
                ImageButton unitImageBtn = backlinerView.findViewById(R.id.unitImageBtn);
                ProgressBar healthBar = backlinerView.findViewById(R.id.healthBar);
                removeUnit(unitImageBtn, backlinerView, healthBar, index, false);
            });

            // set retrieved formation
            setUpFormation();
        });
    }

    // set up all formation
    private void setUpFormation() {
        mapNames.forEach((key, unitAdapter) -> {
            Role preparedRole = unitAdapter.getRole();
            // RoleCollection preparedRoleCollection = unitAdapter.getRoleCollection();
            Position position = unitAdapter.getPosition();
            Entity preparedUnit = RoleFactory.makeRole(preparedRole.getName());
            View unitView;

            if (position.isFront()) {
                unitView = frontlinerViews.get(position.getIndex());
                allies.addToFront(position.getIndex(), preparedUnit, null, null);
            } else {
                unitView = backlinerViews.get(position.getIndex());
                allies.addToBack(position.getIndex(), preparedUnit, null, null);
            }

            ImageButton unitImageBtn = unitView.findViewById(R.id.unitImageBtn);
            ProgressBar healthBar = unitView.findViewById(R.id.healthBar);

            executors.execute(new SetImageTask(activity, unitImageBtn, preparedUnit.getRoleImage()));
            healthBar.setMax((int) preparedUnit.getBasedHp());
            healthBar.setProgress((int) preparedUnit.getHp());

            // set rating
            StarUtils.rewriteStar(unitView, preparedUnit.getRating());
        });
    }

    private void setCurrentUnit(int index) {
        currentEntity = entities.get(index);
        currentRole = roles.get(index);
        currentRoleCollection = roleCollections.get(index);
    }

    // set up battle units with on click listener
    private void setUpBattleUnits(List<View> unitViews, boolean front) {

        // set up battle units
        AtomicInteger viewIndex = new AtomicInteger(0);

        unitViews.forEach(unitView -> {
            int index = viewIndex.getAndIncrement();
            ImageButton unitImageBtn = unitView.findViewById(R.id.unitImageBtn);
            ProgressBar healthBar = unitView.findViewById(R.id.healthBar);
            removeUnit(unitImageBtn, unitView, healthBar, index, front);

            unitImageBtn.setOnClickListener(a -> {

                if(healthBar.getMax() != 0) {
                    // set entity to battle slot
                    Entity removedUnit = removeUnit(unitImageBtn, unitView, healthBar, index, front);
                    mapNames.remove(removedUnit.getName());
                } else {
                    // check if slots are full
                    if(mapNames.size() >= BattleFormationActivity.MAX_UNIT) {
                        @SuppressLint("DefaultLocale")
                        Toast toast = Toast.makeText(activity.getApplicationContext(),
                                String.format("You can only deploy %d units.", BattleFormationActivity.MAX_UNIT), Toast.LENGTH_SHORT);
                        toast.show();
                        return; // stop the function
                    }

                    // check if the unit has already exist
                    if(mapNames.containsKey(currentEntity.getName())) {
                        Toast toast = Toast.makeText(activity.getApplicationContext(),
                                String.format("%s was already exist.", currentEntity.getName()), Toast.LENGTH_SHORT);
                        toast.show();
                        return; // stop the function
                    }

                    // set new entity in the battle formation
                    mapNames.put(currentEntity.getName(), new PreparationUnitInfoAdapter(
                            currentRole, currentRoleCollection, new Position(-1, currentRoleCollection.getId(), index, front))
                    );

                    // set event when the slot has unit for erasure
                    executors.execute(new SetImageTask(activity, unitImageBtn, currentEntity.getRoleImage()));
                    healthBar.setMax((int) currentEntity.getBasedHp());
                    healthBar.setProgress((int) currentEntity.getHp());

                    // set rating
                    StarUtils.rewriteStar(unitView, currentEntity.getRating());

                    if(front) allies.addToFront(index, currentEntity, null, null);
                    else allies.addToBack(index, currentEntity, null, null);
                }

            });
        });

    }

    private Entity removeUnit(ImageButton unitImageBtn, View ratingView, ProgressBar healthBar, int index, boolean front) {
        executors.execute(new SetImageTask(activity, unitImageBtn, R.color.dark_gray));
        healthBar.setMax(0);
        healthBar.setProgress(0);

        // set rating to 0
        StarUtils.rewriteStar(ratingView, 0);

        if(front) return allies.addToFront(index, null, null, null);
        return allies.addToBack(index, null, null, null);
    }

    private void battleStart() {

        // validations
        if(mapNames.isEmpty()) {
            Toast toast = Toast.makeText(activity.getApplicationContext(),
                    String.format("You have no prepared units.", currentEntity.getName()), Toast.LENGTH_SHORT);
            toast.show();
            return; // stop the function
        }

        // get all positions
        List<Position> positions = new ArrayList<>();
        positions.add(PositionLocalDAO.getByID(databaseHelper, currentFormation.getPositionID_A()));
        positions.add(PositionLocalDAO.getByID(databaseHelper, currentFormation.getPositionID_B()));
        positions.add(PositionLocalDAO.getByID(databaseHelper, currentFormation.getPositionID_C()));
        positions.add(PositionLocalDAO.getByID(databaseHelper, currentFormation.getPositionID_D()));
        positions.add(PositionLocalDAO.getByID(databaseHelper, currentFormation.getPositionID_E()));

        // set preparation unit adapter
        List<PreparationUnitInfoAdapter> values = new ArrayList<>(mapNames.values());

        for(int i = 0; i < RolePopulation.FORMATION_SIZE; i++) {
            Position position;
            try {
                PreparationUnitInfoAdapter unitAdapter = values.get(i);
                position = unitAdapter.getPosition();
                position.setId(positions.get(i).getId());
                PositionLocalDAO.update(databaseHelper, position);
            } catch (IndexOutOfBoundsException ex) {
                position = positions.get(i);
                PositionLocalDAO.updateEmpty(databaseHelper, position.getId(), position.getRoleCollectionID());
            }
        }

        // proceed to battle page
        Intent intent = new Intent(activity.getApplicationContext(), BattleActivity.class);
        intent.putExtra("preparedUnits", new ArrayList<>(mapNames.values()));
        activity.startActivity(intent);
    }

}
