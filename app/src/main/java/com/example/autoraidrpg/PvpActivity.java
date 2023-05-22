package com.example.autoraidrpg;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.autoraidrpg.controller.PvpController;

public class PvpActivity extends AppCompatActivity implements IView {

    private View mainHeader;
    private ProgressBar roundGauge;
    private TextView unitTurn, turnDescription, roundNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pvp);

        mainHeader = findViewById(R.id.mainHeader);
        roundNum = mainHeader.findViewById(R.id.roundNum);

        roundGauge = findViewById(R.id.roundGauge);
        unitTurn = findViewById(R.id.unitTurn);
        turnDescription = findViewById(R.id.turnDescription);

        new PvpController(this).init();
    }

    @Override
    public void onBackPressed() {
        // Do nothing to disable the back button functionality
    }

    public View getMainHeader() {
        return mainHeader;
    }

    public ProgressBar getRoundGauge() {
        return roundGauge;
    }

    public TextView getUnitTurn() {
        return unitTurn;
    }

    public TextView getTurnDescription() {
        return turnDescription;
    }

    public TextView getRoundNum() {
        return roundNum;
    }

}