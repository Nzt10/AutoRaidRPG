package com.example.autoraidrpg.gameplay.buff;

import com.example.autoraidrpg.gameplay.formation.battleFormationTypes.AttackType;
import com.example.autoraidrpg.gameplay.entity.Entity;

public class InflictBuff extends Buff {

    public InflictBuff(String name, double pDmg, AttackType attackType, Entity applyBy, int turn) {
        super(name, pDmg, attackType, applyBy, turn);
    }

    @Override
    public void trigger() {
        // actual damage
        double phyDmg = actualDiscount(owner.getPhyDmg(), pDmg);
        double magDmg = actualDiscount(owner.getMagDmg(), pDmg);

        switch(attackType) {
            case PHYSICAL: phyInflict(phyDmg); break;
            case MAGICAL: magInflict(magDmg); break;
            case BOTH: 
                phyInflict(phyDmg);
                magInflict(magDmg);
                break;
            default: 
                break;
        }

        turn--;
    }

    private void phyInflict(double dmg) {
        double currentHealth = target.getHp() - dmg;
        // update observer
        battleSubject.getCurrentObserver()
            .addDescription(String.format("this unit has recieved %d physical damage by %s's %s buff.", (int) dmg, owner.getName(), name), target.getRoleImage(), owner.getRoleImage());
        target.inflictHp(currentHealth);
    }

    private void magInflict(double dmg) {
        double currentHealth = target.getHp() - dmg;
        // update observer
        battleSubject.getCurrentObserver()
            .addDescription(String.format("this unit has recieved %d magical damage by %s's %s buff.", (int) dmg, owner.getName(), name), target.getRoleImage(), owner.getRoleImage());
        target.inflictHp(currentHealth);
    }
    
}
