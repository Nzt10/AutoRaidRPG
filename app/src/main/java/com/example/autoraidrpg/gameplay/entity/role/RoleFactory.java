package com.example.autoraidrpg.gameplay.entity.role;

import com.example.autoraidrpg.gameplay.entity.Entity;

public class RoleFactory {

    public static Entity makeRole(String name) {
        switch(name) {
            case "warrior": return new Warrior();
            case "marksman": return new Marksman();
            case "mage": return new Mage();
            case "knight": return new Knight();
            case "cleric": return new Cleric();
            case "commander": return new Commander();
            case "assassin": return new Assassin();
            case "hunter": return new Hunter();
            case "thief": return new Thief();
            case "berserker": return new Berserker();
            case "blacksmith": return new Blacksmith();
            case "shaman": return new Shaman();
            case "necromancer": return new Necromancer();
            case "spearman": return new Spearman();
            case "paladin": return new Paladin();
            case "vampire": return new Vampire();
            case "monk": return new Monk();
        }
        return null;
    }
    
}
