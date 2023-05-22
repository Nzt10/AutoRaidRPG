package com.example.autoraidrpg.gameplay.bag;

import com.example.autoraidrpg.gameplay.entity.Entity;

public class Inventory {

    private final int SLOT_SIZE = 12;
    private Item[] items;
    private Entity entity;

    public Inventory(Entity entity) {
        this.entity = entity;
        items = new Item[SLOT_SIZE];
    }

    public void equip(Item item, int index) {
        // based additional stats
        double hp = entity.getHp() + item.getHp();
        double phyDmg = entity.getPhyDmg() + item.getPhyDmg();
        double magDmg = entity.getMagDmg() + item.getMagDmg();
        double phyDef = entity.getPhyDef() + item.getPhyDef();
        double magDef = entity.getMagDef() + item.getMagDef();
        double spd = entity.getSpd() + item.getSpd();
        double critChance = entity.getCritChance() + item.getCritChance();
        double critDmg = entity.getCritDmg() + item.getCritDmg();
        double dodge = entity.getDodge() + item.getDodge();
        double armPen = entity.getArmPen() + item.getArmPen();
        double magPen = entity.getMagPen() + item.getMagPen();
        double acc = entity.getAcc() + item.getAcc();

        // increment based additional stats to entity
        entity.setHp(hp);
        entity.setPhyDmg(phyDmg);
        entity.setMagDmg(magDmg);
        entity.setPhyDef(phyDef);
        entity.setMagDef(magDef);
        entity.setSpd(spd);
        entity.setCritChance(critChance);
        entity.setCritDmg(critDmg);
        entity.setDodge(dodge);
        entity.setArmPen(armPen);
        entity.setMagPen(magPen);
        entity.setAcc(acc);

        items[index] = item;
    }

    public void unequip(int index) {
        Item item = items[index];

        // based additional stats
        double hp = entity.getHp() - item.getHp();
        double phyDmg = entity.getPhyDmg() - item.getPhyDmg();
        double magDmg = entity.getMagDmg() - item.getMagDmg();
        double phyDef = entity.getPhyDef() - item.getPhyDef();
        double magDef = entity.getMagDef() - item.getMagDef();
        double spd = entity.getSpd() - item.getSpd();
        double critChance = entity.getCritChance() - item.getCritChance();
        double critDmg = entity.getCritDmg() - item.getCritDmg();
        double dodge = entity.getDodge() - item.getDodge();
        double armPen = entity.getArmPen() - item.getArmPen();
        double magPen = entity.getMagPen() - item.getMagPen();
        double acc = entity.getAcc() - item.getAcc();

        // decrement based additional stats to entity
        entity.setHp(hp);
        entity.setPhyDmg(phyDmg);
        entity.setMagDmg(magDmg);
        entity.setPhyDef(phyDef);
        entity.setMagDef(magDef);
        entity.setSpd(spd);
        entity.setCritChance(critChance);
        entity.setCritDmg(critDmg);
        entity.setDodge(dodge);
        entity.setArmPen(armPen);
        entity.setMagPen(magPen);
        entity.setAcc(acc);

        items[index] = null;
    }
    
}
