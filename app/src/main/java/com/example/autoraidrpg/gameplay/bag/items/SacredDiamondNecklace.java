package com.example.autoraidrpg.gameplay.bag.items;

import com.example.autoraidrpg.R;
import com.example.autoraidrpg.gameplay.bag.Item;

public class SacredDiamondNecklace extends Item {

    public SacredDiamondNecklace() {
        super("sacred diamond necklace", R.drawable.item_sacred_diamond_necklace, 100);
        this.magDef += 10;

        // description
        this.description.add("+" + this.magDef + " magical defense.");

        // long description
        this.description.add("a sacred necklace, a powerful item that provides a range of beneficial effects to its wearer, typically a cleric or other holy warrior. The necklace may provide a boost to the wearer's health points or mana points, as well as a bonus to their healing or protective spells. Additionally, the necklace may provide resistance to dark magic or curses, making it an essential item for battling undead or demonic enemies. Some cleric necklaces may also provide a boost to the wearer's strength or dexterity, allowing them to wield heavier weapons or move more quickly in combat. However, wearing a cleric necklace may also attract the attention of dark forces, making the wearer a target for powerful demonic creatures or dark mages. As a result, the use of a cleric necklace should be carefully considered in any given situation.");
    }
    
}
