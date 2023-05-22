package com.example.autoraidrpg.gameplay.skill.skillManager;

import com.example.autoraidrpg.gameplay.global.BattleInformationObserver;
import com.example.autoraidrpg.gameplay.skill.SkillType;
import com.example.autoraidrpg.gameplay.entity.Entity;
import com.example.autoraidrpg.gameplay.skill.Active;
import com.example.autoraidrpg.gameplay.skill.Skill;
import com.example.autoraidrpg.gameplay.subject.BattleSubject;

import java.util.ArrayList;
import java.util.List;

public abstract class SkillManager {

    protected Entity entity;
    protected List<Skill> skills;
    protected int skillPhase = 0, skillPointer = 0;

    // observers
    private BattleSubject battleSubject;

    public SkillManager(Entity entity) {
        this.entity = entity;
        skills = new ArrayList<>();
        
        // set global observer
        battleSubject = BattleInformationObserver.getInstance();
    }

    public void initializePassives() {
        skills.stream().forEach(skill -> {
            if(skill.getSkillType() == SkillType.INITIAL_PASSIVE) {
                skill.activate(entity);
                entity.initializeBaseStats();

                if(skill.isApplicable(entity)) {
                    // update observer
                    battleSubject.getCurrentObserver()
                        .addDescription(String.format("%s activated its passive skill %s.", entity.getName(), skill.getName()), entity.getRoleImage(), entity.getRoleImage());
                }
            }
        });
    }

    public void applyPassives() {
        skills.stream().forEach(skill -> {
            if(skill.getSkillType() == SkillType.PASSIVE) {
                skill.activate(entity);

                if(skill.isApplicable(entity)) {
                    // update observer
                    battleSubject.getCurrentObserver()
                        .addDescription(String.format("%s activated its passive skill %s.", entity.getName(), skill.getName()), entity.getRoleImage(), entity.getRoleImage());
                }
            }
        });
    }

    public void activate(Entity targetedEntity, List<Entity> targetedEntities, Entity altTargetedEntity, List<Entity> altTargetedEntities) {
        Skill movingSkill = skills.get(skillPhase);

        // increment if the skillPhase is not on the skillPointer
        while(skillPhase < skillPointer) {
            skillPhase++;

            if(skillPhase >= skills.size()) {
                skillPhase = 0;
                skillPointer = 0;
            }

            movingSkill = skills.get(skillPhase);
        }

        // select a skill except passive skills -> increment if the skill is not an active skill and is in cooldown
        while(!(skills.get(skillPhase) instanceof Active) || !movingSkill.isReadyToActivate()) {
            skillPhase++;
            skillPointer++;

            if(skillPhase >= skills.size()) {
                skillPhase = 0;
                skillPointer = 0;
            }

            movingSkill = skills.get(skillPhase);
            //System.out.println("Skill pointer: " + skillPointer + " Skill phase: " + skillPhase);
        }
        
        skillPointer++;
        
        // update observer
        battleSubject.getCurrentObserver()
            .addDescription(String.format("%s activated its active skill %s.", entity.getName(), movingSkill.getName()), entity.getRoleImage(), entity.getRoleImage());

        switch(movingSkill.getSkillType()) {
            case SINGLE: movingSkill.activate(targetedEntity); break;
            case ALL: movingSkill.activateToAll(targetedEntities); break;
            case SUPPORT_ALLY_SINGLE: movingSkill.activate(altTargetedEntity); break;
            case SUPPORT_ALLY_ALL: movingSkill.activateToAll(altTargetedEntities); break;
            default: break;
        }
    }

    // level up skill
    public void levelUp(int index, int level) {
        Skill skill = skills.get(index);

        for(int i = skill.getLevel(); i < level; i++) 
            skill.levelUp();
    }

    // reduce all cooldown
    public void reduceAllCooldown() { skills.stream().forEach(skill -> skill.decrementCooldown()); }
    public List<Skill> getSkills() { return skills; }

    protected abstract void manageSkills();
    
}
