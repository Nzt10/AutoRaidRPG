package com.example.autoraidrpg.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.autoraidrpg.database.dao.local.BagLocalDAO;
import com.example.autoraidrpg.database.dao.local.FormationLocalDAO;
import com.example.autoraidrpg.database.dao.local.InventoryLocalDAO;
import com.example.autoraidrpg.database.dao.local.ItemLocalDAO;
import com.example.autoraidrpg.database.dao.local.PositionLocalDAO;
import com.example.autoraidrpg.database.dao.local.RoleCollectionLocalDAO;
import com.example.autoraidrpg.database.dao.local.RoleLocalDAO;
import com.example.autoraidrpg.database.dao.local.StageLocalDAO;
import com.example.autoraidrpg.database.dao.local.UserLocalDAO;

public class DatabaseHelper extends SQLiteOpenHelper {

    public DatabaseHelper(@Nullable Context context) {
        super(context, "mobileautorpg", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(UserLocalDAO.getTable());
        db.execSQL(RoleLocalDAO.getTable());
        db.execSQL(ItemLocalDAO.getTable());
        db.execSQL(InventoryLocalDAO.getTable());
        db.execSQL(RoleCollectionLocalDAO.getTable());
        db.execSQL(PositionLocalDAO.getTable());
        db.execSQL(FormationLocalDAO.getTable());
        db.execSQL(BagLocalDAO.getTable());
        db.execSQL(StageLocalDAO.getTable());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {}
}
