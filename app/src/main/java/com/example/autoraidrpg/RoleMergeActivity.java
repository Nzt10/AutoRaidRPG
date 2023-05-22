package com.example.autoraidrpg;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.autoraidrpg.controller.RoleMergeController;

public class RoleMergeActivity extends AppCompatActivity implements IView {

    private View mainHeader;
    private ImageButton backBtn, unitImageBtn;
    private TextView mergedUnitName;
    private View mergedUnit;
    private Button mergeBtn;
    private RoleMergeController roleMergeController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_role_merge);

        mainHeader = findViewById(R.id.mainHeader);

        // main merging unit product
        mergedUnitName = findViewById(R.id.mergedUnitName);
        mergedUnit = findViewById(R.id.mergedUnit);

        unitImageBtn = mergedUnit.findViewById(R.id.unitImageBtn);
        mergeBtn = findViewById(R.id.mergeBtn);
        backBtn = findViewById(R.id.backBtn);

        roleMergeController = new RoleMergeController(this);
        roleMergeController.init();
    }

    @Override
    protected void onStart() {
        super.onStart();
        roleMergeController.start();
    }

    public View getMainHeader() { return mainHeader; }

    public ImageButton getBackBtn() {
        return backBtn;
    }

    public ImageButton getUnitImageBtn() {
        return unitImageBtn;
    }

    public TextView getMergedUnitName() {
        return mergedUnitName;
    }

    public View getMergedUnit() {
        return mergedUnit;
    }

    public Button getMergeBtn() {
        return mergeBtn;
    }

}