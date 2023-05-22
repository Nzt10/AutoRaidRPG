package com.example.autoraidrpg;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.autoraidrpg.controller.PurchaseDiamondController;

public class PurchaseDiamondActivity extends AppCompatActivity implements IView {

    private View mainHeader;
    private ImageButton backBtn;
    private PurchaseDiamondController purchaseDiamondController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase_diamond);

        mainHeader = findViewById(R.id.mainHeader);
        backBtn = findViewById(R.id.backBtn);

        purchaseDiamondController = new PurchaseDiamondController(this);
        purchaseDiamondController.init();
    }

    @Override
    protected void onStart() {
        super.onStart();
        purchaseDiamondController.start();
    }

    public View getMainHeader() { return mainHeader; }

    public ImageButton getBackBtn() {
        return backBtn;
    }

}