package com.example.autoraidrpg.gameplay.buff.inflictBuffs;

import com.example.autoraidrpg.gameplay.buff.InflictBuff;
import com.example.autoraidrpg.gameplay.entity.Entity;
import com.example.autoraidrpg.gameplay.formation.battleFormationTypes.AttackType;

public class Ignite extends InflictBuff {

    public Ignite(double pDmg, Entity applyBy, int turn) {
        super("ignite", pDmg, AttackType.PHYSICAL, applyBy, turn);
    }
    
}
