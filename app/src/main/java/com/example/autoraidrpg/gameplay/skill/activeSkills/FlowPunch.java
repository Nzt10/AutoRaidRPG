package com.example.autoraidrpg.gameplay.skill.activeSkills;

import com.example.autoraidrpg.R;
import com.example.autoraidrpg.gameplay.skill.ActiveSkill;
import com.example.autoraidrpg.gameplay.skill.SkillType;
import com.example.autoraidrpg.gameplay.entity.Entity;
import com.example.autoraidrpg.gameplay.formation.battleFormationTypes.AttackType;

import java.util.ArrayList;

public class FlowPunch extends ActiveSkill {

    public FlowPunch(Entity entity) {
        super("flow punch", R.drawable.skill_flow_punch,
                SkillType.SINGLE, entity, AttackType.PHYSICAL, new ArrayList<String>(), 1);
        
        // base
        this.pPhyDmg += 108;

        // incremental
        this.apPhyDmg += 12;

        // description
        this.description.add("deals " + (int) (pPhyDmg + (level * apPhyDmg)) + "% physical damage.");

        // long description
        this.description.add("a hand-to-hand combat skill that channels the user's inner energy into a single, powerful strike. The user focuses their chi into their fist and delivers a fast, precise blow that can break through even the toughest defenses. The force of the attack can knock opponents back, leaving them vulnerable for follow-up attacks. Mastery of this skill requires great control and discipline to properly harness and direct one's inner energy.");
    }
    
}
