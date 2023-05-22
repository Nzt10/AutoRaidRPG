package com.example.autoraidrpg.gameplay.skill.passiveSkills;

import com.example.autoraidrpg.R;
import com.example.autoraidrpg.gameplay.skill.PassiveSkill;
import com.example.autoraidrpg.gameplay.skill.SkillType;

import java.util.ArrayList;

public class KnightMastery extends PassiveSkill {

    public KnightMastery() {
        super("knight mastery", R.drawable.skill_knight_mastery,
                SkillType.INITIAL_PASSIVE, new ArrayList<String>());

        // base
        this.lvlpHp += 11;
        this.lvlpPhyDef += 15;

        // incremental
        this.aLvlpHp += 6.25;
        this.aLvlpPhyDef += 3;

        // description
        this.description.add("gain " + (int) (lvlpHp + (level * aLvlpHp)) + "% health.");
        this.description.add("gain " + (int) (lvlpPhyDef + (level * aLvlpPhyDef)) + "% physical defense.");

        // long description
        this.description.add("become a master of heavy armor, swordsmanship, and chivalry. The skill allows the character to withstand even the most brutal attacks, deal heavy damage with their sword, and protect their allies from harm. The skill requires the character to have high strength and endurance stats, as well as proficiency in using heavy armor and a variety of swords, shields, and other equipment. Knight Mastery is a versatile skill that can be used to charge into battle, withstand enemy attacks, and deal heavy damage to foes, making it a valuable skill for any character seeking to become a legendary warrior.");
    }
    
}
