package com.example.autoraidrpg.controller;

import static android.content.Context.BATTERY_SERVICE;

import android.content.Intent;
import android.os.BatteryManager;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.autoraidrpg.ArenaActivity;
import com.example.autoraidrpg.BattleFormationActivity;
import com.example.autoraidrpg.DiamondShopActivity;
import com.example.autoraidrpg.IView;
import com.example.autoraidrpg.ItemCollectionActivity;
import com.example.autoraidrpg.ItemShopActivity;
import com.example.autoraidrpg.LandingActivity;
import com.example.autoraidrpg.MainActivity;
import com.example.autoraidrpg.R;
import com.example.autoraidrpg.RoleCollectionActivity;
import com.example.autoraidrpg.RoleDescriptionActivity;
import com.example.autoraidrpg.RoleShopActivity;
import com.example.autoraidrpg.StageActivity;
import com.example.autoraidrpg.database.DatabaseHelper;
import com.example.autoraidrpg.database.dao.cloud.RoleCollectionCloudDAO;
import com.example.autoraidrpg.database.dao.local.FormationLocalDAO;
import com.example.autoraidrpg.database.dao.local.PositionLocalDAO;
import com.example.autoraidrpg.database.dao.local.RoleCollectionLocalDAO;
import com.example.autoraidrpg.database.dao.local.RoleLocalDAO;
import com.example.autoraidrpg.executors.LoadItemImageTask;
import com.example.autoraidrpg.executors.SetImageTask;
import com.example.autoraidrpg.gameplay.entity.Entity;
import com.example.autoraidrpg.model.Formation;
import com.example.autoraidrpg.model.Position;
import com.example.autoraidrpg.model.Role;
import com.example.autoraidrpg.model.RoleCollection;
import com.example.autoraidrpg.model.User;
import com.example.autoraidrpg.population.RolePopulation;
import com.example.autoraidrpg.utils.StarUtils;
import com.example.autoraidrpg.utils.UnitUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainController extends Controller {

    private MainActivity activity;
    private List<Entity> teamRoles;
    private List<Position> positions;
    private List<RoleCollection> roleCollections;
    private List<Role> roles;
    private DatabaseHelper databaseHelper;
    private ExecutorService executors;
    public MainController(IView view) {
        super(view);
    }

    @Override
    public void start() {
        // clear
        positions.clear();
        roleCollections.clear();
        roles.clear();
        teamRoles.clear();

        // battery information
        BatteryManager bm = (BatteryManager) activity.getSystemService(BATTERY_SERVICE);
        int batteryPercentage = bm.getIntProperty(BatteryManager.BATTERY_PROPERTY_CAPACITY);
        String message = "Battery: " + batteryPercentage + "%";
        activity.getBatteryText().setText(message);

        // retrieve authenticated user session
        User user = user(activity, databaseHelper);
        setMainHeader(activity.getMainHeader(), user);

        Formation mainFormation = FormationLocalDAO.retrieveFirstFormation(databaseHelper, user.getId());

        positions.add(PositionLocalDAO.getByID(databaseHelper, mainFormation.getPositionID_A()));
        positions.add(PositionLocalDAO.getByID(databaseHelper, mainFormation.getPositionID_B()));
        positions.add(PositionLocalDAO.getByID(databaseHelper, mainFormation.getPositionID_C()));
        positions.add(PositionLocalDAO.getByID(databaseHelper, mainFormation.getPositionID_D()));
        positions.add(PositionLocalDAO.getByID(databaseHelper, mainFormation.getPositionID_E()));

        // retrieve role collections from database
        RoleCollectionCloudDAO roleCollectionCloudDAO = new RoleCollectionCloudDAO(activity);
        positions.forEach(position -> {
            if(position.getIndex() != -1) {
                // roleCollections.add(roleCollectionCloudDAO.retrieve(position.getRoleCollectionFirebaseID()));
                roleCollections.add(RoleCollectionLocalDAO.retrieve(databaseHelper, user.getId(), position.getRoleCollectionID()));
            }
        });

        // retrieve roles from database
        roleCollections.forEach(rc -> roles.add(RoleLocalDAO.retrieve(databaseHelper, rc.getRoleID())));

        // generate formation
        RolePopulation.teamUnit(roles, teamRoles);

        // unit buttons at the upper part
        for(int i = 0; i < teamRoles.size(); i++) {
            Entity role = teamRoles.get(i);
            ImageButton unitImageBtn = activity.getFormations().get(i).findViewById(R.id.unitImageBtn);

            if(role != null) {
                // set rating
                StarUtils.rewriteStar(activity.getFormations().get(i), role.getRating());
                executors.execute(new SetImageTask(activity, unitImageBtn, role.getRoleImage()));
                // executors.execute(new LoadUnitImageTask(activity, unitImageBtn, role.getRoleImage()));

                unitImageBtn.setOnClickListener(v -> {
                    Intent intent = new Intent(activity.getApplicationContext(), RoleDescriptionActivity.class);
                    intent.putExtra("name", role.getName());
                    intent.putExtra("roleDescription", role.getDescription());
                    intent.putExtra("roleImage", role.getRoleImage());
                    intent.putExtra("rating", role.getRating());
                    intent.putExtra("skillInfo", (Serializable) UnitUtils.setAndGetSkills(role.getSkillManager()));
                    activity.startActivity(intent);
                });
            }
        }
    }

    // initialize function
    @Override
    public void init() {
        activity = (MainActivity) view;
        executors = Executors.newFixedThreadPool(LoadItemImageTask.NUMBER_OF_THREADS / 2);
        teamRoles = new ArrayList<>();

        // retrieve authenticated user session
        databaseHelper = new DatabaseHelper(activity.getApplicationContext());

        // battery information
        BatteryManager bm = (BatteryManager) activity.getSystemService(BATTERY_SERVICE);
        int batteryPercentage = bm.getIntProperty(BatteryManager.BATTERY_PROPERTY_CAPACITY);
        String message = "Battery: " + batteryPercentage + "%";
        activity.getBatteryText().setText(message);

        // set lists
        positions = new ArrayList<>();
        roleCollections = new ArrayList<>();
        roles = new ArrayList<>();

        // initialize buttons
        setAndGetMenuBtn(activity.getBattleBtnView(), "BATTLE", R.drawable.background_battle, 0, StageActivity.class); // battle btn
        setAndGetMenuBtn(activity.getArenaBtnView(), "ARENA", R.drawable.background_arena, 0, ArenaActivity.class); // arena btn
        setAndGetMenuBtn(activity.getCharacterShopBtnView(), "CHARACTER\nSHOP", R.drawable.background_tavern, 12, RoleShopActivity.class); // character shop btn
        setAndGetMenuBtn(activity.getItemShopBtnView(), "ITEM\nSHOP", R.drawable.background_item_shop, 12, ItemShopActivity.class); // item shop btn
        setAndGetMenuBtn(activity.getRoleCollectionBtnView(), "ROLE\nCOLLECTION", R.drawable.background_character_merge, 10, RoleCollectionActivity.class); // role collection btn
        setAndGetMenuBtn(activity.getItemCollectionBtnView(), "INVENTORY", R.drawable.background_item_merge, 12, ItemCollectionActivity.class); // inventory btn
        setAndGetMenuBtn(activity.getDiamondShopBtnView(), "DIAMOND\nSHOP", R.drawable.background_diamond_shop, 12, DiamondShopActivity.class); // diamond shop btn
        setAndGetMenuBtn(activity.getBattleFormationBtnView(), "BATTLE\nFORMATION", R.drawable.background_battle_formation, 12, BattleFormationActivity.class); // battle formation btn

        // logout
        activity.getLogoutBtn().setOnClickListener(v -> {
            logout(activity);
            setIntentOnListener(activity, LandingActivity.class);
        });
    }





    @Override
    public void setRecyclerViews() {}

    // reduce redundancy by creating functionality of btn settings
    private void setAndGetMenuBtn(View btnView, String itemText, int backgroundImage, float textSize, Class<?> cls) {
        ImageButton imageButton = btnView.findViewById(R.id.backgroundImage);
        TextView textView = btnView.findViewById(R.id.itemText);

        textView.setText(itemText);
        textView.setTextSize(textSize == 0 ? 15 : textSize);

        executors.execute(new SetImageTask(activity, imageButton, backgroundImage));
        imageButton.setOnClickListener(v -> setIntentOnListener(activity, cls));
    }

}
