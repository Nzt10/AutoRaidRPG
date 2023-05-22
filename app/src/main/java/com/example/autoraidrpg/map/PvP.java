package com.example.autoraidrpg.map;

import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.autoraidrpg.adapter.PreparationUnitInfoAdapter;

import java.util.List;

public class Pvp {

    public static Pvp pvp = null;

    private List<PreparationUnitInfoAdapter> yourUnitInfo;
    private AppCompatActivity activity;
    private Button battleBtn;

    public void setUnitInfo(List<PreparationUnitInfoAdapter> yourUnitInfo) {
        this.yourUnitInfo = yourUnitInfo;
    }


    public void setActivity(AppCompatActivity activity) {
        this.activity = activity;
    }
    public void setBattleBtn(Button battleBtn) {
        this.battleBtn = battleBtn;
    }

    public static Pvp getInstance() {
        if(pvp == null) {
            pvp = new Pvp();
        }
        return pvp;
    }

    public void setOnClickListener(View.OnClickListener listener) {
        battleBtn.setOnClickListener(listener);
    }

    public AppCompatActivity getActivity() {
        return activity;
    }
    public List<PreparationUnitInfoAdapter> getUnitInfo() {
        return yourUnitInfo;
    }

}
