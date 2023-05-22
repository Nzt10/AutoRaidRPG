package com.example.autoraidrpg.gameplay.bag.items;

import com.example.autoraidrpg.R;
import com.example.autoraidrpg.gameplay.bag.Item;

public class BlueGinsengRoot extends Item {

    public BlueGinsengRoot() {
        super("blue ginseng root", R.drawable.item_blue_ginseng_root, 100);
        this.phyDef += 10;

        // description
        this.description.add("+" + this.phyDef + " physical defense.");

        // long description
        this.description.add("a powerful defensive ginseng accessory that provides extra protection to the wearer. When equipped, it grants a significant boost to the wearer's defense, reducing the damage taken from incoming attacks. In addition, the Armor Amulet has the ability to absorb a portion of the damage received, protecting the wearer from taking too much damage at once. This makes the wearer more resistant to high-damage attacks and provides an extra layer of defense against particularly tough opponents. However, due to the powerful nature of the amulet, it can be quite heavy and cumbersome to wear, making the wearer slower and less agile in combat. Despite this drawback, the Armor Amulet is a valuable asset to any adventurer seeking extra protection and durability in battle.");
    }
    
}
