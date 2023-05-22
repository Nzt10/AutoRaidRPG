package com.example.autoraidrpg.gameplay.skill.passiveSkills;

import com.example.autoraidrpg.R;
import com.example.autoraidrpg.gameplay.skill.PassiveSkill;
import com.example.autoraidrpg.gameplay.skill.SkillType;

import java.util.ArrayList;

public class BerserkerMastery extends PassiveSkill {

    public BerserkerMastery() {
        super("berserker mastery", R.drawable.skill_berserker_mastery,
                SkillType.PASSIVE, new ArrayList<String>());

        // trigger this skill if entity health is 50% or below
        this.conditioning = e -> e.getHp() / e.getBasedHp() * 100 <= 50;

        // base
        this.lvlpPhyDmg += 1;

        // incremental
        this.aLvlpPhyDmg += 1;

        // description
        this.description.add("gain " + (int) (lvlpPhyDmg + (level * aLvlpPhyDmg)) + "% physical damage every turn when health is 50% or below.");

        // long description
        this.description.add("enhances the player's damage output and attack speed while in a state of rage or fury. This skill may provide bonuses such as increased critical hit chance, reduced damage taken while attacking, or increased movement speed while attacking. It may also provide additional benefits such as increased resistance to debuffs or increased damage against specific enemy types. The skill is a valuable addition to any character focused on dealing high damage in close combat.");
    }
    
}
