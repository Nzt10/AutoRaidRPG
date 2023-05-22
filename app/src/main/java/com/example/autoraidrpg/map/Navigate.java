package com.example.autoraidrpg.map;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.example.autoraidrpg.ArenaActivity;
import com.example.autoraidrpg.IView;
import com.example.autoraidrpg.model.User;

import org.osmdroid.api.IMapController;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.overlay.Marker;

public class Navigate implements View.OnTouchListener {
    private GeoPoint lastPoint;
    private ArenaActivity activity;
    private IMapController mapController;
    private double currentLong, currentLat;

    public Navigate(IView view, User user) {
        activity = (ArenaActivity) view;
        mapController = activity.getMap().getController();
        currentLong = user.getLongitude();
        currentLat = user.getLatitude();

    }

    private void addMarker(GeoPoint point) {
        // remove previously added marker
        activity.getMap().getOverlays().remove(activity.getMap().getOverlays().size() - 1);

        // create a new marker at the tapped location
        Marker marker = new Marker(activity.getMap());
        marker.setPosition(point);
        marker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
        activity.getMap().getOverlayManager().add(marker);

        currentLong = point.getLongitude();
        currentLat = point.getLatitude();

        // redirect at the center
        mapController.setCenter(point);
        mapController.animateTo(point);

        // force a redraw of the map to show the new marker
        activity.getMap().invalidate();
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            lastPoint = (GeoPoint) activity.getMap().getProjection().fromPixels((int) event.getX(), (int) event.getY());
        } else if (event.getAction() == MotionEvent.ACTION_UP) {
            // get the location where the user tapped
            GeoPoint point = (GeoPoint) activity.getMap().getProjection().fromPixels((int) event.getX(), (int) event.getY());

            // check if the user has clicked on the same location
            if (lastPoint.equals(point)) {
                addMarker(point);
            }

            return true;
        }
        return false;
    }

    public double getCurrentLong() {
        return currentLong;
    }

    public double getCurrentLat() {
        return currentLat;
    }

}
