package com.example.autoraidrpg.gameplay.entity.role;

import com.example.autoraidrpg.R;
import com.example.autoraidrpg.gameplay.entity.Entity;

public class Assassin extends Entity {

    public Assassin() {
        super("assassin", R.drawable.role_assassin, 100, 25);

        /*-----------------------------
         * based incremental stats
         * physical damage :    0.5
         * speed :              0.2
         * critical chance :    0.25%
         * critical damage :    0.25%
         * dodge:               0.2%
         -----------------------------*/
        this.aPhyDmg += 0.5;
        this.aSpd += 0.2;
        this.aCritChance += 0.25;
        this.aCritDmg += 0.25;
        this.aDodge += 0.2;
        initStats();

        this.description = "As a child, Elena was trained in the art of assassination by her father, a notorious killer-for-hire. She learned to move like a shadow, to strike with deadly precision, and to always remain cool and composed, even in the most dangerous of situations. Elena quickly proved herself to be a prodigious talent, mastering even the most complex techniques and earning a reputation as one of the most skilled and effective assassins in the underworld. But as Elena grew older, she began to question the morality of her work. She saw the pain and suffering that her actions caused, and began to wonder if there was a better way to use her talents.\n\nEventually, Elena left the underworld and began using her skills to help those in need. She became a vigilante, targeting those who were preying on the innocent and taking them down with ruthless efficiency. But Elena's past eventually caught up with her. A powerful crime lord who had once hired her father to do his dirty work discovered her true identity and began hunting her down. Elena was forced to fight for her life, using all her training and skill to stay one step ahead of her pursuers. She traveled the world, using her vast network of contacts and allies to evade capture and continue her work.\n\nIn a final, climactic battle, Elena faced off against the crime lord himself. The two engaged in a fierce and brutal fight, with Elena using all her cunning and skill to overcome her foe. In the end, Elena emerged victorious, and the crime lord was brought to justice. For her bravery and service, Elena was hailed as a hero and a defender of the innocent, and her legacy as a skilled and effective assassin turned vigilante lived on long after her passing.";
    }
    
}
