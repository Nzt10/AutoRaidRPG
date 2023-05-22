package com.example.autoraidrpg.gameplay.skill.activeSkills;

import com.example.autoraidrpg.R;
import com.example.autoraidrpg.gameplay.skill.ActiveSkill;
import com.example.autoraidrpg.gameplay.skill.SkillType;
import com.example.autoraidrpg.gameplay.entity.Entity;
import com.example.autoraidrpg.gameplay.formation.battleFormationTypes.AttackType;

import java.util.ArrayList;

public class PowerPull extends ActiveSkill {

    public PowerPull(Entity entity) {
        super("power pull", R.drawable.skill_power_pull,
                SkillType.SINGLE, entity, AttackType.PHYSICAL, new ArrayList<String>(), 6);
        
        // base
        this.pPhyDmg += 170;

        // incremental
        this.apPhyDmg += 18;

        // description
        this.description.add("deals " + (int) (pPhyDmg + (level * apPhyDmg)) + "% physical damage.");

        // long description
        this.description.add("pull an enemy towards them using a grappling hook or similar tool. This skill can be used to interrupt enemy attacks, pull ranged enemies closer for easier takedowns, or simply to draw enemies away from allies. It may also have the added effect of stunning or knocking back the target, making it a useful tool for crowd control.");
    }
    
    
}
