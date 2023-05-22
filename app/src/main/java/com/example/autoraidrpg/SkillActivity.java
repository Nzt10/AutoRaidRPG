package com.example.autoraidrpg;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.autoraidrpg.controller.SkillController;

public class SkillActivity extends AppCompatActivity implements IView, StatsView {

    private View mainHeader;
    private ImageButton backBtn, unitImageBtn;
    private RecyclerView recyclerView;

    // entity instances
    private View roleImageView, unitStatsView;
    private TextView roleName, level,
            health, physicalDamage, magicalDamage, physicalDefense, magicalDefense, speed,
            criticalChance, criticalDamage, dodge, armorPenetration, magicPenetration, accuracy;
    private SkillController skillController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skill);

        mainHeader = findViewById(R.id.mainHeader);
        recyclerView = findViewById(R.id.skillView);
        backBtn = findViewById(R.id.backBtn);

        // stat views
        level = findViewById(R.id.level);
        unitStatsView = findViewById(R.id.unitStatsView);
        roleImageView = unitStatsView.findViewById(R.id.roleImageView);
        unitImageBtn = roleImageView.findViewById(R.id.unitImageBtn);
        roleName = unitStatsView.findViewById(R.id.roleName);

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

        skillController = new SkillController(this);
        skillController.init();
    }

    @Override
    protected void onStart() {
        super.onStart();
        skillController.start();
    }

    public View getMainHeader() { return mainHeader; }

    public ImageButton getBackBtn() {
        return backBtn;
    }

    public RecyclerView getRecyclerView() {
        return recyclerView;
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

    public TextView getLevel() { return level; }

    public TextView getRoleName() {
        return roleName;
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
}