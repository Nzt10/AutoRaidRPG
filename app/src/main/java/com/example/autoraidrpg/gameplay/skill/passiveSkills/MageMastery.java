package com.example.autoraidrpg.gameplay.skill.passiveSkills;

import com.example.autoraidrpg.R;
import com.example.autoraidrpg.gameplay.skill.PassiveSkill;
import com.example.autoraidrpg.gameplay.skill.SkillType;

import java.util.ArrayList;

public class MageMastery extends PassiveSkill {

    public MageMastery() {
        super("mage mastery", R.drawable.skill_mage_mastery,
                SkillType.INITIAL_PASSIVE, new ArrayList<String>());

        // base
        this.lvlpMagDmg += 8;

        // incremental
        this.aLvlpMagDmg += 8;

        // description
        this.description.add("gain " + (int) (lvlpMagDmg + (level * aLvlpMagDmg)) + "% magical damage.");

        // long description
        this.description.add("master of the arcane arts, elemental magic, and enchantments. The skill allows the character to cast powerful spells that can unleash the forces of nature, control the elements, and enchant objects and creatures. The skill requires the character to have high intelligence and wisdom stats, as well as proficiency in using a variety of arcane spells, wands, staves, and other magical equipment. Mage Mastery is a versatile skill that can be used to destroy enemies, manipulate the environment, and control the battlefield, making it a valuable skill for any character seeking to become a master of magic.");
    }
    
}
