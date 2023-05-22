package com.example.autoraidrpg.database.dao.cloud;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;

import com.example.autoraidrpg.model.Stage;
import com.example.autoraidrpg.model.User;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.function.Consumer;

public class UserCloudDAO extends CloudDAO {

    public UserCloudDAO(Context context) {
        super(context, "users");
    }

    public void store(User user) {
        DatabaseReference newDatabaseRef = databaseRef.push();
        newDatabaseRef.setValue(user);
        // user.setFirebaseID(newDatabaseRef.getKey());
    }

    public void retrieve(String firebaseID, Consumer<User> next) {
        Query query = databaseRef.child(firebaseID);
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    User user = (User) dataSnapshot.getValue(User.class);
                    // user.setFirebaseID(firebaseID);
                    next.accept(user);
                } else {
                    Log.i("FIREBASE", "EMPTY");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public User retrieveByEmail(String email) {
        Query query = databaseRef.orderByChild("email").equalTo(email);
        DataSnapshot dataSnapshot = query.get().getResult();
        User user = null;

        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
            user = snapshot.getValue(User.class);
            Log.i("FIREBASE", user.toString());
        }

        return user;
    }

    public void put(String firebaseID, User user) {
        Query query = databaseRef.child(firebaseID);
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    // Retrieve the data
                    String dataKey = snapshot.getKey();
                    DatabaseReference dataRef = databaseRef.child(dataKey);
                    dataRef.child("username").setValue(user.getUsername());
                    dataRef.child("email").setValue(user.getEmail());
                    dataRef.child("password").setValue(user.getPassword());
                    dataRef.child("longitude").setValue(user.getLongitude());
                    dataRef.child("latitude").setValue(user.getLatitude());
                    dataRef.child("coin").setValue(user.getCoin());
                    dataRef.child("exp").setValue(user.getExp());
                    dataRef.child("diamond").setValue(user.getDiamond());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {}
        });
    }

}
