package com.example.autoraidrpg;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.autoraidrpg.controller.BattleResultController;

public class BattleResultActivity extends AppCompatActivity implements IView {

    private View mainHeader;
    private TextView resultTitle, resultDescription, resultRewards;
    private Button battleFormationBtn, homeBtn, stageBtn;
    private BattleResultController battleResultController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle_result);

        mainHeader = findViewById(R.id.mainHeader);
        resultTitle = findViewById(R.id.resultTitle);
        resultDescription = findViewById(R.id.resultDescription);
        resultRewards = findViewById(R.id.resultRewards);

        battleFormationBtn = findViewById(R.id.battleFormationBtn);
        homeBtn = findViewById(R.id.homeBtn);
        stageBtn = findViewById(R.id.stageBtn);

        battleResultController = new BattleResultController(this);
        battleResultController.init();
    }

    @Override
    protected void onStart() {
        super.onStart();
        battleResultController.start();
    }

    @Override
    public void onBackPressed() {
        // Do nothing to disable the back button functionality
    }

    public View getMainHeader() { return mainHeader; }

    public TextView getResultTitle() {
        return resultTitle;
    }

    public TextView getResultDescription() {
        return resultDescription;
    }

    public TextView getResultRewards() {
        return resultRewards;
    }

    public Button getBattleFormationBtn() {
        return battleFormationBtn;
    }

    public Button getHomeBtn() {
        return homeBtn;
    }

    public Button getStageBtn() {
        return stageBtn;
    }

}