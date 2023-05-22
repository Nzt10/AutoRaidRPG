package com.example.autoraidrpg.database.dao.cloud;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;

import com.example.autoraidrpg.model.Formation;
import com.example.autoraidrpg.model.Inventory;
import com.example.autoraidrpg.model.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class FormationCloudDAO extends CloudDAO {

    public FormationCloudDAO(Context context) {
        super(context, "formations");
    }

    public void store(Formation formation) {
        DatabaseReference newDatabaseRef = databaseRef.push();
        newDatabaseRef.setValue(formation);
        // formation.setFirebaseID(newDatabaseRef.getKey());
    }

    public void retrieveByUserID(String userFirebaseID, Consumer<Formation> next) {
        Query query = databaseRef.orderByChild("userFirebaseID").equalTo(userFirebaseID).limitToFirst(1);
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    DataSnapshot firstSnapshot = dataSnapshot.getChildren().iterator().next();
                    Formation formation = firstSnapshot.getValue(Formation.class);
                    // formation.setFirebaseID(firstSnapshot.getKey());
                    next.accept(formation);
                } else {
                    // Handle the case where no data exists
                    Log.i("FIREBASE", "No formation found");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Handle any errors that occurred during the database operation
            }
        });
    }

    public List<Formation> retrieveAll(String userFirebaseID) {
        Query query = databaseRef.orderByChild("userFirebaseID").equalTo(userFirebaseID);
        DataSnapshot dataSnapshot = query.get().getResult();
        List<Formation> formations = new ArrayList<>();

        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
            formations.add(snapshot.getValue(Formation.class));
        }

        return formations;
    }

}
