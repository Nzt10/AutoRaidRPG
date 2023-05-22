package com.example.autoraidrpg.gameplay.skill.supportSkills;

import com.example.autoraidrpg.R;
import com.example.autoraidrpg.gameplay.skill.SupportSkill;
import com.example.autoraidrpg.gameplay.entity.Entity;
import com.example.autoraidrpg.gameplay.skill.SkillType;

import java.util.ArrayList;

public class LightArmorEnhancement extends SupportSkill {

    private double phyDef;

    public LightArmorEnhancement(Entity owner) {
        super("light armor enhancement", R.drawable.skill_light_armor_enhancement,
                SkillType.SUPPORT_ALLY_SINGLE, owner, new ArrayList<String>(), 4);
        
        this.phyDef = 10;

        // description
        this.description.add("gain " + (int) (phyDef * level) + " physical defense to itself.");

        // long description
        this.description.add("increases the defensive capabilities of light armor. It grants additional protection against physical and magical attacks, while also increasing the wearer's movement speed and agility. This skill is essential for Paladins who prefer to wear lighter armor but still want to maintain a high level of protection in combat. With Light Armor Enhancement, Paladins can become highly versatile and effective fighters on the battlefield.");
    }

    @Override
    public void activate(Entity targetedEntity) {
        double acquiredArmor = phyDef * level;
        double ownerPhyDef = this.owner.getPhyDef() + acquiredArmor;
        this.owner.setPhyDef(ownerPhyDef);

        // update observer
        battleSubject.getCurrentObserver()
            .addDescription(String.format("%s gained %d physical defense.", owner.getName(), (int) acquiredArmor), owner.getRoleImage(), owner.getRoleImage());
        turn = cooldown;
    }
    
}
