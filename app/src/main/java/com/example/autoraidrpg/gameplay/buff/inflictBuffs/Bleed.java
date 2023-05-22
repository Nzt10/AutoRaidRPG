package com.example.autoraidrpg.gameplay.buff.inflictBuffs;

import com.example.autoraidrpg.gameplay.buff.InflictBuff;
import com.example.autoraidrpg.gameplay.entity.Entity;
import com.example.autoraidrpg.gameplay.formation.battleFormationTypes.AttackType;

public class Bleed extends InflictBuff {

    public Bleed(double pDmg, Entity applyBy, int turn) {
        super("bleed", pDmg, AttackType.PHYSICAL, applyBy, turn);
    }
    
}
