package com.example.autoraidrpg.gameplay.skill.activeSkills;

import com.example.autoraidrpg.R;
import com.example.autoraidrpg.gameplay.formation.battleFormationTypes.AttackType;
import com.example.autoraidrpg.gameplay.skill.ActiveSkill;
import com.example.autoraidrpg.gameplay.skill.SkillType;
import com.example.autoraidrpg.gameplay.entity.Entity;

import java.util.ArrayList;

public class ChainLightning extends ActiveSkill {

    public ChainLightning(Entity entity) {
        super("chain lightning", R.drawable.skill_chain_lightning,
                SkillType.ALL, entity, AttackType.MAGICAL, new ArrayList<String>(), 8);
        
        // base
        this.pMagDmg += 130;

        // incremental
        this.apMagDmg += 28;

        // description
        this.description.add("deals " + (int) (pMagDmg + (level * apMagDmg)) + "% magical damage to all hostile.");

        // long description
        this.description.add("unleash a powerful bolt of electricity that jumps between multiple enemies. This skill deals moderate damage but can quickly add up against groups of enemies. It also has the potential to stun or paralyze the targets, making them easier to take down. The skill may have a longer cooldown time than other spells, but its crowd control capabilities make it a valuable addition to any magic user's arsenal.");
    }
    
}
