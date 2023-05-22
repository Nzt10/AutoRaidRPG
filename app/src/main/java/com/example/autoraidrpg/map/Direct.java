package com.example.autoraidrpg.map;

import android.location.Location;
import android.view.View;

import com.example.autoraidrpg.ArenaActivity;
import com.example.autoraidrpg.IView;
import com.example.autoraidrpg.model.User;

import org.osmdroid.api.IMapController;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.overlay.mylocation.MyLocationNewOverlay;

public class Direct implements View.OnClickListener {

    private ArenaActivity activity;
    private IMapController mapController;
    MyLocationNewOverlay myLocationOverlay;
    private User user;

    public Direct(IView view, MyLocationNewOverlay myLocationOverlay, User user) {
        activity = (ArenaActivity) view;
        mapController = activity.getMap().getController();
        this.myLocationOverlay = myLocationOverlay;
        this.user = user;
    }

    @Override
    public void onClick(View view) {
        Location location = myLocationOverlay.getLastFix();
        GeoPoint geoPoint = null;
        if(location != null) {
            geoPoint = new GeoPoint(location);
        } else {
            geoPoint = new GeoPoint(48.8583, 2.2944);
        }

        // Direct the user to their current location
        // set user geo point
        user.setLongitude(geoPoint.getLongitude());
        user.setLatitude(geoPoint.getLatitude());

        GeoPoint finalGeoPoint1 = geoPoint;

        activity.runOnUiThread(() -> {
            mapController.setCenter(finalGeoPoint1);
            mapController.animateTo(finalGeoPoint1);

            // force a redraw of the map to show the new marker
            activity.getMap().invalidate();
        });
    }
}
