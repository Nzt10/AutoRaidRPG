package com.example.autoraidrpg.gameplay.skill.activeSkills;

import com.example.autoraidrpg.R;
import com.example.autoraidrpg.gameplay.skill.ActiveSkill;
import com.example.autoraidrpg.gameplay.skill.SkillType;
import com.example.autoraidrpg.gameplay.entity.Entity;
import com.example.autoraidrpg.gameplay.formation.battleFormationTypes.AttackType;

import java.util.ArrayList;

public class HeatBlast extends ActiveSkill {

    public HeatBlast(Entity entity) {
        super("heat blast", R.drawable.skill_heat_blast,
                SkillType.ALL, entity, AttackType.MAGICAL, new ArrayList<String>(), 4);
        
        // base
        this.pMagDmg += 100;

        // incremental
        this.apMagDmg += 22;

        // description
        this.description.add("deals " + (int) (pMagDmg + (level * apMagDmg)) + "% magical damage to all hostile.");

        // long description
        this.description.add("powerful blast of flame in a wide radius, damaging all enemies caught in the blast. This skill is especially effective against enemies weak to fire damage, and may have additional effects such as burning or reducing the targets' fire resistance. The skill may have a longer cooldown time than other abilities, but its area-of-effect damage makes it a popular choice for players who prefer to deal damage to multiple enemies at once.");
    }
    
    
}
