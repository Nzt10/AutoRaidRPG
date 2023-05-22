package com.example.autoraidrpg.gameplay.skill.activeSkills;

import com.example.autoraidrpg.R;
import com.example.autoraidrpg.gameplay.formation.battleFormationTypes.AttackType;
import com.example.autoraidrpg.gameplay.skill.ActiveSkill;
import com.example.autoraidrpg.gameplay.skill.SkillType;
import com.example.autoraidrpg.gameplay.entity.Entity;

import java.util.ArrayList;

public class RagingSlash extends ActiveSkill {

    public RagingSlash(Entity entity) {
        super("raging slash", R.drawable.skill_raging_slash,
                SkillType.SINGLE, entity, AttackType.PHYSICAL, new ArrayList<String>(), 3);
        
        // base
        this.pPhyDmg += 110;

        // incremental
        this.apPhyDmg += 12.5;

        // description
        this.description.add("deals " + (int) (pPhyDmg + (level * apPhyDmg)) + "% physical damage.");

        // long description
        this.description.add("unleash a powerful, high-damage attack on a single enemy or a group of enemies. This skill is especially effective when the player is in a state of rage or fury, as it may provide additional bonuses such as increased attack speed or critical hit chance.");
    }
    
}
