package com.example.autoraidrpg.gameplay.skill.activeSkills;

import com.example.autoraidrpg.R;
import com.example.autoraidrpg.gameplay.buff.BuffFactory;
import com.example.autoraidrpg.gameplay.formation.battleFormationTypes.AttackType;
import com.example.autoraidrpg.gameplay.skill.ActiveSkill;
import com.example.autoraidrpg.gameplay.skill.SkillType;
import com.example.autoraidrpg.gameplay.entity.Entity;

import java.util.ArrayList;

public class PoisonStrike extends ActiveSkill {

    public PoisonStrike(Entity entity) {
        super("poison strike", R.drawable.skill_poison_strike,
                SkillType.SINGLE, entity, AttackType.MAGICAL, new ArrayList<String>(), 6);
        
        // base
        this.pPhyDmg += 160;

        // incremental
        this.apPhyDmg += 35;

        // description
        this.description.add("deals " + (int) (pPhyDmg + (level * apPhyDmg)) + "% physical damage.");

        // long description
        this.description.add("poison an enemy, dealing damage over time and potentially causing other debuffs such as reduced movement speed or accuracy. This skill is especially effective against enemies with high health pools, as the damage over time can wear them down even while the player is attacking other enemies.");

        // add fire buffs
        buffs.add(BuffFactory.makeBuff("poison", 115 + (level * 35), entity, 6));
    }
    
}
