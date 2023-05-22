package com.example.autoraidrpg.gameplay.buff.unableBuffs;

import com.example.autoraidrpg.gameplay.buff.UnableBuff;
import com.example.autoraidrpg.gameplay.entity.Entity;

public class Bind extends UnableBuff {

    public Bind(Entity applyBy, int turn) {
        super("bind", applyBy, turn);
    }

    @Override
    protected boolean unableToMove() { return false; }
    
}
