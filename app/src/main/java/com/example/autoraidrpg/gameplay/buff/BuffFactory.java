package com.example.autoraidrpg.gameplay.buff;

import com.example.autoraidrpg.gameplay.buff.inflictBuffs.Bleed;
import com.example.autoraidrpg.gameplay.buff.inflictBuffs.Burn;
import com.example.autoraidrpg.gameplay.buff.inflictBuffs.Ignite;
import com.example.autoraidrpg.gameplay.buff.inflictBuffs.Nightmare;
import com.example.autoraidrpg.gameplay.buff.inflictBuffs.Poison;
import com.example.autoraidrpg.gameplay.entity.Entity;
import com.example.autoraidrpg.gameplay.buff.unableBuffs.Bind;
import com.example.autoraidrpg.gameplay.buff.unableBuffs.Stun;

public class BuffFactory {

    public static Buff makeBuff(String buffName, double pDmg, Entity applyBy, int turn) {
        switch(buffName) {
            // inflict
            case "burn": return new Burn(pDmg, applyBy, turn);
            case "bleed": return new Bleed(pDmg, applyBy, turn);
            case "poison": return new Poison(pDmg, applyBy, turn);
            case "ignite": return new Ignite(pDmg, applyBy, turn);
            case "nightmare": return new Nightmare(pDmg, applyBy, turn);

            // unable
            case "stun": return new Stun(applyBy, turn);
            case "bind": return new Bind(applyBy, turn);
        }
        return null;
    }
    
}
