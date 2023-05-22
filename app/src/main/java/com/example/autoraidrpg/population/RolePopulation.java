package com.example.autoraidrpg.population;

import android.database.sqlite.SQLiteOpenHelper;

import com.example.autoraidrpg.database.dao.local.FormationLocalDAO;
import com.example.autoraidrpg.database.dao.local.PositionLocalDAO;
import com.example.autoraidrpg.database.dao.local.RoleCollectionLocalDAO;
import com.example.autoraidrpg.database.dao.local.RoleLocalDAO;
import com.example.autoraidrpg.gameplay.entity.Entity;
import com.example.autoraidrpg.gameplay.entity.role.RoleFactory;
import com.example.autoraidrpg.model.Formation;
import com.example.autoraidrpg.model.Position;
import com.example.autoraidrpg.model.Role;
import com.example.autoraidrpg.model.RoleCollection;

import java.util.Arrays;
import java.util.List;

public class RolePopulation {

    // generate five (5) formation per newly registered user
    public final static int FORMATION_SIZE = 5;

    private final static String[] ROLE_NAMES = {
            "warrior",
            "marksman",
            "mage",
            "commander",
            "knight",
            "assassin",
            "cleric",
            "hunter",
            "thief",
            "berserker",
            "blacksmith",
            "shaman",
            "necromancer",
            "spearman",
            "paladin",
            "vampire",
            "monk"
    };

    public static void generate(SQLiteOpenHelper dbHelper) {
        if(RoleLocalDAO.getCount(dbHelper) == 0) {
            Arrays.asList(ROLE_NAMES).stream().forEach(roleName -> {
                Role role = new Role(-1, roleName);
                RoleLocalDAO.store(dbHelper, role);
            });
        }
    }

    public static RoleCollection generateFirstRole(SQLiteOpenHelper dbHelper, int userID) {
        RoleCollection roleCollection = new RoleCollection(-1, userID, 1, 1, 1, 1, 1, 1, 1, 1);
        int newRoleCollectionID = (int) RoleCollectionLocalDAO.store(dbHelper, roleCollection);
        roleCollection.setId(newRoleCollectionID);
        return roleCollection;
    }

    public static void generateFormation(SQLiteOpenHelper dbHelper, int userID, int roleCollectionID) {
        for(int i = 0; i < FORMATION_SIZE; i++) {
            Formation formation = null;
            int positionID_B = (int) PositionLocalDAO.generate(dbHelper, -1);
            int positionID_C = (int) PositionLocalDAO.generate(dbHelper, -1);
            int positionID_D = (int) PositionLocalDAO.generate(dbHelper, -1);
            int positionID_E = (int) PositionLocalDAO.generate(dbHelper, -1);

            if(i == 0) {
                // formation your first character at the center back
                Position position = new Position(-1, roleCollectionID, 1, false);
                int newPositionID = (int) PositionLocalDAO.store(dbHelper, position);
                formation = new Formation(-1, userID, newPositionID, positionID_B, positionID_C, positionID_D, positionID_E);
            } else {
                int positionID_A = (int) PositionLocalDAO.generate(dbHelper, -1);
                formation = new Formation(-1, userID, positionID_A, positionID_B, positionID_C, positionID_D, positionID_E);
            }

            FormationLocalDAO.store(dbHelper, formation);
        }
    }

    public static void roleCollection(List<Role> roles, List<Entity> entities) {
        roles.stream().forEach(r -> entities.add(RoleFactory.makeRole(r.getName())));
    }

    public static void teamUnit(List<Role> roles, List<Entity> entities) {
        roles.stream().forEach(r -> {
            entities.add(RoleFactory.makeRole(r.getName()));
        });
    }

}
