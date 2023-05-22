package com.example.autoraidrpg.gameplay.bag.items;

import com.example.autoraidrpg.R;
import com.example.autoraidrpg.gameplay.bag.Item;

public class HorrorScythe extends Item {

    public HorrorScythe() {
        super("horror scythe", R.drawable.item_horror_scythe, 125);
        this.phyDmg += 6;
        this.magDmg += 6;

        // description
        this.description.add("+" + this.phyDmg + " physical damage.");
        this.description.add("+" + this.magDmg + " magical damage.");

        // long description
        this.description.add("the Horror Scythe is a powerful and terrifying weapon that unleashes darkness and chaos upon the enemy. When wielded, it grants its user the power to drain the life force of their opponents, inflicting severe damage and instilling fear into their hearts. This weapon's eerie and malevolent nature is amplified when used in battle, as its bloodthirsty thirst for carnage is almost palpable. The Horror Scythe's unique abilities are further enhanced when used against the undead or other supernatural beings, as its power over death and decay grows exponentially. However, the user must be careful, as the Scythe's dark magic can consume them if they become too dependent on its abilities.");
    }
    
}
