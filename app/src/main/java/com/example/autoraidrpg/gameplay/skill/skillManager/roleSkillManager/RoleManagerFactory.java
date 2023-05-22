package com.example.autoraidrpg.gameplay.skill.skillManager.roleSkillManager;

import com.example.autoraidrpg.gameplay.skill.skillManager.SkillManager;
import com.example.autoraidrpg.gameplay.entity.Entity;

public class RoleManagerFactory {

    public static SkillManager makeManager(Entity entity) {
        switch(entity.getName()) {
            case "warrior": return new WarriorManager(entity);
            case "marksman": return new MarksmanManager(entity);
            case "mage": return new MageManager(entity);
            case "knight": return new KnightManager(entity);
            case "cleric": return new ClericManager(entity);
            case "commander": return new CommanderManager(entity);
            case "assassin": return new AssassinManager(entity);
            case "hunter": return new HunterManager(entity);
            case "thief": return new ThiefManager(entity);
            case "berserker": return new BersekerManager(entity);
            case "blacksmith": return new BlacksmithManager(entity);
            case "shaman": return new ShamanManager(entity);
            case "necromancer": return new NecromancerManager(entity);
            case "spearman": return new SpearmanManager(entity);
            case "paladin": return new PaladinManager(entity);
            case "vampire": return new VampireManager(entity);
            case "monk": return new MonkManager(entity);
        }
        return null;
    }
    
}
