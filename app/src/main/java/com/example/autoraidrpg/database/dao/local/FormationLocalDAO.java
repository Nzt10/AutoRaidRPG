package com.example.autoraidrpg.database.dao.local;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.autoraidrpg.model.Formation;

import java.util.ArrayList;
import java.util.List;

public class FormationLocalDAO {

    public static final String TABLE = "formations";
    public static final String ID = "id";
    public static final String USER_ID = "userID";
    public static final String POSITION_ID_A = "positionID_A";
    public static final String POSITION_ID_B = "positionID_B";
    public static final String POSITION_ID_C = "positionID_C";
    public static final String POSITION_ID_D = "positionID_D";
    public static final String POSITION_ID_E = "positionID_E";

    public static String getTable() {
        return "CREATE TABLE " + TABLE + "(" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                USER_ID + " INTEGER, " +
                POSITION_ID_A + " INTEGER, " +
                POSITION_ID_B + " INTEGER, " +
                POSITION_ID_C + " INTEGER, " +
                POSITION_ID_D + " INTEGER, " +
                POSITION_ID_E + " INTEGER, " +
                "FOREIGN KEY (" + USER_ID +  ") REFERENCES " + UserLocalDAO.TABLE + " (" + UserLocalDAO.ID + ") ON DELETE CASCADE," +
                "FOREIGN KEY (" + POSITION_ID_A +  ") REFERENCES " + PositionLocalDAO.TABLE + " (" + PositionLocalDAO.ID + ") ON DELETE SET NULL," +
                "FOREIGN KEY (" + POSITION_ID_B +  ") REFERENCES " + PositionLocalDAO.TABLE + " (" + PositionLocalDAO.ID + ") ON DELETE SET NULL," +
                "FOREIGN KEY (" + POSITION_ID_C +  ") REFERENCES " + PositionLocalDAO.TABLE + " (" + PositionLocalDAO.ID + ") ON DELETE SET NULL," +
                "FOREIGN KEY (" + POSITION_ID_D +  ") REFERENCES " + PositionLocalDAO.TABLE + " (" + PositionLocalDAO.ID + ") ON DELETE SET NULL," +
                "FOREIGN KEY (" + POSITION_ID_E +  ") REFERENCES " + PositionLocalDAO.TABLE + " (" + PositionLocalDAO.ID + ") ON DELETE SET NULL)";
    }

    // create
    public static long store(SQLiteOpenHelper dbHelper, Formation formation) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(FormationLocalDAO.USER_ID, formation.getUserID());
        cv.put(FormationLocalDAO.POSITION_ID_A, formation.getPositionID_A());
        cv.put(FormationLocalDAO.POSITION_ID_B, formation.getPositionID_B());
        cv.put(FormationLocalDAO.POSITION_ID_C, formation.getPositionID_C());
        cv.put(FormationLocalDAO.POSITION_ID_D, formation.getPositionID_D());
        cv.put(FormationLocalDAO.POSITION_ID_E, formation.getPositionID_E());

        return db.insert(FormationLocalDAO.TABLE, null, cv);
    }

    // read
    public static Formation retrieveFirstFormation(SQLiteOpenHelper dbHelper, int userID) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Formation formation = null;

        String[] projection = { "*" };
        String selection = "userID = ?";
        String[] selectionArgs = { String.valueOf(userID) };
        Cursor cursor = db.query(FormationLocalDAO.TABLE, projection, selection, selectionArgs, null, null, null);

        if(cursor.moveToNext()) {
            formation = new Formation(
                    cursor.getInt(cursor.getColumnIndexOrThrow(FormationLocalDAO.ID)),
                    cursor.getInt(cursor.getColumnIndexOrThrow(FormationLocalDAO.USER_ID)),
                    cursor.getInt(cursor.getColumnIndexOrThrow(FormationLocalDAO.POSITION_ID_A)),
                    cursor.getInt(cursor.getColumnIndexOrThrow(FormationLocalDAO.POSITION_ID_B)),
                    cursor.getInt(cursor.getColumnIndexOrThrow(FormationLocalDAO.POSITION_ID_C)),
                    cursor.getInt(cursor.getColumnIndexOrThrow(FormationLocalDAO.POSITION_ID_D)),
                    cursor.getInt(cursor.getColumnIndexOrThrow(FormationLocalDAO.POSITION_ID_E))
            );
        }

        cursor.close();
        db.close();

        return formation;
    }

    // read all
    public static List<Formation> all(SQLiteOpenHelper dbHelper, int userID) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        List<Formation> formations = new ArrayList<>();

        String[] projection = { "*" };
        String selection = "userID = ?";
        String[] selectionArgs = { String.valueOf(userID) };
        Cursor cursor = db.query(FormationLocalDAO.TABLE, projection, selection, selectionArgs, null, null, null);

        while (cursor.moveToNext()) {
            formations.add(new Formation(
                    cursor.getInt(cursor.getColumnIndexOrThrow(FormationLocalDAO.ID)),
                    cursor.getInt(cursor.getColumnIndexOrThrow(FormationLocalDAO.USER_ID)),
                    cursor.getInt(cursor.getColumnIndexOrThrow(FormationLocalDAO.POSITION_ID_A)),
                    cursor.getInt(cursor.getColumnIndexOrThrow(FormationLocalDAO.POSITION_ID_B)),
                    cursor.getInt(cursor.getColumnIndexOrThrow(FormationLocalDAO.POSITION_ID_C)),
                    cursor.getInt(cursor.getColumnIndexOrThrow(FormationLocalDAO.POSITION_ID_D)),
                    cursor.getInt(cursor.getColumnIndexOrThrow(FormationLocalDAO.POSITION_ID_E))
            ));
        }

        cursor.close();
        db.close();

        return formations;
    }

}
