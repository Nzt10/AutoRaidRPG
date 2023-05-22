package com.example.autoraidrpg.gameplay.buff;

import com.example.autoraidrpg.gameplay.entity.Entity;
import com.example.autoraidrpg.gameplay.formation.battleFormationTypes.AttackType;
import com.example.autoraidrpg.gameplay.global.BattleInformationObserver;
import com.example.autoraidrpg.gameplay.proxy.Discount;
import com.example.autoraidrpg.gameplay.subject.BattleSubject;

public abstract class Buff implements Discount {

    protected Entity owner, target;
    protected AttackType attackType;
    protected String name;
    protected double pDmg;
    protected int turn;

    // observers
    protected BattleSubject battleSubject;

    public Buff(String name, double pDmg, AttackType attackType, Entity applyBy, int turn) {
        this.name = name;
        this.pDmg = pDmg;
        this.attackType = attackType;
        this.turn = turn;
        owner = applyBy;
        
        // set global observer
        battleSubject = BattleInformationObserver.getInstance();
    }

    public Buff applyTo(Entity applyTo) { target = applyTo; return this; }

    public abstract void trigger();

    public String getName() { return name; }
    public boolean hasEnded() { return turn <= 0; }
    
}
