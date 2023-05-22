package com.example.autoraidrpg.controller;

import android.content.Intent;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.autoraidrpg.IView;
import com.example.autoraidrpg.SkillActivity;
import com.example.autoraidrpg.adapter.SkillBuyCardAdapter;
import com.example.autoraidrpg.database.DatabaseHelper;
import com.example.autoraidrpg.database.dao.local.RoleCollectionLocalDAO;
import com.example.autoraidrpg.gameplay.entity.Entity;
import com.example.autoraidrpg.gameplay.entity.role.RoleFactory;
import com.example.autoraidrpg.model.RoleCollection;
import com.example.autoraidrpg.model.User;
import com.example.autoraidrpg.utils.UnitUtils;

public class SkillController extends Controller {

    private SkillActivity activity;
    private Entity entity;
    private DatabaseHelper databaseHelper;
    private User user;

    public SkillController(IView view) {
        super(view);
    }

    @Override
    public void start() {
        // retrieve authenticated user session
        databaseHelper = new DatabaseHelper(activity.getApplicationContext());
        user = user(activity, databaseHelper);
        setMainHeader(activity.getMainHeader(), user);
    }

    @Override
    public void init() {
        activity = (SkillActivity) view;

        // retrieve authenticated user session
        databaseHelper = new DatabaseHelper(activity.getApplicationContext());
        user = user(activity, databaseHelper);

        Intent intent = activity.getIntent();

        // set values
        int roleCollectionID = intent.getIntExtra("roleCollectionID", 0);
        String name = intent.getStringExtra("name");
        int currentRating = intent.getIntExtra("rating", 0);
        int currentLevel = intent.getIntExtra("level", 0);

        activity.getLevel().setText("Level " + String.valueOf(currentLevel));
        RoleCollection roleCollection = RoleCollectionLocalDAO.retrieve(databaseHelper, user.getId(), roleCollectionID);

        // set entity
        entity = RoleFactory.makeRole(name).setLevel(currentLevel).setRating(currentRating);
        entity.initStats();
        UnitUtils.setSingleStats(entity, roleCollection);

        // set description
        activity.getUnitImageBtn().setBackgroundResource(entity.getRoleImage());
        activity.getRoleName().setText(entity.getName());
        UnitUtils.setStats(entity, activity);

        setRecyclerViews();
        activity.getBackBtn().setOnClickListener(v -> activity.finish());
    }

    @Override
    public void setRecyclerViews() {
        LinearLayoutManager gridLayoutManager = new LinearLayoutManager(activity, LinearLayoutManager.VERTICAL,false);
        SkillBuyCardAdapter skillBuyCardAdapter = new SkillBuyCardAdapter(activity, UnitUtils.setAndGetSkills(entity.getSkillManager()));
        setAdapter(activity.getRecyclerView(), gridLayoutManager, skillBuyCardAdapter);
    }

}
