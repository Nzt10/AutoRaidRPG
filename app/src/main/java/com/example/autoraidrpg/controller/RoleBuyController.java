package com.example.autoraidrpg.controller;

import android.content.Intent;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.autoraidrpg.IView;
import com.example.autoraidrpg.RoleBuyActivity;
import com.example.autoraidrpg.RoleShopActivity;
import com.example.autoraidrpg.adapter.SkillCardAdapter;
import com.example.autoraidrpg.adapter.SkillInfoAdapter;
import com.example.autoraidrpg.database.DatabaseHelper;
import com.example.autoraidrpg.database.dao.local.BagLocalDAO;
import com.example.autoraidrpg.database.dao.local.RoleCollectionLocalDAO;
import com.example.autoraidrpg.database.dao.local.RoleLocalDAO;
import com.example.autoraidrpg.database.dao.local.UserLocalDAO;
import com.example.autoraidrpg.executors.SetImageTask;
import com.example.autoraidrpg.model.Bag;
import com.example.autoraidrpg.model.Role;
import com.example.autoraidrpg.model.RoleCollection;
import com.example.autoraidrpg.model.User;
import com.example.autoraidrpg.utils.StarUtils;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RoleBuyController extends Controller {

    private RoleBuyActivity activity;
    private String name;
    private double coin, diamond;
    private List<SkillInfoAdapter> skillInfo;
    private DatabaseHelper databaseHelper;
    private User user;

    public RoleBuyController(IView view) {
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
        activity = (RoleBuyActivity) view;
        ExecutorService executor = Executors.newSingleThreadExecutor();

        // retrieve authenticated user session
        databaseHelper = new DatabaseHelper(activity.getApplicationContext());
        user = user(activity, databaseHelper);
        Intent intent = activity.getIntent();

        // set values
        name = intent.getStringExtra("name");
        String roleDescription = intent.getStringExtra("roleDescription");
        int rating = intent.getIntExtra("rating", 0);
        int roleImage = intent.getIntExtra("roleImage", 0);
        coin = intent.getDoubleExtra("coin", 0);
        diamond = intent.getDoubleExtra("diamond", 0);
        skillInfo = (List<SkillInfoAdapter>) intent.getSerializableExtra("skillInfo");

        executor.execute(new SetImageTask(activity, activity.getUnitImageBtn(), roleImage));
        activity.getRoleName().setText(name);
        activity.getDescription().setText(roleDescription);

        // set rating
        StarUtils.rewriteStar(activity.getRoleImageView().getRootView(), rating);
        setRecyclerViews();
        activity.getBuyWithCoinBtn().setText(String.format("%d COINS", (int) coin));
        activity.getBuyWithDiamondBtn().setText(String.format("%d DIAMONDS", (int) diamond));
        activity.getBackBtn().setOnClickListener(v -> activity.finish());

        // buy with gold
        activity.getBuyWithCoinBtn().setOnClickListener(v -> {
            if(checkResource(user.getCoin(), coin, "Not enough coins!")) {
                user.addGold(-coin);

                // update user coin resource
                UserLocalDAO.update(databaseHelper, user);

                // insert role collection
                Role role = RoleLocalDAO.retrieveByName(databaseHelper, name);
                RoleCollection roleCollection = new RoleCollection(-1, user.getId(), role.getId(), 1, 1, 1, 1, 1, 1, 1);
                int newRoleCollectionID = (int) RoleCollectionLocalDAO.store(databaseHelper, roleCollection);
                Bag bag = new Bag(-1, user.getId(), newRoleCollectionID, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1);
                BagLocalDAO.store(databaseHelper, bag);

                // feedback
                alert(activity.getApplicationContext(), "You buy " + name + " with coins.");
                setIntentOnListener(activity, RoleShopActivity.class);
            }
        });

        // buy with diamond
        activity.getBuyWithDiamondBtn().setOnClickListener(v -> {
            if(checkResource(user.getDiamond(), diamond, "Not enough diamonds!")) {
                user.addDiamond(-diamond);

                // update user diamond resource
                UserLocalDAO.update(databaseHelper, user);

                // insert role collection
                Role role = RoleLocalDAO.retrieveByName(databaseHelper, name);
                RoleCollection roleCollection = new RoleCollection(-1, user.getId(), role.getId(), 1, 1, 1, 1, 1, 1, 1);
                int newRoleCollectionID = (int) RoleCollectionLocalDAO.store(databaseHelper, roleCollection);
                Bag bag = new Bag(-1, user.getId(), newRoleCollectionID, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1);
                BagLocalDAO.store(databaseHelper, bag);

                // feedback
                alert(activity.getApplicationContext(), "You buy " + name + " with diamonds.");
                setIntentOnListener(activity, RoleShopActivity.class);
            }
        });
    }

    @Override
    public void setRecyclerViews() {
        LinearLayoutManager gridLayoutManager = new LinearLayoutManager(activity, LinearLayoutManager.VERTICAL,false);
        SkillCardAdapter skillCardAdapter = new SkillCardAdapter(activity, skillInfo);
        setAdapter(activity.getRecyclerView(), gridLayoutManager, skillCardAdapter);
    }

    private boolean checkResource(double availableResource, double resource, String message) {
        if(availableResource < resource) {
            alert(activity.getApplicationContext(), message);
            return false;
        }

        return true;
    }

}
