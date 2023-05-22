package com.example.autoraidrpg.gameplay.bag.items;

import com.example.autoraidrpg.R;
import com.example.autoraidrpg.gameplay.bag.Item;

public class WildHeart extends Item {

    public WildHeart() {
        super("wild heart", R.drawable.item_wild_heart, 100);
        this.hp += 175;

        // description
        this.description.add("+" + this.hp + " health.");

        // long description
        this.description.add("valuable item that provides the wearer with increased health and healing abilities. The necklace may grant a bonus to the wearer's maximum health points or provide passive health regeneration, allowing them to recover from injuries more quickly in combat. Additionally, the heart necklace may provide the wearer with healing abilities, such as the ability to cast a healing spell or to consume a health potion at a reduced cost. The heart necklace is especially useful for characters who act as healers or tanks, as it enables them to withstand more damage and support their allies in combat. However, the wearer must be careful not to become overconfident, as the heart necklace does not provide invincibility and the wearer can still be defeated with sufficient force or tactics. As a result, the heart necklace should be used in conjunction with other defensive and supportive abilities to ensure the wearer's success in combat.");
    }
    
    
}
