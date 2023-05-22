package com.example.autoraidrpg.gameplay.skill.passiveSkills;

import com.example.autoraidrpg.R;
import com.example.autoraidrpg.gameplay.skill.PassiveSkill;
import com.example.autoraidrpg.gameplay.skill.SkillType;

import java.util.ArrayList;

public class HunterMastery extends PassiveSkill {

    public HunterMastery() {
        super("hunter mastery", R.drawable.skill_hunter_mastery,
                SkillType.INITIAL_PASSIVE, new ArrayList<String>());

        // base
        this.lvlpPhyDmg += 1.5;

        // incremental
        this.aLvlpPhyDmg += 10;

        // description
        this.description.add("gain " + (int) (lvlpPhyDmg + (level * aLvlpPhyDmg)) + "% physical damage.");

        // long description
        this.description.add("enhance their abilities and damage against specific types of enemies. This skill may provide bonuses such as increased damage, critical hit chance, or accuracy against enemies such as beasts, undead, or dragons. It may also provide additional benefits such as increased loot drop rates or reduced incoming damage from those enemy types. The skill is a valuable addition to any character focused on hunting specific types of enemies.");
    }
    
}
