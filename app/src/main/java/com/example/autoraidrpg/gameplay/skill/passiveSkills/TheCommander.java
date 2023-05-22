package com.example.autoraidrpg.gameplay.skill.passiveSkills;

import com.example.autoraidrpg.R;
import com.example.autoraidrpg.gameplay.skill.PassiveSkill;
import com.example.autoraidrpg.gameplay.skill.SkillType;

import java.util.ArrayList;

public class TheCommander extends PassiveSkill {

    public TheCommander() {
        super("the commander", R.drawable.skill_the_commander,
                SkillType.INITIAL_PASSIVE, new ArrayList<String>());

        // base
        this.lvlpHp += 20;
        this.lvlpPhyDmg += 20;

        // incremental
        this.aLvlpHp += 3.5;
        this.aLvlpPhyDmg += 3.5;

        // description
        this.description.add("gain " + (int) (lvlpHp + (level * aLvlpHp)) + "% health.");
        this.description.add("gain " + (int) (lvlpPhyDmg + (level * aLvlpPhyDmg)) + "% physical damage.");

        // long description
        this.description.add("inspire and empower their allies. This skill may provide temporary bonuses to the player's allies, such as increased damage, healing, or movement speed. It may also have additional effects such as reducing incoming damage or restoring mana or stamina.");
    }
    
}
