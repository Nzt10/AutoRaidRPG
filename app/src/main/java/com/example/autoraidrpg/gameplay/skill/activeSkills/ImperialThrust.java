package com.example.autoraidrpg.gameplay.skill.activeSkills;

import com.example.autoraidrpg.R;
import com.example.autoraidrpg.gameplay.formation.battleFormationTypes.AttackType;
import com.example.autoraidrpg.gameplay.skill.ActiveSkill;
import com.example.autoraidrpg.gameplay.skill.SkillType;
import com.example.autoraidrpg.gameplay.entity.Entity;

import java.util.ArrayList;

public class ImperialThrust extends ActiveSkill {

    public ImperialThrust(Entity entity) {
        super("imperial thrust", R.drawable.skill_imperial_thrust,
                SkillType.SINGLE, entity, AttackType.PHYSICAL, new ArrayList<String>(), 2);
        
        // base
        this.pPhyDmg += 120;

        // incremental
        this.apPhyDmg += 28;

        // description
        this.description.add("deals " + (int) (pPhyDmg + (level * apPhyDmg)) + "% high & quick physical damage.");

        // long description
        this.description.add("charge forward and strike a single enemy with a powerful thrust of their weapon. This skill deals high damage and may have the added effect of staggering or knocking back the target. It may also be used to close the gap between the player and a distant enemy quickly.");
    }
    
}
