package com.example.autoraidrpg.gameplay.entity.role;

import com.example.autoraidrpg.R;
import com.example.autoraidrpg.gameplay.entity.Entity;

public class Shaman extends Entity {

    public Shaman() {
        super("shaman", R.drawable.role_shaman, 250, 75);

        /*-----------------------------
         * based incremental stats
         * health :             4.5
         * magical defense :    0.85
         -----------------------------*/
        this.aHp += 4.5;
        this.aMagDef += 0.85;
        initStats();

        this.description = "In a far-off land, nestled in the heart of a dense jungle, there lived a shaman named Kaya. Kaya was the most powerful and respected shaman in the region, known for her wisdom and her ability to communicate with the spirits of the forest. Kaya was born with the gift of second sight, and from a young age, she was trained in the ways of the shaman. She learned to speak the language of the animals, to read the signs of nature, and to call upon the spirits for guidance and protection.\n\nAs the years went by, Kaya became known as a healer and a protector, using her knowledge of herbs and her connection to the spirits to help those in need. People came to her from all over the region, seeking her advice and her blessings. One day, a terrible illness swept through the village, leaving many in its wake. The people were desperate for a cure, and they turned to Kaya for help. Kaya knew that the illness was the work of an evil spirit, and she set out to find it.\n\nFor three days and three nights, Kaya journeyed deep into the jungle, calling out to the spirits for guidance. On the fourth day, she came upon a dark and twisted grove, where she found the spirit hiding. With her knowledge of magic and her connection to the spirits, Kaya battled the evil spirit, using all her power to drive it away. When the battle was over, the illness lifted, and the people of the village were cured. From that day on, Kaya's reputation as a shaman grew even greater. She continued to heal and protect her people, and her legacy lived on long after she was gone. To this day, the people of the region tell stories of Kaya, the greatest shaman who ever lived.";
    }
    
}
