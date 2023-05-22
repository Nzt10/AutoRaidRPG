package com.example.autoraidrpg;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.autoraidrpg.controller.ItemCollectionController;

public class ItemCollectionActivity extends AppCompatActivity implements IView {

    private View mainHeader;
    private RecyclerView recyclerView;
    private View layoutItemDescription;
    private ImageButton backBtn;
    private Button mergeBtn;
    private ItemCollectionController itemCollectionController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_collection);

        mainHeader = findViewById(R.id.mainHeader);
        recyclerView = findViewById(R.id.itemShopView);
        layoutItemDescription = findViewById(R.id.layoutItemDescription);

        mergeBtn = findViewById(R.id.mergeBtn);
        backBtn = findViewById(R.id.backBtn);

        itemCollectionController = new ItemCollectionController(this);
        itemCollectionController.init();
    }

    @Override
    protected void onStart() {
        super.onStart();
        itemCollectionController.start();
    }

    public View getMainHeader() { return mainHeader; }

    public RecyclerView getRecyclerView() {
        return recyclerView;
    }

    public View getLayoutItemDescription() {
        return layoutItemDescription;
    }

    public ImageButton getBackBtn() {
        return backBtn;
    }

    public Button getMergeBtn() {
        return mergeBtn;
    }

}