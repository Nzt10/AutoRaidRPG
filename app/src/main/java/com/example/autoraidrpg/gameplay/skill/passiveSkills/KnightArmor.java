package com.example.autoraidrpg.gameplay.skill.passiveSkills;

import com.example.autoraidrpg.R;
import com.example.autoraidrpg.gameplay.skill.PassiveSkill;
import com.example.autoraidrpg.gameplay.skill.SkillType;

import java.util.ArrayList;

public class KnightArmor extends PassiveSkill {

    public KnightArmor() {
        super("knight armor", R.drawable.skill_knight_armor,
                SkillType.INITIAL_PASSIVE, new ArrayList<String>());

        // base
        this.lvlpPhyDef += 5.5;
        this.lvlpMagDef += 6.5;

        // incremental
        this.aLvlpPhyDef += 1.75;
        this.aLvlpMagDef += 2.25;

        // description
        this.description.add("gain " + (int) (lvlpPhyDef + (level * aLvlpPhyDef)) + "% physical defense.");
        this.description.add("gain " + (int) (lvlpMagDef + (level * aLvlpMagDef)) + "% magical defense.");

        // long description
        this.description.add("increase their armor or damage resistance for a limited period of time. This skill can be used to mitigate incoming damage, especially against enemies that deal physical damage. It may also have additional effects such as reducing incoming status effects or granting temporary immunity to certain types of attacks.");
    }
    
}
