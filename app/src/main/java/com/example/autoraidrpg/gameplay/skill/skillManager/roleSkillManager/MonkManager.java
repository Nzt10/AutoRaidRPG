package com.example.autoraidrpg.gameplay.skill.skillManager.roleSkillManager;

import com.example.autoraidrpg.gameplay.skill.SkillFactory;
import com.example.autoraidrpg.gameplay.skill.skillManager.SkillManager;
import com.example.autoraidrpg.gameplay.entity.Entity;

public class MonkManager extends SkillManager {

    public MonkManager(Entity entity) {
        super(entity);
        manageSkills();
    }

    @Override
    protected void manageSkills() {
        skills.add(SkillFactory.makeSkill(entity, "monk-skill-1"));
        skills.add(SkillFactory.makeSkill(entity, "basic-attack"));
        skills.add(SkillFactory.makeSkill(entity, "monk-skill-2"));
        skills.add(SkillFactory.makeSkill(entity, "monk-skill-3"));
        skills.add(SkillFactory.makeSkill(entity, "monk-skill-4"));
    }
    
}
