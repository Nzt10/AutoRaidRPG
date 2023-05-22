package com.example.autoraidrpg.utils;

import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.autoraidrpg.executors.LoadItemImageTask;
import com.example.autoraidrpg.gameplay.bag.Item;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ItemUtils {

    public final static ExecutorService executors = Executors.newSingleThreadExecutor();

    public static void designItem(Item item, ImageButton itemImageBtn, TextView itemName, TextView itemStats, TextView itemDescription) {

        executors.execute(new LoadItemImageTask((AppCompatActivity) itemImageBtn.getContext(), itemImageBtn, item.getItemImage()));
        itemName.setText(item.getName());

        String stats = "";

        for(int i = 0; i < item.getDescription().size() - 1; i++) {
            stats += item.getDescription().get(i) + "\n";
        }

        itemStats.setText(stats);
        itemDescription.setText(item.getDescription().get(item.getDescription().size() - 1));

    }

}
