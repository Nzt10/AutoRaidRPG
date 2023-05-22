package com.example.autoraidrpg.executors;

import android.graphics.Bitmap;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

import java.io.IOException;

public abstract class LoadImageTask implements Runnable {

    public final static int NUMBER_OF_THREADS = 6;

    protected AppCompatActivity activity;
    private final ImageView imageView;
    private final int resourceID;
    protected int width, height;

    public LoadImageTask(AppCompatActivity activity, ImageView imageView, int resourceID, int width, int height) {
        this.activity = activity;
        this.imageView = imageView;
        this.resourceID = resourceID;
        this.width = width;
        this.height = height;
    }

    public void setWidth(int width) { this.width = width; }
    public void setHeight(int height) { this.height = height; }

    @Override
    public void run() {
        Bitmap bitmap = null;

        try {
            bitmap = Picasso.get()
                        .load(resourceID)
                        .resize(width, height)
                        .get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        final Bitmap finalBitmap = bitmap;

        activity.runOnUiThread(() -> {
            if (finalBitmap != null) {
                imageView.setImageBitmap(finalBitmap);
            }
        });
    }
}
