package com.example.autoraidrpg.gameplay.bag.items;

import com.example.autoraidrpg.R;
import com.example.autoraidrpg.gameplay.bag.Item;

public class ShiningSwordOfTheLegend extends Item {

    public ShiningSwordOfTheLegend() {
        super("shining sword of the legend", R.drawable.item_shinning_sword_of_the_legend, 100);
        this.phyDmg += 10;

        // description
        this.description.add("+" + this.phyDmg + " physical damage.");

        // long description
        this.description.add("a powerful weapon that emits a bright aura or light, often imbued with holy or magical properties. When wielded, the light sword can deal extra damage to undead or demonic enemies, as well as provide a boost to the wielder's accuracy and speed. Some light swords may also have additional effects, such as healing the wielder's HP, boosting their resistance to magic, or increasing the amount of EXP gained from battles. However, using a light sword may also attract the attention of dark forces, making the wielder a target for powerful demonic creatures or dark mages. As a result, the use of a light sword should be carefully considered in any given situation.");
    }
    
}
