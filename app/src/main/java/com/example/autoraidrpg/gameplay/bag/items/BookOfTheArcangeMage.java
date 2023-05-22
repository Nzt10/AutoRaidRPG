package com.example.autoraidrpg.gameplay.bag.items;

import com.example.autoraidrpg.R;
import com.example.autoraidrpg.gameplay.bag.Item;

public class BookOfTheArcangeMage extends Item {

    public BookOfTheArcangeMage() {
        super("book of the arcane mage", R.drawable.item_book_of_the_arcane_mage, 100);
        this.magDmg += 10;

        // description
        this.description.add("+" + this.magDmg + " magical damage.");

        // long description
        this.description.add("new magical spells, allowing them to cast powerful and devastating attacks in combat. This can be especially useful for mage or wizard-type characters who rely on magic as their primary means of offense. However, reading certain mage books may also come with risks, such as attracting the attention of magical creatures or causing the character to become corrupted by dark magic. As a result, players must carefully consider the potential risks and rewards of using a mage book before deciding whether to use it or not.");
    }
    
}
