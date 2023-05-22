package com.example.autoraidrpg.gameplay.bag.items;

import com.example.autoraidrpg.R;
import com.example.autoraidrpg.gameplay.bag.Item;

public class AssassinFinestBlade extends Item {

    public AssassinFinestBlade() {
        super("assassin finest blade", R.drawable.item_assassin_finest_blade, 150);
        this.phyDmg += 4;
        this.critChance += 5;

        // description
        this.description.add("+" + this.phyDmg + " physical damage.");
        this.description.add("+" + this.critChance + "% critical chance.");

        // long description
        this.description.add("Assassin Finest Blade is a rare and deadly weapon that possesses the power to take down the toughest of enemies. When wielded in combat, it grants the user exceptional agility and precision, making it easier to hit and dodge attacks. The blade is imbued with dark magic that enables it to deal critical damage and bypass armor. Additionally, the blade's hilt is designed to reduce the weight of the weapon, allowing the user to move with greater speed and fluidity in combat. However, the blade's dark magic comes at a cost - prolonged use can drain the user's energy and cause them to become fatigued. Only the most skilled and experienced assassins can handle the power of the Finest Blade.");
    }
    
}
