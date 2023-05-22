package com.example.autoraidrpg.gameplay.bag.items;

import com.example.autoraidrpg.R;
import com.example.autoraidrpg.gameplay.bag.Item;

public class ImmortalHunterAxe extends Item {

    public ImmortalHunterAxe() {
        super("immortal hunter axe", R.drawable.item_immortal_thunder_axe, 125);
        this.hp += 100;
        this.magDmg += 6;

        // description
        this.description.add("+" + this.hp + " health.");
        this.description.add("+" + this.magDmg + " magical damage.");

        // long description
        this.description.add("the Immortal Thunder Axe is a powerful weapon imbued with the essence of lightning. It has the ability to unleash thunderous shocks that can strike down enemies from afar. This axe also grants its wielder immense strength, allowing them to deal devastating blows that can shatter the toughest armor. Moreover, the axe has an enchantment that makes it indestructible, ensuring its longevity in battle. However, the power of the Immortal Thunder Axe is not easily wielded and requires great skill and mastery to harness. Only the bravest and most skilled warriors are able to fully harness the power of this legendary weapon.");
    }
    
    
}
