package com.example.autoraidrpg.gameplay.inspector;

import com.example.autoraidrpg.gameplay.entity.Entity;
import com.example.autoraidrpg.gameplay.formation.BattleFormation;

import java.util.List;

public class DeathInspector {

    private BattleFormation formation;
    private List<Entity> party;
    
    public DeathInspector(BattleFormation formation, List<Entity> party) {
        this.formation = formation;
        this.party = party;
    }

    // check a spcific party if there is a dead entity
    public void inspect() {
        for(int i = 0; i < party.size(); i++) {
            Entity e = party.get(i) != null && !party.get(i).isDead() ? party.get(i) : null;

            if(i >= BattleFormation.INITIAL_CAPACITY) formation.addToBack(i - BattleFormation.INITIAL_CAPACITY, e, null, null);
            else formation.addToFront(i, e, null, null);
        }

        party.removeIf(e -> e.isDead());
    }

    // check if all the entity from specific party is dead
    public boolean isAllDead() {
        return party.stream().allMatch(Entity::isDead);
    }
    
}
