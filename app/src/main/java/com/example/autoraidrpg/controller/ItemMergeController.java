package com.example.autoraidrpg.controller;

import android.content.Intent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.autoraidrpg.IView;
import com.example.autoraidrpg.ItemMergeActivity;
import com.example.autoraidrpg.MainActivity;
import com.example.autoraidrpg.R;
import com.example.autoraidrpg.database.DatabaseHelper;
import com.example.autoraidrpg.database.dao.local.InventoryLocalDAO;
import com.example.autoraidrpg.database.dao.local.ItemLocalDAO;
import com.example.autoraidrpg.gameplay.bag.Item;
import com.example.autoraidrpg.model.Inventory;
import com.example.autoraidrpg.model.User;
import com.example.autoraidrpg.population.ItemPopulation;
import com.example.autoraidrpg.utils.StarUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ItemMergeController extends Controller {

    private ItemMergeActivity activity;
    private Intent intent;
    private List<TextView> itemNames;
    private List<View> mergingItemViews;
    private List<Item> availableItems;
    private DatabaseHelper databaseHelper;
    private User user;

    public ItemMergeController(IView view) {
        super(view);
    }

    @Override
    public void start() {
        // retrieve authenticated user session
        user = user(activity, databaseHelper);
        setMainHeader(activity.getMainHeader(), user);
    }

    @Override
    public void init() {
        activity = (ItemMergeActivity) view;
        databaseHelper = new DatabaseHelper(activity.getApplicationContext());
        user = user(activity, databaseHelper);

        intent = activity.getIntent();
        itemNames = new ArrayList<>();
        mergingItemViews = new ArrayList<>();
        availableItems = new ArrayList<>();

        // set values
        Item item = (Item) intent.getSerializableExtra("item");
        List<Inventory> inventories = InventoryLocalDAO.all(databaseHelper, user.getId());
        List<com.example.autoraidrpg.model.Item> currentItems = ItemLocalDAO.allByInventory(databaseHelper, inventories);
        ItemPopulation.itemCollection(currentItems, availableItems);

        // set items views
        setMergingUnitSlot();

        // empty images
        emptyImages(mergingItemViews);

        // set output of a merging item
        StarUtils.rewriteStar(activity.getMergedItem(), item.getRating() + 1);
        activity.getItemBtn().setBackgroundResource(item.getItemImage());
        activity.getMergedItemName().setText(item.getName());

        List<Item> duplicatedItems = availableItems.stream().filter(
                t -> t.getName().equalsIgnoreCase(item.getName()) && t.getRating() == item.getRating()).collect(Collectors.toList());

        // apply duplicated items
        for(int i = 0; i < duplicatedItems.size(); i++) {
            if(i >= 3) break;

            Item dItem = duplicatedItems.get(i);
            View unitView = mergingItemViews.get(i);
            TextView textName = itemNames.get(i);

            ImageButton imageBtn = unitView.findViewById(R.id.itemBtn);
            StarUtils.rewriteStar(unitView, dItem.getRating());
            imageBtn.setBackgroundResource(dItem.getItemImage());
            textName.setText("ready!");
        }

        activity.getMergeBtn().setOnClickListener(v -> {
            int size = duplicatedItems.size();

            if(size >= 3) {
                Toast toast = Toast.makeText(activity.getApplicationContext(),
                        String.format("Congrats! You acquired %d star - %s", item.getRating() + 1, item.getName()), Toast.LENGTH_SHORT);
                toast.show();
                setIntentOnListener(activity, MainActivity.class);
            } else {
                Toast toast = Toast.makeText(activity.getApplicationContext(),
                        String.format("Not enough requirements!", item.getRating() + 1, item.getName()), Toast.LENGTH_SHORT);
                toast.show();
            }
        });

        activity.getBackBtn().setOnClickListener(v -> activity.finish());
    }

    @Override
    public void setRecyclerViews() {}

    private void setMergingUnitSlot() {
        mergingItemViews.add(activity.findViewById(R.id.mergingItem1));
        mergingItemViews.add(activity.findViewById(R.id.mergingItem2));
        mergingItemViews.add(activity.findViewById(R.id.mergingItem3));

        itemNames.add(activity.findViewById(R.id.itemName1));
        itemNames.add(activity.findViewById(R.id.itemName2));
        itemNames.add(activity.findViewById(R.id.itemName3));
    }

    private void emptyImages(List<View> imageViews) {
        imageViews.stream().forEach(v -> v.findViewById(R.id.itemBtn).setBackgroundResource(R.color.dark_gray));
    }

}
