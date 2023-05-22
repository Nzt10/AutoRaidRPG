package com.example.autoraidrpg.gameplay.skill.activeSkills;

import com.example.autoraidrpg.R;
import com.example.autoraidrpg.gameplay.buff.BuffFactory;
import com.example.autoraidrpg.gameplay.skill.ActiveSkill;
import com.example.autoraidrpg.gameplay.skill.SkillType;
import com.example.autoraidrpg.gameplay.entity.Entity;
import com.example.autoraidrpg.gameplay.formation.battleFormationTypes.AttackType;

import java.util.ArrayList;

public class BloodPoint extends ActiveSkill {

    public BloodPoint(Entity entity) {
        super("blood point", R.drawable.skill_blood_point,
                SkillType.SINGLE, entity, AttackType.PHYSICAL, new ArrayList<String>(), 5);
        
        // base
        this.pPhyDmg += 50;

        // incremental
        this.apPhyDmg += 12;

        // description
        this.description.add("deals " + (int) (pPhyDmg + (level * apPhyDmg)) + "% physical damage.");

        // long description
        this.description.add("deal low damage to an enemy with bleed effect. This skill is especially effective against tough enemies or in situations where the player needs to sustain themselves in battle.");    
        
        // add bleed buffs
        buffs.add(BuffFactory.makeBuff("bleed", 75 + (level * 6), entity, 6));
    }
    
}
