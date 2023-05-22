package com.example.autoraidrpg.gameplay.skill.activeSkills;

import com.example.autoraidrpg.R;
import com.example.autoraidrpg.gameplay.formation.battleFormationTypes.AttackType;
import com.example.autoraidrpg.gameplay.skill.ActiveSkill;
import com.example.autoraidrpg.gameplay.skill.SkillType;
import com.example.autoraidrpg.gameplay.entity.Entity;

import java.util.ArrayList;

public class TheWhirlwind extends ActiveSkill {

    private boolean hasSpd = false;

    public TheWhirlwind(Entity entity) {
        super("the whirlwind", R.drawable.skill_the_whirlwind,
                SkillType.ALL, entity, AttackType.PHYSICAL, new ArrayList<String>(), 10);

        // attack damage increases by speed once
        this.extra = e -> {
            if(!hasSpd) this.pPhyDmg += e.getSpd() * (0.125 * level);
            hasSpd = true;
        };
        
        // base
        this.pPhyDmg += 125;

        // incremental
        this.apPhyDmg += 40;

        // description
        this.description.add("deals " + (int) (pPhyDmg + (level * apPhyDmg)) + "% physical damage + speed to all hostile.");

        // long description
        this.description.add(" allows the user to spin rapidly, attacking enemies within a certain radius. The spinning motion deals damage to multiple foes at once, making it an effective crowd control skill. The skill also has a chance to knock back enemies, giving the user some breathing room. However, it usually requires a long cooldown period, leaving the user vulnerable to counterattacks.");
    }
    
}
