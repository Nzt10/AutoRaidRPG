package com.example.autoraidrpg;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.autoraidrpg.controller.RoleShopController;

public class RoleShopActivity extends AppCompatActivity implements IView {

    private View mainHeader;
    private RecyclerView recyclerView;
    private ImageButton backBtn;
    private RoleShopController roleShopController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_role_shop);

        mainHeader = findViewById(R.id.mainHeader);
        recyclerView = findViewById(R.id.characterShopView);
        backBtn = findViewById(R.id.backBtn);

        roleShopController = new RoleShopController(this);
        roleShopController.init();
    }

    @Override
    protected void onStart() {
        super.onStart();
        roleShopController.start();
    }

    @Override
    public void finish() {
        roleShopController.setIntentOnListener(this, MainActivity.class);
    }

    public View getMainHeader() { return mainHeader; }

    public RecyclerView getRecyclerView() {
        return recyclerView;
    }

    public ImageButton getBackBtn() {
        return backBtn;
    }

}