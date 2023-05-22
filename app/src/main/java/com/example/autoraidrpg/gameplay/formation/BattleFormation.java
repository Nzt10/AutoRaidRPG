package com.example.autoraidrpg.gameplay.formation;

import com.example.autoraidrpg.gameplay.entity.Entity;
import com.example.autoraidrpg.gameplay.formation.battleFormationTypes.FormationType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.BiConsumer;

public abstract class BattleFormation {

    public static final int INITIAL_CAPACITY = 3;
    private final FormationType formationType;
    protected HashMap<Integer, Entity> frontliners, backliners;
    private List<Entity> party;

    public BattleFormation(FormationType formationType) { 
        this.formationType = formationType;
        frontliners = new HashMap<>(INITIAL_CAPACITY); 
        backliners = new HashMap<>(INITIAL_CAPACITY);
    }

    public void moveBy(Entity attacker, List<Entity> altParty) {
        Entity targetedEntity = null;
        Entity altTargetedEntity = null;

        // find target
        for(Entity entity: party) {
            if(targetedEntity == null) targetedEntity = entity;
            else break;
        }

        // find alternative target
        for(Entity altEntity: altParty) {
            if(altTargetedEntity == null) altTargetedEntity = altEntity;
            else break;
        }
        
        // the attacker will make a move to this battle formation
        attacker.getSkillManager().activate(targetedEntity, party, altTargetedEntity, altParty);
    }

    public Entity addToFront(int index, Entity entity, BiConsumer<Integer, Entity> basedBiConsumer, BiConsumer<Integer, Entity> biConsumer) {
        Entity tempUnit = frontliners.get(index);
        frontliners.put(index, entity);

        if(entity != null) {
            entity.setFormationType(formationType);
            if(biConsumer != null) {
                entity.setHpConsumers(basedBiConsumer, biConsumer, index); // set view
                entity.setHp(entity.getHp());
            }
        }

        return tempUnit;
    }

    public Entity addToBack(int index, Entity entity, BiConsumer<Integer, Entity> basedBiConsumer, BiConsumer<Integer, Entity> biConsumer) {
        Entity tempUnit = backliners.get(index);
        backliners.put(index, entity);

        if(entity != null) {
            entity.setFormationType(formationType);
            if(biConsumer != null) {
                entity.setHpConsumers(basedBiConsumer, biConsumer, index); // set view
                entity.setHp(entity.getHp());
            }
        }

        return tempUnit;
    }

    public FormationType getFormationType() { return formationType; }

    public List<Entity> setAndGetParty() { 
        party = new ArrayList<>();
        frontliners.values().stream().forEach(party::add);
        backliners.values().stream().forEach(party::add);
        return party; 
    }

    public List<Entity> getParty() { return party; }
    
}
