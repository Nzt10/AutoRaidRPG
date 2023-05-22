package com.example.autoraidrpg.controller;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.autoraidrpg.DiamondShopActivity;
import com.example.autoraidrpg.IView;
import com.example.autoraidrpg.adapter.BundleCardAdapter;
import com.example.autoraidrpg.database.DatabaseHelper;
import com.example.autoraidrpg.listener.OnClickPurchaseListener;
import com.example.autoraidrpg.model.User;

public class DiamondShopController extends Controller {

    private DiamondShopActivity activity;

    public DiamondShopController(IView view) {
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
        activity = (DiamondShopActivity) view;

        // retrieve
        setRecyclerViews();
        activity.getBackBtn().setOnClickListener(v -> activity.finish());
    }

    @Override
    public void setRecyclerViews() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(activity, 3, LinearLayoutManager.VERTICAL,false);
        BundleCardAdapter bundleCardAdapter = new BundleCardAdapter(activity);
        bundleCardAdapter.setOnClickPurchaseListener(new OnClickPurchaseListener(activity, intent -> activity.startActivity(intent)));

        setAdapter(activity.getRecyclerView(), gridLayoutManager, bundleCardAdapter);
    }

}
