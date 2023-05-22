package com.example.autoraidrpg.gameplay.skill.skillManager.roleSkillManager;

import com.example.autoraidrpg.gameplay.skill.SkillFactory;
import com.example.autoraidrpg.gameplay.skill.skillManager.SkillManager;
import com.example.autoraidrpg.gameplay.entity.Entity;

public class MageManager extends SkillManager {

    public MageManager(Entity entity) {
        super(entity);
        manageSkills();
    }

    @Override
    protected void manageSkills() {
        skills.add(SkillFactory.makeSkill(entity, "mage-skill-1"));
        skills.add(SkillFactory.makeSkill(entity, "basic-attack"));
        skills.add(SkillFactory.makeSkill(entity, "mage-skill-2"));
        skills.add(SkillFactory.makeSkill(entity, "mage-skill-3"));
        skills.add(SkillFactory.makeSkill(entity, "mage-skill-4"));
    }
    
}
