package com.example.autoraidrpg.controller;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.autoraidrpg.BattleInformationActivity;
import com.example.autoraidrpg.IView;
import com.example.autoraidrpg.adapter.BattleInformationAdapter;

public class BattleInformationController extends Controller {

    private BattleInformationActivity activity;

    public BattleInformationController(IView view) {
        super(view);
    }

    @Override
    public void init() {
        activity = (BattleInformationActivity) view;
        setRecyclerViews();
    }

    @Override
    public void setRecyclerViews() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false);
        BattleInformationAdapter battleInformationAdapter = new BattleInformationAdapter(activity);
        setAdapter(activity.getRecyclerView(), linearLayoutManager, battleInformationAdapter);
    }

}
