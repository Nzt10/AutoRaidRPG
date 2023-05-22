package com.example.autoraidrpg.gameplay.skill.activeSkills;

import com.example.autoraidrpg.R;
import com.example.autoraidrpg.gameplay.buff.BuffFactory;
import com.example.autoraidrpg.gameplay.formation.battleFormationTypes.AttackType;
import com.example.autoraidrpg.gameplay.skill.ActiveSkill;
import com.example.autoraidrpg.gameplay.skill.SkillType;
import com.example.autoraidrpg.gameplay.entity.Entity;

import java.util.ArrayList;

public class DarkBinding extends ActiveSkill {

    public DarkBinding(Entity entity) {
        super("dark binding", R.drawable.skill_dark_binding,
                SkillType.SINGLE, entity, AttackType.MAGICAL, new ArrayList<String>(), 3);
        
        // base
        this.pMagDmg += 90;

        // incremental
        this.apMagDmg += 9;

        // description
        this.description.add("deals " + (int) (pMagDmg + (level * apMagDmg)) + "% magical damage.");

        // long description
        this.description.add("immobilize a single enemy, preventing them from moving or attacking for a certain duration. This skill may provide additional bonuses such as increased damage or increased duration. summon a wave of dark energy that damages and weakens all enemies within a certain radius. This skill may provide additional bonuses such as decreased enemy defenses or increased damage over time.");

        // add bind buffs
        buffs.add(BuffFactory.makeBuff("bind", 0, entity, 1));
    }
    
}
