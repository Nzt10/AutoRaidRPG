package com.example.autoraidrpg.gameplay.skill.passiveSkills;

import com.example.autoraidrpg.R;
import com.example.autoraidrpg.gameplay.skill.PassiveSkill;
import com.example.autoraidrpg.gameplay.skill.SkillType;

import java.util.ArrayList;

public class FierceWarrior extends PassiveSkill {

    public FierceWarrior() {
        super("fierce warrior", R.drawable.skill_fierce_warrior,
                SkillType.INITIAL_PASSIVE, new ArrayList<String>());

        // base
        this.lvlpHp += 5;
        this.lvlpPhyDmg += 5;

        // incremental
        this.aLvlpHp += 12;
        this.aLvlpPhyDmg += 5;

        // description
        this.description.add("gain " + (int) (lvlpHp + (level * aLvlpHp)) + "% health.");
        this.description.add("gain " + (int) (lvlpPhyDmg + (level * aLvlpPhyDmg)) + "% physical damage.");

        // long description
        this.description.add("enhances the player's physical attacks and defensive abilities. This skill may provide bonuses such as increased attack power, increased critical hit chance, increased armor, or increased resistance to debuffs. It may also provide additional benefits such as increased movement speed or increased damage against specific enemy types. The skill is a valuable addition to any character focused on dealing high physical damage and surviving in combat.");
    }
    
}
