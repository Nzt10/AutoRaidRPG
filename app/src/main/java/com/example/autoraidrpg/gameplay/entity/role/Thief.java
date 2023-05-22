package com.example.autoraidrpg.gameplay.entity.role;

import com.example.autoraidrpg.R;
import com.example.autoraidrpg.gameplay.entity.Entity;

public class Thief extends Entity {

    public Thief() {
        super("thief", R.drawable.role_thief, 160, 40);
        
        /*-----------------------------
         * based incremental stats
         * speed :              0.15
         -----------------------------*/
        this.aSpd += 0.15;
        initStats();

        this.description = "Once upon a time in medieval Europe, there was a notorious thief named William. He was known throughout the land for his daring heists and clever tactics. He lived by his wits and his skills, relying on his agility and quick thinking to evade capture. One day, William decided to steal from the richest man in the town, Lord Robert. He had heard that the Lord kept a treasure trove of jewels and gold in his castle, and William couldn't resist the temptation. Under the cover of night, William crept into the castle and made his way to the treasure room. He had managed to avoid the guards, but when he arrived at the treasure room, he found it guarded by a ferocious dog.\n\nThinking quickly, William found a bone and tossed it to the dog, distracting it long enough for him to slip past and grab a handful of jewels. However, the noise had alerted the guards, and they soon came rushing in. William raced through the castle, using his quick reflexes and knowledge of the layout to evade capture. He managed to escape with his loot, but the Lord was furious and put a bounty on his head. From that day on, William was known as the most daring thief in the land. He continued to pull off heists and evade the law, but he knew that he was always one step away from being caught. In the end, he realized that the life of a thief was not sustainable and retired, hoping to live out the rest of his days in peace.";
    }
    
}
