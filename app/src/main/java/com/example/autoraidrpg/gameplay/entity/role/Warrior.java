package com.example.autoraidrpg.gameplay.entity.role;

import com.example.autoraidrpg.R;
import com.example.autoraidrpg.gameplay.entity.Entity;

public class Warrior extends Entity {

    public Warrior() {
        super("warrior", R.drawable.role_warrior, 100, 25);

        /*-----------------------------
         * based incremental stats
         * health :             4.5
         * physical damage :    0.4
         * physical defense :   0.2
         * magical defense :    0.1
         * critical damage :    5%
         -----------------------------*/
        this.aHp += 4.5;
        this.aPhyDmg += 0.4;
        this.aPhyDef += 0.2;
        this.aMagDef += 0.1;
        this.aCritDmg += 5;
        initStats();

        this.description = "Born into a family of warriors, Jack was trained in combat from a young age. He grew up in a society where strength and valor were highly prized, and he was determined to prove himself worthy of his family's legacy. When Jack was just a teenager, his village was attacked by an enemy tribe. He fought valiantly alongside his family and fellow warriors, but in the end, they were overwhelmed and forced to retreat. This defeat only strengthened Jack's resolve to become a better warrior.\n\nOver the years, Jack honed his skills through rigorous training and countless battles. He became known for his bravery and tactical expertise, and his reputation as a fearsome warrior spread far and wide. Eventually, Jack's prowess caught the attention of the king, who recruited him to join his elite guard. Jack served the king with distinction, leading his troops to numerous victories and earning the respect of all who fought alongside him. Even in his later years, Jack remained a fierce and respected warrior, always ready to take up his sword and defend his kingdom against any threat. His legacy as a great warrior lived on long after his passing, inspiring generations of young warriors to follow in his footsteps.";
    }
    
}
