package com.example.autoraidrpg.gameplay.skill.activeSkills;

import com.example.autoraidrpg.R;
import com.example.autoraidrpg.gameplay.skill.ActiveSkill;
import com.example.autoraidrpg.gameplay.skill.SkillType;
import com.example.autoraidrpg.gameplay.entity.Entity;
import com.example.autoraidrpg.gameplay.formation.battleFormationTypes.AttackType;

import java.util.ArrayList;

public class FurySwipe extends ActiveSkill {

    public FurySwipe(Entity entity) {
        super("fury swipe", R.drawable.skill_fury_swipe,
                SkillType.ALL, entity, AttackType.PHYSICAL, new ArrayList<String>(), 5);
        
        // base
        this.pPhyDmg += 100;

        // incremental
        this.apPhyDmg += 10.75;

        // description
        this.description.add("deals " + (int) (pPhyDmg + (level * apPhyDmg)) + "% physical damage to all hostile.");

        // long description
        this.description.add("unleash a flurry of rapid attacks on a single enemy, dealing moderate damage with each hit. This skill is especially effective when the player is in a state of rage or fury, as it may provide additional bonuses such as increased attack speed or critical hit chance. The skill may have a shorter cooldown time than other attacks, but its ability to deal consistent damage makes it a valuable addition to any character's arsenal.");
    }
    
}
