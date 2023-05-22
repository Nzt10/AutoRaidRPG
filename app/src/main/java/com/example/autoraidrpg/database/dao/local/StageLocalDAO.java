package com.example.autoraidrpg.database.dao.local;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.autoraidrpg.model.Stage;

public class StageLocalDAO {

    public static final String TABLE = "stages";
    public static final String USER_ID = "userID";
    public static final String VALUE = "value";

    public static String getTable() {
        return "CREATE TABLE " + TABLE + "(" + USER_ID + " INTEGER, " + VALUE + " INTEGER NOT NULL DEFAULT 1," +
                "FOREIGN KEY (" + USER_ID +  ") REFERENCES " + UserLocalDAO.TABLE + " (" + UserLocalDAO.ID + ") ON DELETE CASCADE)";
    }

    // create
    public static long store(SQLiteOpenHelper dbHelper, Stage stage) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(StageLocalDAO.USER_ID, stage.getUserID());
        cv.put(StageLocalDAO.VALUE, stage.getValue());

        return db.insert(StageLocalDAO.TABLE, null, cv);
    }

    // read
    public static Stage retrieve(SQLiteOpenHelper dbHelper, int userID) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Stage stage = null;

        String[] projection = { "*" };
        String selection = "userID = ?";
        String[] selectionArgs = { String.valueOf(userID) };
        Cursor cursor = db.query(StageLocalDAO.TABLE, projection, selection, selectionArgs, null, null, null);

        if(cursor.moveToNext()) {
            stage = new Stage(
                    cursor.getInt(cursor.getColumnIndexOrThrow(StageLocalDAO.USER_ID)),
                    cursor.getInt(cursor.getColumnIndexOrThrow(StageLocalDAO.VALUE))
            );
        }

        cursor.close();
        db.close();

        return stage;
    }

    // update
    public static void update(SQLiteOpenHelper dbHelper, Stage stage) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(StageLocalDAO.VALUE, stage.getValue());

        String selection = "userID = ?";
        String[] selectionArgs = { String.valueOf(stage.getUserID()) };

        db.update(StageLocalDAO.TABLE, cv, selection, selectionArgs);
        db.close();
    }

}
