package com.example.autoraidrpg.population;

import android.database.sqlite.SQLiteOpenHelper;

import com.example.autoraidrpg.database.dao.local.StageLocalDAO;
import com.example.autoraidrpg.model.Stage;

public class StagePopulation {

    public static void generate(SQLiteOpenHelper dbHelper, int userID) {
        StageLocalDAO.store(dbHelper, new Stage(userID, 1));
    }

}
