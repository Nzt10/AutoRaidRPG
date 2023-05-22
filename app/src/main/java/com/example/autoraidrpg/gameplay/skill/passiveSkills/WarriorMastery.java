package com.example.autoraidrpg.gameplay.skill.passiveSkills;

import com.example.autoraidrpg.R;
import com.example.autoraidrpg.gameplay.skill.PassiveSkill;
import com.example.autoraidrpg.gameplay.skill.SkillType;

import java.util.ArrayList;
public class WarriorMastery extends PassiveSkill {

    public WarriorMastery() {
        super("warrior mastery", R.drawable.skill_warrior_mastery,
                SkillType.INITIAL_PASSIVE, new ArrayList<String>());

        // base
        this.lvlpHp += 12;
        this.lvlpPhyDmg += 8;
        this.lvlpCritDmg += 30;

        // incremental
        this.aLvlpHp += 3;
        this.aLvlpPhyDmg += 2;

        // description
        this.description.add("gain " + (int) (lvlpHp + (level * aLvlpHp)) + "% health.");
        this.description.add("gain " + (int) (lvlpPhyDmg + (level * aLvlpPhyDmg)) + "% physical damage.");
        this.description.add("gain " + (int) lvlpCritDmg + "% critical damage.");

        // long description
        this.description.add("advanced combat skill that enables a character to become a master of close combat, such as with swords, axes, and maces. The skill allows the character to deal heavy damage to enemies, withstand even the most brutal attacks, and lead their allies in battle. The skill requires the character to have high strength and endurance stats, as well as proficiency in using a variety of melee weapons, shields, and other equipment. Warrior Mastery is a versatile skill that can be used to charge into battle, withstand enemy attacks, and protect allies from harm, making it a valuable skill for any character seeking to become a master of close combat.");
    }
    
}
