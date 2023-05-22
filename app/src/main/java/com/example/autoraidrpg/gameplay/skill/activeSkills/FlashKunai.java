package com.example.autoraidrpg.gameplay.skill.activeSkills;

import com.example.autoraidrpg.R;
import com.example.autoraidrpg.gameplay.skill.ActiveSkill;
import com.example.autoraidrpg.gameplay.skill.SkillType;
import com.example.autoraidrpg.gameplay.entity.Entity;
import com.example.autoraidrpg.gameplay.formation.battleFormationTypes.AttackType;

import java.util.ArrayList;

public class FlashKunai extends ActiveSkill {

    public FlashKunai(Entity entity) {
        super("flash kunai", R.drawable.skill_flash_kunai,
                SkillType.SINGLE, entity, AttackType.PHYSICAL, new ArrayList<String>(), 1);
        
        // base
        this.pPhyDmg += 100;

        // incremental
        this.apPhyDmg += 18;

        // description
        this.description.add("deals " + (int) (pPhyDmg + (level * apPhyDmg)) + "% quick physical damage.");

        // long description
        this.description.add("crafted kunai that emits a bright flash upon impact, blinding and disorienting enemies caught in the area of effect. This skill is especially effective against enemies that rely on sight, such as ranged attackers or ambush predators. It may also have the added effect of dealing damage or reducing the targets' accuracy. The skill may have a longer cooldown time than other attacks, but its crowd control capabilities make it a valuable addition to any ranged-focused character's arsenal.");
    }
    
    
}
