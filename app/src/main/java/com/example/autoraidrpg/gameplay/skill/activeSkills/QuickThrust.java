package com.example.autoraidrpg.gameplay.skill.activeSkills;

import com.example.autoraidrpg.R;
import com.example.autoraidrpg.gameplay.formation.battleFormationTypes.AttackType;
import com.example.autoraidrpg.gameplay.skill.ActiveSkill;
import com.example.autoraidrpg.gameplay.skill.SkillType;
import com.example.autoraidrpg.gameplay.entity.Entity;

import java.util.ArrayList;

public class QuickThrust extends ActiveSkill {

    public QuickThrust(Entity entity) {
        super("quick thrust", R.drawable.skill_quick_thrust,
                SkillType.SINGLE, entity, AttackType.PHYSICAL, new ArrayList<String>(), 6);

        // set extra moves = gain speed after an attack
        this.extra = e -> e.setSpd(e.getSpd() + (2.5 * level));
        
        // base
        this.pPhyDmg += 100;

        // incremental
        this.apPhyDmg += 30;

        // description
        this.description.add("deals " + (int) (pPhyDmg + (level * apPhyDmg)) + "% high & quick physical damage and gain speed.");

        // long description
        this.description.add("quickly lunge forward and strike their enemy. This skill is typically used to quickly close the distance between the player and their target, allowing them to strike from a closer range. Quick Thrust may also have a chance to deal additional critical damage or inflict a status ailment such as bleeding or paralysis. It is a useful skill for players who prefer to play as agile and quick-moving characters.");
    }
    
}
