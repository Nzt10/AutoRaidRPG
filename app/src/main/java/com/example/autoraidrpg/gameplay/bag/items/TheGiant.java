package com.example.autoraidrpg.gameplay.bag.items;

import com.example.autoraidrpg.R;
import com.example.autoraidrpg.gameplay.bag.Item;

public class TheGiant extends Item {

    public TheGiant() {
        super("the giant", R.drawable.item_the_giant, 150);
        this.phyDef += 4;
        this.magDef += 4;
        this.hp += 65;

        // description
        this.description.add("+" + this.phyDef + " physical defense.");
        this.description.add("+" + this.magDef + " magical defense.");
        this.description.add("+" + this.hp + " health.");

        // long description
        this.description.add("a heavy weapon that inflicts devastating blows on enemies. When wielded in battle, the spiked ball at the end of the chain can swing in a wide arc, striking multiple targets at once. Additionally, the chain can be used to entangle enemies, immobilizing them for a short time. This can give the wielder a strategic advantage, allowing them to attack the enemy while they are vulnerable. The mace's weight and size make it difficult to handle, requiring significant strength and skill to wield effectively. However, in the hands of a capable warrior, the Chain Mace can be a deadly weapon on the battlefield.");
    }
    
}
