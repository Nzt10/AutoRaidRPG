package com.example.autoraidrpg.controller;

import android.content.Intent;

import com.example.autoraidrpg.BattleInformationActivity;
import com.example.autoraidrpg.BattleResultActivity;
import com.example.autoraidrpg.IView;
import com.example.autoraidrpg.MainActivity;
import com.example.autoraidrpg.StageActivity;
import com.example.autoraidrpg.gameplay.global.BattleInformationObserver;

public class BattleResultController extends Controller {

    public BattleResultController(IView view) {
        super(view);
    }

    @Override
    public void init() {
        BattleResultActivity activity = (BattleResultActivity) view;
        setAuthHeader(activity.getMainHeader(), "Battle Result");

        Intent intent = activity.getIntent();

        // setup intent
        String result = intent.getStringExtra("result");
        String reward = intent.getStringExtra("reward");

        String state;
        if(result.contains("WIN")) state = "WINNER";
        else state = "LOSER";

        activity.getResultTitle().setText(state);
        activity.getResultDescription().setText(result);
        activity.getResultRewards().setText(reward);

        activity.getBattleFormationBtn().setOnClickListener(v -> setIntentOnListener(activity, BattleInformationActivity.class));

        activity.getHomeBtn().setOnClickListener(v -> {
            setIntentOnListener(activity, MainActivity.class);
            BattleInformationObserver.getInstance().clearAll();
        });

        activity.getStageBtn().setOnClickListener(v -> {
            setIntentOnListener(activity, StageActivity.class);
            BattleInformationObserver.getInstance().clearAll();
        });
    }

    @Override
    public void setRecyclerViews() {}

}
