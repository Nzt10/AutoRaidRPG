package com.example.autoraidrpg.gameplay.entity.role;

import com.example.autoraidrpg.R;
import com.example.autoraidrpg.gameplay.entity.Entity;

public class Blacksmith extends Entity {

    public Blacksmith() {
        super("blacksmith", R.drawable.role_blacksmith, 500, 200);

        /*-----------------------------
         * based incremental stats
         * health :             6.5
         * physical defense :   0.25
         * magical defense :    1
         -----------------------------*/
        this.aHp += 6.5;
        this.aPhyDef += 0.25;
        this.aMagDef += 1;
        initStats();

        this.description = "In a small village, nestled in the heart of the countryside, there lived a blacksmith named Marcus. He was the most skilled and sought-after blacksmith in the region, known for his fine craftsmanship and attention to detail. From a young age, Marcus had a passion for metalworking, and he spent countless hours perfecting his skills. He learned the art of forging from his father, who was also a blacksmith, and as he grew older, he developed his own unique style.\n\nOne day, a wealthy merchant came to Marcus with a special request. He wanted Marcus to forge a sword unlike any other, one that would be the envy of every warrior in the land. The merchant promised to pay Marcus a fortune for his work, and Marcus eagerly accepted the challenge. For weeks, Marcus worked tirelessly in his forge, carefully crafting the sword with every strike of his hammer. He poured all of his skill and passion into the project, determined to create a work of art that would stand the test of time. When the sword was finally finished, Marcus presented it to the merchant, who was in awe of its beauty and craftsmanship. He paid Marcus the agreed-upon fee, and the sword became the talk of the town.\n\nFrom that day on, Marcus's reputation as a blacksmith grew even greater. He continued to take on new projects, each one more challenging than the last, and his skill only continued to improve with each passing day. He became known as the best blacksmith in the land, a true master of his craft, and his legacy lived on long after he was gone.";
    }
    
}
