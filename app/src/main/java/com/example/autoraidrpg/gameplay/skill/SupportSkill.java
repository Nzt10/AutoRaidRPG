package com.example.autoraidrpg.gameplay.skill;

import com.example.autoraidrpg.gameplay.entity.Entity;
import com.example.autoraidrpg.gameplay.global.BattleInformationObserver;
import com.example.autoraidrpg.gameplay.subject.BattleSubject;

import java.util.List;

public abstract class SupportSkill extends Skill implements Active {

    protected Entity owner;

    // observers
    protected BattleSubject battleSubject;

    public SupportSkill(String name, int itemImage, SkillType type, Entity owner, List<String> description, int cooldown) {
        super(name, itemImage, type, description);
        this.owner = owner;
        this.cooldown = cooldown;
        
        // set global observer
        battleSubject = BattleInformationObserver.getInstance();
    }

    @Override
    public void activateToAll(List<Entity> targetedEntities) {
        targetedEntities.stream().forEach(e -> { if(e != null) activate(e); });
    }
    
}
