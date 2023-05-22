package com.example.autoraidrpg.controller;

import static android.content.Context.MODE_PRIVATE;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.text.TextUtils;

import com.example.autoraidrpg.IView;
import com.example.autoraidrpg.LandingActivity;
import com.example.autoraidrpg.LoginActivity;
import com.example.autoraidrpg.MainActivity;
import com.example.autoraidrpg.authentication.AuthConfig;
import com.example.autoraidrpg.database.dao.cloud.CloudDAO;
import com.example.autoraidrpg.database.dao.cloud.UserCloudDAO;
import com.example.autoraidrpg.model.User;
import com.google.gson.Gson;

public class LandingController extends Controller {

    private LandingActivity activity;
    private int i;
    private Handler handler;

    public LandingController(IView view) {
        super(view);
    }

    @Override
    public void init() {
        activity = (LandingActivity) view;
        handler = new Handler();
        new Thread(this::startProgress).start();
    }

    @Override
    public void setRecyclerViews() {}

    @SuppressLint("SetTextI18n")
    private void startProgress() {
        for (i = 0; i < 100; i++) {
            try {
                Thread.sleep(20);
                activity.getProgressBar().setProgress(i);
            } catch (InterruptedException e) { e.printStackTrace(); }

            handler.post(() -> activity.getLoadingText().setText("Initializing... " + i + "%"));
        }

        // check user session
        if(this.isAuthenticated(activity)) {
            setIntentOnListener(activity, MainActivity.class);
        } else {
            setIntentOnListener(activity, LoginActivity.class);
        }

    }

}
