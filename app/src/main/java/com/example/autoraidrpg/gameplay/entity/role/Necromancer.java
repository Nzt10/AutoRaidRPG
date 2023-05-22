package com.example.autoraidrpg.gameplay.entity.role;

import com.example.autoraidrpg.R;
import com.example.autoraidrpg.gameplay.entity.Entity;

public class Necromancer extends Entity {

    public Necromancer() {
        super("necromancer", R.drawable.role_necromancer, 250, 75);

        /*-----------------------------
         * based incremental stats
         * health :             7.5
         -----------------------------*/
        this.aHp += 21;
        initStats();

        this.description = "In a dark and twisted land, where the dead never truly rest, there lived a powerful necromancer named Malakai. Malakai was feared and reviled by all who knew of him, for he had the power to summon the dead and bend them to his will. Malakai was a master of dark magic, having learned the secrets of the necromancer's art from his father, who had been a powerful sorcerer before him. Malakai's power grew with each passing day, and he soon became known as the most feared necromancer in the land.\n\nOne day, a group of adventurers came to Malakai seeking his help. They had heard of his powers and hoped that he could aid them in their quest to defeat a powerful demon that had taken up residence in a nearby castle. Malakai agreed to help the adventurers, but his price was steep. He demanded that they bring him the heart of a dragon, the rarest and most valuable of all treasures.\n\nThe adventurers set out on their quest, and after many trials and tribulations, they returned with the dragon's heart. Malakai used the heart in a dark and terrible ritual, summoning forth the spirits of the dead and binding them to his will. With an army of the undead at his command, Malakai marched upon the demon's castle, leading the charge against the dark lord. The battle was long and bloody, but in the end, Malakai emerged victorious, having vanquished the demon and secured his place as the most feared necromancer in the land.";
    }
    
}
