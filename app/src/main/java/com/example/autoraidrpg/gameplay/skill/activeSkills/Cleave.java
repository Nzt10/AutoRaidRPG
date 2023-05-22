package com.example.autoraidrpg.gameplay.skill.activeSkills;

import com.example.autoraidrpg.R;
import com.example.autoraidrpg.gameplay.entity.Entity;
import com.example.autoraidrpg.gameplay.formation.battleFormationTypes.AttackType;
import com.example.autoraidrpg.gameplay.skill.ActiveSkill;
import com.example.autoraidrpg.gameplay.skill.SkillType;

import java.util.ArrayList;

public class Cleave extends ActiveSkill {

    public Cleave(Entity entity) {
        super("cleave", R.drawable.skill_cleave,
                SkillType.ALL, entity, AttackType.PHYSICAL, new ArrayList<String>(), 6);
        
        // base
        this.pPhyDmg += 115;

        // incremental
        this.apPhyDmg += 18;

        // description
        this.description.add("deals " + (int) (pPhyDmg + (level * apPhyDmg)) + "% physical damage to all hostile.");

        // long description
        this.description.add("strike with a powerful, wide sweep of their weapon, damaging all enemies within a certain radius in front of them.");
    }
    
}
