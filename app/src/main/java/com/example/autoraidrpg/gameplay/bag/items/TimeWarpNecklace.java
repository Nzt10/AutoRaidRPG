package com.example.autoraidrpg.gameplay.bag.items;

import com.example.autoraidrpg.R;
import com.example.autoraidrpg.gameplay.bag.Item;

public class TimeWarpNecklace extends Item {

    public TimeWarpNecklace() {
        super("time warp necklace", R.drawable.item_time_warp_necklace, 100);
        this.spd += 5;

        // description
        this.description.add("+" + this.spd + " speed.");

        // long description
        this.description.add("enhances the wearer's speed and agility. The necklace may provide a boost to the wearer's dexterity or reflexes, allowing them to dodge attacks more easily or move more quickly in combat. Additionally, the necklace may provide a bonus to the wearer's initiative or attack speed, allowing them to strike first in battle or unleash a flurry of attacks. The speed necklace is especially useful for characters who rely on mobility and agility in combat, such as archers or rogues. However, the wearer must be careful not to overexert themselves, as the speed necklace may cause fatigue or even physical damage if used for too long. As a result, the use of a speed necklace should be balanced with other defensive and offensive tactics to ensure the wearer's survival.");
    }
    
}
