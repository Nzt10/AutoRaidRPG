package com.example.autoraidrpg;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.autoraidrpg.controller.BattleFormationController;

public class BattleFormationActivity extends AppCompatActivity implements IView, StatsView {

    public static final int MAX_UNIT = 5;

    private RecyclerView recyclerViewSide, recyclerViewBottom;
    private ImageButton backBtn, unitImageBtn;

    // entity instances
    private View mainHeader, roleImageView, unitStatsView;
    private TextView roleName, level,
            health, physicalDamage, magicalDamage, physicalDefense, magicalDefense, speed,
            criticalChance, criticalDamage, dodge, armorPenetration, magicPenetration, accuracy;
    private Button battleBtn, formationA, formationB, formationC, formationD, formationE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle_formation);

        // recycler views
        recyclerViewSide = findViewById(R.id.selectionView);
        recyclerViewBottom = findViewById(R.id.skillView);

        // view components
        mainHeader = findViewById(R.id.mainHeader);
        unitStatsView = findViewById(R.id.unitStatsView);
        roleImageView = unitStatsView.findViewById(R.id.roleImageView);
        unitImageBtn = roleImageView.findViewById(R.id.unitImageBtn);
        roleName = unitStatsView.findViewById(R.id.roleName);
        level = unitStatsView.findViewById(R.id.level);

        // stat views
        health = unitStatsView.findViewById(R.id.health);
        physicalDamage = unitStatsView.findViewById(R.id.physicalDamage);
        magicalDamage = unitStatsView.findViewById(R.id.magicalDamage);
        physicalDefense = unitStatsView.findViewById(R.id.physicalDefense);
        magicalDefense = unitStatsView.findViewById(R.id.magicalDefense);
        speed = unitStatsView.findViewById(R.id.speed);

        criticalChance = unitStatsView.findViewById(R.id.criticalChance);
        criticalDamage = unitStatsView.findViewById(R.id.criticalDamage);
        dodge = unitStatsView.findViewById(R.id.dodge);
        armorPenetration = unitStatsView.findViewById(R.id.armorPenetration);
        magicPenetration = unitStatsView.findViewById(R.id.magicPenetration);
        accuracy = unitStatsView.findViewById(R.id.accuracy);

        formationA = findViewById(R.id.formationA);
        formationB = findViewById(R.id.formationB);
        formationC = findViewById(R.id.formationC);
        formationD = findViewById(R.id.formationD);
        formationE = findViewById(R.id.formationE);

        backBtn = findViewById(R.id.backBtn);
        battleBtn = findViewById(R.id.battleBtn);

        new BattleFormationController(this).init();
    }

    public View getMainHeader() { return mainHeader; }

    public RecyclerView getRecyclerViewSide() {
        return recyclerViewSide;
    }

    public RecyclerView getRecyclerViewBottom() {
        return recyclerViewBottom;
    }

    public ImageButton getBackBtn() {
        return backBtn;
    }

    public ImageButton getUnitImageBtn() {
        return unitImageBtn;
    }

    public View getRoleImageView() {
        return roleImageView;
    }

    public View getUnitStatsView() {
        return unitStatsView;
    }

    public TextView getRoleName() {
        return roleName;
    }
    public TextView getLevel() {
        return level;
    }

    public Button getBattleBtn() {
        return battleBtn;
    }

    @Override
    public TextView getHealth() {
        return health;
    }

    @Override
    public TextView getPhysicalDamage() {
        return physicalDamage;
    }

    @Override
    public TextView getMagicalDamage() {
        return magicalDamage;
    }

    @Override
    public TextView getPhysicalDefense() {
        return physicalDefense;
    }

    @Override
    public TextView getMagicalDefense() {
        return magicalDefense;
    }

    @Override
    public TextView getSpeed() {
        return speed;
    }

    @Override
    public TextView getCriticalChance() {
        return criticalChance;
    }

    @Override
    public TextView getCriticalDamage() {
        return criticalDamage;
    }

    @Override
    public TextView getDodge() {
        return dodge;
    }

    @Override
    public TextView getArmorPenetration() {
        return armorPenetration;
    }

    @Override
    public TextView getMagicPenetration() {
        return magicPenetration;
    }

    @Override
    public TextView getAccuracy() {
        return accuracy;
    }

    public Button getFormationA() {
        return formationA;
    }

    public Button getFormationB() {
        return formationB;
    }

    public Button getFormationC() {
        return formationC;
    }

    public Button getFormationD() {
        return formationD;
    }

    public Button getFormationE() {
        return formationE;
    }
}