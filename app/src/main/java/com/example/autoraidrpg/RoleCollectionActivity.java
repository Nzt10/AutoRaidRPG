package com.example.autoraidrpg;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.autoraidrpg.controller.RoleCollectionController;

public class RoleCollectionActivity extends AppCompatActivity implements IView {

    private View mainHeader;
    private RecyclerView recyclerView;
    private ImageButton backBtn;
    private RoleCollectionController roleCollectionController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_role_collection);

        mainHeader = findViewById(R.id.mainHeader);
        recyclerView = findViewById(R.id.roleCollectionView);
        backBtn = findViewById(R.id.backBtn);

        roleCollectionController = new RoleCollectionController(this);
        roleCollectionController.init();
    }

    @Override
    protected void onStart() {
        super.onStart();
        roleCollectionController.start();
    }

    public View getMainHeader() { return mainHeader; }

    public RecyclerView getRecyclerView() {
        return recyclerView;
    }

    public ImageButton getBackBtn() {
        return backBtn;
    }

}