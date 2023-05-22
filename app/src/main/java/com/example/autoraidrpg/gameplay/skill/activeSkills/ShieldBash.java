package com.example.autoraidrpg.gameplay.skill.activeSkills;

import com.example.autoraidrpg.R;
import com.example.autoraidrpg.gameplay.buff.BuffFactory;
import com.example.autoraidrpg.gameplay.formation.battleFormationTypes.AttackType;
import com.example.autoraidrpg.gameplay.skill.ActiveSkill;
import com.example.autoraidrpg.gameplay.skill.SkillType;
import com.example.autoraidrpg.gameplay.entity.Entity;

import java.util.ArrayList;

public class ShieldBash extends ActiveSkill {

    public ShieldBash(Entity entity) {
        super("shield bash", R.drawable.skill_shield_bash,
                SkillType.SINGLE, entity, AttackType.PHYSICAL, new ArrayList<String>(), 4);
        
        // base
        this.pPhyDmg += 90;

        // incremental
        this.apPhyDmg += 5.75;

        // description
        this.description.add("deals " + (int) (pPhyDmg + (level * apPhyDmg)) + "% physical damage.");

        // long description
        this.description.add("shield as a weapon to strike their opponent, dealing moderate damage and potentially stunning them. The skill requires the character to be equipped with a shield and in close proximity to their target. The accuracy and damage output of the skill are typically determined by the character's strength stat and equipment, while the chance to stun the target is usually based on the character's level and the target's resistance. Shield Bash is a useful skill that can allow characters to disable their opponents while protecting themselves with their shield.");

        // add stun buffs
        buffs.add(BuffFactory.makeBuff("stun", 0, entity, 1));
    }
    
}
