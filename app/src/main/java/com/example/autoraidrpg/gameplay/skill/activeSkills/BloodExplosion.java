package com.example.autoraidrpg.gameplay.skill.activeSkills;

import com.example.autoraidrpg.R;
import com.example.autoraidrpg.gameplay.buff.BuffFactory;
import com.example.autoraidrpg.gameplay.formation.battleFormationTypes.AttackType;
import com.example.autoraidrpg.gameplay.skill.ActiveSkill;
import com.example.autoraidrpg.gameplay.skill.SkillType;
import com.example.autoraidrpg.gameplay.entity.Entity;

import java.util.ArrayList;

public class BloodExplosion extends ActiveSkill {

    public BloodExplosion(Entity entity) {
        super("blood explosion", R.drawable.skill_blood_explosion,
                SkillType.ALL, entity, AttackType.PHYSICAL, new ArrayList<String>(), 12);
        
        // base
        this.pMagDmg += 94;

        // incremental
        this.apMagDmg += 17;

        // description
        this.description.add("deals " + (int) (pMagDmg + (level * apMagDmg)) + "% magical damage to all hostile.");

        // long description
        this.description.add("unleashes a devastating blast of blood magic, damaging all enemies in a wide radius. As the name suggests, the attack causes blood to explode from the target, inflicting significant damage and leaving them weakened. Additionally, the user can absorb some of the life essence of their foes to restore their own health, making this skill an effective way to turn the tide of a difficult battle.");    
        
        // add bleed buffs
        buffs.add(BuffFactory.makeBuff("bleed", 55 + (level * 25), entity, 6));
    }
    
}
