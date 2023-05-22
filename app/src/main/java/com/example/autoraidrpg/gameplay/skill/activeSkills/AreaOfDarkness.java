package com.example.autoraidrpg.gameplay.skill.activeSkills;

import com.example.autoraidrpg.R;
import com.example.autoraidrpg.gameplay.buff.BuffFactory;
import com.example.autoraidrpg.gameplay.formation.battleFormationTypes.AttackType;
import com.example.autoraidrpg.gameplay.skill.ActiveSkill;
import com.example.autoraidrpg.gameplay.skill.SkillType;
import com.example.autoraidrpg.gameplay.entity.Entity;

import java.util.ArrayList;

public class AreaOfDarkness extends ActiveSkill {

    public AreaOfDarkness(Entity entity) {
        super("area of darkness", R.drawable.skill_area_of_darkness,
                SkillType.ALL, entity, AttackType.MAGICAL, new ArrayList<String>(), 12);
        
        // base
        this.pMagDmg += 40;

        // incremental
        this.apMagDmg += 40;

        // description
        this.description.add("deals " + (int) (pMagDmg + (level * apMagDmg)) + "% magical damage.");

        // long description
        this.description.add("summon a wave of dark energy that damages and weakens all enemies within a certain radius. This skill may provide additional bonuses such as decreased enemy defenses or increased damage over time.Area of Darkness is a shadow magic skill in RPG games that allows the player to create a large area of darkness, reducing visibility and causing fear in enemies. This skill may provide additional bonuses such as increased damage or increased duration of the darkness. Enemies within the area may have their accuracy and movement speed reduced, making it difficult for them to attack or escape. The skill is useful for crowd control and setting up ambushes.");

        // add nightmare buffs
        buffs.add(BuffFactory.makeBuff("nightmare", 5 + (level * 20), entity, 5));
    }
    
}
