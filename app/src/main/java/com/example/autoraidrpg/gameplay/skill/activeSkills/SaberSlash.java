package com.example.autoraidrpg.gameplay.skill.activeSkills;

import com.example.autoraidrpg.R;
import com.example.autoraidrpg.gameplay.skill.ActiveSkill;
import com.example.autoraidrpg.gameplay.skill.SkillType;
import com.example.autoraidrpg.gameplay.entity.Entity;
import com.example.autoraidrpg.gameplay.formation.battleFormationTypes.AttackType;

import java.util.ArrayList;

public class SaberSlash extends ActiveSkill {

    public SaberSlash(Entity entity) {
        super("saber strike", R.drawable.skill_saber_slash,
                SkillType.SINGLE, entity, AttackType.PHYSICAL, new ArrayList<String>(), 2);
        
        // base
        this.pPhyDmg += 100;

        // incremental
        this.apPhyDmg += 16;

        // description
        this.description.add("deals " + (int) (pPhyDmg + (level * apPhyDmg)) + "% physical damage.");

        // long description
        this.description.add("quickly strike their opponent with a saber or other close-range weapon, dealing moderate damage. The skill requires the character to be in close proximity to their target and can be used to make quick, precise strikes in rapid succession. The accuracy and damage output of the skill are typically determined by the character's dexterity and strength stats, as well as their equipment and any other relevant factors. Saber Strike is a basic but versatile skill that can be used in a wide range of combat situations.");
    }
    
}
