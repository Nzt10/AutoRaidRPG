package com.example.autoraidrpg.database.dao.cloud;

import android.content.Context;

import com.example.autoraidrpg.model.Inventory;
import com.example.autoraidrpg.model.RoleCollection;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;

import java.util.ArrayList;
import java.util.List;

public class RoleCollectionCloudDAO extends CloudDAO {

    public RoleCollectionCloudDAO(Context context) {
        super(context, "roleCollections");
    }

    public void store(RoleCollection roleCollection) {
        DatabaseReference newDatabaseRef = databaseRef.push();
        newDatabaseRef.setValue(roleCollection);
        // roleCollection.setFirebaseID(newDatabaseRef.getKey());
    }

    public RoleCollection retrieve(String firebaseID) {
        Query query = databaseRef.orderByChild("firebaseID").equalTo(firebaseID).limitToFirst(1);
        DataSnapshot dataSnapshot = query.get().getResult();
        RoleCollection roleCollection = null;

        if (dataSnapshot.exists()) {
            DataSnapshot firstSnapshot = dataSnapshot.getChildren().iterator().next();
            roleCollection = firstSnapshot.getValue(RoleCollection.class);
        }

        return roleCollection;
    }

    public List<RoleCollection> retrieveAll(String userFirebaseID) {
        Query query = databaseRef.orderByChild("userFirebaseID").equalTo(userFirebaseID);
        DataSnapshot dataSnapshot = query.get().getResult();
        List<RoleCollection> roleCollections = new ArrayList<>();

        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
            roleCollections.add(snapshot.getValue(RoleCollection.class));
        }

        return roleCollections;
    }

}
