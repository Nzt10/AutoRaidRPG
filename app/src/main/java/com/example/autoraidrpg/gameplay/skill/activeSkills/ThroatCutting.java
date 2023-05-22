package com.example.autoraidrpg.gameplay.skill.activeSkills;

import com.example.autoraidrpg.R;
import com.example.autoraidrpg.gameplay.formation.battleFormationTypes.AttackType;
import com.example.autoraidrpg.gameplay.skill.ActiveSkill;
import com.example.autoraidrpg.gameplay.skill.SkillType;
import com.example.autoraidrpg.gameplay.entity.Entity;

import java.util.ArrayList;

public class ThroatCutting extends ActiveSkill {

    public ThroatCutting(Entity entity) {
        super("throat cutting", R.drawable.skill_throat_cutting,
                SkillType.SINGLE, entity, AttackType.PHYSICAL, new ArrayList<String>(), 5);
        
        // base
        this.pPhyDmg += 30;

        // incremental
        this.apPhyDmg += 70;

        // description
        this.description.add("deals " + (int) (pPhyDmg + (level * apPhyDmg)) + "% physical damage.");

        // long description
        this.description.add("silently take down an enemy from behind, dealing high damage and instantly killing the target. This skill is especially effective against unsuspecting or weaker enemies, and may have additional effects such as causing nearby enemies to panic or flee.");
    }
    
}
