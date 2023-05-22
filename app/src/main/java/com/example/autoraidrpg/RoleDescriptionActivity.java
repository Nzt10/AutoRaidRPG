package com.example.autoraidrpg;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.autoraidrpg.controller.RoleDescriptionController;

public class RoleDescriptionActivity extends AppCompatActivity implements IView {

    private View mainHeader;
    private RecyclerView recyclerView;
    private View roleImageView;
    private ImageButton backBtn, unitImageBtn;
    private Button inventoryBtn, levelUpBtn, skillUpBtn;
    private TextView roleName, level, description, requiredExp;
    private RoleDescriptionController roleDescriptionController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_role_description);

        mainHeader = findViewById(R.id.mainHeader);
        recyclerView = findViewById(R.id.skillView);
        levelUpBtn = findViewById(R.id.levelUpBtn);
        skillUpBtn = findViewById(R.id.skillUpBtn);
        roleImageView = findViewById(R.id.roleImageView);

        inventoryBtn = findViewById(R.id.inventoryBtn);
        unitImageBtn = roleImageView.findViewById(R.id.unitImageBtn);
        backBtn = findViewById(R.id.backBtn);

        roleName = findViewById(R.id.roleName);
        level = findViewById(R.id.level);
        description = findViewById(R.id.description);
        requiredExp = findViewById(R.id.requiredExp);

        roleDescriptionController = new RoleDescriptionController(this);
        roleDescriptionController.init();
    }

    @Override
    protected void onStart() {
        super.onStart();
        roleDescriptionController.start();
    }

    public View getMainHeader() { return mainHeader; }

    public RecyclerView getRecyclerView() {
        return recyclerView;
    }

    public View getRoleImageView() {
        return roleImageView;
    }

    public ImageButton getBackBtn() {
        return backBtn;
    }

    public ImageButton getUnitImageBtn() {
        return unitImageBtn;
    }

    public Button getInventoryBtn() {
        return inventoryBtn;
    }

    public Button getLevelUpBtn() {
        return levelUpBtn;
    }

    public Button getSkillUpBtn() {
        return skillUpBtn;
    }

    public TextView getRoleName() {
        return roleName;
    }

    public TextView getLevel() {
        return level;
    }

    public TextView getDescription() {
        return description;
    }

    public TextView getRequiredExp() {
        return requiredExp;
    }

}