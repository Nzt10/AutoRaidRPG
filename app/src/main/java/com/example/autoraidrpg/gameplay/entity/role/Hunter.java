package com.example.autoraidrpg.gameplay.entity.role;

import com.example.autoraidrpg.R;
import com.example.autoraidrpg.gameplay.entity.Entity;

public class Hunter extends Entity {

    public Hunter() {
        super("hunter", R.drawable.role_hunter, 175, 45);

        /*-----------------------------
         * based incremental stats
         * physical damage :    2
         * armen penetration :  10% // INITIAL STATS
         -----------------------------*/
        this.aPhyDmg += 2;
        this.armPen += 10;
        initStats();

        this.description = "Jared grew up in a small village deep in the forest, where his father and grandfather taught him how to hunt and survive in the wilderness. As a young man, Jared's skills with a bow and arrow were unmatched, and he quickly became known as the best hunter in the region. But when a pack of vicious wolves began attacking the village and killing the livestock, Jared's skills were put to the test like never before. He knew that he had to stop the wolves before they killed any of the villagers, and he set out into the forest with his bow and a fierce determination. Jared tracked the wolves for days, always one step behind them but never losing sight of his quarry. He had to be stealthy and quick, always watching his back for any sign of danger.\n\nIn the end, Jared finally caught up with the wolves in a narrow ravine, where they had cornered a herd of deer. He could see the wolves circling the terrified animals, ready to pounce at any moment. With lightning-fast reflexes, Jared drew his bow and let fly a single arrow. It flew straight and true, hitting the lead wolf in the eye and dropping it dead instantly. The other wolves fled, and Jared knew that he had saved the village from disaster. From that day on, Jared was hailed as a hero in the village. He continued to hunt and protect the people of the forest, using his skills to keep them safe from all manner of threats.\n\nYears later, when he was an old man, Jared told the story of his great hunt to his grandchildren, passing down his knowledge and experience to the next generation. And his legend lived on, inspiring others to take up the mantle of the hunter and protect the wild places of the world.";
    }
    
}
