package com.example.autoraidrpg.gameplay.entity.role;

import com.example.autoraidrpg.R;
import com.example.autoraidrpg.gameplay.entity.Entity;

public class Marksman extends Entity {

    public Marksman() {
        super("marksman", R.drawable.role_marksman, 150, 35);

        /*-----------------------------
         * based incremental stats
         * physical damage :    1.3
         * magical damage :     0.25
         * speed :              0.05
         * armen penetration :  0.35%
         -----------------------------*/
        this.aPhyDmg += 1.3;
        this.aMagDmg += 0.25;
        this.aSpd += 0.05;
        this.aArmPen += 0.35;
        initStats();

        this.description = "As a young boy, David was fascinated with archery. He would spend hours practicing his aim and perfecting his technique, dreaming of becoming a master marksman. As he grew older, David's passion for archery only intensified. He began competing in local tournaments and quickly made a name for himself as a prodigious talent. His skills were put to the test when his village was attacked by a group of bandits. David picked up his bow and arrow and, with calm and precision, took down the attackers one by one. The village was saved, and David was hailed as a hero. News of David's heroism soon spread, and he was recruited to serve as a marksman in the king's army. He quickly rose through the ranks, becoming one of the most skilled and respected marksmen in the kingdom.\n\nDavid's exceptional skills were put to the test when the kingdom was threatened by a massive invasion force. He stood alongside his fellow soldiers on the front lines, raining arrows down on the enemy with deadly accuracy. Despite being vastly outnumbered, David and his comrades fought with incredible bravery and skill, ultimately repelling the invaders and saving the kingdom. For his bravery and skill, David was knighted by the king and given a place of honor in the royal court. He continued to serve the kingdom as a marksman for many years, training new recruits and leading his fellow soldiers into battle. Even in his old age, David remained a skilled marksman, always ready to pick up his bow and defend his kingdom against any threat. His legacy as a hero and a master marksman lived on long after his passing, inspiring future generations to take up the bow and follow in his footsteps.";
    }
    
}
