package com.example.autoraidrpg.gameplay.skill.activeSkills;

import com.example.autoraidrpg.R;
import com.example.autoraidrpg.gameplay.formation.battleFormationTypes.AttackType;
import com.example.autoraidrpg.gameplay.skill.ActiveSkill;
import com.example.autoraidrpg.gameplay.skill.SkillType;
import com.example.autoraidrpg.gameplay.entity.Entity;

import java.util.ArrayList;

public class SolarStrike extends ActiveSkill {

    public SolarStrike(Entity entity) {
        super("solar strike", R.drawable.skill_solar_strike,
                SkillType.SINGLE, entity, AttackType.MAGICAL, new ArrayList<String>(), 3);
        
        // base
        this.pMagDmg += 115;

        // incremental
        this.apMagDmg += 18;

        // description
        this.description.add("deals " + (int) (pMagDmg + (level * apMagDmg)) + "% magical damage.");

        // long description
        this.description.add("a powerful magic spell that unleashes a blast of intense solar energy, dealing heavy fire damage to all enemies in the area of effect. The spell requires the caster to channel the power of the sun and unleash it in a focused burst, potentially incinerating enemies in a wide radius. The accuracy and damage output of the spell are typically determined by the caster's level, intelligence stat, and any relevant equipment or modifiers. Solar Strike is a high-level spell that can be devastating in combat, but its high mana cost and lengthy casting time make it a risky move.");
    }
    
}
