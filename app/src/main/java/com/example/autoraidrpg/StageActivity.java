package com.example.autoraidrpg;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.autoraidrpg.controller.StageController;

public class StageActivity extends AppCompatActivity implements IView {

    private View mainHeader;
    private RecyclerView recyclerView;
    private ImageButton backBtn;
    private StageController stageController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stage);

        mainHeader = findViewById(R.id.mainHeader);
        recyclerView = findViewById(R.id.stageView);
        backBtn = findViewById(R.id.backBtn);

        stageController = new StageController(this);
        stageController.init();
    }

    @Override
    protected void onStart() {
        super.onStart();
        stageController.start();
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

    public View getMainHeader() { return mainHeader; }

    public RecyclerView getRecyclerView() {
        return recyclerView;
    }

    public ImageButton getBackBtn() {
        return backBtn;
    }

}