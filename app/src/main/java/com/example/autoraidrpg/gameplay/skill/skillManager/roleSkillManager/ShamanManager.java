package com.example.autoraidrpg.gameplay.skill.skillManager.roleSkillManager;

import com.example.autoraidrpg.gameplay.skill.SkillFactory;
import com.example.autoraidrpg.gameplay.skill.skillManager.SkillManager;
import com.example.autoraidrpg.gameplay.entity.Entity;

public class ShamanManager extends SkillManager {

    public ShamanManager(Entity entity) {
        super(entity);
        manageSkills();
    }

    @Override
    protected void manageSkills() {
        skills.add(SkillFactory.makeSkill(entity, "shaman-skill-1"));
        skills.add(SkillFactory.makeSkill(entity, "basic-attack"));
        skills.add(SkillFactory.makeSkill(entity, "shaman-skill-2"));
        skills.add(SkillFactory.makeSkill(entity, "shaman-skill-3"));
        skills.add(SkillFactory.makeSkill(entity, "shaman-skill-4"));
    }
    
}
