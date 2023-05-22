package com.example.autoraidrpg.gameplay.entity;

import com.example.autoraidrpg.gameplay.buff.BuffManager;
import com.example.autoraidrpg.gameplay.formation.battleFormationTypes.FormationType;
import com.example.autoraidrpg.gameplay.global.BattleInformationObserver;
import com.example.autoraidrpg.gameplay.skill.skillManager.SkillManager;
import com.example.autoraidrpg.gameplay.skill.skillManager.roleSkillManager.RoleManagerFactory;
import com.example.autoraidrpg.gameplay.subject.BattleSubject;
import com.example.autoraidrpg.gameplay.bag.Inventory;
import com.example.autoraidrpg.gameplay.buff.Buff;

import java.util.Random;
import java.util.function.BiConsumer;

public abstract class Entity implements Comparable<Entity> {

    // database
    protected int roleID, roleCollectionID;

    // intances
    protected String name, description;
    protected int roleImage, level, rating;
    protected double priceCoin, priceDiamond;
    protected boolean isDead = false;
    protected FormationType formationType;
    protected SkillManager skillManager;
    protected BuffManager buffManager;
    protected Inventory inventory;

    protected double hp, phyDmg, magDmg, phyDef, magDef, spd, critChance, critDmg, dodge, armPen, magPen, acc; // based stats
    protected double aHp, aPhyDmg, aMagDmg, aPhyDef, aMagDef, aSpd, aCritChance, aCritDmg, aDodge, aArmPen, aMagPen, aAcc; // incremental stats
    protected double bHp, bPhyDmg, bMagDmg, bPhyDef, bMagDef, bSpd, bCritChance, bCritDmg, bDodge, bArmPen, bMagPen, bAcc; // battle stats
    protected double speedMeter; // speed meter

    // consumers
    private BiConsumer<Integer, Entity> basedHpConsumer, hpConsumer;
    private int battleIndex;

    // observers
    protected BattleSubject battleSubject;

    public Entity(String name, int roleImage, double priceCoin, double priceDiamond) {
        this.name = name;
        this.roleImage = roleImage;
        this.priceCoin = priceCoin;
        this.priceDiamond = priceDiamond;
        level = 1;
        rating = 1;
        speedMeter = 0;

        inventory = new Inventory(this);
        skillManager = RoleManagerFactory.makeManager(this);
        buffManager = new BuffManager();

        initBasedStats();
        initIncrementalStats();
        initBattleStats();

        // set global observer
        battleSubject = BattleInformationObserver.getInstance();
    }

    // initialize based initial stats
    private void initBasedStats() {
        /*-----------------------------
         * based stats
         * health :             125
         * physical damage :    5
         * magical damage :     10
         * physical defense :   2
         * magical defense :    2
         * speed :              5
         * critical chance :    0%
         * critical damage :    100%
         * dodge:               0%
         * armen penetration :  0%
         * magic penetration :  0%
         * accuracy :           100%
         -----------------------------*/
        hp = 125; phyDmg = 5; magDmg = 10; phyDef = 2; magDef = 2; spd = 5;
        critChance = 0; critDmg = 100; dodge = 0; armPen = 0; magPen = 0; acc = 100;
    }

    // initialize incremental stats
    private void initIncrementalStats() {
        /*-----------------------------
         * incremental stats
         * health :             7.5
         * physical damage :    0.75
         * magical damage :     1.25
         * physical defense :   0.2
         * magical defense :    0.3
         * speed :              0.25
         * critical chance :    0%
         * critical damage :    0%
         * dodge:               0%
         * armen penetration :  0%
         * magic penetration :  0%
         * accuracy :           0%
         -----------------------------*/
        aHp = 7.5; aPhyDmg = 0.75; aMagDmg = 1.25; aPhyDef = 0.2; aMagDef = 0.3; aSpd = 0.25;
        aCritChance = 0; aCritDmg = 0; aDodge = 0; aArmPen = 0; aMagPen = 0; aAcc = 0;
    }

    // initialize battle stats
    private void initBattleStats() {
        bHp = bPhyDmg = bMagDmg = bPhyDef = bMagDef = bSpd =
                bCritChance = bCritDmg = bDodge = bArmPen = bMagPen = bAcc = 0;
    }

    // initialize battle stats increase per level
    public void initStats() {
        hp = bHp += hp + (level * aHp);
        phyDmg = bPhyDmg += phyDmg + (level * aPhyDmg);
        magDmg = bMagDmg += magDmg + (level * aMagDmg);
        phyDef = bPhyDef += phyDef + (level * aPhyDef);
        magDef = bMagDef += magDef + (level * aMagDef);
        spd= bSpd += spd + (level * aSpd);

        bCritChance += critChance + (level * aCritChance);
        bCritDmg += critDmg + (level * aCritDmg);
        bDodge += dodge + (level * aDodge);
        bArmPen += armPen + (level * aArmPen);
        bMagPen += magPen + (level * aMagPen);
        bAcc += acc + (level * aAcc);
    }

    // initialize based stats
    public void initializeBaseStats() {
        hp = bHp;
        phyDmg = bPhyDmg;
        magDmg = bMagDmg;
        phyDef = bPhyDef;
        magDef = bMagDef;
        spd = bSpd;
        setHp(bHp);
    }

    // set view hp consumers
    public void setHpConsumers(BiConsumer<Integer, Entity> basedHpConsumer, BiConsumer<Integer, Entity> hpConsumer, int battleIndex) {
        this.basedHpConsumer = basedHpConsumer;
        this.hpConsumer = hpConsumer;
        this.battleIndex = battleIndex;
    }

    // set hp
    public void setHp(double bHp) {
        this.bHp = bHp;
        if(basedHpConsumer != null) basedHpConsumer.accept(battleIndex, this);
    }

    // inflict hp
    public void inflictHp(double bHp) {
        this.bHp = bHp;

        if(this.bHp <= 0) {
            this.bHp = 0;
            dead();
        }

        if(basedHpConsumer != null) hpConsumer.accept(battleIndex, this);
    }

    // support hp
    public void supportHp(double bHp) {
        this.bHp = bHp;
        if(this.bHp >= hp) this.bHp = hp;
        if(basedHpConsumer != null) hpConsumer.accept(battleIndex, this);
    }

    // reset speed meter
    public void resetMove(double excess) { speedMeter = excess; }

    // apply buffs
    public void applyBuff(Buff buff) { buffManager.add(buff.applyTo(this)); }

    // trigger buffs
    public boolean reduceBuffTurns() { return buffManager.triggerAll(); }

    // move the entity based on its speed
    public double getMove() {
        speedMeter += bSpd;
        return speedMeter;
    }

    // set entity to a dead state
    private void dead() {
        isDead = true;
        battleSubject.getCurrentObserver().addDescription(String.format("%s is dead.", name), this.getRoleImage(), this.getRoleImage());
    }

    public void setRoleID(int roleID) { this.roleID = roleID; }
    public void setRoleCollectionID(int roleCollectionID) { this.roleCollectionID = roleCollectionID; }
    public Entity setName(String name) { this.name = name; return this; }
    public Entity setLevel(int level) { this.level = level; return this; }
    public Entity setRating(int rating) { this.rating = rating; return this; }
    public Entity setPhyDmg(double bPhyDmg) { this.bPhyDmg = bPhyDmg; return this; }
    public Entity setMagDmg(double bMagDmg) { this.bMagDmg = bMagDmg; return this; }
    public Entity setPhyDef(double bPhyDef) { this.bPhyDef = bPhyDef; return this; }
    public Entity setMagDef(double bMagDef) { this.bMagDef = bMagDef; return this; }
    public Entity setSpd(double bSpd) { this.bSpd = bSpd; return this; }
    public Entity setCritChance(double bCritChance) { this.bCritChance = bCritChance; return this; }
    public Entity setCritDmg(double bCritDmg) { this.bCritDmg = bCritDmg; return this; }
    public Entity setDodge(double bDodge) { this.bDodge = bDodge; return this; }
    public Entity setArmPen(double bArmPen) { this.bArmPen = bArmPen; return this; }
    public Entity setMagPen(double bMagPen) { this.bMagPen = bMagPen; return this; }
    public Entity setAcc(double bAcc) { this.bAcc = bAcc; return this; }
    public Entity setFormationType(FormationType formationType) { this.formationType = formationType; return this; }

    public double getBasedHp() { return hp; }
    public double getBasedPhyDmg() { return phyDmg; }
    public double getBasedMagDmg() { return magDmg; }
    public double getBasedPhyDef() { return phyDef; }
    public double getBasedMagDef() { return magDef; }
    public double getBasedSpd() { return spd; }
    public double getBasedCritChance() { return critChance; }
    public double getBasedCritDmg() { return critDmg; }
    public double getBasedDodge() { return dodge; }
    public double getBasedArmPen() { return armPen; }
    public double getBasedMagPen() { return magPen; }
    public double getBasedAcc() { return acc; }

    public int getRoleID() { return roleID; }
    public int getRoleCollectionID() { return roleCollectionID; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public int getRoleImage() { return roleImage; }
    public int getLevel() { return level; }
    public int getRating() { return rating; }
    public double getPriceCoin() { return priceCoin; }
    public double getPriceDiamond() { return priceDiamond; }
    public double getHp() { return bHp; }
    public double getPhyDmg() { return bPhyDmg; }
    public double getMagDmg() { return bMagDmg; }
    public double getPhyDef() { return bPhyDef; }
    public double getMagDef() { return bMagDef; }
    public double getSpd() { return bSpd; }
    public double getCritChance() { return bCritChance; }
    public double getCritDmg() { return bCritDmg; }
    public double getDodge() { return bDodge; }
    public double getArmPen() { return bArmPen; }
    public double getMagPen() { return bMagPen; }
    public double getAcc() { return bAcc; }

    public double getSpeedMeter() { return speedMeter; }
    public Inventory getInventory() { return inventory; }
    public FormationType getFormationType() { return formationType; }
    public SkillManager getSkillManager() { return skillManager; }
    public boolean isDead() { return isDead; }

    @Override
    public int compareTo(Entity o) { return new Random().nextInt(2) - 1; }

    public String toString() {
        return "bHp: " + bHp + " bPhyDmg: " + bPhyDmg + " bMagDmg: " + bMagDmg +
                " bPhyDef: " + bPhyDef + " bMagDef: " + bMagDef + " bSpd: " + bSpd +
                " bCritChance: " + bCritChance + " bCritDmg: " + bCritDmg + " bDodge: " + bDodge +
                " bArmPen: " + bArmPen + " bMagPen: " + bMagPen + " bAcc: " + bAcc;
    }

}
