package com.example.autoraidrpg.gameplay.skill.activeSkills;

import com.example.autoraidrpg.R;
import com.example.autoraidrpg.gameplay.buff.BuffFactory;
import com.example.autoraidrpg.gameplay.skill.ActiveSkill;
import com.example.autoraidrpg.gameplay.skill.SkillType;
import com.example.autoraidrpg.gameplay.entity.Entity;
import com.example.autoraidrpg.gameplay.formation.battleFormationTypes.AttackType;

import java.util.ArrayList;

public class DeadRoot extends ActiveSkill {

    public DeadRoot(Entity entity) {
        super("dark root", R.drawable.skill_dead_root,
                SkillType.SINGLE, entity, AttackType.MAGICAL, new ArrayList<String>(), 4);
        
        // base
        this.pMagDmg += 143;

        // incremental
        this.apMagDmg += 34;

        // description
        this.description.add("deals " + (int) (pMagDmg + (level * apMagDmg)) + "% magical damage.");

        // long description
        this.description.add("summon a group of undead roots from the ground to ensnare and damage enemies. This skill may provide additional bonuses such as increased damage or increased duration of the root's effect. The roots may also prevent enemies from moving or attacking, allowing the player to control the battlefield and pick off enemies one by one.");

        // add bind buffs
        buffs.add(BuffFactory.makeBuff("bind", 0, entity, 1));
    }
    
}
