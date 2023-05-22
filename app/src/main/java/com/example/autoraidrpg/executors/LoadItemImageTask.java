package com.example.autoraidrpg.executors;

import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.autoraidrpg.R;

public class LoadItemImageTask extends LoadImageTask {

    public LoadItemImageTask(AppCompatActivity activity, ImageView imageView, int resourceID) {
        super(activity, imageView, resourceID, (int) activity.getResources().getDimension(R.dimen.item_size), (int) activity.getResources().getDimension(R.dimen.item_size));
    }

}
