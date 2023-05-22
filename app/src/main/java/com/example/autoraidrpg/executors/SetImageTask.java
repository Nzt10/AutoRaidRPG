package com.example.autoraidrpg.executors;

import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.concurrent.CountDownLatch;

public class SetImageTask implements Runnable {

    protected AppCompatActivity activity;
    private final ImageView imageView;
    private final int resourceID;

    public SetImageTask(AppCompatActivity activity, ImageView imageView, int resourceID) {
        this.activity = activity;
        this.imageView = imageView;
        this.resourceID = resourceID;
    }

    @Override
    public void run() {
        activity.runOnUiThread(() -> {
            imageView.setBackgroundResource(resourceID);
        });
    }

}
