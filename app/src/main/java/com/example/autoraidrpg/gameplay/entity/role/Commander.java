package com.example.autoraidrpg.gameplay.entity.role;

import com.example.autoraidrpg.R;
import com.example.autoraidrpg.gameplay.entity.Entity;

public class Commander extends Entity {

    public Commander() {
        super("commander", R.drawable.role_commander, 125, 30);

        /*-----------------------------
         * based incremental stats
         * speed :              0.25
         -----------------------------*/
        this.aSpd += 0.25;
        initStats();

        this.description = "As a young soldier, John always showed great leadership potential. He had a keen tactical mind and a natural talent for inspiring and motivating his fellow troops. Over the years, John rose through the ranks of the army, earning the respect and admiration of his superiors and peers alike. He quickly became known as one of the most skilled and effective commanders in the kingdom. John's true test came when the kingdom was threatened by a massive invasion force. He was appointed as the commander of the army, tasked with leading his troops into battle against the enemy.\n\nDespite being vastly outnumbered, John led his troops with incredible bravery and skill, using his tactical genius to outmaneuver and outflank the enemy at every turn. His troops rallied behind him, inspired by his courage and determination. As the battle raged on, John found himself facing the enemy commander in single combat. The two men clashed in a fierce and brutal fight, but in the end, John emerged victorious, delivering a crushing blow to the enemy\'s morale and turning the tide of the battle in the kingdom\'s favor. For his bravery and leadership, John was hailed as a hero and granted a place of honor in the royal court. He continued to serve the kingdom as a commander for many years, leading his troops to numerous victories and earning the respect and admiration of all who fought alongside him.\n\nEven in his old age, John remained a revered figure in the kingdom, a symbol of the power of leadership and the importance of inspiring and motivating others. His legacy as a great commander and hero lived on long after his passing, inspiring future generations of leaders to follow in his footsteps.";
    }
    
}
