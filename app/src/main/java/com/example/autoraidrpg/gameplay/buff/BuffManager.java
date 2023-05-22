package com.example.autoraidrpg.gameplay.buff;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BuffManager {

    private final List<Buff> appliedBuffs;
    private boolean ableToMove = true;
    
    public BuffManager() {
        appliedBuffs = new ArrayList<>();
    }

    public void add(Buff buff) {
        appliedBuffs.add(buff);
    }

    // trigger all and check if the unit is unable to do something
    public boolean triggerAll() {
        ableToMove = true; // set a unit to move

        // set new list of buffs
        List<Buff> newBuffList = appliedBuffs.stream().filter(buff -> {

            // check if the the buff unable type buff
            if(buff instanceof UnableBuff) {
                UnableBuff unableBuff = (UnableBuff) buff;
                ableToMove = unableBuff.unableToMove(); // set a unit to stop moving
            }

            buff.trigger();
            return !buff.hasEnded();
        }).collect(Collectors.toList());

        appliedBuffs.clear(); 
        appliedBuffs.addAll(newBuffList); // update new list of buffs

        return ableToMove;
    }   

}
