package com.example.autoraidrpg.database.dao.local;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.autoraidrpg.model.Position;

public class PositionLocalDAO {

    public static final String TABLE = "positions";
    public static final String ID = "id";
    public static final String ROLE_COLLECTION_ID = "roleCollectionID";
    public static final String INDEX = "_index";
    public static final String FRONT = "front";

    public static String getTable() {
        return "CREATE TABLE " + TABLE + "(" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ROLE_COLLECTION_ID + " INTEGER, " +
                INDEX + " INTEGER, " +
                FRONT + " INTEGER, " +
                "FOREIGN KEY (" + ROLE_COLLECTION_ID +  ") REFERENCES " + RoleCollectionLocalDAO.TABLE + " (" + RoleCollectionLocalDAO.ID + ") ON DELETE CASCADE)";
    }

    // generate
    public static long generate(SQLiteOpenHelper dbHelper, int roleCollectionID) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        Position position = new Position(-1, roleCollectionID, -1, false);

        cv.put(PositionLocalDAO.ROLE_COLLECTION_ID, position.getRoleCollectionID());
        cv.put(PositionLocalDAO.INDEX, position.getIndex());
        cv.put(PositionLocalDAO.FRONT, position.isFront() ? 1 : 0);

        return db.insert(PositionLocalDAO.TABLE, null, cv);
    }

    // create
    public static long store(SQLiteOpenHelper dbHelper, Position position) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(PositionLocalDAO.ROLE_COLLECTION_ID, position.getRoleCollectionID());
        cv.put(PositionLocalDAO.INDEX, position.getIndex());
        cv.put(PositionLocalDAO.FRONT, position.isFront() ? 1 : 0);

        return db.insert(PositionLocalDAO.TABLE, null, cv);
    }

    // read
    public static Position retrieve(SQLiteOpenHelper dbHelper, int positionID) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Position position = null;

        String[] projection = { "*" };
        String selection = "id = ?";
        String[] selectionArgs = { String.valueOf(positionID) };
        Cursor cursor = db.query(PositionLocalDAO.TABLE, projection, selection, selectionArgs, null, null, null);

        if(cursor.moveToNext()) {
            position = new Position(
                    cursor.getInt(cursor.getColumnIndexOrThrow(PositionLocalDAO.ID)),
                    cursor.getInt(cursor.getColumnIndexOrThrow(PositionLocalDAO.ROLE_COLLECTION_ID)),
                    cursor.getInt(cursor.getColumnIndexOrThrow(PositionLocalDAO.INDEX)),
                    cursor.getInt(cursor.getColumnIndexOrThrow(PositionLocalDAO.FRONT)) == 1
            );
        }

        cursor.close();
        db.close();

        return position;
    }

    // read by id
    public static Position getByID(SQLiteOpenHelper dbHelper, int positionID) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Position position = null;

        String[] projection = { "*" };
        String selection = "id = ?";
        String[] selectionArgs = { String.valueOf(positionID) };
        Cursor cursor = db.query(PositionLocalDAO.TABLE, projection, selection, selectionArgs, null, null, null);

        if (cursor.moveToNext()) {
            position = new Position(
                    cursor.getInt(cursor.getColumnIndexOrThrow(PositionLocalDAO.ID)),
                    cursor.getInt(cursor.getColumnIndexOrThrow(PositionLocalDAO.ROLE_COLLECTION_ID)),
                    cursor.getInt(cursor.getColumnIndexOrThrow(PositionLocalDAO.INDEX)),
                    cursor.getInt(cursor.getColumnIndexOrThrow(PositionLocalDAO.FRONT)) == 1
            );
        }

        cursor.close();
        db.close();

        return position;
    }

    // update
    public static long update(SQLiteOpenHelper dbHelper, Position position) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        String selection = "id = ?";
        String[] selectionArgs = { String.valueOf(position.getId()) };

        cv.put(PositionLocalDAO.ROLE_COLLECTION_ID, position.getRoleCollectionID());
        cv.put(PositionLocalDAO.INDEX, position.getIndex());
        cv.put(PositionLocalDAO.FRONT, position.isFront());

        long rows = db.update(PositionLocalDAO.TABLE, cv, selection, selectionArgs);
        db.close();

        return rows;
    }

    // update
    public static long updateEmpty(SQLiteOpenHelper dbHelper, int originalPositionID, int roleCollectionID) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        String selection = "id = ?";
        String[] selectionArgs = { String.valueOf(originalPositionID) };

        cv.put(PositionLocalDAO.ROLE_COLLECTION_ID, roleCollectionID);
        cv.put(PositionLocalDAO.INDEX, -1);
        cv.put(PositionLocalDAO.FRONT, 0);

        long rows = db.update(PositionLocalDAO.TABLE, cv, selection, selectionArgs);
        db.close();

        return rows;
    }

}
