package com.example.autoraidrpg.gameplay.skill.activeSkills;

import com.example.autoraidrpg.R;
import com.example.autoraidrpg.gameplay.formation.battleFormationTypes.AttackType;
import com.example.autoraidrpg.gameplay.skill.ActiveSkill;
import com.example.autoraidrpg.gameplay.skill.SkillType;
import com.example.autoraidrpg.gameplay.entity.Entity;

import java.util.ArrayList;

public class SilverShot extends ActiveSkill {

    public SilverShot(Entity entity) {
        super("silver shot", R.drawable.skill_silver_shot,
                SkillType.SINGLE, entity, AttackType.PHYSICAL, new ArrayList<String>(), 2);
        
        // base
        this.pPhyDmg += 95;

        // incremental
        this.apPhyDmg += 38;

        // description
        this.description.add("deals " + (int) (pPhyDmg + (level * apPhyDmg)) + "% physical damage.");

        // long description
        this.description.add("fire off a rapid succession of shots at a single or multiple enemies. This skill is often used for fast-paced combat situations or to interrupt enemy attacks. It typically deals moderate damage but compensates for this with its speed and versatility. The skill may also have a shorter cooldown time than other attacks, making it a popular choice for players who prefer a hit-and-run playstyle.");
    }
    
}
