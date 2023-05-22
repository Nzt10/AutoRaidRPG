package com.example.autoraidrpg;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.autoraidrpg.controller.RoleBuyController;

public class RoleBuyActivity extends AppCompatActivity implements IView {

    private View mainHeader;
    private RecyclerView recyclerView;
    private View roleImageView;
    private TextView roleName, description;
    private ImageButton backBtn, unitImageBtn;
    private Button buyWithCoinBtn, buyWithDiamondBtn;
    private RoleBuyController roleBuyController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_role_buy);

        mainHeader = findViewById(R.id.mainHeader);
        recyclerView = findViewById(R.id.skillView);
        roleImageView = findViewById(R.id.roleImageView);
        roleName = findViewById(R.id.roleName);
        description = findViewById(R.id.description);

        unitImageBtn = roleImageView.findViewById(R.id.unitImageBtn);
        buyWithCoinBtn = findViewById(R.id.buyWithCoinBtn);
        buyWithDiamondBtn = findViewById(R.id.buyWithDiamondBtn);
        backBtn = findViewById(R.id.backBtn);

        roleBuyController = new RoleBuyController(this);
        roleBuyController.init();
    }

    @Override
    protected void onStart() {
        super.onStart();
        roleBuyController.start();
    }

    public View getMainHeader() { return mainHeader; }

    public RecyclerView getRecyclerView() {
        return recyclerView;
    }

    public View getRoleImageView() {
        return roleImageView;
    }

    public TextView getRoleName() {
        return roleName;
    }

    public TextView getDescription() {
        return description;
    }

    public ImageButton getBackBtn() {
        return backBtn;
    }

    public ImageButton getUnitImageBtn() {
        return unitImageBtn;
    }

    public Button getBuyWithCoinBtn() {
        return buyWithCoinBtn;
    }

    public Button getBuyWithDiamondBtn() {
        return buyWithDiamondBtn;
    }

}