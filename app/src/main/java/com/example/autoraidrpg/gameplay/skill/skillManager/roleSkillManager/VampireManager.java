package com.example.autoraidrpg.gameplay.skill.skillManager.roleSkillManager;

import com.example.autoraidrpg.gameplay.skill.SkillFactory;
import com.example.autoraidrpg.gameplay.skill.skillManager.SkillManager;
import com.example.autoraidrpg.gameplay.entity.Entity;

public class VampireManager extends SkillManager {

    public VampireManager(Entity entity) {
        super(entity);
        manageSkills();
    }

    @Override
    protected void manageSkills() {
        skills.add(SkillFactory.makeSkill(entity, "vampire-skill-1"));
        skills.add(SkillFactory.makeSkill(entity, "basic-attack"));
        skills.add(SkillFactory.makeSkill(entity, "vampire-skill-2"));
        skills.add(SkillFactory.makeSkill(entity, "vampire-skill-3"));
        skills.add(SkillFactory.makeSkill(entity, "vampire-skill-4"));
    }
    
}
