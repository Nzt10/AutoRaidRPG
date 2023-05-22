package com.example.autoraidrpg.gameplay.skill.activeSkills;

import com.example.autoraidrpg.R;
import com.example.autoraidrpg.gameplay.formation.battleFormationTypes.AttackType;
import com.example.autoraidrpg.gameplay.skill.ActiveSkill;
import com.example.autoraidrpg.gameplay.skill.SkillType;
import com.example.autoraidrpg.gameplay.entity.Entity;

import java.util.ArrayList;

public class BloodImpale extends ActiveSkill {

    public BloodImpale(Entity entity) {
        super("blood impale", R.drawable.skill_blood_impale,
                SkillType.SINGLE, entity, AttackType.PHYSICAL, new ArrayList<String>(), 2);
        
        // base
        this.pMagDmg += 100;

        // incremental
        this.apMagDmg += 20;

        // description
        this.description.add("deals " + (int) (pMagDmg + (level * apMagDmg)) + "% magical damage.");

        // long description
        this.description.add("The user charges forward with their weapon, impaling the target and dealing massive damage. The attack also causes the target to bleed, draining their health over time. Additionally, the user gains health equal to the amount of damage inflicted. This skill is particularly useful for high-damage, high-risk builds and can turn the tide of battle in the user's favor.");    
    }
    
}
