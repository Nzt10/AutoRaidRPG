package com.example.autoraidrpg.gameplay.skill.activeSkills;

import com.example.autoraidrpg.R;
import com.example.autoraidrpg.gameplay.buff.BuffFactory;
import com.example.autoraidrpg.gameplay.entity.Entity;
import com.example.autoraidrpg.gameplay.formation.battleFormationTypes.AttackType;
import com.example.autoraidrpg.gameplay.skill.ActiveSkill;
import com.example.autoraidrpg.gameplay.skill.SkillType;

import java.util.ArrayList;

public class Fear extends ActiveSkill {

    public Fear(Entity entity) {
        super("fear", R.drawable.skill_fear,
                SkillType.SINGLE, entity, AttackType.MAGICAL, new ArrayList<String>(), 12);
        
        // base
        this.pMagDmg += 180;

        // incremental
        this.apMagDmg += 22;

        // description
        this.description.add("deals " + (int) (pMagDmg + (level * apMagDmg)) + "% magical damage.");

        // long description
        this.description.add("run away in terror for a certain duration, preventing them from attacking or moving towards the player. This skill may provide additional bonuses such as increased damage or increased duration. It may have a longer cooldown time than other debuff attacks, but its ability to control enemies makes it a valuable addition to any character's arsenal.");

        // add nightmare buffs
        buffs.add(BuffFactory.makeBuff("nightmare", 50 + (level * 3.5), entity, 3));

        // add bind buffs
        buffs.add(BuffFactory.makeBuff("bind", 0, entity, 2));
    }
    
}
