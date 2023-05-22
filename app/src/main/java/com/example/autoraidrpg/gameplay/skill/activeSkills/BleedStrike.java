package com.example.autoraidrpg.gameplay.skill.activeSkills;

import com.example.autoraidrpg.R;
import com.example.autoraidrpg.gameplay.buff.BuffFactory;
import com.example.autoraidrpg.gameplay.formation.battleFormationTypes.AttackType;
import com.example.autoraidrpg.gameplay.skill.ActiveSkill;
import com.example.autoraidrpg.gameplay.skill.SkillType;
import com.example.autoraidrpg.gameplay.entity.Entity;

import java.util.ArrayList;

public class BleedStrike extends ActiveSkill {

    public BleedStrike(Entity entity) {
        super("bleed strike", R.drawable.skill_bleed_strike,
                SkillType.SINGLE, entity, AttackType.PHYSICAL, new ArrayList<String>(), 5);
        
        // base
        this.pPhyDmg += 90;

        // incremental
        this.apPhyDmg += 8;

        // description
        this.description.add("deals " + (int) (pPhyDmg + (level * apPhyDmg)) + "% physical damage.");

        // long description
        this.description.add("strike an enemy with a weapon coated in a poisonous substance, causing the target to bleed and take additional damage over time. This skill is especially effective against enemies weak to poison damage and may have the added effect of reducing the target's defense or movement speed. The skill may have a longer cooldown time than other attacks, but its damage-over-time effect makes it a popular choice for players who prefer a strategic playstyle.");    
        
        // add bleed buffs
        buffs.add(BuffFactory.makeBuff("bleed", 60 + (level * 4.25), entity, 1 + level));
    }
    
}
