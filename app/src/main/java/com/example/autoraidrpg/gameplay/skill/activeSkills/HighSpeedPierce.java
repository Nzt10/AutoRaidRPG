package com.example.autoraidrpg.gameplay.skill.activeSkills;

import com.example.autoraidrpg.R;
import com.example.autoraidrpg.gameplay.formation.battleFormationTypes.AttackType;
import com.example.autoraidrpg.gameplay.skill.ActiveSkill;
import com.example.autoraidrpg.gameplay.skill.SkillType;
import com.example.autoraidrpg.gameplay.entity.Entity;

import java.util.ArrayList;

public class HighSpeedPierce extends ActiveSkill {

    public HighSpeedPierce(Entity entity) {
        super("high speed pierce", R.drawable.skill_high_speed_pierce,
                SkillType.SINGLE, entity, AttackType.PHYSICAL, new ArrayList<String>(), 5);

        // set extra moves = gain speed after an attack
        this.extra = e -> e.setSpd(e.getSpd() + (2 * level));
        
        // base
        this.pPhyDmg += 90;

        // incremental
        this.apPhyDmg += 21;

        // description
        this.description.add("deals " + (int) (pPhyDmg + (level * apPhyDmg)) + "% high & quick physical damage and gain speed.");

        // long description
        this.description.add("quickly thrust their spear forward with great force. This skill can deal significant damage to enemies and may even have a chance to pierce through multiple targets in a line. It is a useful skill for players who prefer to keep their distance from enemies and strike from afar, as it allows them to quickly deal damage without putting themselves in harm's way.");
    }
    
}
