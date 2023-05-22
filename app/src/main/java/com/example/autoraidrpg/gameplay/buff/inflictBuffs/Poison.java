package com.example.autoraidrpg.gameplay.buff.inflictBuffs;

import com.example.autoraidrpg.gameplay.buff.InflictBuff;
import com.example.autoraidrpg.gameplay.entity.Entity;
import com.example.autoraidrpg.gameplay.formation.battleFormationTypes.AttackType;

public class Poison extends InflictBuff {

    public Poison(double pDmg, Entity applyBy, int turn) {
        super("poison", pDmg, AttackType.MAGICAL, applyBy, turn);
    }
    
}
