package com.example.autoraidrpg.gameplay.buff.inflictBuffs;

import com.example.autoraidrpg.gameplay.buff.InflictBuff;
import com.example.autoraidrpg.gameplay.entity.Entity;
import com.example.autoraidrpg.gameplay.formation.battleFormationTypes.AttackType;

public class Burn extends InflictBuff {

    public Burn(double pDmg, Entity applyBy, int turn) {
        super("burn", pDmg, AttackType.MAGICAL, applyBy, turn);
    }
    
}
