package com.example.autoraidrpg.gameplay.skill.activeSkills;

import com.example.autoraidrpg.R;
import com.example.autoraidrpg.gameplay.buff.BuffFactory;
import com.example.autoraidrpg.gameplay.formation.battleFormationTypes.AttackType;
import com.example.autoraidrpg.gameplay.skill.ActiveSkill;
import com.example.autoraidrpg.gameplay.skill.SkillType;
import com.example.autoraidrpg.gameplay.entity.Entity;

import java.util.ArrayList;

public class HammerIgnition extends ActiveSkill {

    public HammerIgnition(Entity entity) {
        super("hammer ignition", R.drawable.skill_hammer_ignition,
                SkillType.SINGLE, entity, AttackType.PHYSICAL, new ArrayList<String>(), 4);
        
        // base
        this.pPhyDmg += 118;

        // incremental
        this.apPhyDmg += 18;

        // description
        this.description.add("deals " + (int) (pPhyDmg + (level * apPhyDmg)) + "% physical damage.");

        // long description
        this.description.add("charge up their weapon and unleash a powerful, fiery attack on a single enemy. This skill is especially effective against enemies with high armor or resistance to physical attacks, as it may deal additional fire damage.");    
        
        // add ignite buffs
        buffs.add(BuffFactory.makeBuff("ignite", 40 + (level * 5.5), entity, 4));
    }
    
}
