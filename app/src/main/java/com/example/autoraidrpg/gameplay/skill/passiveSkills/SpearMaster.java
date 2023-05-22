package com.example.autoraidrpg.gameplay.skill.passiveSkills;

import com.example.autoraidrpg.R;
import com.example.autoraidrpg.gameplay.skill.PassiveSkill;
import com.example.autoraidrpg.gameplay.skill.SkillType;

import java.util.ArrayList;

public class SpearMaster extends PassiveSkill {

    public SpearMaster() {
        super("spear master", R.drawable.skill_spear_master,
                SkillType.INITIAL_PASSIVE, new ArrayList<String>());

        // base
        this.lvlpPhyDmg += 3;
        this.lvlpSpd += 0.5;

        // incremental
        this.aLvlpPhyDmg += 3;
        this.aLvlpSpd += 1;

        // description
        this.description.add("gain " + (int) (lvlpPhyDmg + (level * aLvlpPhyDmg)) + "% physical damage.");
        this.description.add("gain " + (int) (lvlpSpd + (level * aLvlpSpd)) + "% speed.");

        // long description
        this.description.add(" specialize in using spears as their weapon of choice. This skill may provide additional bonuses such as increased damage, increased range, or increased critical hit chance with spears. The player may also gain access to exclusive spear techniques, such as thrusting or sweeping attacks. The skill is useful for players who prefer a more defensive playstyle, as the longer reach of spears allows for safer attacks from a distance.");
    }
    
}
