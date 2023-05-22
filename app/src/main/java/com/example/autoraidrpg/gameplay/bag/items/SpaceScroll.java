package com.example.autoraidrpg.gameplay.bag.items;

import com.example.autoraidrpg.R;
import com.example.autoraidrpg.gameplay.bag.Item;

public class SpaceScroll extends Item {

    public SpaceScroll() {
        super("space scroll", R.drawable.item_space_scroll, 125);
        this.magDmg += 6;
        this.spd += 2.75;

        // description
        this.description.add("+" + this.magDmg + " magical damage.");
        this.description.add("+" + this.spd + " speed.");

        // long description
        this.description.add("a magical item that when activated, creates a portal to a different location. The portal remains open for a short period, allowing the user and other nearby individuals to pass through. The destination of the portal can be chosen by the user, but the scroll must be attuned to the desired location beforehand. Once used, the Space Scroll needs to be recharged before it can be used again. This item can be useful for quickly traveling long distances or escaping dangerous situations. However, it is not without its risks, as the user may end up in an unfamiliar or dangerous location if they are not careful in choosing the destination of the portal.");
    }
    
}
