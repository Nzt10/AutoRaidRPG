package com.example.autoraidrpg.controller;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.autoraidrpg.IView;
import com.example.autoraidrpg.RoleShopActivity;
import com.example.autoraidrpg.adapter.RoleShopAdapter;
import com.example.autoraidrpg.database.DatabaseHelper;
import com.example.autoraidrpg.database.dao.local.RoleLocalDAO;
import com.example.autoraidrpg.gameplay.entity.Entity;
import com.example.autoraidrpg.model.User;
import com.example.autoraidrpg.population.RolePopulation;

import java.util.ArrayList;
import java.util.List;

public class RoleShopController extends Controller {

    private RoleShopActivity activity;
    private List<Entity> entities;
    private DatabaseHelper databaseHelper;

    public RoleShopController(IView view) {
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
        activity = (RoleShopActivity) view;
        entities = new ArrayList<>();

        // retrieve
        databaseHelper = new DatabaseHelper(activity.getApplicationContext());
        RolePopulation.roleCollection(RoleLocalDAO.all(databaseHelper), entities);
        setRecyclerViews();

        activity.getBackBtn().setOnClickListener(v -> activity.finish());
    }

    @Override
    public void setRecyclerViews() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(activity,ItemShopController.ITEM_COLUMN, LinearLayoutManager.VERTICAL,false);
        RoleShopAdapter roleShopAdapter = new RoleShopAdapter(activity, entities, intent -> activity.startActivity(intent));
        setAdapter(activity.getRecyclerView(), gridLayoutManager, roleShopAdapter);
    }

}
