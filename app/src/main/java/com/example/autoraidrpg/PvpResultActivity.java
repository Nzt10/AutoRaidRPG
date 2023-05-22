package com.example.autoraidrpg;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.autoraidrpg.controller.BattleResultController;
import com.example.autoraidrpg.controller.PvpResultController;

public class PvpResultActivity extends AppCompatActivity implements IView {

    private View mainHeader;
    private TextView resultTitle, resultDescription, resultRewards;
    private Button battleFormationBtn, homeBtn, arenaBtn;
    private PvpResultController pvpResultController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pvp_result);

        mainHeader = findViewById(R.id.mainHeader);
        resultTitle = findViewById(R.id.resultTitle);
        resultDescription = findViewById(R.id.resultDescription);
        resultRewards = findViewById(R.id.resultRewards);

        battleFormationBtn = findViewById(R.id.battleFormationBtn);
        homeBtn = findViewById(R.id.homeBtn);
        arenaBtn = findViewById(R.id.arenaBtn);

        pvpResultController = new PvpResultController(this);
        pvpResultController.init();
    }

    @Override
    protected void onStart() {
        super.onStart();
        pvpResultController.start();
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

    public Button getArenaBtn() {
        return arenaBtn;
    }

}