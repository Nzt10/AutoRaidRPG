package com.example.autoraidrpg;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.autoraidrpg.controller.MainController;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements IView {

    private View mainHeader, battleBtnView, arenaBtnView, characterShopBtnView, itemShopBtnView, roleCollectionBtnView, itemCollectionBtnView, diamondShopBtnView, battleFormationBtnView;
    private List<View> formations;
    private Button logoutBtn;
    private MainController mainController;

    private TextView batteryText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        batteryText = findViewById(R.id.batteryText);

        formations = new ArrayList<>();
        formations.add(findViewById(R.id.formation1));
        formations.add(findViewById(R.id.formation2));
        formations.add(findViewById(R.id.formation3));
        formations.add(findViewById(R.id.formation4));
        formations.add(findViewById(R.id.formation5));

        mainHeader = findViewById(R.id.mainHeader);
        battleBtnView = findViewById(R.id.battleBtnView);
        arenaBtnView = findViewById(R.id.arenaBtnView);
        characterShopBtnView = findViewById(R.id.characterShopBtnView);
        itemShopBtnView = findViewById(R.id.itemShopBtnView);
        roleCollectionBtnView = findViewById(R.id.roleCollectionBtnView);
        itemCollectionBtnView = findViewById(R.id.itemCollectionBtnView);
        diamondShopBtnView = findViewById(R.id.diamondShopBtnView);
        battleFormationBtnView = findViewById(R.id.battleFormationBtnView);

        logoutBtn = findViewById(R.id.logoutBtn);
        mainController = new MainController(this);
        mainController.init();
    }

    @Override
    protected void onStart() {
        super.onStart();
        mainController.start();
    }

    @Override
    public void onBackPressed() {
        // Do nothing to disable the back button functionality
    }

    public View getMainHeader() {
        return mainHeader;
    }

    public TextView getBatteryText() {
        return batteryText;
    }

    public View getBattleBtnView() {
        return battleBtnView;
    }

    public View getArenaBtnView() {
        return arenaBtnView;
    }

    public View getCharacterShopBtnView() {
        return characterShopBtnView;
    }

    public View getItemShopBtnView() {
        return itemShopBtnView;
    }

    public View getRoleCollectionBtnView() {
        return roleCollectionBtnView;
    }

    public View getItemCollectionBtnView() {
        return itemCollectionBtnView;
    }

    public View getDiamondShopBtnView() {
        return diamondShopBtnView;
    }

    public View getBattleFormationBtnView() {
        return battleFormationBtnView;
    }

    public List<View> getFormations() {
        return formations;
    }

    public Button getLogoutBtn() {
        return logoutBtn;
    }

}