package com.example.autoraidrpg.gameplay.bag.items;

import com.example.autoraidrpg.R;
import com.example.autoraidrpg.gameplay.bag.Item;

public class EnchantedHunterTrap extends Item {

    public EnchantedHunterTrap() {
        super("enchanted hunter trap", R.drawable.item_enchanted_hunter_trap, 125);
        this.phyDmg += 6;
        this.spd += 2.75;

        // description
        this.description.add("+" + this.phyDmg + " physical damage.");
        this.description.add("+" + this.spd + " speed.");

        // long description
        this.description.add("item that can be used to set traps in order to immobilize or damage enemies. When triggered, the trap will snare the enemy for a short period of time, allowing the hunter to either attack or retreat. The trap can be set in various locations and can be triggered by stepping on it, or by using a remote trigger. The trap can be upgraded to deal more damage or to last longer, and can be used in a variety of situations, such as in combat or during a chase. However, it requires strategic placement and timing to be effective, and can be disarmed or avoided by skilled enemies.");
    }
    
}
