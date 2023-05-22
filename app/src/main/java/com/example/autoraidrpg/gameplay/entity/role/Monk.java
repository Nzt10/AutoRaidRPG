package com.example.autoraidrpg.gameplay.entity.role;

import com.example.autoraidrpg.R;
import com.example.autoraidrpg.gameplay.entity.Entity;

public class Monk extends Entity {

    public Monk() {
        super("monk", R.drawable.role_monk, 200, 50);
          
        /*-----------------------------
         * based incremental stats
         * health :             5
         * physical damage :    0.25
         * accuracy :           0.5%
         -----------------------------*/
        this.aHp += 5;
        this.aPhyDmg += 0.25;
        this.aAcc += 0.5;
        initStats();

        this.description = "In a secluded monastery high in the mountains, there lived a monk named Kian. Kian had devoted his life to the pursuit of enlightenment, meditating for hours each day and living a life of simplicity and discipline. Kian had joined the monastery as a young man, seeking a deeper understanding of the world and a way to escape the distractions of the outside world. He had spent many years in silent contemplation, learning the ways of the monk and striving for a greater understanding of the universe.\n\nOne day, a group of bandits invaded the monastery, seeking to steal its riches and terrorize its inhabitants. The other monks were unprepared for the attack, but Kian refused to stand idly by. With his years of training and discipline, Kian sprang into action, using his martial arts skills to fight off the bandits and protect his fellow monks. He moved with a fluid grace, striking his opponents with precise blows and avoiding their attacks with ease.\n\nDespite being vastly outnumbered, Kian was able to hold off the bandits long enough for the other monks to regroup and join the fight. Together, they were able to drive the invaders away, saving their monastery and preserving their way of life. Kian had shown that the ways of the monk were not just for personal enlightenment, but also for the greater good of all. He became a respected member of the monastery, admired for his martial prowess and his unwavering dedication to his fellow monks.";
    }
    
}
