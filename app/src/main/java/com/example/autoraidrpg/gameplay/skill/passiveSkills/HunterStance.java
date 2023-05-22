package com.example.autoraidrpg.gameplay.skill.passiveSkills;

import com.example.autoraidrpg.R;
import com.example.autoraidrpg.gameplay.skill.PassiveSkill;
import com.example.autoraidrpg.gameplay.skill.SkillType;

import java.util.ArrayList;

public class HunterStance extends PassiveSkill {

    public HunterStance() {
        super("hunter stance", R.drawable.skill_hunter_stance,
                SkillType.INITIAL_PASSIVE, new ArrayList<String>());

        // base
        this.lvlpPhyDmg += 15;
        this.lvlPhyDef -= 7.7;

        // incremental
        this.aLvlpPhyDmg += 15;
        this.aLvlpPhyDef -= 7.7;

        // description
        this.description.add("gain " + (int) (lvlpPhyDmg + (level * aLvlpPhyDmg)) + "% physical damage.");
        this.description.add("decrease " + (int) (lvlPhyDef + (level * aLvlpPhyDef)) + "% physical defense.");

        // long description
        this.description.add("enhances the player's damage, accuracy, or critical hit chance against enemies while in a specific stance or position. This skill may provide bonuses when using ranged attacks, attacking from stealth, or attacking from behind. The skill is a valuable addition to any character focused on hunting specific types of enemies or utilizing certain combat tactics.");
    }
    
}
