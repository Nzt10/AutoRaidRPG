package com.example.autoraidrpg.map;

import com.example.autoraidrpg.ArenaActivity;
import com.example.autoraidrpg.IView;
import com.example.autoraidrpg.controller.ArenaController;
import com.example.autoraidrpg.database.DatabaseHelper;
import com.example.autoraidrpg.model.User;

import org.osmdroid.api.IMapController;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.overlay.Marker;

import java.util.List;

public class Locator implements Runnable {

    private User user;
    private List<User> users;
    private ArenaActivity activity;

    // database helper
    private DatabaseHelper databaseHelper;

    public Locator(IView view, User user, List<User> users, DatabaseHelper databaseHelper) {
        activity = (ArenaActivity) view;
        this.user = user;
        this.users = users;
        this.databaseHelper = databaseHelper;
    }

    @Override
    public void run() {
        // map controller
        IMapController mapController = activity.getMap().getController();

        // create a marker for each user with valid location
        for (User otherUser : users) {
            if (user.getId() != otherUser.getId() && (otherUser.getLongitude() != 0 && otherUser.getLatitude() != 0)) {
                Marker marker = new Marker(activity.getMap());
                marker.setPosition(new GeoPoint(otherUser.getLatitude(), otherUser.getLongitude()));
                marker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);

                // calculate distance using Haversine formula
                double distanceInKm = new Haversine()
                        .getLatLong1(user.getLatitude(), user.getLongitude())
                        .getLatLong2(otherUser.getLatitude(), otherUser.getLongitude())
                        .getDistance();

                UserInfoWindow customInfoWindow = new UserInfoWindow(activity.getMap(), otherUser, distanceInKm, databaseHelper);
                marker.setInfoWindow(customInfoWindow);

                activity.getMap().getOverlays().add(marker);
            }
        }

        if(user.getLongitude() != 0 && user.getLatitude() != 0) {
            GeoPoint geoPoint = new GeoPoint(user.getLatitude(), user.getLongitude());

            // Add a marker at the user's location
            Marker userMarker = new Marker(activity.getMap());
            userMarker.setPosition(geoPoint);
            userMarker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
            activity.getMap().getOverlays().add(userMarker);

            // Move the camera to the marker position
            GeoPoint finalGeoPoint = geoPoint;

            activity.runOnUiThread(() -> {
                mapController.setCenter(finalGeoPoint);
                mapController.animateTo(finalGeoPoint);

                // force a redraw of the map to show the new marker
                activity.getMap().invalidate();
            });
        }
    }
}
