package com.example.autoraidrpg;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.autoraidrpg.controller.ItemDescriptionController;

public class ItemDescriptionActivity extends AppCompatActivity implements IView {

    private View layoutItemDescription;
    private ImageButton backBtn, itemImageBtn;
    private TextView itemName, stats, description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_description);

        layoutItemDescription = findViewById(R.id.layoutItemDescription);
        itemName = layoutItemDescription.findViewById(R.id.itemName);
        stats = layoutItemDescription.findViewById(R.id.stats);
        description = layoutItemDescription.findViewById(R.id.description);

        itemImageBtn = layoutItemDescription.findViewById(R.id.itemImageBtn);
        backBtn = findViewById(R.id.backBtn);

        new ItemDescriptionController(this).init();
    }

    public View getLayoutItemDescription() {
        return layoutItemDescription;
    }

    public ImageButton getBackBtn() {
        return backBtn;
    }

    public ImageButton getItemImageBtn() {
        return itemImageBtn;
    }

    public TextView getItemName() {
        return itemName;
    }

    public TextView getStats() {
        return stats;
    }

    public TextView getDescription() {
        return description;
    }

}