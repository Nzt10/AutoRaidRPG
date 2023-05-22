package com.example.autoraidrpg.database.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.autoraidrpg.model.Inventory;
import com.example.autoraidrpg.model.RoleCollection;

import java.util.ArrayList;
import java.util.List;

public class InventoryDAO {

    public static final String TABLE = "inventories";
    public static final String ID = "id";
    public static final String USER_ID = "userID";
    public static final String ITEM_ID = "itemID";
    public static final String RATING = "rating";

    public static String getTable() {
        return "CREATE TABLE " + TABLE + "(" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                USER_ID + " INTEGER, " + ITEM_ID + " INTEGER, " + RATING + " INTEGER NOT NULL DEFAULT 1," +
                "FOREIGN KEY (" + USER_ID +  ") REFERENCES " + UserDAO.TABLE + " (" + UserDAO.ID + ") ON DELETE CASCADE," +
                "FOREIGN KEY (" + ITEM_ID +  ") REFERENCES " + ItemDAO.TABLE + " (" + ItemDAO.ID + ") ON DELETE CASCADE)";
    }

    // create
    public static long store(SQLiteOpenHelper dbHelper, Inventory inventory) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(InventoryDAO.USER_ID, inventory.getUserID());
        cv.put(InventoryDAO.ITEM_ID, inventory.getItemID());
        cv.put(InventoryDAO.RATING, inventory.getRating());

        return db.insert(InventoryDAO.TABLE, null, cv);
    }

    // read
    public static Inventory retrieve(SQLiteOpenHelper dbHelper, int userID, int inventoryID) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Inventory inventory = null;

        String[] projection = { "*" };
        String selection = "id = ? AND userID = ?";
        String[] selectionArgs = { String.valueOf(inventoryID), String.valueOf(userID) };
        Cursor cursor = db.query(InventoryDAO.TABLE, projection, selection, selectionArgs, null, null, null);

        if(cursor.moveToNext()) {
            inventory = new Inventory(
                    cursor.getInt(cursor.getColumnIndexOrThrow(InventoryDAO.ID)),
                    cursor.getInt(cursor.getColumnIndexOrThrow(InventoryDAO.USER_ID)),
                    cursor.getInt(cursor.getColumnIndexOrThrow(InventoryDAO.ITEM_ID)),
                    cursor.getInt(cursor.getColumnIndexOrThrow(InventoryDAO.RATING))
            );
        }

        cursor.close();
        db.close();

        return inventory;
    }

    // read all
    public static List<Inventory> all(SQLiteOpenHelper dbHelper, int userID) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        List<Inventory> inventories = new ArrayList<>();

        String[] projection = { "*" };
        String selection = "userID = ?";
        String[] selectionArgs = { String.valueOf(userID) };
        Cursor cursor = db.query(InventoryDAO.TABLE, projection, selection, selectionArgs, null, null, null);

        while (cursor.moveToNext()) {
            inventories.add(new Inventory(
                    cursor.getInt(cursor.getColumnIndexOrThrow(InventoryDAO.ID)),
                    cursor.getInt(cursor.getColumnIndexOrThrow(InventoryDAO.USER_ID)),
                    cursor.getInt(cursor.getColumnIndexOrThrow(InventoryDAO.ITEM_ID)),
                    cursor.getInt(cursor.getColumnIndexOrThrow(InventoryDAO.RATING))
            ));
        }

        cursor.close();
        db.close();

        return inventories;
    }

}
