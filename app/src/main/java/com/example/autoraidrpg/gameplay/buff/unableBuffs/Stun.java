package com.example.autoraidrpg.gameplay.buff.unableBuffs;

import com.example.autoraidrpg.gameplay.buff.UnableBuff;
import com.example.autoraidrpg.gameplay.entity.Entity;

public class Stun extends UnableBuff {

    public Stun(Entity applyBy, int turn) {
        super("stun", applyBy, turn);
    }

    @Override
    protected boolean unableToMove() { return false; }
    
}
