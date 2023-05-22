package com.example.autoraidrpg.database.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.autoraidrpg.model.Inventory;
import com.example.autoraidrpg.model.Item;
import com.example.autoraidrpg.model.Role;
import com.example.autoraidrpg.model.RoleCollection;

import java.util.ArrayList;
import java.util.List;

public class ItemDAO {

    public static final String TABLE = "items";
    public static final String ID = "id";
    public static final String NAME = "name";

    public static String getTable() {
        return "CREATE TABLE " + TABLE + "(" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + NAME + " TEXT NOT NULL)";
    }

    // create
    public static long store(SQLiteOpenHelper dbHelper, Item item) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(ItemDAO.NAME, item.getName());
        return db.insert(ItemDAO.TABLE, null, cv);
    }

    // read
    public static Item retrieve(SQLiteOpenHelper dbHelper, int itemID) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Item item = null;

        String[] projection = { "*" };
        String selection = "id = ?";
        String[] selectionArgs = { String.valueOf(itemID) };
        Cursor cursor = db.query(ItemDAO.TABLE, projection, selection, selectionArgs, null, null, null);

        if(cursor.moveToNext()) {
            item = new Item(
                    cursor.getInt(cursor.getColumnIndexOrThrow(ItemDAO.ID)),
                    cursor.getString(cursor.getColumnIndexOrThrow(ItemDAO.NAME))
            );
        }

        cursor.close();
        db.close();

        return item;
    }

    // read all
    public static List<Item> all(SQLiteOpenHelper dbHelper) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        List<Item> items = new ArrayList<>();

        String[] projection = { "*" };
        Cursor cursor = db.query(ItemDAO.TABLE, projection, null, null, null, null, null);

        while(cursor.moveToNext()) {
            items.add(new Item(
                    cursor.getInt(cursor.getColumnIndexOrThrow(RoleDAO.ID)),
                    cursor.getString(cursor.getColumnIndexOrThrow(RoleDAO.NAME))
            ));
        }

        cursor.close();
        db.close();

        return items;
    }

    // read all by inventories
    public static List<Item> allByInventory(SQLiteOpenHelper dbHelper, List<Inventory> inventories) {
        List<Item> items = new ArrayList<>();
        inventories.stream().forEach(i -> items.add(retrieve(dbHelper, i.getItemID())));
        return items;
    }

    // count
    public static int getCount(SQLiteOpenHelper dbHelper) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String[] projection = {"COUNT(*)"};
        Cursor cursor = db.query(ItemDAO.TABLE, projection, null, null, null, null, null);

        int count = 0;
        if (cursor.moveToFirst()) { count = cursor.getInt(0); }

        cursor.close();
        db.close();

        return count;
    }

}
