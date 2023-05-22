package com.example.autoraidrpg.gameplay.skill.activeSkills;

import com.example.autoraidrpg.R;
import com.example.autoraidrpg.gameplay.formation.battleFormationTypes.AttackType;
import com.example.autoraidrpg.gameplay.skill.ActiveSkill;
import com.example.autoraidrpg.gameplay.skill.SkillType;
import com.example.autoraidrpg.gameplay.entity.Entity;

import java.util.ArrayList;

public class MassiveStrike extends ActiveSkill {

    public MassiveStrike(Entity entity) {
        super("massive strike", R.drawable.skill_massive_strike,
                SkillType.SINGLE, entity, AttackType.PHYSICAL, new ArrayList<String>(), 3);
        
        // base
        this.pPhyDmg += 175;

        // incremental
        this.apPhyDmg += 25;

        // description
        this.description.add("deals " + (int) (pPhyDmg + (level * apPhyDmg)) + "% physical damage.");

        // long description
        this.description.add("a melee combat skill that enables a character to deliver a powerful blow to their target, dealing heavy damage. The skill requires the character to wind up their attack, leaving them vulnerable to counter-attacks, but provides a significant bonus to damage if the attack successfully lands. The damage output of the skill is typically determined by the character's strength stat and the weapon they are using. Massive Strike is a high-risk, high-reward skill that can turn the tide of a battle if used effectively.");
    }
    
}
