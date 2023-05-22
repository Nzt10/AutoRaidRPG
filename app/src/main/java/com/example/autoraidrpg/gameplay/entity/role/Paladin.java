package com.example.autoraidrpg.gameplay.entity.role;

import com.example.autoraidrpg.R;
import com.example.autoraidrpg.gameplay.entity.Entity;

public class Paladin extends Entity {

    public Paladin() {
        super("paladin", R.drawable.role_paladin, 250, 75);

        /*-----------------------------
         * based incremental stats
         * health :             5
         -----------------------------*/
        this.aHp += 5;
        initStats();

        this.description = "In a land wracked by darkness and evil, there lived a paladin named Sir Cedric. Cedric was a holy warrior, devoted to the goddess of light and the protection of the innocent. He had trained for years in the arts of war and magic, mastering the sword and the spells that would aid him in his quest. Cedric had been sent by his order to defeat an evil sorcerer who had been terrorizing the land. The sorcerer had summoned dark forces from beyond the realm of the living, unleashing an army of demons and undead upon the innocent people. Cedric journeyed to the sorcerer's lair, where he faced many trials and tribulations. He battled demons and undead, overcame treacherous traps and illusions, and faced the sorcerer's powerful spells and minions. But Cedric's faith never wavered, and he continued to fight on, relying on his strength, his courage, and his holy powers to aid him in his quest. With his sword and his spells, he finally confronted the sorcerer in a fierce battle.\n\nThe sorcerer was a powerful foe, but Cedric's faith proved stronger. He called upon the power of his goddess, channeling her light through his sword and striking down the sorcerer with a mighty blow. With the sorcerer defeated, the land was freed from his dark influence. Cedric had saved the innocent people from certain doom, and he was hailed as a hero by all who knew of him. He continued to serve his goddess and protect the people, always ready to face whatever darkness lay ahead.";
    }
    
}
