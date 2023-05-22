package com.example.autoraidrpg.controller;

import android.content.Intent;

import com.example.autoraidrpg.IView;
import com.example.autoraidrpg.ItemDescriptionActivity;
import com.example.autoraidrpg.ItemMergeActivity;
import com.example.autoraidrpg.gameplay.bag.Item;
import com.example.autoraidrpg.utils.ItemUtils;
import com.example.autoraidrpg.utils.StarUtils;

public class ItemDescriptionController extends Controller {

    public ItemDescriptionController(IView view) {
        super(view);
    }

    @Override
    public void init() {
        ItemDescriptionActivity activity = (ItemDescriptionActivity) view;
        Intent intent1 = activity.getIntent();
        Item item = (Item) intent1.getSerializableExtra("item");

        activity.getItemImageBtn().setBackgroundResource(item.getItemImage());
        activity.getItemImageBtn().setOnLongClickListener(v -> {
            Intent intent = new Intent(activity.getApplicationContext(), ItemMergeActivity.class);
            intent.putExtra("item", item);
            activity.startActivity(intent);
            return true;
        });

        // set item
        ItemUtils.designItem(item, activity.getItemImageBtn(), activity.getItemName(), activity.getStats(), activity.getDescription());
        StarUtils.rewriteStar(activity.getLayoutItemDescription(), item.getRating());

        activity.getBackBtn().setOnClickListener(v -> activity.finish());
    }

    @Override
    public void setRecyclerViews() {}

}
