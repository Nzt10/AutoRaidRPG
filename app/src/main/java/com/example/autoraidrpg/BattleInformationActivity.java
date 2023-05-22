package com.example.autoraidrpg;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.autoraidrpg.controller.BattleInformationController;

public class BattleInformationActivity extends AppCompatActivity implements IView {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle_information);

        recyclerView = findViewById(R.id.battleInformationView);
        new BattleInformationController(this).init();
    }

    public RecyclerView getRecyclerView() {
        return recyclerView;
    }

}