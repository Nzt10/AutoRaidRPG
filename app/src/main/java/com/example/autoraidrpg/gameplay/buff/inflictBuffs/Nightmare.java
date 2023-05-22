package com.example.autoraidrpg.gameplay.buff.inflictBuffs;

import com.example.autoraidrpg.gameplay.buff.InflictBuff;
import com.example.autoraidrpg.gameplay.entity.Entity;
import com.example.autoraidrpg.gameplay.formation.battleFormationTypes.AttackType;

public class Nightmare extends InflictBuff {

    public Nightmare(double pDmg, Entity applyBy, int turn) {
        super("nightmare", pDmg, AttackType.MAGICAL, applyBy, turn);
    }
    
}
