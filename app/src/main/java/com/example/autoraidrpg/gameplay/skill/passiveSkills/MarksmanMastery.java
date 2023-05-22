package com.example.autoraidrpg.gameplay.skill.passiveSkills;

import com.example.autoraidrpg.R;
import com.example.autoraidrpg.gameplay.skill.PassiveSkill;
import com.example.autoraidrpg.gameplay.skill.SkillType;

import java.util.ArrayList;

public class MarksmanMastery extends PassiveSkill {

    public MarksmanMastery() {
        super("marksman mastery", R.drawable.skill_marksman_mastery,
                SkillType.INITIAL_PASSIVE, new ArrayList<String>());

        // base
        this.lvlpPhyDmg += 8;
        this.lvlpArmPen += 10;

        // incremental
        this.aLvlpPhyDmg += 4.5;

        // description
        this.description.add("gain " + (int) (lvlpPhyDmg + (level * aLvlpPhyDmg)) + "% physical damage.");
        this.description.add("gain " + (int) lvlpArmPen + "% armor penetration.");

        // long description
        this.description.add("master of ranged weapons, such as bows, crossbows, and firearms. The skill allows the character to shoot accurately at long range, deal heavy damage to enemies, and set traps and other ambushes. The skill requires the character to have high dexterity and perception stats, as well as proficiency in using a variety of ranged weapons, traps, and other equipment. Marksman Mastery is a versatile skill that can be used to pick off enemies from afar, disable traps and other hazards, and set up deadly ambushes, making it a valuable skill for any character seeking to become a master of ranged combat.");
    }
    
}
