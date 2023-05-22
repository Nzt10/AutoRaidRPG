package com.example.autoraidrpg.database.dao.local;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.autoraidrpg.model.Role;
import com.example.autoraidrpg.model.RoleCollection;

import java.util.ArrayList;
import java.util.List;

public class RoleLocalDAO {

    public static final String TABLE = "roles";
    public static final String ID = "id";
    public static final String NAME = "name";

    public static String getTable() {
        return "CREATE TABLE " + TABLE + "(" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + NAME + " TEXT NOT NULL)";
    }

    // create
    public static long store(SQLiteOpenHelper dbHelper, Role role) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(RoleLocalDAO.NAME, role.getName());
        return db.insert(RoleLocalDAO.TABLE, null, cv);
    }

    // read
    public static Role retrieve(SQLiteOpenHelper dbHelper, int roleID) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Role role = null;

        String[] projection = { "*" };
        String selection = "id = ?";
        String[] selectionArgs = { String.valueOf(roleID) };
        Cursor cursor = db.query(RoleLocalDAO.TABLE, projection, selection, selectionArgs, null, null, null);

        if(cursor.moveToNext()) {
            role = new Role(
                    cursor.getInt(cursor.getColumnIndexOrThrow(RoleLocalDAO.ID)),
                    cursor.getString(cursor.getColumnIndexOrThrow(RoleLocalDAO.NAME))
            );
        }

        cursor.close();
        db.close();

        return role;
    }

    // read by name
    public static Role retrieveByName(SQLiteOpenHelper dbHelper, String name) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Role role = null;

        String[] projection = { "*" };
        String selection = "name = ?";
        String[] selectionArgs = { name };
        Cursor cursor = db.query(RoleLocalDAO.TABLE, projection, selection, selectionArgs, null, null, null);

        if(cursor.moveToNext()) {
            role = new Role(
                    cursor.getInt(cursor.getColumnIndexOrThrow(RoleLocalDAO.ID)),
                    cursor.getString(cursor.getColumnIndexOrThrow(RoleLocalDAO.NAME))
            );
        }

        cursor.close();
        db.close();

        return role;
    }

    // read all
    public static List<Role> all(SQLiteOpenHelper dbHelper) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        List<Role> roles = new ArrayList<>();

        String[] projection = { "*" };
        Cursor cursor = db.query(RoleLocalDAO.TABLE, projection, null, null, null, null, null);

        while(cursor.moveToNext()) {
            roles.add(new Role(
                    cursor.getInt(cursor.getColumnIndexOrThrow(RoleLocalDAO.ID)),
                    cursor.getString(cursor.getColumnIndexOrThrow(RoleLocalDAO.NAME))
            ));
        }

        cursor.close();
        db.close();

        return roles;
    }

    // read all by the list of role collection
    public static List<Role> allByRoleCollections(SQLiteOpenHelper dbHelper, List<RoleCollection> roleCollections) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        List<Role> roles = new ArrayList<>();

        roleCollections.stream().forEach(r -> {
            roles.add(retrieve(dbHelper, r.getRoleID()));
        });

        return roles;
    }

    // count
    public static int getCount(SQLiteOpenHelper dbHelper) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String[] projection = {"COUNT(*)"};
        Cursor cursor = db.query(RoleLocalDAO.TABLE, projection, null, null, null, null, null);

        int count = 0;
        if (cursor.moveToFirst()) { count = cursor.getInt(0); }

        cursor.close();
        db.close();

        return count;
    }

}
