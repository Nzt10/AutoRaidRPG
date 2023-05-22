package com.example.autoraidrpg.gameplay.bag;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class Item implements Serializable {

    protected int inventoryID;
    protected String name;
    protected int itemImage, rating;
    protected double price;
    protected double hp, phyDmg, magDmg, phyDef, magDef, spd, critChance, critDmg, dodge, armPen, magPen, acc; // based stats
    protected List<String> description;

    public Item(String name, int itemImage, double price) {
        this.name = name;
        this.itemImage = itemImage;
        this.price = price;
        this.rating = 1;

        // initialize base item stats
        hp = phyDmg = magDmg = phyDef = magDef = spd =
                critChance = critDmg = dodge = armPen = magPen = acc = 0;

        description = new ArrayList<>();
    }

    public Item setInventoryID(int inventoryID) { this.inventoryID = inventoryID; return this; }
    public Item setRating(int rating) { this.rating = rating; return this; }

    public int getInventoryID() { return inventoryID; }

    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getItemImage() { return itemImage; }
    public int getRating() { return rating; }
    public double getHp() { return hp; }
    public double getPhyDmg() { return phyDmg; }
    public double getMagDmg() { return magDmg; }
    public double getPhyDef() { return phyDef; }
    public double getMagDef() { return magDef; }
    public double getSpd() { return spd; }
    public double getCritChance() { return critChance; }
    public double getCritDmg() { return critDmg; }
    public double getDodge() { return dodge; }
    public double getArmPen() { return armPen; }
    public double getMagPen() { return magPen; }
    public double getAcc() { return acc; }
    public List<String> getDescription() { return description; }

}
