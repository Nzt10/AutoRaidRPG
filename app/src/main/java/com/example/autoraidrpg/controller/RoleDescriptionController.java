package com.example.autoraidrpg.controller;

import android.content.Intent;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.autoraidrpg.IView;
import com.example.autoraidrpg.ItemSettingActivity;
import com.example.autoraidrpg.RoleDescriptionActivity;
import com.example.autoraidrpg.RoleMergeActivity;
import com.example.autoraidrpg.SkillActivity;
import com.example.autoraidrpg.adapter.SkillCardAdapter;
import com.example.autoraidrpg.adapter.SkillInfoAdapter;
import com.example.autoraidrpg.database.DatabaseHelper;
import com.example.autoraidrpg.database.dao.local.RoleCollectionLocalDAO;
import com.example.autoraidrpg.database.dao.local.UserLocalDAO;
import com.example.autoraidrpg.executors.SetImageTask;
import com.example.autoraidrpg.model.RoleCollection;
import com.example.autoraidrpg.model.User;
import com.example.autoraidrpg.utils.StarUtils;
import com.example.autoraidrpg.utils.UnitUtils;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RoleDescriptionController extends Controller {

    private RoleDescriptionActivity activity;
    private List<SkillInfoAdapter> skillInfo;
    private DatabaseHelper databaseHelper;
    private User user;
    private double expCost;

    public RoleDescriptionController(IView view) {
        super(view);
    }

    @Override
    public void start() {
        user = user(activity, databaseHelper);
        setMainHeader(activity.getMainHeader(), user);
    }

    @Override
    public void init() {
        activity = (RoleDescriptionActivity) view;
        ExecutorService executor = Executors.newSingleThreadExecutor();

        // retrieve authenticated user session
        databaseHelper = new DatabaseHelper(activity.getApplicationContext());
        user = user(activity, databaseHelper);

        Intent intent = activity.getIntent();

        // set values
        String name = intent.getStringExtra("name");
        String roleDescription = intent.getStringExtra("roleDescription");

        int roleCollectionID = intent.getIntExtra("roleCollectionID", 0);
        int roleID = intent.getIntExtra("roleID", 0);
        int roleImage = intent.getIntExtra("roleImage", 0);
        int level = intent.getIntExtra("level", 0);
        int rating = intent.getIntExtra("rating", 0);

        skillInfo = (List<SkillInfoAdapter>) intent.getSerializableExtra("skillInfo");
        RoleCollection roleCollection = new RoleCollection(
                roleCollectionID, user.getId(), roleID, level, rating,
                skillInfo.get(0).getLevel(), skillInfo.get(1).getLevel(), skillInfo.get(2).getLevel(), skillInfo.get(3).getLevel(), skillInfo.get(4).getLevel()
        );

        // set buttons
        activity.getInventoryBtn().setOnClickListener(v -> {
            Intent nextIntent = new Intent(activity.getApplicationContext(), ItemSettingActivity.class);
            nextIntent.putExtra("roleCollectionID", roleCollection.getId());
            nextIntent.putExtra("name", name);
            nextIntent.putExtra("rating", roleCollection.getRating());
            nextIntent.putExtra("level", roleCollection.getLevel());
            activity.startActivity(nextIntent);
        });

        activity.getLevelUpBtn().setOnClickListener(v -> {
            // exp resource validation
            if(user.getExp() >= expCost) {
                // level up
                user.addExp(-expCost);
                roleCollection.levelUp();

                // display update
                expCost = UnitUtils.expCostsPerLevel[roleCollection.getLevel()]; // set current level exp cost
                activity.getLevel().setText("Level " + String.valueOf(roleCollection.getLevel()));
                activity.getRequiredExp().setText(String.format("%d EXP for next level!", (int) expCost));
                setMainHeader(activity.getMainHeader(), user);

                // update data
                UserLocalDAO.update(databaseHelper, user);
                RoleCollectionLocalDAO.update(databaseHelper, roleCollection);
            } else {
                alert(activity.getApplicationContext(), "Not enough EXP!");
            }
        });

        activity.getSkillUpBtn().setOnClickListener(v -> {
            Intent nextIntent = new Intent(activity.getApplicationContext(), SkillActivity.class);
            nextIntent.putExtra("roleCollectionID", roleCollection.getId());
            nextIntent.putExtra("name", name);
            nextIntent.putExtra("rating", roleCollection.getRating());
            nextIntent.putExtra("level", roleCollection.getLevel());
            activity.startActivity(nextIntent);
        });

        executor.execute(new SetImageTask(activity, activity.getUnitImageBtn(), roleImage));
        activity.getUnitImageBtn().setOnLongClickListener(v -> {
            Intent nextIntent = new Intent(activity.getApplicationContext(), RoleMergeActivity.class);
            nextIntent.putExtra("name", name);
            nextIntent.putExtra("roleImage", roleImage);
            nextIntent.putExtra("rating", roleCollection.getRating());
            activity.startActivity(nextIntent);
            return true;
        });

        // set current level exp cost
        expCost = UnitUtils.expCostsPerLevel[roleCollection.getLevel()];

        // set role view
        activity.getRoleName().setText(name);
        activity.getLevel().setText("Level " + String.valueOf(roleCollection.getLevel()));
        activity.getDescription().setText(roleDescription);
        activity.getRequiredExp().setText(String.format("%d EXP for next level!", (int) expCost));

        // set rating
        StarUtils.rewriteStar(activity.getRoleImageView().getRootView(), roleCollection.getRating());
        setRecyclerViews();

        activity.getBackBtn().setOnClickListener(v -> activity.finish());
    }

    @Override
    public void setRecyclerViews() {
        LinearLayoutManager gridLayoutManager = new LinearLayoutManager(activity, LinearLayoutManager.VERTICAL,false);
        SkillCardAdapter skillCardAdapter = new SkillCardAdapter(activity, skillInfo);
        setAdapter(activity.getRecyclerView(), gridLayoutManager, skillCardAdapter);
    }

}
