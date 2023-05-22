package com.example.autoraidrpg.gameplay.entity.role;

import com.example.autoraidrpg.R;
import com.example.autoraidrpg.gameplay.entity.Entity;

public class Knight extends Entity {

    public Knight() {
        super("knight", R.drawable.role_knight, 150, 35);

        /*-----------------------------
         * based incremental stats
         * health :             9
         * physical damage :    0.1
         * physical defense :   0.6
         * magical defense :    0.4
         -----------------------------*/
        this.aHp += 9;
        this.aPhyDmg += 0.1;
        this.aPhyDef += 0.6;
        this.aMagDef += 0.4;
        initStats();

        this.description = "Growing up, Thomas always admired the knights who roamed the countryside, protecting the innocent and upholding the law. He dreamed of one day becoming a knight himself, and spent hours practicing his swordsmanship and honing his combat skills. As he grew older, Thomas' passion for knighthood only intensified. He trained under the finest swordmasters in the kingdom, eventually earning his knighthood through feats of strength, bravery, and honor. Thomas quickly made a name for himself as one of the most skilled and respected knights in the land. He traveled the kingdom, righting wrongs and protecting the innocent, earning the admiration and gratitude of all who knew him.\n\nBut Thomas' true test came when the kingdom was threatened by a powerful and ruthless tyrant. The tyrant had amassed a huge army and was intent on seizing control of the land by force. Thomas joined the king's forces, leading his fellow knights into battle against the tyrant's armies. Despite being outnumbered and outmatched, Thomas and his comrades fought with incredible bravery and determination, holding their ground against the enemy's relentless onslaught. In a final, climactic battle, Thomas faced off against the tyrant in single combat. The two men clashed in a fierce and brutal fight, their swords ringing out across the battlefield.\n\nIn the end, Thomas emerged victorious, striking the final blow that toppled the tyrant's regime and freed the kingdom from his oppressive rule. For his bravery and service, Thomas was hailed as a hero and granted a place of honor in the royal court. He continued to serve the kingdom as a knight for many years, defending the innocent and upholding the law with honor and integrity. His legacy as a great knight and hero lived on long after his passing, inspiring future generations to follow in his footsteps.";
    }
    
}
