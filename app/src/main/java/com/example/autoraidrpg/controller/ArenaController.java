package com.example.autoraidrpg.controller;

import android.widget.Toast;

import com.example.autoraidrpg.ArenaActivity;
import com.example.autoraidrpg.IView;
import com.example.autoraidrpg.R;
import com.example.autoraidrpg.adapter.PreparationUnitInfoAdapter;
import com.example.autoraidrpg.database.DatabaseHelper;
import com.example.autoraidrpg.database.dao.local.FormationLocalDAO;
import com.example.autoraidrpg.database.dao.local.PositionLocalDAO;
import com.example.autoraidrpg.database.dao.local.RoleCollectionLocalDAO;
import com.example.autoraidrpg.database.dao.local.RoleLocalDAO;
import com.example.autoraidrpg.database.dao.local.UserLocalDAO;
import com.example.autoraidrpg.map.Pvp;
import com.example.autoraidrpg.map.RPGMap;
import com.example.autoraidrpg.model.Formation;
import com.example.autoraidrpg.model.Position;
import com.example.autoraidrpg.model.RoleCollection;
import com.example.autoraidrpg.model.User;

import org.osmdroid.views.overlay.mylocation.MyLocationNewOverlay;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class ArenaController extends Controller {
    private MyLocationNewOverlay myLocationOverlay;
    private ArenaActivity activity;
    private User user;
    private List<User> users;
    private List<Formation> formations;
    private DatabaseHelper databaseHelper;
    private RPGMap rpgMap;
    private boolean isEnabled = true;
    private boolean hasBeenSet = false;

    public ArenaController(IView view) {
        super(view);
    }

    @Override
    public void start() {
        // retrieve authenticated user session
        databaseHelper = new DatabaseHelper(activity.getApplicationContext());
        user = user(activity, databaseHelper);
        users = UserLocalDAO.retrieveAll(databaseHelper);
        setMainHeader(activity.getMainHeader(), user);
        rpgMap.start();
    }

    @Override
    public void init() {
        activity = (ArenaActivity) view;
        Pvp.getInstance().setActivity(activity);
        Pvp.getInstance().setBattleBtn(activity.getBattleBtn());

        // retrieve authenticated user session
        databaseHelper = new DatabaseHelper(activity.getApplicationContext());
        user = user(activity, databaseHelper);
        users = UserLocalDAO.retrieveAll(databaseHelper);
        setMainHeader(activity.getMainHeader(), user);

        // get formations
        formations = FormationLocalDAO.all(databaseHelper, user.getId());
        hasBeenSet = false;
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

            if(!preparedUnitInfoList.toString().equalsIgnoreCase("[]") && !hasBeenSet) {
                Pvp.getInstance().setUnitInfo(preparedUnitInfoList);
                hasBeenSet = true;
            }
        });

        // set geolocation
        rpgMap = new RPGMap(activity, user, users, databaseHelper);
        activity.getMap().setOnTouchListener(rpgMap.getNavigate());
        activity.getCurrentBtn().setOnClickListener(rpgMap.getDirect());

        // switch mode (navigate | view info)
        activity.getEnableBtn().setOnClickListener(v -> {
            isEnabled = !isEnabled;

            if(isEnabled) {
                activity.getMap().setOnTouchListener(rpgMap.getNavigate());
                activity.getEnableBtn().setBackgroundResource(R.drawable.border_red_black);
                activity.getEnableBtn().setText("D");
            } else {
                activity.getMap().setOnTouchListener(null);
                activity.getEnableBtn().setBackgroundResource(R.drawable.border_yellow_black);
                activity.getEnableBtn().setText("E");
            }
        });

        // save location
        activity.getSaveLocationBtn().setOnClickListener(v -> {
            user.setLongitude(rpgMap.getNavigate().getCurrentLong());
            user.setLatitude(rpgMap.getNavigate().getCurrentLat());
            UserLocalDAO.update(databaseHelper, user);
            Toast.makeText(activity, String.format("Your location was successfully updated. Longitude: %f, Latitude: %f", user.getLongitude(), user.getLatitude()), Toast.LENGTH_SHORT).show();
        });

        activity.getBackBtn().setOnClickListener(v -> activity.finish());
    }

    @Override
    public void setRecyclerViews() {}

    public void resume() {
        rpgMap.resume();
    }

    public void pause(){
        rpgMap.pause();
    }
}
