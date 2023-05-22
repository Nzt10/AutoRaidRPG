package com.example.autoraidrpg.controller;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.autoraidrpg.IView;
import com.example.autoraidrpg.RoleCollectionActivity;
import com.example.autoraidrpg.adapter.RoleCardAdapter;
import com.example.autoraidrpg.database.DatabaseHelper;
import com.example.autoraidrpg.database.dao.local.RoleCollectionLocalDAO;
import com.example.autoraidrpg.database.dao.local.RoleLocalDAO;
import com.example.autoraidrpg.gameplay.entity.Entity;
import com.example.autoraidrpg.model.Role;
import com.example.autoraidrpg.model.RoleCollection;
import com.example.autoraidrpg.model.User;
import com.example.autoraidrpg.population.RolePopulation;
import com.example.autoraidrpg.utils.OrderUtils;
import com.example.autoraidrpg.utils.UnitUtils;

import java.util.ArrayList;
import java.util.List;

public class RoleCollectionController extends Controller {

    private RoleCollectionActivity activity;
    private List<Entity> entities;

    public RoleCollectionController(IView view) {
        super(view);
    }

    @Override
    public void start() {
        // retrieve authenticated user session
        DatabaseHelper databaseHelper = new DatabaseHelper(activity.getApplicationContext());
        User user = user(activity, databaseHelper);
        setMainHeader(activity.getMainHeader(), user);

        entities.clear(); // clear the previous list first
        List<RoleCollection> roleCollections = RoleCollectionLocalDAO.all(databaseHelper, user.getId());
        List<Role> roles = RoleLocalDAO.allByRoleCollections(databaseHelper, roleCollections);

        // set entities
        RolePopulation.roleCollection(roles, entities);
        UnitUtils.setStats(entities, roleCollections);
        OrderUtils.sortByNames(entities);

        setRecyclerViews();
    }

    @Override
    public void init() {
        activity = (RoleCollectionActivity) view;
        entities = new ArrayList<>();
        activity.getBackBtn().setOnClickListener(v -> activity.finish());
    }

    @Override
    public void setRecyclerViews() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(activity, ItemShopController.ITEM_COLUMN, LinearLayoutManager.VERTICAL,false);
        RoleCardAdapter roleCardAdapter = new RoleCardAdapter(activity, entities, intent -> activity.startActivity(intent));
        setAdapter(activity.getRecyclerView(), gridLayoutManager, roleCardAdapter);
    }

}
