package com.example.autoraidrpg.gameplay.skill.activeSkills;

import com.example.autoraidrpg.R;
import com.example.autoraidrpg.gameplay.buff.BuffFactory;
import com.example.autoraidrpg.gameplay.formation.battleFormationTypes.AttackType;
import com.example.autoraidrpg.gameplay.skill.ActiveSkill;
import com.example.autoraidrpg.gameplay.skill.SkillType;
import com.example.autoraidrpg.gameplay.entity.Entity;

import java.util.ArrayList;

public class HammerStomp extends ActiveSkill {

    public HammerStomp(Entity entity) {
        super("hammer stomp", R.drawable.skill_hammer_stomp,
                SkillType.ALL, entity, AttackType.PHYSICAL, new ArrayList<String>(), 15);
        
        // base
        this.pPhyDmg += 45;

        // incremental
        this.apPhyDmg += 5;

        // description
        this.description.add("deals " + (int) (pPhyDmg + (level * apPhyDmg)) + "% physical damage to all hostile.");

        // long description
        this.description.add("allows the player to slam their weapon into the ground, creating a shockwave that damages and knocks down nearby enemies. This skill is especially effective against groups of enemies, as it may provide additional bonuses such as increased damage or increased knockdown duration.");

        // add stun buffs
        buffs.add(BuffFactory.makeBuff("stun", 0, entity, 1));
    }
    
}
