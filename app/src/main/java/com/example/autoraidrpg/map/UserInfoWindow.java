package com.example.autoraidrpg.map;

import android.content.Intent;
import android.widget.TextView;

import com.example.autoraidrpg.PvpActivity;
import com.example.autoraidrpg.R;
import com.example.autoraidrpg.adapter.PreparationUnitInfoAdapter;
import com.example.autoraidrpg.database.DatabaseHelper;
import com.example.autoraidrpg.database.dao.cloud.FormationCloudDAO;
import com.example.autoraidrpg.database.dao.cloud.RoleCollectionCloudDAO;
import com.example.autoraidrpg.database.dao.local.FormationLocalDAO;
import com.example.autoraidrpg.database.dao.local.PositionLocalDAO;
import com.example.autoraidrpg.database.dao.local.RoleCollectionLocalDAO;
import com.example.autoraidrpg.database.dao.local.RoleLocalDAO;
import com.example.autoraidrpg.gameplay.global.StageObserver;
import com.example.autoraidrpg.gameplay.global.StageState;
import com.example.autoraidrpg.gameplay.stage.Stage;
import com.example.autoraidrpg.model.Formation;
import com.example.autoraidrpg.model.Position;
import com.example.autoraidrpg.model.RoleCollection;
import com.example.autoraidrpg.model.User;

import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.Marker;
import org.osmdroid.views.overlay.infowindow.MarkerInfoWindow;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class UserInfoWindow extends MarkerInfoWindow {
    private TextView textView;
    private User user;
    private double distance;

    // database helper
    private DatabaseHelper databaseHelper;
    private List<Formation> formations;
    private boolean hasBeenSet = false;
    private List<PreparationUnitInfoAdapter> enemyInfoUnitList;

    public UserInfoWindow(MapView mapView, User user, double distance, DatabaseHelper databaseHelper) {
        super(R.layout.layout_marker_tooltip, mapView);
        this.user = user;
        this.distance = distance;
        this.databaseHelper = databaseHelper;
        textView = (TextView) getView().findViewById(R.id.tv_tooltip_text);
    }

    @Override
    public void onOpen(Object item) {
        if (item instanceof Marker) {
            Marker marker = (Marker) item;
            String info = user.getEmail() + "\n" + (int) distance + "km far away at you.";
            textView.setText(info);

            // retrieve battle formation
            formations = FormationLocalDAO.all(databaseHelper, user.getId());
            // formations = new FormationCloudDAO(Pvp.getInstance().getActivity()).retrieveAll(user.getFirebaseID());
            AtomicInteger formationCount = new AtomicInteger(0);
            hasBeenSet = false;

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
                    // if(position.getIndex() != -1) roleCollectionList.add(new RoleCollectionCloudDAO(Pvp.getInstance().getActivity()).retrieve(position.getRoleCollectionFirebaseID()));
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
                    enemyInfoUnitList = preparedUnitInfoList;
                    hasBeenSet = true;
                }
            });

            // set function to PvP battle btn
            Pvp.getInstance().setOnClickListener(v -> {
                Stage stage = new Stage();
                stage.setState(StageState.PVP);

                Pvp pvp = Pvp.getInstance();
                StageObserver.setStage(stage);

                // proceed to battle page
                Intent intent = new Intent(pvp.getActivity().getApplicationContext(), PvpActivity.class);
                intent.putExtra("allyUnits", (Serializable) pvp.getUnitInfo());
                intent.putExtra("enemyUnits", (Serializable) enemyInfoUnitList);
                pvp.getActivity().startActivity(intent);
            });

            // Set the anchor point of the InfoWindow just above the marker
            marker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
        }
    }

    @Override
    public void onClose() {}
}
