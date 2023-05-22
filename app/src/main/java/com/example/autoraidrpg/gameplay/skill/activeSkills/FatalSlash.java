package com.example.autoraidrpg.gameplay.skill.activeSkills;

import com.example.autoraidrpg.R;
import com.example.autoraidrpg.gameplay.skill.ActiveSkill;
import com.example.autoraidrpg.gameplay.skill.SkillType;
import com.example.autoraidrpg.gameplay.entity.Entity;
import com.example.autoraidrpg.gameplay.formation.battleFormationTypes.AttackType;

import java.util.ArrayList;

public class FatalSlash  extends ActiveSkill {

    public FatalSlash(Entity entity) {
        super("fatal slash", R.drawable.skill_fatal_slash,
                SkillType.SINGLE, entity, AttackType.PHYSICAL, new ArrayList<String>(), 8);
        
        // base
        this.pPhyDmg += 225;

        // incremental
        this.apPhyDmg += 45;

        // description
        this.description.add("deals " + (int) (pPhyDmg + (level * apPhyDmg)) + "% massive physical damage.");

        // long description
        this.description.add("unleash a devastatingly powerful strike against a single enemy. It often requires precise timing and positioning to execute successfully. When successful, it can deal massive damage and potentially even finish off an opponent in a single blow. However, it may also leave the player vulnerable to counterattacks or other enemies.");
    }
    
}
