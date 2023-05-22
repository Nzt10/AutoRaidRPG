package com.example.autoraidrpg.gameplay.skill.activeSkills;

import com.example.autoraidrpg.R;
import com.example.autoraidrpg.gameplay.buff.BuffFactory;
import com.example.autoraidrpg.gameplay.formation.battleFormationTypes.AttackType;
import com.example.autoraidrpg.gameplay.skill.ActiveSkill;
import com.example.autoraidrpg.gameplay.skill.SkillType;
import com.example.autoraidrpg.gameplay.entity.Entity;

import java.util.ArrayList;

public class BombExplosion extends ActiveSkill {

    public BombExplosion(Entity entity) {
        super("bomb explosion", R.drawable.skill_bomb_explosion,
                SkillType.ALL, entity, AttackType.MAGICAL, new ArrayList<String>(), 2);
        
        // base
        this.pMagDmg += 80;

        // incremental
        this.apMagDmg += 10;

        // description
        this.description.add("deals " + (int) (pMagDmg + (level * apMagDmg)) + "% magical explosive damage to all hostile.");

        // long description
        this.description.add("plant and detonate a powerful bomb, dealing high area-of-effect damage to all enemies caught in the blast. This skill is especially effective against groups of enemies or enemies weak to explosive damage.");

        // add fire buffs
        buffs.add(BuffFactory.makeBuff("burn", 25 + (level * 3), entity, 3));
    }
    
}
