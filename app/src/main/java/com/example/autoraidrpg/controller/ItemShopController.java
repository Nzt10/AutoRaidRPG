package com.example.autoraidrpg.controller;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.autoraidrpg.IView;
import com.example.autoraidrpg.ItemShopActivity;
import com.example.autoraidrpg.adapter.ItemCardAdapter;
import com.example.autoraidrpg.database.DatabaseHelper;
import com.example.autoraidrpg.database.dao.local.ItemLocalDAO;
import com.example.autoraidrpg.gameplay.bag.Item;
import com.example.autoraidrpg.model.User;
import com.example.autoraidrpg.population.ItemPopulation;

import java.util.ArrayList;
import java.util.List;

public class ItemShopController extends Controller {

    public final static int ITEM_COLUMN = 4;
    private ItemShopActivity activity;
    private List<Item> items;
    private DatabaseHelper databaseHelper;

    public ItemShopController(IView view) {
        super(view);
    }

    @Override
    public void start() {
        // retrieve authenticated user session
        User user = user(activity, databaseHelper);
        setMainHeader(activity.getMainHeader(), user);
    }

    @Override
    public void init() {
        activity = (ItemShopActivity) view;
        items = new ArrayList<>();

        // retrieve
        databaseHelper = new DatabaseHelper(activity.getApplicationContext());
        ItemPopulation.itemCollection(ItemLocalDAO.all(databaseHelper), items);
        setRecyclerViews();
        activity.getBackBtn().setOnClickListener(v -> activity.finish());
    }

    @Override
    public void setRecyclerViews() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(activity, ITEM_COLUMN, LinearLayoutManager.VERTICAL, false);
        ItemCardAdapter itemCardAdapter = new ItemCardAdapter(
                activity, items, activity.getLayoutItemDescription(), null, null, null, intent -> activity.startActivity(intent));

        itemCardAdapter.setShopComponent(activity.getBuyBtn());
        setAdapter(activity.getRecyclerView(), gridLayoutManager, itemCardAdapter);
    }

}
