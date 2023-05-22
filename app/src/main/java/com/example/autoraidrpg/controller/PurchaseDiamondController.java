package com.example.autoraidrpg.controller;

import com.example.autoraidrpg.IView;
import com.example.autoraidrpg.PurchaseDiamondActivity;
import com.example.autoraidrpg.database.DatabaseHelper;
import com.example.autoraidrpg.model.User;

public class PurchaseDiamondController extends Controller {

    private PurchaseDiamondActivity activity;

    public PurchaseDiamondController(IView view) {
        super(view);
    }

    @Override
    public void start() {
        // retrieve authenticated user session
        DatabaseHelper databaseHelper = new DatabaseHelper(activity.getApplicationContext());
        User user = user(activity, databaseHelper);
        setMainHeader(activity.getMainHeader(), user);
    }

    @Override
    public void init() {
        activity = (PurchaseDiamondActivity) view;
        activity.getBackBtn().setOnClickListener(v -> activity.finish());
    }

    @Override
    public void setRecyclerViews() {}

}
