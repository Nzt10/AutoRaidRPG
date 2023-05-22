package com.example.autoraidrpg.database.dao.local;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.autoraidrpg.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserLocalDAO {

    public static final String TABLE = "users";
    public static final String ID = "id";
    public static final String USERNAME = "username";
    public static final String EMAIL = "email";
    public static final String PASSWORD = "password";
    public static final String LONGITUDE = "longitude";
    public static final String LATITUDE = "latitude";
    public static final String COIN = "coin";
    public static final String EXP = "exp";
    public static final String DIAMOND = "diamond";

    public static String getTable() {
        return String.format("CREATE TABLE %s (" +
                "%s INTEGER PRIMARY KEY AUTOINCREMENT," +
                "%s TEXT NOT NULL," +
                "%s TEXT UNIQUE NOT NULL," +
                "%s TEXT NOT NULL," +
                "%s REAL NOT NULL DEFAULT 0," +
                "%s REAL NOT NULL DEFAULT 0," +
                "%s REAL NOT NULL DEFAULT 1000," +
                "%s REAL NOT NULL DEFAULT 0," +
                "%s REAL NOT NULL DEFAULT 1000)",
                TABLE, ID, USERNAME, EMAIL, PASSWORD, LONGITUDE, LATITUDE, COIN, EXP, DIAMOND);
    }

    // create
    public static long store(SQLiteOpenHelper dbHelper, User user) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(UserLocalDAO.USERNAME, user.getUsername());
        cv.put(UserLocalDAO.EMAIL, user.getEmail());
        cv.put(UserLocalDAO.PASSWORD, user.getPassword());
        cv.put(UserLocalDAO.LONGITUDE, user.getLongitude());
        cv.put(UserLocalDAO.LATITUDE, user.getLatitude());
        cv.put(UserLocalDAO.COIN, user.getCoin());
        cv.put(UserLocalDAO.EXP, user.getExp());
        cv.put(UserLocalDAO.DIAMOND, user.getDiamond());

        return db.insert(UserLocalDAO.TABLE, null, cv);
    }

    // read all users
    public static List<User> retrieveAll(SQLiteOpenHelper dbHelper) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        List<User> userList = new ArrayList<>();

        String[] projection = { "*" };
        Cursor cursor = db.query(UserLocalDAO.TABLE, projection, null, null, null, null, null);

        while(cursor.moveToNext()) {
            User user = new User(
                    cursor.getInt(cursor.getColumnIndexOrThrow(UserLocalDAO.ID)),
                    cursor.getString(cursor.getColumnIndexOrThrow(UserLocalDAO.USERNAME)),
                    cursor.getString(cursor.getColumnIndexOrThrow(UserLocalDAO.EMAIL)),
                    cursor.getString(cursor.getColumnIndexOrThrow(UserLocalDAO.PASSWORD)),
                    cursor.getDouble(cursor.getColumnIndexOrThrow(UserLocalDAO.LONGITUDE)),
                    cursor.getDouble(cursor.getColumnIndexOrThrow(UserLocalDAO.LATITUDE)),
                    cursor.getDouble(cursor.getColumnIndexOrThrow(UserLocalDAO.COIN)),
                    cursor.getDouble(cursor.getColumnIndexOrThrow(UserLocalDAO.EXP)),
                    cursor.getDouble(cursor.getColumnIndexOrThrow(UserLocalDAO.DIAMOND))
            );
            userList.add(user);
        }

        cursor.close();
        db.close();

        return userList;
    }

    // read
    public static User retrieve(SQLiteOpenHelper dbHelper, String email) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        User user = null;

        String[] projection = { "*" };
        String selection = "email = ?";
        String[] selectionArgs = { email };
        Cursor cursor = db.query(UserLocalDAO.TABLE, projection, selection, selectionArgs, null, null, null);

        while(cursor.moveToNext()) {
            user = new User(
                    cursor.getInt(cursor.getColumnIndexOrThrow(UserLocalDAO.ID)),
                    cursor.getString(cursor.getColumnIndexOrThrow(UserLocalDAO.USERNAME)),
                    cursor.getString(cursor.getColumnIndexOrThrow(UserLocalDAO.EMAIL)),
                    cursor.getString(cursor.getColumnIndexOrThrow(UserLocalDAO.PASSWORD)),
                    cursor.getDouble(cursor.getColumnIndexOrThrow(UserLocalDAO.LONGITUDE)),
                    cursor.getDouble(cursor.getColumnIndexOrThrow(UserLocalDAO.LATITUDE)),
                    cursor.getDouble(cursor.getColumnIndexOrThrow(UserLocalDAO.COIN)),
                    cursor.getDouble(cursor.getColumnIndexOrThrow(UserLocalDAO.EXP)),
                    cursor.getDouble(cursor.getColumnIndexOrThrow(UserLocalDAO.DIAMOND))
            );
        }

        cursor.close();
        db.close();

        return user;
    }

    // read by id
    public static User retrieveByID(SQLiteOpenHelper dbHelper, int id) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        User user = null;

        String[] projection = { "*" };
        String selection = "id = ?";
        String[] selectionArgs = { String.valueOf(id) };
        Cursor cursor = db.query(UserLocalDAO.TABLE, projection, selection, selectionArgs, null, null, null);

        while(cursor.moveToNext()) {
            user = new User(
                    cursor.getInt(cursor.getColumnIndexOrThrow(UserLocalDAO.ID)),
                    cursor.getString(cursor.getColumnIndexOrThrow(UserLocalDAO.USERNAME)),
                    cursor.getString(cursor.getColumnIndexOrThrow(UserLocalDAO.EMAIL)),
                    cursor.getString(cursor.getColumnIndexOrThrow(UserLocalDAO.PASSWORD)),
                    cursor.getDouble(cursor.getColumnIndexOrThrow(UserLocalDAO.LONGITUDE)),
                    cursor.getDouble(cursor.getColumnIndexOrThrow(UserLocalDAO.LATITUDE)),
                    cursor.getDouble(cursor.getColumnIndexOrThrow(UserLocalDAO.COIN)),
                    cursor.getDouble(cursor.getColumnIndexOrThrow(UserLocalDAO.EXP)),
                    cursor.getDouble(cursor.getColumnIndexOrThrow(UserLocalDAO.DIAMOND))
            );
        }

        cursor.close();
        db.close();

        return user;
    }

    // update
    public static void update(SQLiteOpenHelper dbHelper, User user) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(UserLocalDAO.USERNAME, user.getUsername());
        cv.put(UserLocalDAO.EMAIL, user.getEmail());
        cv.put(UserLocalDAO.PASSWORD, user.getPassword());
        cv.put(UserLocalDAO.LONGITUDE, user.getLongitude());
        cv.put(UserLocalDAO.LATITUDE, user.getLatitude());
        cv.put(UserLocalDAO.COIN, user.getCoin());
        cv.put(UserLocalDAO.EXP, user.getExp());
        cv.put(UserLocalDAO.DIAMOND, user.getDiamond());

        String selection = "id = ?";
        String[] selectionArgs = { String.valueOf(user.getId()) };

        db.update(UserLocalDAO.TABLE, cv, selection, selectionArgs);
        db.close();
    }

}
