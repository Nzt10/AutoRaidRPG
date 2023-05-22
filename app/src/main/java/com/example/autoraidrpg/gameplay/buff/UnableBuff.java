package com.example.autoraidrpg.gameplay.buff;

import com.example.autoraidrpg.gameplay.formation.battleFormationTypes.AttackType;
import com.example.autoraidrpg.gameplay.entity.Entity;

public abstract class UnableBuff extends Buff {

    public UnableBuff(String name, Entity applyBy, int turn) {
        super(name, 0, AttackType.NONE, applyBy, turn);
    }

    @Override
    public void trigger() {
        // update observer
        battleSubject.getCurrentObserver()
            .addDescription(String.format("unit has %s buff causing to unable to move.", this.name), target.getRoleImage(), target.getRoleImage());
        turn--;
    }

    protected abstract boolean unableToMove();
}
