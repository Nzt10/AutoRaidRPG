package com.example.autoraidrpg.gameplay.skill.passiveSkills;

import com.example.autoraidrpg.R;
import com.example.autoraidrpg.gameplay.skill.PassiveSkill;
import com.example.autoraidrpg.gameplay.skill.SkillType;

import java.util.ArrayList;

public class ThiefMastery extends PassiveSkill {

    public ThiefMastery() {
        super("thief mastery", R.drawable.skill_thief_mastery,
                SkillType.INITIAL_PASSIVE, new ArrayList<String>());

        // base
        this.lvlpPhyDef += 4;

        // incremental
        this.aLvlpPhyDef += 4;

        // description
        this.description.add("gain " + (int) (lvlpPhyDef + (level * aLvlpPhyDef)) + "% physical defense.");

        // long description
        this.description.add("ability to steal, pickpocket, or disarm traps. This skill may provide bonuses such as increased success rate, reduced chance of being detected, or increased loot drop rates from successful thefts. It may also provide additional benefits such as faster lockpicking or increased damage when attacking from stealth. The skill is a valuable addition to any character focused on thievery or stealth-based gameplay.");
    }
    
}
