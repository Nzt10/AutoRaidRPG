package com.example.autoraidrpg.gameplay.skill.activeSkills;

import com.example.autoraidrpg.R;
import com.example.autoraidrpg.gameplay.buff.BuffFactory;
import com.example.autoraidrpg.gameplay.skill.ActiveSkill;
import com.example.autoraidrpg.gameplay.skill.SkillType;
import com.example.autoraidrpg.gameplay.entity.Entity;
import com.example.autoraidrpg.gameplay.formation.battleFormationTypes.AttackType;

import java.util.ArrayList;

public class Fireball extends ActiveSkill {

    public Fireball(Entity entity) {
        super("fireball", R.drawable.skill_fireball,
                SkillType.SINGLE, entity, AttackType.MAGICAL, new ArrayList<String>(), 5);
        
        // base
        this.pMagDmg += 160;

        // incremental
        this.apMagDmg += 35;

        // description
        this.description.add("deals " + (int) (pMagDmg + (level * apMagDmg)) + "% magical damage.");

        // long description
        this.description.add("unleashes a burst of flames, incinerating everything within its area of effect. The spell creates a fiery sphere that can be directed by the caster, exploding on impact and dealing damage to all creatures caught within its blast radius. The spell's power and area of effect increase with the caster's level, and the spell is often a staple in the arsenal of offensive spellcasters. However, the use of Fireball may also cause collateral damage to the environment, including objects and structures caught in the spell's path.");

        // add fire buffs
        buffs.add(BuffFactory.makeBuff("burn", 45 + (level * 2.5), entity, 2 + level));
    }
    
}
