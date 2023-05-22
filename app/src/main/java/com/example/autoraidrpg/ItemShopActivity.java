package com.example.autoraidrpg;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.autoraidrpg.controller.ItemShopController;

public class ItemShopActivity extends AppCompatActivity implements IView {

    private View mainHeader;
    private RecyclerView recyclerView;
    private View layoutItemDescription;
    private ImageButton backBtn;
    private Button buyBtn;
    private ItemShopController itemShopController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_shop);

        mainHeader = findViewById(R.id.mainHeader);
        recyclerView = findViewById(R.id.itemShopView);
        layoutItemDescription = findViewById(R.id.layoutItemDescription);

        buyBtn = findViewById(R.id.buyBtn);
        backBtn = findViewById(R.id.backBtn);

        itemShopController = new ItemShopController(this);
        itemShopController.init();
    }

    @Override
    protected void onStart() {
        super.onStart();
        itemShopController.start();
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

    public Button getBuyBtn() {
        return buyBtn;
    }

}