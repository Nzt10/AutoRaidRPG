package com.example.autoraidrpg.gameplay.entity.role;

import com.example.autoraidrpg.R;
import com.example.autoraidrpg.gameplay.entity.Entity;

public class Berserker extends Entity {

    public Berserker() {
        super("berserker", R.drawable.role_berserker, 500, 200);

        /*-----------------------------
         * based incremental stats
         * health :             7.5
         * physical damage :    0.45
         -----------------------------*/
        this.aHp += 7.5;
        this.aPhyDmg += 0.45;
        initStats();

        this.description = "In ancient Norse mythology, there was a legendary warrior known as a Berserker. The Berserkers were a fearsome group of warriors known for their battle frenzy and incredible strength. One particular Berserker, named Erik, was the most renowned of all. Erik was said to be the most powerful and ferocious of all the Berserkers, and his fame spread far and wide. Erik was feared by all who knew of him, and his enemies trembled at the thought of facing him in battle. He was a giant of a man, with rippling muscles and a fierce expression on his face. He wore a bear-skin cloak and carried a massive battle axe, which he wielded with deadly accuracy.\n\nDuring one battle, Erik's fellow warriors watched in amazement as he became consumed by a wild frenzy. His eyes rolled back in his head, and he let out a blood-curdling scream as he charged into the fray, his axe swinging wildly. The enemy soldiers were no match for Erik in his Berserker state, and he cut them down with ease. His own comrades were wary of getting too close, for fear that they too would fall victim to his frenzied attacks. When the battle was over, Erik was left standing amid a pile of bodies, panting and covered in blood. He had lost all control during his frenzy, and the Berserker rage had taken over completely.\n\nDespite his fearsome reputation, Erik was plagued by a sense of guilt and shame for the atrocities he had committed in battle. He sought to find a way to control his Berserker rage and harness its power for good. Erik eventually found a wise old hermit who taught him to channel his rage into a controlled frenzy, giving him the strength and speed of the Berserker without losing his mind to the madness. With this newfound power, Erik became a true force to be reckoned with, feared by his enemies and revered by his fellow warriors.";
    }
    
}
