package com.example.autoraidrpg.database.dao.cloud;

import android.content.Context;

import androidx.annotation.NonNull;

import com.example.autoraidrpg.model.Bag;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class BagCloudDAO extends CloudDAO {

    public BagCloudDAO(Context context) {
        super(context, "bags");
    }

    public void store(Bag bag) {
        DatabaseReference newDatabaseRef = databaseRef.push();
        newDatabaseRef.setValue(bag);
        // bag.setFirebaseID(newDatabaseRef.getKey());
    }

    public Bag retrieveByRoleCollectionID(String roleCollectionFirebaseID) {
        Query query = databaseRef.orderByChild("roleCollectionFirebaseID").equalTo(roleCollectionFirebaseID).limitToFirst(1);
        DataSnapshot dataSnapshot = query.get().getResult();
        Bag bag = null;

        if (dataSnapshot.exists()) {
            DataSnapshot firstSnapshot = dataSnapshot.getChildren().iterator().next();
            bag = firstSnapshot.getValue(Bag.class);
        }

        return bag;
    }

    public void put(String firebaseID, String inventoryFirebaseID, int index) {
        Query query = databaseRef.orderByChild("firebaseID").equalTo(firebaseID);
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    // Retrieve the data
                    String dataKey = snapshot.getKey();
                    DatabaseReference dataRef = databaseRef.child(dataKey);

                    switch(index) {
                        case 0:
                            dataRef.child("inventoryFirebaseID_A").setValue(inventoryFirebaseID);
                            break;
                        case 1:
                            dataRef.child("inventoryFirebaseID_B").setValue(inventoryFirebaseID);
                            break;
                        case 2:
                            dataRef.child("inventoryFirebaseID_C").setValue(inventoryFirebaseID);
                            break;
                        case 3:
                            dataRef.child("inventoryFirebaseID_D").setValue(inventoryFirebaseID);
                            break;
                        case 4:
                            dataRef.child("inventoryFirebaseID_E").setValue(inventoryFirebaseID);
                            break;
                        case 5:
                            dataRef.child("inventoryFirebaseID_F").setValue(inventoryFirebaseID);
                            break;
                        case 6:
                            dataRef.child("inventoryFirebaseID_G").setValue(inventoryFirebaseID);
                            break;
                        case 7:
                            dataRef.child("inventoryFirebaseID_H").setValue(inventoryFirebaseID);
                            break;
                        case 8:
                            dataRef.child("inventoryFirebaseID_I").setValue(inventoryFirebaseID);
                            break;
                        case 9:
                            dataRef.child("inventoryFirebaseID_J").setValue(inventoryFirebaseID);
                            break;
                        case 10:
                            dataRef.child("inventoryFirebaseID_K").setValue(inventoryFirebaseID);
                            break;
                        case 11:
                            dataRef.child("inventoryFirebaseID_L").setValue(inventoryFirebaseID);
                            break;
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {}
        });
    }

}
