package com.example.autoraidrpg.database.dao.cloud;

import android.content.Context;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.function.Consumer;

public abstract class CloudDAO {

    protected DatabaseReference databaseRef;
    protected Context context;

    public CloudDAO(Context context, String collection_name) {
        FirebaseApp.initializeApp(context);
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
        databaseRef = FirebaseDatabase.getInstance("https://auto-raid-rpg-default-rtdb.asia-southeast1.firebasedatabase.app").getReference(collection_name);
        this.context = context;
    }

}
