package com.example.autoraidrpg.gameplay.entity.role;

import com.example.autoraidrpg.R;
import com.example.autoraidrpg.gameplay.entity.Entity;

public class Cleric extends Entity {

    public Cleric() {
        super("cleric", R.drawable.role_cleric, 200, 50);

        /*-----------------------------
         * based incremental stats
         * magical damage :     2.25
         * magical defense :    1.2
         * speed :              0.15
         -----------------------------*/
        this.aMagDmg += 2.25;
        this.aMagDef += 1.2;
        this.aSpd += 0.15;
        initStats();

        this.description = "As a young acolyte, Maria dedicated herself to the worship of her deity and the study of the sacred texts. She showed a great talent for healing and quickly rose through the ranks of the priesthood, becoming a full-fledged cleric at a young age. Maria's true test came when a terrible plague swept through the land, killing thousands and leaving countless more sick and suffering. She was called upon to use her healing powers to aid the afflicted, and she threw herself into the task with unbridled dedication and skill. Day and night, Maria worked tirelessly to tend to the sick and dying, using her divine powers to bring comfort and relief to those in pain. Her work earned her the respect and admiration of all who knew her, and she soon became known as a beacon of hope in the darkest of times.\n\nBut Maria's work was far from over. She realized that the true cause of the plague was a dark and powerful force, working behind the scenes to spread chaos and death throughout the land. With the help of her fellow clerics, Maria began a quest to uncover the source of the plague and put an end to it once and for all. They traveled to the far reaches of the kingdom, braving danger and hardship at every turn, but always keeping faith in their deity and their cause.\n\nIn a final, climactic battle, Maria and her companions faced off against the dark force behind the plague. The battle was fierce and grueling, but in the end, Maria emerged victorious, banishing the darkness and restoring light to the land.For her bravery and service, Maria was hailed as a hero and a true servant of her deity. She continued to work as a cleric, using her powers to heal the sick and aid the needy, and her legacy as a beacon of hope and compassion lived on long after her passing.";
    }
    
}
