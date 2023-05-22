package com.example.autoraidrpg.gameplay.entity.role;

import com.example.autoraidrpg.R;
import com.example.autoraidrpg.gameplay.entity.Entity;

public class Spearman extends Entity {

    public Spearman() {
        super("spearman", R.drawable.role_spearman, 500, 200);

        /*-----------------------------
         * based incremental stats
         * physical damage :    4.5
         * physical defense :   0.2
         * magical defense :    0.2
         -----------------------------*/
        this.aPhyDmg += 4.5;
        this.aPhyDef += 0.2;
        this.aMagDef += 0.2;
        initStats();

        this.description = "In a kingdom torn by war, there lived a brave and skilled spearman named Leon. Leon had been trained from a young age in the art of combat, and he had proven himself time and time again on the battlefield. Leon was known for his deadly accuracy with the spear, which he could wield with great speed and precision. He had a reputation as a fierce and relentless warrior, feared by all who faced him in battle.\n\nOne day, the kingdom was invaded by a neighboring army, led by a powerful and ruthless general. The king's army was outnumbered and outmatched, and it seemed that all was lost. But Leon refused to give up. He rallied his fellow soldiers, inspiring them with his bravery and his unwavering determination. Together, they stood firm against the enemy, fighting with all their might to defend their homeland.\n\nIn the midst of the battle, Leon spotted the enemy general, a towering figure who was laying waste to the king's army. With a fierce battle cry, Leon charged forward, his spear at the ready. The two warriors clashed in a fierce battle, their weapons flashing in the sun. But in the end, it was Leon who emerged victorious, his spear striking true and felling the enemy general. The victory was a turning point in the war, and Leon became a hero in the eyes of his fellow soldiers and the people of the kingdom. He continued to fight for his homeland, always leading the charge and inspiring others to follow his example.";
    }
    
}
