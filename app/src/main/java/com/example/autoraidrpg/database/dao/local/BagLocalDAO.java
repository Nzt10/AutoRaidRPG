package com.example.autoraidrpg.database.dao.local;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.autoraidrpg.model.Bag;

public class BagLocalDAO {

    public static final String TABLE = "bags";
    public static final String ID = "id";
    public static final String USER_ID = "userID";
    public static final String ROLE_COLLECTION_ID = "roleCollectionID";
    public static final String INVENTORY_ID_A = "inventoryID_A";
    public static final String INVENTORY_ID_B = "inventoryID_B";
    public static final String INVENTORY_ID_C = "inventoryID_C";
    public static final String INVENTORY_ID_D = "inventoryID_D";
    public static final String INVENTORY_ID_E = "inventoryID_E";
    public static final String INVENTORY_ID_F = "inventoryID_F";
    public static final String INVENTORY_ID_G = "inventoryID_G";
    public static final String INVENTORY_ID_H = "inventoryID_H";
    public static final String INVENTORY_ID_I = "inventoryID_I";
    public static final String INVENTORY_ID_J = "inventoryID_J";
    public static final String INVENTORY_ID_K = "inventoryID_K";
    public static final String INVENTORY_ID_L = "inventoryID_L";

    public static String getTable() {
        return "CREATE TABLE " + TABLE + "(" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                USER_ID + " INTEGER, " +
                ROLE_COLLECTION_ID + " INTEGER, " +
                INVENTORY_ID_A + " INTEGER, " +
                INVENTORY_ID_B + " INTEGER, " +
                INVENTORY_ID_C + " INTEGER, " +
                INVENTORY_ID_D + " INTEGER, " +
                INVENTORY_ID_E + " INTEGER, " +
                INVENTORY_ID_F + " INTEGER, " +
                INVENTORY_ID_G + " INTEGER, " +
                INVENTORY_ID_H + " INTEGER, " +
                INVENTORY_ID_I + " INTEGER, " +
                INVENTORY_ID_J + " INTEGER, " +
                INVENTORY_ID_K + " INTEGER, " +
                INVENTORY_ID_L + " INTEGER, " +
                "FOREIGN KEY (" + USER_ID +  ") REFERENCES " + UserLocalDAO.TABLE + " (" + UserLocalDAO.ID + ") ON DELETE CASCADE," +
                "FOREIGN KEY (" + ROLE_COLLECTION_ID +  ") REFERENCES " + RoleCollectionLocalDAO.TABLE + " (" + RoleCollectionLocalDAO.ID + ") ON DELETE CASCADE," +
                "FOREIGN KEY (" + INVENTORY_ID_A +  ") REFERENCES " + InventoryLocalDAO.TABLE + " (" + InventoryLocalDAO.ID + ") ON DELETE SET NULL," +
                "FOREIGN KEY (" + INVENTORY_ID_B +  ") REFERENCES " + InventoryLocalDAO.TABLE + " (" + InventoryLocalDAO.ID + ") ON DELETE SET NULL," +
                "FOREIGN KEY (" + INVENTORY_ID_C +  ") REFERENCES " + InventoryLocalDAO.TABLE + " (" + InventoryLocalDAO.ID + ") ON DELETE SET NULL," +
                "FOREIGN KEY (" + INVENTORY_ID_D +  ") REFERENCES " + InventoryLocalDAO.TABLE + " (" + InventoryLocalDAO.ID + ") ON DELETE SET NULL," +
                "FOREIGN KEY (" + INVENTORY_ID_E +  ") REFERENCES " + InventoryLocalDAO.TABLE + " (" + InventoryLocalDAO.ID + ") ON DELETE SET NULL," +
                "FOREIGN KEY (" + INVENTORY_ID_F +  ") REFERENCES " + InventoryLocalDAO.TABLE + " (" + InventoryLocalDAO.ID + ") ON DELETE SET NULL," +
                "FOREIGN KEY (" + INVENTORY_ID_G +  ") REFERENCES " + InventoryLocalDAO.TABLE + " (" + InventoryLocalDAO.ID + ") ON DELETE SET NULL," +
                "FOREIGN KEY (" + INVENTORY_ID_H +  ") REFERENCES " + InventoryLocalDAO.TABLE + " (" + InventoryLocalDAO.ID + ") ON DELETE SET NULL," +
                "FOREIGN KEY (" + INVENTORY_ID_I +  ") REFERENCES " + InventoryLocalDAO.TABLE + " (" + InventoryLocalDAO.ID + ") ON DELETE SET NULL," +
                "FOREIGN KEY (" + INVENTORY_ID_J +  ") REFERENCES " + InventoryLocalDAO.TABLE + " (" + InventoryLocalDAO.ID + ") ON DELETE SET NULL," +
                "FOREIGN KEY (" + INVENTORY_ID_K +  ") REFERENCES " + InventoryLocalDAO.TABLE + " (" + InventoryLocalDAO.ID + ") ON DELETE SET NULL," +
                "FOREIGN KEY (" + INVENTORY_ID_L +  ") REFERENCES " + InventoryLocalDAO.TABLE + " (" + InventoryLocalDAO.ID + ") ON DELETE SET NULL)";
    }

    // create
    public static long store(SQLiteOpenHelper dbHelper, Bag bag) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(BagLocalDAO.USER_ID, bag.getUserID());
        cv.put(BagLocalDAO.ROLE_COLLECTION_ID, bag.getRoleCollectionID());
        cv.put(BagLocalDAO.INVENTORY_ID_A, bag.getInventoryID_A());
        cv.put(BagLocalDAO.INVENTORY_ID_B, bag.getInventoryID_B());
        cv.put(BagLocalDAO.INVENTORY_ID_C, bag.getInventoryID_C());
        cv.put(BagLocalDAO.INVENTORY_ID_D, bag.getInventoryID_D());
        cv.put(BagLocalDAO.INVENTORY_ID_E, bag.getInventoryID_E());
        cv.put(BagLocalDAO.INVENTORY_ID_F, bag.getInventoryID_F());
        cv.put(BagLocalDAO.INVENTORY_ID_G, bag.getInventoryID_G());
        cv.put(BagLocalDAO.INVENTORY_ID_H, bag.getInventoryID_H());
        cv.put(BagLocalDAO.INVENTORY_ID_I, bag.getInventoryID_I());
        cv.put(BagLocalDAO.INVENTORY_ID_J, bag.getInventoryID_J());
        cv.put(BagLocalDAO.INVENTORY_ID_K, bag.getInventoryID_K());
        cv.put(BagLocalDAO.INVENTORY_ID_L, bag.getInventoryID_L());

        return db.insert(BagLocalDAO.TABLE, null, cv);
    }

    // read
    public static Bag retrieve(SQLiteOpenHelper dbHelper, int roleCollectionID) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Bag bag = null;

        String[] projection = { "*" };
        String selection = "roleCollectionID = ?";
        String[] selectionArgs = { String.valueOf(roleCollectionID) };
        Cursor cursor = db.query(BagLocalDAO.TABLE, projection, selection, selectionArgs, null, null, null);

        if(cursor.moveToNext()) {
            bag = new Bag(
                    cursor.getInt(cursor.getColumnIndexOrThrow(BagLocalDAO.ID)),
                    cursor.getInt(cursor.getColumnIndexOrThrow(BagLocalDAO.USER_ID)),
                    cursor.getInt(cursor.getColumnIndexOrThrow(BagLocalDAO.ROLE_COLLECTION_ID)),
                    cursor.getInt(cursor.getColumnIndexOrThrow(BagLocalDAO.INVENTORY_ID_A)),
                    cursor.getInt(cursor.getColumnIndexOrThrow(BagLocalDAO.INVENTORY_ID_B)),
                    cursor.getInt(cursor.getColumnIndexOrThrow(BagLocalDAO.INVENTORY_ID_C)),
                    cursor.getInt(cursor.getColumnIndexOrThrow(BagLocalDAO.INVENTORY_ID_D)),
                    cursor.getInt(cursor.getColumnIndexOrThrow(BagLocalDAO.INVENTORY_ID_E)),
                    cursor.getInt(cursor.getColumnIndexOrThrow(BagLocalDAO.INVENTORY_ID_F)),
                    cursor.getInt(cursor.getColumnIndexOrThrow(BagLocalDAO.INVENTORY_ID_G)),
                    cursor.getInt(cursor.getColumnIndexOrThrow(BagLocalDAO.INVENTORY_ID_H)),
                    cursor.getInt(cursor.getColumnIndexOrThrow(BagLocalDAO.INVENTORY_ID_I)),
                    cursor.getInt(cursor.getColumnIndexOrThrow(BagLocalDAO.INVENTORY_ID_J)),
                    cursor.getInt(cursor.getColumnIndexOrThrow(BagLocalDAO.INVENTORY_ID_K)),
                    cursor.getInt(cursor.getColumnIndexOrThrow(BagLocalDAO.INVENTORY_ID_L))
            );
        }

        cursor.close();
        db.close();

        return bag;
    }

    // check if an item is equipped
    public static boolean isEquipped(SQLiteOpenHelper dbHelper, int userID, int inventoryID) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        String[] projection = { "*" };
        String selection = "userID = ? AND (inventoryID_A = ? OR inventoryID_B = ? OR inventoryID_C = ? OR inventoryID_D = ? OR inventoryID_E = ? OR inventoryID_F = ? OR inventoryID_G = ? OR inventoryID_H = ? OR inventoryID_I = ? OR inventoryID_J = ? OR inventoryID_K = ? OR inventoryID_L = ?)";
        String[] selectionArgs = {
                String.valueOf(userID),
                String.valueOf(inventoryID), String.valueOf(inventoryID), String.valueOf(inventoryID),
                String.valueOf(inventoryID), String.valueOf(inventoryID), String.valueOf(inventoryID),
                String.valueOf(inventoryID), String.valueOf(inventoryID), String.valueOf(inventoryID),
                String.valueOf(inventoryID), String.valueOf(inventoryID), String.valueOf(inventoryID)
        };
        Cursor cursor = db.query(BagLocalDAO.TABLE, projection, selection, selectionArgs, null, null, null);
        boolean exist = cursor.moveToNext();

        cursor.close();
        db.close();

        return exist;
    }

    // put specific inventory id in the bag
    public static long put(SQLiteOpenHelper dbHelper, int bagID, int inventoryID, int index) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        String selection = "id = ?";
        String[] selectionArgs = { String.valueOf(bagID) };

        switch(index) {
            case 0:
                cv.put(BagLocalDAO.INVENTORY_ID_A, inventoryID);
                break;
            case 1:
                cv.put(BagLocalDAO.INVENTORY_ID_B, inventoryID);
                break;
            case 2:
                cv.put(BagLocalDAO.INVENTORY_ID_C, inventoryID);
                break;
            case 3:
                cv.put(BagLocalDAO.INVENTORY_ID_D, inventoryID);
                break;
            case 4:
                cv.put(BagLocalDAO.INVENTORY_ID_E, inventoryID);
                break;
            case 5:
                cv.put(BagLocalDAO.INVENTORY_ID_F, inventoryID);
                break;
            case 6:
                cv.put(BagLocalDAO.INVENTORY_ID_G, inventoryID);
                break;
            case 7:
                cv.put(BagLocalDAO.INVENTORY_ID_H, inventoryID);
                break;
            case 8:
                cv.put(BagLocalDAO.INVENTORY_ID_I, inventoryID);
                break;
            case 9:
                cv.put(BagLocalDAO.INVENTORY_ID_J, inventoryID);
                break;
            case 10:
                cv.put(BagLocalDAO.INVENTORY_ID_K, inventoryID);
                break;
            case 11:
                cv.put(BagLocalDAO.INVENTORY_ID_L, inventoryID);
                break;
        }

        long rows = db.update(BagLocalDAO.TABLE, cv, selection, selectionArgs);
        db.close();

        return rows;
    }

}
