package com.example.autoraidrpg.gameplay.skill.passiveSkills;

import com.example.autoraidrpg.R;
import com.example.autoraidrpg.gameplay.skill.PassiveSkill;
import com.example.autoraidrpg.gameplay.skill.SkillType;

import java.util.ArrayList;

public class AssassinMastery extends PassiveSkill {

    public AssassinMastery() {
        super("assassin mastery", R.drawable.skill_assassin_mastery,
                SkillType.INITIAL_PASSIVE, new ArrayList<String>());

        // base
        this.lvlpDodge += 3;
        this.lvlpSpd += 1;

        // incremental
        this.aLvlpDodge += 0.1;
        this.aLvlpSpd += 1.25;

        // description
        this.description.add("gain " + (int) (lvlpDodge + (level * aLvlpDodge)) + "% dodge.");
        this.description.add("gain " + (int) (lvlpSpd + (level * aLvlpSpd)) + "% speed.");

        // long description
        this.description.add("an advanced combat skill that enables a character to become a master of stealth, deception, and assassination. The skill allows the character to move quickly and quietly, strike from the shadows, and deliver devastating critical hits to their targets. The skill requires the character to have high dexterity and intelligence stats, as well as proficiency in using a variety of weapons and tools, such as poisons, traps, and disguises. Assassin Mastery is a versatile skill that can be used for infiltration, assassination, and evasion, making it a valuable tool for any character seeking to gain an edge in combat.");
    }
    
}
