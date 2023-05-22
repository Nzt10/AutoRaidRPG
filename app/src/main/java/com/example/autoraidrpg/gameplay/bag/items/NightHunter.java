package com.example.autoraidrpg.gameplay.bag.items;

import com.example.autoraidrpg.R;
import com.example.autoraidrpg.gameplay.bag.Item;

public class NightHunter extends Item {

    public NightHunter() {
        super("night hunter", R.drawable.item_night_hunter, 125);
        this.phyDef += 6;
        this.spd += 2.75;

        // description
        this.description.add("+" + this.phyDmg + " physical damage.");
        this.description.add("+" + this.spd + " speed.");

        // long description
        this.description.add("gains the ability to use the hook as a weapon and as a utility tool. The Hook can be thrown to grab objects, allowing the player to climb up to higher areas or pull down objects to reveal secret paths. In combat, the Hook can be used to pull enemies closer, making it easier to defeat them with melee attacks or spells. The Hook also has a chance to stun enemies it hits, making them vulnerable to follow-up attacks. However, the Hook has a limited range and can be difficult to aim, making it a high-risk, high-reward tool for players who like to get up close and personal with their enemies.");
    }
    
}
