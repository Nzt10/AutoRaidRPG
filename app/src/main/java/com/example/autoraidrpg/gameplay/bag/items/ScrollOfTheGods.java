package com.example.autoraidrpg.gameplay.bag.items;

import com.example.autoraidrpg.R;
import com.example.autoraidrpg.gameplay.bag.Item;

public class ScrollOfTheGods extends Item {

    public ScrollOfTheGods() {
        super("scroll of the gods", R.drawable.item_scroll_of_the_gods, 125);
        this.phyDef += 6;
        this.magDef += 6;

        // description
        this.description.add("+" + this.phyDef + " physical defense.");
        this.description.add("+" + this.magDef + " magical defense.");

        // long description
        this.description.add("the Scroll of the Gods is a powerful magical artifact that enhances the abilities of the user. When used, it increases the user's magical power and grants them temporary invincibility. The user becomes immune to all forms of damage, and their attacks deal increased damage. Additionally, the Scroll of the Gods has the power to dispel magical effects and barriers, making it a useful tool in combat against spellcasters. However, the power of the scroll is not without its drawbacks, as the user is left weakened and vulnerable once its effects wear off. The scroll must be used with caution, as overuse or misuse can have dire consequences.");
    }
    
}
