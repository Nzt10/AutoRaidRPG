package com.example.autoraidrpg.gameplay.skill.supportSkills;

import com.example.autoraidrpg.R;
import com.example.autoraidrpg.gameplay.skill.SkillType;
import com.example.autoraidrpg.gameplay.skill.SupportSkill;
import com.example.autoraidrpg.gameplay.entity.Entity;

import java.util.ArrayList;

public class StealArmor extends SupportSkill {

    private double phyDef;

    public StealArmor(Entity owner) {
        super("steal armor", R.drawable.skill_steal_armor,
                SkillType.ALL, owner, new ArrayList<String>(), 4);
        
        this.phyDef = 1;

        // description
        this.description.add("steal " + (int) (phyDef * level) + " physical defense to all hostile.");

        // long description
        this.description.add("remove a piece of armor from an enemy and equip it themselves, providing a temporary boost to their own defense. This skill is especially effective against heavily armored enemies or bosses, and may have additional effects such as reducing the target's defense or causing them to stagger.");
    }

    @Override
    public void activate(Entity targetedEntity) {
        double acquiredArmor = phyDef * level;
        double targetPhyDef = targetedEntity.getPhyDef() - acquiredArmor;
        double ownerPhyDef = this.owner.getPhyDef() + acquiredArmor;

        targetedEntity.setPhyDef(targetPhyDef);
        this.owner.setPhyDef(ownerPhyDef);

        // update observer
        battleSubject.getCurrentObserver()
            .addDescription(String.format("%s steal %d physical defense to %s.", owner.getName(), (int) acquiredArmor, targetedEntity.getName()), owner.getRoleImage(), targetedEntity.getRoleImage());
        turn = cooldown;
    }
    
}
