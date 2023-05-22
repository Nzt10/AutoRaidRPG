package com.example.autoraidrpg.database.dao.local;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.autoraidrpg.model.RoleCollection;

import java.util.ArrayList;
import java.util.List;

public class RoleCollectionLocalDAO {

    public static final String TABLE = "role_collection";
    public static final String ID = "id";
    public static final String USER_ID = "userID";
    public static final String ROLE_ID = "roleID";
    public static final String LEVEL = "level";
    public static final String RATING = "rating";
    public static final String SKILL_A = "skillA";
    public static final String SKILL_B = "skillB";
    public static final String SKILL_C = "skillC";
    public static final String SKILL_D = "skillD";
    public static final String SKILL_E = "skillE";

    public static String getTable() {
        return "CREATE TABLE " + TABLE + "(" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                USER_ID + " INTEGER, " + ROLE_ID + " INTEGER, " + LEVEL + " INTEGER NOT NULL DEFAULT 1," + RATING + " INTEGER NOT NULL DEFAULT 1," +
                SKILL_A + " INTEGER NOT NULL DEFAULT 1," +
                SKILL_B + " INTEGER NOT NULL DEFAULT 1," +
                SKILL_C + " INTEGER NOT NULL DEFAULT 1," +
                SKILL_D + " INTEGER NOT NULL DEFAULT 1," +
                SKILL_E + " INTEGER NOT NULL DEFAULT 1," +
                "FOREIGN KEY (" + USER_ID +  ") REFERENCES " + UserLocalDAO.TABLE + " (" + UserLocalDAO.ID + ") ON DELETE CASCADE," +
                "FOREIGN KEY (" + ROLE_ID +  ") REFERENCES " + RoleLocalDAO.TABLE + " (" + RoleLocalDAO.ID + ") ON DELETE CASCADE)";
    }

    // create
    public static long store(SQLiteOpenHelper dbHelper, RoleCollection roleCollection) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(RoleCollectionLocalDAO.USER_ID, roleCollection.getUserID());
        cv.put(RoleCollectionLocalDAO.ROLE_ID, roleCollection.getRoleID());
        cv.put(RoleCollectionLocalDAO.LEVEL, roleCollection.getLevel());
        cv.put(RoleCollectionLocalDAO.RATING, roleCollection.getRating());
        cv.put(RoleCollectionLocalDAO.SKILL_A, roleCollection.getSkillA());
        cv.put(RoleCollectionLocalDAO.SKILL_B, roleCollection.getSkillB());
        cv.put(RoleCollectionLocalDAO.SKILL_C, roleCollection.getSkillC());
        cv.put(RoleCollectionLocalDAO.SKILL_D, roleCollection.getSkillD());
        cv.put(RoleCollectionLocalDAO.SKILL_E, roleCollection.getSkillE());

        return db.insert(RoleCollectionLocalDAO.TABLE, null, cv);
    }

    // read
    public static RoleCollection retrieve(SQLiteOpenHelper dbHelper, int userID, int roleCollectionID) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        RoleCollection roleCollection = null;

        String[] projection = { "*" };
        String selection = "id = ? AND userID = ?";
        String[] selectionArgs = { String.valueOf(roleCollectionID), String.valueOf(userID) };
        Cursor cursor = db.query(RoleCollectionLocalDAO.TABLE, projection, selection, selectionArgs, null, null, null);

        if(cursor.moveToNext()) {
            roleCollection = new RoleCollection(
                    cursor.getInt(cursor.getColumnIndexOrThrow(RoleCollectionLocalDAO.ID)),
                    cursor.getInt(cursor.getColumnIndexOrThrow(RoleCollectionLocalDAO.USER_ID)),
                    cursor.getInt(cursor.getColumnIndexOrThrow(RoleCollectionLocalDAO.ROLE_ID)),
                    cursor.getInt(cursor.getColumnIndexOrThrow(RoleCollectionLocalDAO.LEVEL)),
                    cursor.getInt(cursor.getColumnIndexOrThrow(RoleCollectionLocalDAO.RATING)),
                    cursor.getInt(cursor.getColumnIndexOrThrow(RoleCollectionLocalDAO.SKILL_A)),
                    cursor.getInt(cursor.getColumnIndexOrThrow(RoleCollectionLocalDAO.SKILL_B)),
                    cursor.getInt(cursor.getColumnIndexOrThrow(RoleCollectionLocalDAO.SKILL_C)),
                    cursor.getInt(cursor.getColumnIndexOrThrow(RoleCollectionLocalDAO.SKILL_D)),
                    cursor.getInt(cursor.getColumnIndexOrThrow(RoleCollectionLocalDAO.SKILL_E))
            );
        }

        cursor.close();
        db.close();

        return roleCollection;
    }

    // read all
    public static List<RoleCollection> all(SQLiteOpenHelper dbHelper, int userID) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        List<RoleCollection> roleCollections = new ArrayList<>();

        String[] projection = { "*" };
        String selection = "userID = ?";
        String[] selectionArgs = { String.valueOf(userID) };
        Cursor cursor = db.query(RoleCollectionLocalDAO.TABLE, projection, selection, selectionArgs, null, null, null);

        while (cursor.moveToNext()) {
            roleCollections.add(new RoleCollection(
                    cursor.getInt(cursor.getColumnIndexOrThrow(RoleCollectionLocalDAO.ID)),
                    cursor.getInt(cursor.getColumnIndexOrThrow(RoleCollectionLocalDAO.USER_ID)),
                    cursor.getInt(cursor.getColumnIndexOrThrow(RoleCollectionLocalDAO.ROLE_ID)),
                    cursor.getInt(cursor.getColumnIndexOrThrow(RoleCollectionLocalDAO.LEVEL)),
                    cursor.getInt(cursor.getColumnIndexOrThrow(RoleCollectionLocalDAO.RATING)),
                    cursor.getInt(cursor.getColumnIndexOrThrow(RoleCollectionLocalDAO.SKILL_A)),
                    cursor.getInt(cursor.getColumnIndexOrThrow(RoleCollectionLocalDAO.SKILL_B)),
                    cursor.getInt(cursor.getColumnIndexOrThrow(RoleCollectionLocalDAO.SKILL_C)),
                    cursor.getInt(cursor.getColumnIndexOrThrow(RoleCollectionLocalDAO.SKILL_D)),
                    cursor.getInt(cursor.getColumnIndexOrThrow(RoleCollectionLocalDAO.SKILL_E))
            ));
        }

        cursor.close();
        db.close();

        return roleCollections;
    }

    // update
    public static long update(SQLiteOpenHelper dbHelper, RoleCollection roleCollection) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        String selection = "id = ?";
        String[] selectionArgs = { String.valueOf(roleCollection.getId()) };

        cv.put(RoleCollectionLocalDAO.LEVEL, roleCollection.getLevel());
        cv.put(RoleCollectionLocalDAO.RATING, roleCollection.getRating());
        cv.put(RoleCollectionLocalDAO.SKILL_A, roleCollection.getSkillA());
        cv.put(RoleCollectionLocalDAO.SKILL_B, roleCollection.getSkillB());
        cv.put(RoleCollectionLocalDAO.SKILL_C, roleCollection.getSkillC());
        cv.put(RoleCollectionLocalDAO.SKILL_D, roleCollection.getSkillD());
        cv.put(RoleCollectionLocalDAO.SKILL_E, roleCollection.getSkillE());

        long rows = db.update(RoleCollectionLocalDAO.TABLE, cv, selection, selectionArgs);
        db.close();

        return rows;
    }

}
