package com.example.autoraidrpg.gameplay.skill.activeSkills;

import com.example.autoraidrpg.R;
import com.example.autoraidrpg.gameplay.buff.BuffFactory;
import com.example.autoraidrpg.gameplay.formation.battleFormationTypes.AttackType;
import com.example.autoraidrpg.gameplay.skill.ActiveSkill;
import com.example.autoraidrpg.gameplay.skill.SkillType;
import com.example.autoraidrpg.gameplay.entity.Entity;

import java.util.ArrayList;

public class DarkDomination extends ActiveSkill {

    public DarkDomination(Entity entity) {
        super("dark domination", R.drawable.skill_dark_domination,
                SkillType.SINGLE, entity, AttackType.MAGICAL, new ArrayList<String>(), 10);
        
        // base
        this.pMagDmg += 10;

        // incremental
        this.apMagDmg += 5;

        // description
        this.description.add("deals " + (int) (pMagDmg + (level * apMagDmg)) + "% magical damage.");

        // long description
        this.description.add("take control of a weakened enemy and turn them into an ally. This skill may provide additional bonuses such as increased duration or the ability to control multiple enemies at once. The controlled enemy can be used to distract other enemies, attack their former allies, or even sacrifice themselves for the player's benefit. The skill is useful for manipulating the battlefield and turning the tide of battle in the player's favor.");

        // add nightmare buffs
        buffs.add(BuffFactory.makeBuff("nightmare", 40 + (level * 30), entity, 5));
    }
    
}
