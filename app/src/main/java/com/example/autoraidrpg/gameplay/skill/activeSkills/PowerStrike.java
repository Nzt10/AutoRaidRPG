package com.example.autoraidrpg.gameplay.skill.activeSkills;

import com.example.autoraidrpg.R;
import com.example.autoraidrpg.gameplay.formation.battleFormationTypes.AttackType;
import com.example.autoraidrpg.gameplay.skill.ActiveSkill;
import com.example.autoraidrpg.gameplay.skill.SkillType;
import com.example.autoraidrpg.gameplay.entity.Entity;

import java.util.ArrayList;

public class PowerStrike extends ActiveSkill {

    public PowerStrike(Entity entity) {
        super("power strike", R.drawable.skill_power_strike,
                SkillType.SINGLE, entity, AttackType.PHYSICAL, new ArrayList<String>(), 3);
        
        // base
        this.pPhyDmg += 125;

        // incremental
        this.apPhyDmg += 35;

        // description
        this.description.add("deals " + (int) (pPhyDmg + (level * apPhyDmg)) + "% physical damage.");

        // long description
        this.description.add("a ranged combat skill that allows a character to fire a powerful arrow at their target, dealing piercing damage. The skill requires the character to be equipped with a bow or other ranged weapon, and provides a significant bonus to damage if the attack successfully lands. The accuracy and damage output of the skill are typically determined by the character's dexterity stat, as well as their equipment and any other relevant factors. Arrow Strike is a versatile skill that allows characters to engage their opponents from a safe distance and can be an effective tool in many combat situations.");
    }
    
}
