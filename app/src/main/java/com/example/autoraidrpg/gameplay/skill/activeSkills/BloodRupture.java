package com.example.autoraidrpg.gameplay.skill.activeSkills;

import com.example.autoraidrpg.R;
import com.example.autoraidrpg.gameplay.buff.BuffFactory;
import com.example.autoraidrpg.gameplay.formation.battleFormationTypes.AttackType;
import com.example.autoraidrpg.gameplay.skill.ActiveSkill;
import com.example.autoraidrpg.gameplay.skill.SkillType;
import com.example.autoraidrpg.gameplay.entity.Entity;

import java.util.ArrayList;

public class BloodRupture extends ActiveSkill {

    public BloodRupture(Entity entity) {
        super("blood rupture", R.drawable.skill_blood_rupture,
                SkillType.SINGLE, entity, AttackType.PHYSICAL, new ArrayList<String>(), 2);
        
        // base
        this.pMagDmg += 115;

        // incremental
        this.apMagDmg += 21.5;

        // description
        this.description.add("deals " + (int) (pMagDmg + (level * apMagDmg)) + "% magical damage.");

        // long description
        this.description.add("Blood Rupture is a devastating skill in RPG games that allows the user to deal a significant amount of damage to their opponents. When activated, the user delivers a powerful strike that ruptures their opponent's blood vessels, causing them to bleed out and take additional damage over time. This skill is particularly effective against heavily-armored opponents, as it bypasses their armor and inflicts direct damage. It requires a high level of proficiency in melee combat and a deep understanding of human anatomy.");    
        
        // add bleed buffs
        buffs.add(BuffFactory.makeBuff("bleed", 25 + (level * 5), entity, 2));
    }
    
}
