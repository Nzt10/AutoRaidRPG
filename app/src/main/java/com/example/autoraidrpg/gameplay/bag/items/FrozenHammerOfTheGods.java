package com.example.autoraidrpg.gameplay.bag.items;

import com.example.autoraidrpg.R;
import com.example.autoraidrpg.gameplay.bag.Item;

public class FrozenHammerOfTheGods extends Item {

    public FrozenHammerOfTheGods() {
        super("frozen hammer of the gods", R.drawable.item_frozen_hammer_of_the_gods, 125);
        this.phyDmg += 6;
        this.phyDef += 6;

        // description
        this.description.add("+" + this.phyDmg + " physical damage.");
        this.description.add("+" + this.phyDef + " physical defense.");

        // long description
        this.description.add("a powerful hammer that deals massive damage to enemies, especially those vulnerable to cold attacks. When the hammer strikes, it has a chance to freeze the enemy, slowing their movements and making them more susceptible to additional attacks. The hammer's magic also imbues the wielder with increased resistance to cold-based attacks, providing extra protection in battle. The hammer's powers are most effective when facing enemies in cold environments, making it a valuable tool in battles in frozen tundras or snow-covered peaks. However, it can be less effective in warmer climates or against enemies with high resistance to cold damage. Overall, the Frozen Hammer is a valuable asset to any warrior looking to deal devastating blows and gain an advantage in battle.");
    }
    
}
