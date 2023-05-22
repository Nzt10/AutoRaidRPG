package com.example.autoraidrpg.gameplay.skill.activeSkills;

import com.example.autoraidrpg.R;
import com.example.autoraidrpg.gameplay.formation.battleFormationTypes.AttackType;
import com.example.autoraidrpg.gameplay.skill.ActiveSkill;
import com.example.autoraidrpg.gameplay.skill.SkillType;
import com.example.autoraidrpg.gameplay.entity.Entity;

import java.util.ArrayList;

public class BasicAttack extends ActiveSkill {

    public BasicAttack(Entity entity) {
        super("basic attack", R.drawable.skill_basic_attack,
                SkillType.SINGLE, entity, AttackType.PHYSICAL, new ArrayList<String>(), 0);
        
        // base
        this.pPhyDmg += 95;

        // incremental
        this.apPhyDmg += 11.5;

        // description
        this.description.add("deals " + (int) (pPhyDmg + (level * apPhyDmg)) + "% physical damage.");

        // long description
        this.description.add("simple combat skill that allows a character to make a standard attack using their primary weapon or unarmed strikes. The skill typically deals a base amount of damage and can be used in most situations where combat is required. The accuracy and damage dealt may be affected by the character's level, stats, equipment, and other factors.");
    }
    
}
