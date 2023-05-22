package com.example.autoraidrpg.controller;

import android.content.Intent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.autoraidrpg.IView;
import com.example.autoraidrpg.MainActivity;
import com.example.autoraidrpg.R;
import com.example.autoraidrpg.RoleMergeActivity;
import com.example.autoraidrpg.database.DatabaseHelper;
import com.example.autoraidrpg.executors.LoadImageTask;
import com.example.autoraidrpg.executors.SetImageTask;
import com.example.autoraidrpg.gameplay.entity.Entity;
import com.example.autoraidrpg.model.Role;
import com.example.autoraidrpg.model.User;
import com.example.autoraidrpg.population.RolePopulation;
import com.example.autoraidrpg.utils.StarUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class RoleMergeController extends Controller {

    private RoleMergeActivity activity;
    private List<TextView> unitNames;
    private List<View> mergingUnitViews;
    private Intent intent;
    private String name;
    private int rating, roleImage;
    private List<Entity> availableUnits;
    private ExecutorService executor;

    public RoleMergeController(IView view) {
        super(view);
    }

    @Override
    public void start() {
        // retrieve authenticated user session
        DatabaseHelper databaseHelper = new DatabaseHelper(activity.getApplicationContext());
        User user = user(activity, databaseHelper);
        setMainHeader(activity.getMainHeader(), user);
    }

    @Override
    public void init() {
        activity = (RoleMergeActivity) view;
        executor = Executors.newFixedThreadPool(LoadImageTask.NUMBER_OF_THREADS);
        intent = activity.getIntent();

        unitNames = new ArrayList<>();
        mergingUnitViews = new ArrayList<>();
        availableUnits = new ArrayList<>();

        // set values
        name = intent.getStringExtra("name");
        roleImage = intent.getIntExtra("roleImage", 0);
        rating = intent.getIntExtra("rating", 0);

        List<Role> roles = new ArrayList<>();
        RolePopulation.roleCollection(roles, availableUnits);

        // set unit views
        setMergingUnitSlot();

        // empty images
        emptyImages(mergingUnitViews);

        // set output of a merging unit
        StarUtils.rewriteStar(activity.getMergedUnit(), rating + 1);
        executor.execute(new SetImageTask(activity, activity.getUnitImageBtn(), roleImage));
        activity.getMergedUnitName().setText(name);

        List<Entity> duplicatedUnits = availableUnits.stream().filter(e -> e.getName().equalsIgnoreCase(name) && e.getRating() == rating).collect(Collectors.toList());

        // apply duplicated units
        for(int i = 0; i < duplicatedUnits.size(); i++) {
            if(i >= 3) break;

            Entity entity = duplicatedUnits.get(i);
            View unitView = mergingUnitViews.get(i);
            TextView textName = unitNames.get(i);

            ImageButton imageBtn = unitView.findViewById(R.id.unitImageBtn);
            StarUtils.rewriteStar(unitView, entity.getRating());
            executor.execute(new SetImageTask(activity, imageBtn, entity.getRoleImage()));
            textName.setText("ready!");
        }

        activity.getMergeBtn().setOnClickListener(v -> {
            int size = duplicatedUnits.size();

            if(size >= 3) {
                Toast toast = Toast.makeText(activity.getApplicationContext(),
                        String.format("Congrats! You acquired %d star - %s", rating + 1, name), Toast.LENGTH_SHORT);
                toast.show();
                setIntentOnListener(activity, MainActivity.class);
            } else {
                Toast toast = Toast.makeText(activity.getApplicationContext(),
                        String.format("Not enough requirements!", rating + 1, name), Toast.LENGTH_SHORT);
                toast.show();
            }
        });

        activity.getBackBtn().setOnClickListener(v -> activity.finish());
    }

    @Override
    public void setRecyclerViews() {}

    private void setMergingUnitSlot() {
        mergingUnitViews.add(activity.findViewById(R.id.mergingUnit1));
        mergingUnitViews.add(activity.findViewById(R.id.mergingUnit2));
        mergingUnitViews.add(activity.findViewById(R.id.mergingUnit3));

        unitNames.add(activity.findViewById(R.id.unitName1));
        unitNames.add(activity.findViewById(R.id.unitName2));
        unitNames.add(activity.findViewById(R.id.unitName3));
    }

    private void emptyImages(List<View> imageViews) {
        imageViews.stream().forEach(v -> executor.execute(new SetImageTask(activity, v.findViewById(R.id.unitImageBtn), R.color.dark_gray)));
    }

}
