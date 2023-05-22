package com.example.autoraidrpg.gameplay.skill.passiveSkills;

import com.example.autoraidrpg.R;
import com.example.autoraidrpg.gameplay.skill.PassiveSkill;
import com.example.autoraidrpg.gameplay.skill.SkillType;

import java.util.ArrayList;

public class VampiricTouch extends PassiveSkill {

    public VampiricTouch() {
        super("vampiric touch", R.drawable.skill_vampiric_mastery,
                SkillType.PASSIVE, new ArrayList<String>());

        // trigger this skill to heal if health is 50% and below
        this.conditioning = e -> e.getHp() / e.getBasedHp() * 100 <= 50;

        // base
        this.lvlpHp += 1.75;

        // incremental
        this.aLvlpHp += 2.1;

        // description
        this.description.add("heal " + (int) (lvlpHp + (level * aLvlpHp)) + "% of the current health every turn when health is 50% or below.");

        // long description
        this.description.add("allows the user to drain the life force from their enemies, restoring their own health in the process. With a successful hit, the user can gain a portion of the damage dealt as health points. This skill is particularly useful in battles where the user is outnumbered or facing formidable opponents, allowing them to sustain themselves and continue fighting for longer periods of time.");
    }
    
}
