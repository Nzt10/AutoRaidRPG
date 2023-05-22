package com.example.autoraidrpg.controller;

import android.content.Intent;
import android.widget.Toast;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.autoraidrpg.IView;
import com.example.autoraidrpg.ItemCollectionActivity;
import com.example.autoraidrpg.ItemMergeActivity;
import com.example.autoraidrpg.adapter.ItemCardAdapter;
import com.example.autoraidrpg.database.DatabaseHelper;
import com.example.autoraidrpg.database.dao.local.InventoryLocalDAO;
import com.example.autoraidrpg.database.dao.local.ItemLocalDAO;
import com.example.autoraidrpg.gameplay.bag.Item;
import com.example.autoraidrpg.model.Inventory;
import com.example.autoraidrpg.model.User;
import com.example.autoraidrpg.population.ItemPopulation;

import java.util.ArrayList;
import java.util.List;

public class ItemCollectionController extends Controller {

    private ItemCollectionActivity activity;
    private List<Item> items;
    private Item currentItem;
    private DatabaseHelper databaseHelper;
    private User user;

    public ItemCollectionController(IView view) {
        super(view);
    }

    @Override
    public void start() {
        // retrieve authenticated user session
        setMainHeader(activity.getMainHeader(), user);
    }

    @Override
    public void init() {
        activity = (ItemCollectionActivity) view;
        items = new ArrayList<>();

        // retrieve authenticated user session
        databaseHelper = new DatabaseHelper(activity.getApplicationContext());
        user = user(activity, databaseHelper);

        List<Inventory> inventories = InventoryLocalDAO.all(databaseHelper, user.getId());
        List<com.example.autoraidrpg.model.Item> storedItems = ItemLocalDAO.allByInventory(databaseHelper, inventories);

        ItemPopulation.itemCollection(storedItems, items);
        setRecyclerViews();

        activity.getMergeBtn().setOnClickListener(v -> {
            if(currentItem != null) {
                Intent intent = new Intent(activity.getApplicationContext(), ItemMergeActivity.class);
                intent.putExtra("item", currentItem);
                activity.startActivity(intent);
            } else {
                Toast toast = Toast.makeText(activity.getApplicationContext(), "Select an item first", Toast.LENGTH_SHORT);
                toast.show();
            }
        });

        activity.getBackBtn().setOnClickListener(v -> activity.finish());
    }

    @Override
    public void setRecyclerViews() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(activity, ItemShopController.ITEM_COLUMN, LinearLayoutManager.VERTICAL,false);
        ItemCardAdapter itemCardAdapter = new ItemCardAdapter(
                activity, items, activity.getLayoutItemDescription(), null, null, null, intent -> activity.startActivity(intent));

        itemCardAdapter.setItemCollectionController(this);
        setAdapter(activity.getRecyclerView(), gridLayoutManager, itemCardAdapter);
    }

    public void setCurrentItem(Item item) { currentItem = item; }

}
