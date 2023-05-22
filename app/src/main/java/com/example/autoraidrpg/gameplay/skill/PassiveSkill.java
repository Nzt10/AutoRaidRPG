package com.example.autoraidrpg.gameplay.skill;

import com.example.autoraidrpg.gameplay.entity.Entity;

import java.util.List;

public abstract class PassiveSkill extends Skill {

    protected double lvlHp, lvlPhyDmg, lvlMagDmg, lvlPhyDef, lvlMagDef, lvlSpd; // based additional stats
    protected double aLvlHp, aLvlPhyDmg, aLvlMagDmg, aLvlPhyDef, aLvlMagDef, aLvlSpd;

    // incremental level stats
    protected double lvlpHp, lvlpPhyDmg, lvlpMagDmg, lvlpPhyDef, lvlpMagDef, lvlpSpd, lvlpCritChance, lvlpCritDmg, lvlpDodge, lvlpArmPen, lvlpMagPen, lvlpAcc;
    protected double aLvlpHp, aLvlpPhyDmg, aLvlpMagDmg, aLvlpPhyDef, aLvlpMagDef, aLvlpSpd, aLvlpCritChance, aLvlpCritDmg, aLvlpDodge, aLvlpArmPen, aLvlpMagPen, aLvlpAcc;

    public PassiveSkill(String name, int itemImage, SkillType type, List<String> description) {
        super(name, itemImage, type, description);
        initAdditionalStats();
        initAdditionalPercStats();
    }

    // initialize based additional stats
    private void initAdditionalStats() {
        lvlHp = lvlPhyDmg = lvlMagDmg = lvlPhyDef = lvlMagDef = lvlSpd = 0; // base
        aLvlHp = aLvlPhyDmg = aLvlMagDmg = aLvlPhyDef = aLvlMagDef = aLvlSpd = 0; // incremental
    }

    // initialize based additional percentage stats
    private void initAdditionalPercStats() {
        // base
        lvlpHp = lvlpPhyDmg = lvlpMagDmg = lvlpPhyDef = lvlpMagDef = lvlpSpd = 
        lvlpCritChance = lvlpCritDmg = lvlpDodge = lvlpArmPen = lvlpMagPen = lvlpAcc = 0;
        
        // incremental
        aLvlpHp = aLvlpPhyDmg = aLvlpMagDmg = aLvlpPhyDef = aLvlpMagDef = aLvlpSpd = 
        aLvlpCritChance = aLvlpCritDmg = aLvlpDodge = aLvlpArmPen = aLvlpMagPen = aLvlpAcc = 0;
    }

    @Override
    public void activate(Entity entity) {
        if(!this.isApplicable(entity)) return;
        
        // based additional stats
        double aHp = entity.getHp() + (level * aLvlHp) + lvlHp; 
        double aPhyDmg = entity.getPhyDmg() + (level * aLvlPhyDmg) + lvlPhyDmg;  
        double aMagDmg = entity.getMagDmg() + (level * aLvlMagDmg) + lvlMagDmg;  
        double aPhyDef = entity.getPhyDef() + (level * aLvlPhyDef) + lvlPhyDef;  
        double aMagDef = entity.getMagDef() + (level * aLvlMagDef) + lvlMagDef;  
        double aSpd = entity.getSpd() + (level * aLvlSpd) + lvlSpd;

        // increment based additional stats to entity
        entity.setHp(aHp);
        entity.setPhyDmg(aPhyDmg);
        entity.setMagDmg(aMagDmg);
        entity.setPhyDef(aPhyDef);
        entity.setMagDef(aMagDef);
        entity.setSpd(aSpd);
        
        // based additional percentage stats
        double apHp = discount(entity.getHp(), (level * aLvlpHp) + lvlpHp); 
        double apPhyDmg = discount(entity.getPhyDmg(), (level * aLvlpPhyDmg) + lvlpPhyDmg);  
        double apMagDmg = discount(entity.getMagDmg(), (level * aLvlpMagDmg) + lvlpMagDmg);  
        double apPhyDef = discount(entity.getPhyDef(), (level * aLvlpPhyDef) + lvlpPhyDef);  
        double apMagDef = discount(entity.getMagDef(), (level * aLvlpMagDef) + lvlpMagDef);  
        double apSpd = discount(entity.getSpd(), (level * aLvlpSpd) + lvlpSpd);
        double apCritChance = discountRate(entity.getCritChance(), (level * aLvlpCritChance) + lvlpCritChance);  
        double apCritDmg = discountRate(entity.getCritDmg(), (level * aLvlpCritDmg) + lvlpCritDmg);  
        double apDodge = discountRate(entity.getDodge(), (level * aLvlpDodge) + lvlpDodge);  
        double apArmPen = discountRate(entity.getArmPen(), (level * aLvlpArmPen) + lvlpArmPen);  
        double apMagPen = discountRate(entity.getMagPen(), (level * aLvlpMagPen) + lvlpMagPen);  
        double apAcc = discountRate(entity.getAcc(), (level * aLvlpAcc));

        // increment based additional percentage stats to entity
        entity.setHp(apHp);
        entity.setPhyDmg(apPhyDmg);
        entity.setMagDmg(apMagDmg);
        entity.setPhyDef(apPhyDef);
        entity.setMagDef(apMagDef);
        entity.setSpd(apSpd);
        entity.setCritChance(apCritChance);
        entity.setCritDmg(apCritDmg);
        entity.setDodge(apDodge);
        entity.setArmPen(apArmPen);
        entity.setMagPen(apMagPen);
        entity.setAcc(apAcc);
    }

    @Override
    public void activateToAll(List<Entity> entities) {
        entities.stream().forEach(e -> activate(e));
    }

    public double getLvlHp() { return lvlHp; }
    public double getLvlPhyDmg() { return lvlPhyDmg; }
    public double getLvlMagDmg() { return lvlMagDmg; }
    public double getLvlPhyDef() { return lvlPhyDef; }
    public double getLvlMagDef() { return lvlMagDef; }
    public double getLvlSpd() { return lvlSpd; }

    public double getLvlpHp() { return lvlpHp; }
    public double getLvlpPhyDmg() { return lvlpPhyDmg; }
    public double getLvlpMagDmg() { return lvlpMagDmg; }
    public double getLvlpPhyDef() { return lvlpPhyDef; }
    public double getLvlpMagDef() { return lvlpMagDef; }
    public double getLvlpSpd() { return lvlpSpd; }
    public double getLvlpCritChance() { return lvlpCritChance; }
    public double getLvlpCritDmg() { return lvlpCritDmg; }
    public double getLvlpDodge() { return lvlpDodge; }
    public double getLvlpArmPen() { return lvlpArmPen; }
    public double getLvlpMagPen() { return lvlpMagPen; }
    public double getLvlpAcc() { return lvlpAcc; }
    
    @Override
    public boolean isReadyToActivate() { return false; }
    
}
