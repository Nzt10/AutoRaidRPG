package com.example.autoraidrpg.gameplay.skill.activeSkills;

import com.example.autoraidrpg.R;
import com.example.autoraidrpg.gameplay.formation.battleFormationTypes.AttackType;
import com.example.autoraidrpg.gameplay.skill.ActiveSkill;
import com.example.autoraidrpg.gameplay.skill.SkillType;
import com.example.autoraidrpg.gameplay.entity.Entity;

import java.util.ArrayList;

public class PalmDiagram extends ActiveSkill {

    public PalmDiagram(Entity entity) {
        super("palm diagram", R.drawable.skill_palm_strike,
                SkillType.SINGLE, entity, AttackType.PHYSICAL, new ArrayList<String>(), 2);
        
        // base
        this.pMagDmg += 125;

        // incremental
        this.apMagDmg += 16;

        // description
        this.description.add("deals " + (int) (pMagDmg + (level * apMagDmg)) + "% magical damage.");

        // long description
        this.description.add("deliver a powerful punch to the target. It is a fast and precise attack that deals moderate damage and has a chance to stun the opponent. This skill is ideal for quick encounters where the user needs to deliver a finishing blow or gain the upper hand in a fight. It is commonly used by martial artists or brawlers who rely on their fists in combat.");
    }
    
}
