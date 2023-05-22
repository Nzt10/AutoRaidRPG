package com.example.autoraidrpg.gameplay.skill.activeSkills;

import com.example.autoraidrpg.R;
import com.example.autoraidrpg.gameplay.formation.battleFormationTypes.AttackType;
import com.example.autoraidrpg.gameplay.skill.ActiveSkill;
import com.example.autoraidrpg.gameplay.skill.SkillType;
import com.example.autoraidrpg.gameplay.entity.Entity;

import java.util.ArrayList;

public class ElementalPunch extends ActiveSkill {

    public ElementalPunch(Entity entity) {
        super("elemental punch", R.drawable.skill_elemental_punch,
                SkillType.SINGLE, entity, AttackType.PHYSICAL, new ArrayList<String>(), 3);
        
        // base
        this.pPhyDmg += 90;
        this.pMagDmg += 125;

        // incremental
        this.apPhyDmg += 10.5;
        this.apMagDmg += 16;

        // description
        this.description.add("deals " + (int) (pPhyDmg + (level * apPhyDmg)) + "% physical damage.");
        this.description.add("deals " + (int) (pMagDmg + (level * apMagDmg)) + "% magical damage.");

        // long description
        this.description.add("powerful physical attack that imbues the user's fist with elemental energy. The user can choose the type of elemental energy to infuse their punch with, such as fire, ice, lightning, or earth, depending on the enemy's weakness. This skill not only deals heavy damage, but also has a chance to inflict elemental status effects on the enemy, making it a versatile and formidable skill in battle.");
    }
    
}
