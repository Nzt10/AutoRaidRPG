package com.example.autoraidrpg.map;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.location.LocationManager;

import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.autoraidrpg.ArenaActivity;
import com.example.autoraidrpg.IView;
import com.example.autoraidrpg.database.DatabaseHelper;
import com.example.autoraidrpg.model.User;

import org.osmdroid.api.IMapController;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.overlay.TilesOverlay;
import org.osmdroid.views.overlay.mylocation.GpsMyLocationProvider;
import org.osmdroid.views.overlay.mylocation.MyLocationNewOverlay;

import java.util.List;

public class RPGMap {

    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1;
    private MyLocationNewOverlay myLocationOverlay;
    private ArenaActivity activity;
    private Direct direct;
    private Navigate navigate;
    private User user;
    private List<User> users;
    private DatabaseHelper databaseHelper;

    public void start() {
        // Enable the location overlay and start updating the user's location
        myLocationOverlay.enableMyLocation();
        myLocationOverlay.enableFollowLocation();
    }

    public RPGMap(IView view, User user, List<User> users, DatabaseHelper databaseHelper) {
        activity = (ArenaActivity) view;
        this.user = user;
        this.users = users;
        this.databaseHelper = databaseHelper;

        // handle permissions first, before map is created. not depicted here
        requestLocationPermissions();
        isGpsEnabled();
        checkGpsEnabled();

        activity.getMap().setMultiTouchControls(true);
        activity.getMap().setBuiltInZoomControls(false);
        activity.getMap().setTileSource(TileSourceFactory.MAPNIK);

        TilesOverlay tilesOverlay = activity.getMap().getOverlayManager().getTilesOverlay();
        ColorFilter filter = new PorterDuffColorFilter(Color.rgb(100, 100, 100), PorterDuff.Mode.MULTIPLY);
        tilesOverlay.setColorFilter(filter);

        IMapController mapController = activity.getMap().getController();
        mapController.setZoom(9.5);
        GeoPoint startPoint = new GeoPoint(48.8583, 2.2944);
        mapController.setCenter(startPoint);

        // Create the location overlay
        myLocationOverlay = new MyLocationNewOverlay(new GpsMyLocationProvider(activity.getApplicationContext()), activity.getMap());
        myLocationOverlay.enableMyLocation();
        activity.getMap().getOverlays().add(myLocationOverlay);

        // Zoom to the user's location when it becomes available
        myLocationOverlay.runOnFirstFix(new Locator(activity, user, users, databaseHelper));

        // Enable the location overlay and start updating the user's location
        myLocationOverlay.enableMyLocation();
        myLocationOverlay.enableFollowLocation();

        // set navigators
        direct = new Direct(activity, myLocationOverlay, user);
        navigate = new Navigate(activity, user);
    }

    private void requestLocationPermissions() {
        if (ContextCompat.checkSelfPermission(activity.getApplicationContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(activity, new String[] { Manifest.permission.ACCESS_FINE_LOCATION }, LOCATION_PERMISSION_REQUEST_CODE);
        }
    }

    private boolean isGpsEnabled() {
        LocationManager locationManager = (LocationManager) activity.getSystemService(Context.LOCATION_SERVICE);
        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
    }

    private void checkGpsEnabled() {
        LocationManager locationManager = (LocationManager) activity.getSystemService(Context.LOCATION_SERVICE);
        boolean gpsEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        if (!gpsEnabled) {
            showGpsDisabledDialog();
        }
    }

    private void showGpsDisabledDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setMessage("GPS is disabled. Do you want to enable it?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent gpsOptionsIntent = new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                        activity.startActivity(gpsOptionsIntent);
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }

    public void resume() {
        // this will refresh the osmdroid configuration on resuming.
        activity.getMap().onResume(); //needed for compass, my location overlays, v6.0.0 and up
        myLocationOverlay.enableMyLocation();
    }

    public void pause(){
        // this will refresh the osmdroid configuration on resuming.);
        activity.getMap().onPause();  // needed for compass, my location overlays, v6.0.0 and up
        myLocationOverlay.enableMyLocation();
    }

    public Direct getDirect() {
        return direct;
    }

    public Navigate getNavigate() {
        return navigate;
    }

}
