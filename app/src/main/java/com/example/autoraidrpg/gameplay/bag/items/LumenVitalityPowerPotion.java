package com.example.autoraidrpg.gameplay.bag.items;

import com.example.autoraidrpg.R;
import com.example.autoraidrpg.gameplay.bag.Item;

public class LumenVitalityPowerPotion extends Item {

    public LumenVitalityPowerPotion() {
        super("lumen vitality power potion", R.drawable.item_lumen_vitality_power_potion, 125);
        this.hp += 100;
        this.spd += 2.75;

        // description
        this.description.add("+" + this.hp + " health.");
        this.description.add("+" + this.spd + " speed.");

        // long description
        this.description.add("a type of consumable item that temporarily increases the user's health and overall physical endurance. Upon consumption, the potion grants an immediate boost to the user's health points, allowing them to withstand more damage in combat or strenuous activity. In addition, the potion increases the user's stamina and reduces fatigue, enabling them to perform physical tasks for longer periods of time. The effects of the potion last for a limited time, after which the user's health and stamina return to their previous levels. Vitality potions are highly valued by adventurers, warriors, and anyone who needs to stay physically active for prolonged periods, and can be a lifesaver in the midst of battle or a physically demanding quest.");
    }
    
}
