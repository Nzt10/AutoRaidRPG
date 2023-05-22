package com.example.autoraidrpg.gameplay.bag.items;

import com.example.autoraidrpg.R;
import com.example.autoraidrpg.gameplay.bag.Item;

public class MarksmanSanctionGun extends Item {

    public MarksmanSanctionGun() {
        super("marksman sanction gun", R.drawable.item_marksman_sanction_gun, 150);
        this.phyDmg += 30;
        this.spd -= 5;

        // description
        this.description.add("+" + this.phyDmg + " physical damage.");
        this.description.add("+" + this.spd + " speed.");

        // long description
        this.description.add("Marksman weapon that offers an increased critical hit rate and precision shooting capabilities. It fires specialized rounds that deal heavy damage to a single target or multiple targets in a row. The gun also offers an enhanced zoom for improved accuracy and range. The Sanction Gun is ideal for sniping, as its long-range capabilities allow for precise hits on distant enemies. Additionally, the gun offers a rapid-fire mode for close-range combat, making it a versatile weapon suitable for a wide range of situations.");
    }
    
}
