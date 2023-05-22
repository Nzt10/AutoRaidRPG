package com.example.autoraidrpg.database.dao.cloud;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;

import com.example.autoraidrpg.model.Formation;
import com.example.autoraidrpg.model.Position;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.function.Consumer;

public class PositionCloudDAO extends CloudDAO {

    public PositionCloudDAO(Context context) {
        super(context, "positions");
    }

    public void store(Position position) {
        DatabaseReference newDatabaseRef = databaseRef.push();
        newDatabaseRef.setValue(position);
        // position.setFirebaseID(newDatabaseRef.getKey());
    }

    public void retrieve(String firebaseID, Consumer<Position> next) {
        Query query = databaseRef.orderByChild("firebaseID").equalTo(firebaseID).limitToFirst(1);
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Position position = new Position();

                if (dataSnapshot.exists()) {
                    DataSnapshot firstSnapshot = dataSnapshot.getChildren().iterator().next();
                    position = firstSnapshot.getValue(Position.class);
                    // position.setFirebaseID(firstSnapshot.getKey());
                } else {
                    // Handle the case where no data exists
                    position.setIndex(-1);
                    Log.i("FIREBASE", "No formation found");
                }

                next.accept(position);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Handle any errors that occurred during the database operation
            }
        });
    }

    public void put(String firebaseID, Position position) {
        Query query = databaseRef.orderByChild("firebaseID").equalTo(firebaseID);
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    // Retrieve the data
                    String dataKey = snapshot.getKey();
                    DatabaseReference dataRef = databaseRef.child(dataKey);
                    // dataRef.child("firebaseID").setValue(position.getFirebaseID());
                    // dataRef.child("roleCollectionFirebaseID").setValue(position.getRoleCollectionFirebaseID());
                    dataRef.child("index").setValue(position.getIndex());
                    dataRef.child("front").setValue(position.isFront());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {}
        });
    }

}
