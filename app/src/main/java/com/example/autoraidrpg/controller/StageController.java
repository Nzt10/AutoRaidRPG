package com.example.autoraidrpg.controller;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.autoraidrpg.IView;
import com.example.autoraidrpg.StageActivity;
import com.example.autoraidrpg.adapter.StageCardAdapter;
import com.example.autoraidrpg.database.DatabaseHelper;
import com.example.autoraidrpg.database.dao.local.StageLocalDAO;
import com.example.autoraidrpg.gameplay.stage.StageFactory;
import com.example.autoraidrpg.model.Stage;
import com.example.autoraidrpg.model.User;

public class StageController extends Controller {

    private StageActivity activity;
    private Stage stage;

    public StageController(IView view) {
        super(view);
    }

    @Override
    public void start() {
        // retrieve authenticated user session
        DatabaseHelper databaseHelper = new DatabaseHelper(activity.getApplicationContext());
        User user = user(activity, databaseHelper);
        stage = StageLocalDAO.retrieve(databaseHelper, user.getId());
        setAuthHeader(activity.getMainHeader(), "CURRENT: STAGE " + stage.getValue());
        setRecyclerViews();
    }

    @Override
    public void init() {
        activity = (StageActivity) view;
        activity.getBackBtn().setOnClickListener(v -> activity.finish());
    }

    @Override
    public void setRecyclerViews() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(activity, LinearLayoutManager.VERTICAL,false);
        StageCardAdapter stageCardAdapter = new StageCardAdapter(activity, stage.getValue());
        stageCardAdapter.setConsumer(intent -> activity.startActivity(intent));
        setAdapter(activity.getRecyclerView(), linearLayoutManager, stageCardAdapter);
    }

}
