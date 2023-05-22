package com.example.autoraidrpg.database.dao.cloud;

import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.autoraidrpg.model.Position;
import com.example.autoraidrpg.model.RoleCollection;
import com.example.autoraidrpg.model.Stage;
import com.example.autoraidrpg.model.User;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class StageCloudDAO extends CloudDAO {

    public StageCloudDAO(Context context) {
        super(context, "stages");
    }

    public void store(Stage stage) {
        DatabaseReference newDatabaseRef = databaseRef.push();
        newDatabaseRef.setValue(stage);
    }

    public Stage retrieveByUserID(String userFirebaseID) {
        Query query = databaseRef.orderByChild("userFirebaseID").equalTo(userFirebaseID);
        DataSnapshot dataSnapshot = query.get().getResult();
        Stage stage = null;

        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
            stage = snapshot.getValue(Stage.class);
        }

        return stage;
    }

    public void put(String userFirebaseID, Stage stage) {
        Query query = databaseRef.orderByChild("userFirebaseID").equalTo(userFirebaseID);
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    // Retrieve the data
                    String dataKey = snapshot.getKey();
                    DatabaseReference dataRef = databaseRef.child(dataKey);
                    dataRef.child("value").setValue(stage.getValue());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {}
        });
    }

}
