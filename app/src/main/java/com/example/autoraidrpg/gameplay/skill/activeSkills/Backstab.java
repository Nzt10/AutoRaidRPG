package com.example.autoraidrpg.gameplay.skill.activeSkills;

import com.example.autoraidrpg.R;
import com.example.autoraidrpg.gameplay.entity.Entity;
import com.example.autoraidrpg.gameplay.formation.battleFormationTypes.AttackType;
import com.example.autoraidrpg.gameplay.skill.ActiveSkill;
import com.example.autoraidrpg.gameplay.skill.SkillType;

import java.util.ArrayList;

public class Backstab extends ActiveSkill {

    public Backstab(Entity entity) {
        super("backstab", R.drawable.skill_backstab,
                SkillType.SINGLE, entity, AttackType.PHYSICAL, new ArrayList<String>(), 3);
        
        // base
        this.pPhyDmg += 60;

        // incremental
        this.apPhyDmg += 6.5;

        // description
        this.description.add("deals " + (int) (pPhyDmg + (level * apPhyDmg)) + "% physical damage.");

        // long description
        this.description.add("deals significant damage to a target by striking them from behind with a melee weapon. The attack must be made from behind the target, while the rogue is hidden, or while the target is stunned, blinded, or otherwise incapacitated. The skill can critically hit and is more effective against enemies with lower armor class.");
    }
    
}
