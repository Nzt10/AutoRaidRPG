package com.example.autoraidrpg.gameplay.skill.activeSkills;

import com.example.autoraidrpg.R;
import com.example.autoraidrpg.gameplay.formation.battleFormationTypes.AttackType;
import com.example.autoraidrpg.gameplay.skill.ActiveSkill;
import com.example.autoraidrpg.gameplay.skill.SkillType;
import com.example.autoraidrpg.gameplay.entity.Entity;

import java.util.ArrayList;

public class MagicMissile extends ActiveSkill {

    public MagicMissile(Entity entity) {
        super("magic missile", R.drawable.skill_magic_missile,
                SkillType.SINGLE, entity, AttackType.MAGICAL, new ArrayList<String>(), 6);
        
        // base
        this.pMagDmg += 250;

        // incremental
        this.apMagDmg += 50;

        // description
        this.description.add("deals " + (int) (pMagDmg + (level * apMagDmg)) + "% magical damage.");

        // long description
        this.description.add("a spell that creates three or more glowing, dart-like projectiles that unerringly strike their targets, dealing force damage. The caster does not have to roll an attack roll to hit the target, making it highly accurate. This makes Magic Missile an ideal spell for dealing damage to a single target or for overcoming an enemy's damage resistance. The spell's damage output increases as the caster's level goes up, and it is a common spell in the arsenal of many spellcasters due to its versatility and reliability.");
    }
    
}
