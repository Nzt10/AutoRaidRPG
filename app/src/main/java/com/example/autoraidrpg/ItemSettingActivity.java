package com.example.autoraidrpg;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.autoraidrpg.controller.ItemSettingController;

public class ItemSettingActivity extends AppCompatActivity implements IView, StatsView {

    private View mainHeader;
    private RecyclerView recyclerView;
    private ImageButton backBtn, selectedItem, unitImageBtn;
    private Button equipBtn, showBtn;

    // entity instances
    private View roleImageView, unitStatsView;
    private TextView roleName, level,
            health, physicalDamage, magicalDamage, physicalDefense, magicalDefense, speed,
            criticalChance, criticalDamage, dodge, armorPenetration, magicPenetration, accuracy;
    private ItemSettingController itemSettingController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_setting);

        mainHeader = findViewById(R.id.mainHeader);
        recyclerView = findViewById(R.id.itemShopView);
        selectedItem = findViewById(R.id.selectedItem);
        equipBtn = findViewById(R.id.equipBtn);
        showBtn = findViewById(R.id.showBtn);
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

        itemSettingController = new ItemSettingController(this);
        itemSettingController.init();
    }

    @Override
    protected void onStart() {
        super.onStart();
        itemSettingController.start();
    }

    public View getMainHeader() { return mainHeader; }

    public RecyclerView getRecyclerView() {
        return recyclerView;
    }

    public ImageButton getBackBtn() {
        return backBtn;
    }

    public ImageButton getSelectedItem() {
        return selectedItem;
    }

    public Button getEquipBtn() {
        return equipBtn;
    }

    public Button getShowBtn() {
        return showBtn;
    }

    public TextView getLevel() { return level; }

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

}