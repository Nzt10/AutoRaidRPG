package com.example.autoraidrpg.gameplay.skill.activeSkills;

import com.example.autoraidrpg.R;
import com.example.autoraidrpg.gameplay.buff.BuffFactory;
import com.example.autoraidrpg.gameplay.skill.ActiveSkill;
import com.example.autoraidrpg.gameplay.skill.SkillType;
import com.example.autoraidrpg.gameplay.entity.Entity;
import com.example.autoraidrpg.gameplay.formation.battleFormationTypes.AttackType;

import java.util.ArrayList;

public class DarkPurge extends ActiveSkill {

    public DarkPurge(Entity entity) {
        super("dark purge", R.drawable.skill_dark_purge,
                SkillType.SINGLE, entity, AttackType.MAGICAL, new ArrayList<String>(), 3);
        
        // base
        this.pMagDmg += 90;

        // incremental
        this.apMagDmg += 9;

        // description
        this.description.add("deals " + (int) (pMagDmg + (level * apMagDmg)) + "% magical damage.");

        // long description
        this.description.add("summon a wave of dark energy that damages and weakens all enemies within a certain radius. This skill may provide additional bonuses such as decreased enemy defenses or increased damage over time.");

        // add nightmare buffs
        buffs.add(BuffFactory.makeBuff("nightmare", 65 + (level * 5), entity, 4));
    }
    
}
