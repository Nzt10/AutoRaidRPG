package com.example.autoraidrpg;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.autoraidrpg.controller.DiamondShopController;

public class DiamondShopActivity extends AppCompatActivity implements IView {

    private View mainHeader;
    private RecyclerView recyclerView;
    private ImageButton backBtn;
    private DiamondShopController diamondShopController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diamond_shop);

        mainHeader = findViewById(R.id.mainHeader);
        recyclerView = findViewById(R.id.bundleView);
        backBtn = findViewById(R.id.backBtn);

        diamondShopController = new DiamondShopController(this);
        diamondShopController.init();
    }

    @Override
    protected void onStart() {
        super.onStart();
        diamondShopController.start();
    }

    public View getMainHeader() { return mainHeader; }

    public RecyclerView getRecyclerView() {
        return recyclerView;
    }

    public ImageButton getBackBtn() {
        return backBtn;
    }

}