package com.example.autoraidrpg;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.autoraidrpg.controller.ItemMergeController;

public class ItemMergeActivity extends AppCompatActivity implements IView {

    private View mainHeader;
    private ImageButton backBtn, itemBtn;
    private TextView mergedItemName;
    private View mergedItem;
    private Button mergeBtn;
    private ItemMergeController itemMergeController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_merge);

        mainHeader = findViewById(R.id.mainHeader);

        // main merging item product
        mergedItemName = findViewById(R.id.mergedItemName);
        mergedItem = findViewById(R.id.mergedItem);

        itemBtn = mergedItem.findViewById(R.id.itemBtn);
        mergeBtn = findViewById(R.id.mergeBtn);
        backBtn = findViewById(R.id.backBtn);

        itemMergeController = new ItemMergeController(this);
        itemMergeController.init();
    }

    @Override
    protected void onStart() {
        super.onStart();
        itemMergeController.start();
    }

    public View getMainHeader() { return mainHeader; }

    public ImageButton getBackBtn() {
        return backBtn;
    }

    public ImageButton getItemBtn() {
        return itemBtn;
    }

    public TextView getMergedItemName() {
        return mergedItemName;
    }

    public View getMergedItem() {
        return mergedItem;
    }

    public Button getMergeBtn() {
        return mergeBtn;
    }

}