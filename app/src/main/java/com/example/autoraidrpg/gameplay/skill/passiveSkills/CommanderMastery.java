package com.example.autoraidrpg.gameplay.skill.passiveSkills;

import com.example.autoraidrpg.R;
import com.example.autoraidrpg.gameplay.skill.PassiveSkill;
import com.example.autoraidrpg.gameplay.skill.SkillType;

import java.util.ArrayList;

public class CommanderMastery extends PassiveSkill {

    public CommanderMastery() {
        super("commander mastery", R.drawable.skill_commander_mastery,
                SkillType.INITIAL_PASSIVE, new ArrayList<String>());

        // base
        this.lvlpDodge += 5;

        // incremental
        this.aLvlpDodge += 0.075;

        // description
        this.description.add("gain " + (int) (lvlpDodge + (level * aLvlpDodge)) + "% dodge.");

        // long description
        this.description.add("master of tactics, strategy, and leadership. The skill allows the character to inspire their allies, rally them to action, and coordinate their attacks to devastating effect. The skill requires the character to have high charisma and intelligence stats, as well as proficiency in using a variety of weapons and equipment, such as banners, horns, and traps. Commander Mastery is a versatile skill that can be used to turn the tide of battle, overcome superior forces, and defeat even the most daunting foes.");
    }
    
}
