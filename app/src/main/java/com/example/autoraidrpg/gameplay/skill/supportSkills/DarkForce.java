package com.example.autoraidrpg.gameplay.skill.supportSkills;

import com.example.autoraidrpg.R;
import com.example.autoraidrpg.gameplay.skill.SkillType;
import com.example.autoraidrpg.gameplay.skill.SupportSkill;
import com.example.autoraidrpg.gameplay.entity.Entity;

import java.util.ArrayList;

public class DarkForce extends SupportSkill {

    private double magDef;

    public DarkForce(Entity owner) {
        super("dark force", R.drawable.skill_dark_force,
                SkillType.SUPPORT_ALLY_ALL, owner, new ArrayList<String>(), 8);
        
        this.magDef = 10;

        // description
        this.description.add("enhance " + (int) (magDef * level) + " magical defense of your team.");

        // long description
        this.description.add("imbue their weapon with dark energy, increasing its damage and possibly adding additional effects such as lifesteal or increased critical hit chance.");
    }

    @Override
    public void activate(Entity targetedEntity) {
        double acquiredMagDef = magDef * level;
        double targetMagDef = targetedEntity.getMagDef() + acquiredMagDef;

        targetedEntity.setMagDef(targetMagDef);

        // update observer
        battleSubject.getCurrentObserver()
            .addDescription(String.format("%s enhanced %s magic defense by %d.", owner.getName(), targetedEntity.getName(), (int) acquiredMagDef), owner.getRoleImage(), targetedEntity.getRoleImage());
        turn = cooldown;
    }
    
}
