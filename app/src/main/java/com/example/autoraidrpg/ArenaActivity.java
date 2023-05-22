package com.example.autoraidrpg;

import android.Manifest;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.autoraidrpg.controller.ArenaController;

import org.osmdroid.api.IMapController;
import org.osmdroid.config.Configuration;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.mylocation.GpsMyLocationProvider;
import org.osmdroid.views.overlay.mylocation.MyLocationNewOverlay;

public class ArenaActivity extends AppCompatActivity implements IView {

    private MapView map;
    private View mainHeader;
    private Button enableBtn, currentBtn, saveLocationBtn, battleBtn;
    private ImageButton backBtn;
    private ArenaController arenaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arena);

        // initialize the osmdroid configuration, this can be done
        Context ctx = getApplicationContext();
        Configuration.getInstance().load(ctx, PreferenceManager.getDefaultSharedPreferences(ctx));

        map = findViewById(R.id.mapView);
        mainHeader = findViewById(R.id.mainHeader);
        enableBtn = findViewById(R.id.enableBtn);
        currentBtn = findViewById(R.id.currentBtn);
        saveLocationBtn = findViewById(R.id.saveLocationBtn);
        battleBtn = findViewById(R.id.battleBtn);
        backBtn = findViewById(R.id.backBtn);

        arenaController = new ArenaController(this);
        arenaController.init();
    }

    @Override
    protected void onStart() {
        super.onStart();
        arenaController.start();
    }

    @Override
    protected void onResume() {
        super.onResume();
        arenaController.resume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        arenaController.pause();
    }

    @Override
    public void finish() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public MapView getMap() {
        return map;
    }

    public View getMainHeader() {
        return mainHeader;
    }

    public Button getEnableBtn() {
        return enableBtn;
    }

    public Button getCurrentBtn() {
        return currentBtn;
    }

    public Button getSaveLocationBtn() {
        return saveLocationBtn;
    }

    public Button getBattleBtn() {
        return battleBtn;
    }

    public ImageButton getBackBtn() {
        return backBtn;
    }
}