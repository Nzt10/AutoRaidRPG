package com.example.autoraidrpg.gameplay.skill.passiveSkills;

import com.example.autoraidrpg.R;
import com.example.autoraidrpg.gameplay.skill.PassiveSkill;
import com.example.autoraidrpg.gameplay.skill.SkillType;

import java.util.ArrayList;

public class ClericMastery extends PassiveSkill {

    public ClericMastery() {
        super("cleric mastery", R.drawable.skill_cleric_mastery,
                SkillType.INITIAL_PASSIVE, new ArrayList<String>());

        // base
        this.lvlpMagDmg += 5;
        this.lvlpSpd += 0.5;

        // incremental
        this.aLvlpMagDmg += 2;
        this.aLvlpSpd += 0.5;

        // description
        this.description.add("gain " + (int) (lvlpMagDmg + (level * aLvlpMagDmg)) + "% magical damage.");
        this.description.add("gain " + (int) (lvlpSpd + (level * aLvlpSpd)) + "% speed.");

        // long description
        this.description.add("master of divine magic, healing, and protection. The skill allows the character to cast powerful spells that can heal injuries, cure diseases, and protect themselves and their allies from harm. The skill requires the character to have high wisdom and charisma stats, as well as proficiency in using divine magic and holy relics, such as sacred symbols and amulets. Cleric Mastery is a versatile skill that can be used in a wide range of situations, from healing injured allies to repelling undead creatures and banishing demons.");
    }
    
}
