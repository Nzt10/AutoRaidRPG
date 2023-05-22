package com.example.autoraidrpg.gameplay.entity.role;

import com.example.autoraidrpg.R;
import com.example.autoraidrpg.gameplay.entity.Entity;

public class Mage extends Entity {

    public Mage() {
        super("mage", R.drawable.role_mage, 160, 40);

        /*-----------------------------
         * based incremental stats
         * magical damage :     3.75
         * magical defense :    0.2
         * magic penetration :  0.3%
         -----------------------------*/
        this.aMagDmg += 3.75;
        this.aMagDef += 0.2;
        this.aMagPen += 0.3;
        initStats();

        this.description = "As a child, Elizabeth was always fascinated by the power of magic. She spent her days poring over ancient tomes and practicing her spells, dreaming of one day becoming a great mage. When she came of age, Elizabeth left her small village and journeyed to the city to seek out a master mage who could train her in the ways of magic. She found a renowned wizard named Arcturus, who saw great potential in the young woman and took her on as his apprentice. Under Arcturus' tutelage, Elizabeth learned to wield the power of magic with incredible precision and control. She quickly proved herself to be a prodigious talent, mastering even the most complex spells with ease.\n\nBut Elizabeth's true test came when the kingdom was threatened by a powerful sorcerer who sought to conquer the land with an army of dark creatures. Elizabeth and Arcturus joined the king's forces, using their magical abilities to repel the invaders and push them back into their own territory. As the battle raged on, Elizabeth found herself facing the sorcerer himself, a powerful and formidable foe. But with her extensive training and skill, Elizabeth was able to hold her own against the dark wizard, ultimately defeating him and driving his forces out of the kingdom. For her bravery and skill, Elizabeth was hailed as a hero and granted a place of honor in the royal court. She continued to serve the kingdom as a mage for many years, using her powers to defend the land against any threat.\n\nIn her old age, Elizabeth became a revered figure in the kingdom, a symbol of the power of magic and the strength of the human spirit. Her legacy as a master mage and hero lived on long after her passing, inspiring future generations to take up the study of magic and use their powers to protect and defend their homes and loved ones.";
    }
    
}
