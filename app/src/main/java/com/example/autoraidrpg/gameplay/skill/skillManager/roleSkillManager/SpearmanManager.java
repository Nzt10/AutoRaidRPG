package com.example.autoraidrpg.gameplay.skill.skillManager.roleSkillManager;

import com.example.autoraidrpg.gameplay.skill.SkillFactory;
import com.example.autoraidrpg.gameplay.skill.skillManager.SkillManager;
import com.example.autoraidrpg.gameplay.entity.Entity;

public class SpearmanManager extends SkillManager {

    public SpearmanManager(Entity entity) {
        super(entity);
        manageSkills();
    }

    @Override
    protected void manageSkills() {
        skills.add(SkillFactory.makeSkill(entity, "spearman-skill-1"));
        skills.add(SkillFactory.makeSkill(entity, "basic-attack"));
        skills.add(SkillFactory.makeSkill(entity, "spearman-skill-2"));
        skills.add(SkillFactory.makeSkill(entity, "spearman-skill-3"));
        skills.add(SkillFactory.makeSkill(entity, "spearman-skill-4"));
    }
    
}
