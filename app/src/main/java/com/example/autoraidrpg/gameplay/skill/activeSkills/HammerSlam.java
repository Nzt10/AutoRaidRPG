package com.example.autoraidrpg.gameplay.skill.activeSkills;

import com.example.autoraidrpg.R;
import com.example.autoraidrpg.gameplay.buff.BuffFactory;
import com.example.autoraidrpg.gameplay.skill.ActiveSkill;
import com.example.autoraidrpg.gameplay.skill.SkillType;
import com.example.autoraidrpg.gameplay.entity.Entity;
import com.example.autoraidrpg.gameplay.formation.battleFormationTypes.AttackType;

import java.util.ArrayList;

public class HammerSlam extends ActiveSkill {

    public HammerSlam(Entity entity) {
        super("hammer slam", R.drawable.skill_hammer_slam,
                SkillType.SINGLE, entity, AttackType.PHYSICAL, new ArrayList<String>(), 5);
        
        // base
        this.pPhyDmg += 90;

        // incremental
        this.apPhyDmg += 12;

        // description
        this.description.add("deals " + (int) (pPhyDmg + (level * apPhyDmg)) + "% physical damage.");

        // long description
        this.description.add("jump into the air and slam their weapon down, creating a shockwave that damages and knocks down nearby enemies. This skill is especially effective against groups of enemies, as it may provide additional bonuses such as increased damage or increased knockdown duration. The skill may have a longer cooldown time than other attacks, but its ability to crowd control enemies makes it a valuable addition to any character's arsenal.");

        // add stun buffs
        buffs.add(BuffFactory.makeBuff("stun", 0, entity, 1));
    }
    
}
