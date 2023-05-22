package com.example.autoraidrpg.gameplay.skill.passiveSkills;

import com.example.autoraidrpg.R;
import com.example.autoraidrpg.gameplay.skill.PassiveSkill;
import com.example.autoraidrpg.gameplay.skill.SkillType;

import java.util.ArrayList;

public class PaladinMastery extends PassiveSkill {

    public PaladinMastery() {
        super("paladin mastery", R.drawable.skill_paladin_mastery,
                SkillType.INITIAL_PASSIVE, new ArrayList<String>());

        // base
        this.lvlpMagDmg += 12;
        this.lvlpPhyDef += 8;

        // incremental
        this.aLvlpMagDmg += 4.5;
        this.aLvlpPhyDef += 1.75;

        // description
        this.description.add("gain " + (int) (lvlpMagDmg + (level * aLvlpMagDmg)) + "% magical damage.");
        this.description.add("gain " + (int) (lvlpPhyDef + (level * aLvlpPhyDef)) + "% physical defense.");

        // long description
        this.description.add("enhances a player's abilities in combat. It provides a range of defensive and healing abilities to protect and support allies, while also dealing heavy damage to enemies. With this skill, players can use holy magic to smite evil and bring justice to the battlefield. It also grants increased durability and resilience, allowing paladins to withstand even the most ferocious of attacks.");
    }
    
}
