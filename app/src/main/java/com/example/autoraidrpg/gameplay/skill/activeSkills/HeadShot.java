package com.example.autoraidrpg.gameplay.skill.activeSkills;

import com.example.autoraidrpg.R;
import com.example.autoraidrpg.gameplay.skill.ActiveSkill;
import com.example.autoraidrpg.gameplay.skill.SkillType;
import com.example.autoraidrpg.gameplay.entity.Entity;
import com.example.autoraidrpg.gameplay.formation.battleFormationTypes.AttackType;

import java.util.ArrayList;

public class HeadShot extends ActiveSkill {

    public HeadShot(Entity entity) {
        super("head shot", R.drawable.skill_headshot,
                SkillType.SINGLE, entity, AttackType.PHYSICAL, new ArrayList<String>(), 13);
        
        // base
        this.pPhyDmg += 250;

        // incremental
        this.apPhyDmg += 50;

        // description
        this.description.add("deals " + (int) (pPhyDmg + (level * apPhyDmg)) + "% massive physical damage.");

        // long description
        this.description.add("aim and fire a powerful shot at an enemy's head, dealing high damage and potentially even incapacitating them. This skill requires precise aiming and timing, but can be extremely effective against heavily armored opponents or enemies with high health. It may also have additional effects such as stunning or knocking back the target, making it a popular choice for players who prefer a strategic and tactical playstyle.");
    }
    
}
