package com.example.autoraidrpg.gameplay.skill.passiveSkills;

import com.example.autoraidrpg.R;
import com.example.autoraidrpg.gameplay.skill.PassiveSkill;
import com.example.autoraidrpg.gameplay.skill.SkillType;

import java.util.ArrayList;

public class NecromancerMastery extends PassiveSkill {

    public NecromancerMastery() {
        super("necromancer mastery", R.drawable.skill_necromancer_mastery,
                SkillType.INITIAL_PASSIVE, new ArrayList<String>());

        // base
        this.lvlpMagDmg += 8;

        // incremental
        this.aLvlpMagDmg += 4;

        // description
        this.description.add("gain " + (int) (lvlpMagDmg + (level * aLvlpMagDmg)) + "% magical damage.");

        // long description
        this.description.add("control the power of death and raise undead minions to fight for them. This skill may provide bonuses such as increased damage or health regeneration for the player's minions. The player may have the ability to summon different types of undead creatures with varying strengths and abilities, making it a versatile and powerful skill to master.");
    }
    
}
