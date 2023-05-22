package com.example.autoraidrpg.gameplay.bag.items;

import com.example.autoraidrpg.R;
import com.example.autoraidrpg.gameplay.bag.Item;

public class BerserkAxe extends Item {

    public BerserkAxe() {
        super("berserk axe", R.drawable.item_berserk_axe, 150);
        this.phyDmg += 4;
        this.spd += 1.5;
        this.hp += 65;

        // description
        this.description.add("+" + this.phyDmg + " physical damage.");
        this.description.add("+" + this.spd + " speed.");
        this.description.add("+" + this.hp + " health.");

        // long description
        this.description.add("the Berserk Axe is a powerful weapon that increases the wielder's strength and speed, but at a cost. While equipped, the wielder gains a significant boost to their physical attack power, allowing them to deal massive damage to their enemies. However, the berserk nature of the weapon can cause the wielder to lose control, making them more vulnerable to attacks and lowering their defense. Additionally, the weapon drains the wielder's health over time, making it a risky choice in prolonged battles. Skilled fighters can make great use of this weapon, but it is not recommended for those who are not confident in their abilities.");
    }
    
}
