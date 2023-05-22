package com.example.autoraidrpg.gameplay.skill.passiveSkills;

import com.example.autoraidrpg.R;
import com.example.autoraidrpg.gameplay.skill.PassiveSkill;
import com.example.autoraidrpg.gameplay.skill.SkillType;

import java.util.ArrayList;

public class BlacksmithMastery extends PassiveSkill {

    public BlacksmithMastery() {
        super("blacksmith mastery", R.drawable.skill_blacksmith_mastery,
                SkillType.INITIAL_PASSIVE, new ArrayList<String>());

        // base
        this.lvlpPhyDef += 2.5;
        this.lvlpMagDef += 4.5;

        // incremental
        this.aLvlpPhyDef += 2.5;
        this.aLvlpMagDef += 6.75;

        // description
        this.description.add("gain " + (int) (lvlpPhyDef + (level * aLvlpPhyDef)) + "% physical defense.");
        this.description.add("gain " + (int) (lvlpMagDef + (level * aLvlpMagDef)) + "% magical defense.");

        // long description
        this.description.add("ability to craft and improve weapons and armor. This skill may provide bonuses such as increased success rate for crafting and upgrades, reduced material costs, or increased durability for crafted items. It may also provide additional benefits such as access to unique crafting recipes or the ability to imbue items with magical properties. The skill is a valuable addition to any character focused on crafting and improving their equipment.");
    }
    
}
