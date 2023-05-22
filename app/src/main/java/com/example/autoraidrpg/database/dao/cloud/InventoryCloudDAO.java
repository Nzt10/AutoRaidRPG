package com.example.autoraidrpg.database.dao.cloud;

import android.content.Context;

import com.example.autoraidrpg.model.Inventory;
import com.example.autoraidrpg.model.Position;
import com.example.autoraidrpg.model.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;

import java.util.ArrayList;
import java.util.List;

public class InventoryCloudDAO extends CloudDAO {


    public InventoryCloudDAO(Context context) {
        super(context, "inventories");
    }

    public void store(Inventory inventory) {
        DatabaseReference newDatabaseRef = databaseRef.push();
        newDatabaseRef.setValue(inventory);
        // inventory.setFirebaseID(newDatabaseRef.getKey());
    }

    public Inventory retrieve(String firebaseID) {
        Query query = databaseRef.orderByChild("firebaseID").equalTo(firebaseID).limitToFirst(1);
        DataSnapshot dataSnapshot = query.get().getResult();
        Inventory inventory = null;

        if (dataSnapshot.exists()) {
            DataSnapshot firstSnapshot = dataSnapshot.getChildren().iterator().next();
            inventory = firstSnapshot.getValue(Inventory.class);
        }

        return inventory;
    }

    public List<Inventory> retrieveAll(String userFirebaseID) {
        Query query = databaseRef.orderByChild("userFirebaseID").equalTo(userFirebaseID);
        DataSnapshot dataSnapshot = query.get().getResult();
        List<Inventory> inventories = new ArrayList<>();

        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
            inventories.add(snapshot.getValue(Inventory.class));
        }

        return inventories;
    }

}
