package com.example.autoraidrpg.gameplay.entity.role;

import com.example.autoraidrpg.R;
import com.example.autoraidrpg.gameplay.entity.Entity;

public class Vampire extends Entity {

    public Vampire() {
        super("vampire", R.drawable.role_bloodsucker, 500, 200);

        /*-----------------------------
         * based incremental stats
         * health :             6
         * magical damage :     0.35
         -----------------------------*/
        this.aHp += 6;
        this.aMagDmg += 0.35;
        initStats();

        this.description = "In the darkness of the night, a lone vampire named Valeria roamed the streets. She was a creature of the shadows, feeding on the blood of the living to sustain her immortal life. Valeria had lived for centuries, moving from place to place, always searching for new prey. She had grown tired of her existence, feeling nothing but the emptiness of her cursed life. One night, Valeria met a young man named Gabriel, who she felt drawn to for reasons she could not explain. Gabriel was a kind and compassionate soul, and despite her vampire nature, Valeria found herself growing fond of him.\n\nIn the darkness of the night, a lone vampire named Valeria roamed the streets. She was a creature of the shadows, feeding on the blood of the living to sustain her immortal life. Valeria had lived for centuries, moving from place to place, always searching for new prey. She had grown tired of her existence, feeling nothing but the emptiness of her cursed life. One night, Valeria met a young man named Gabriel, who she felt drawn to for reasons she could not explain. Gabriel was a kind and compassionate soul, and despite her vampire nature, Valeria found herself growing fond of him.";
    }
    
}
