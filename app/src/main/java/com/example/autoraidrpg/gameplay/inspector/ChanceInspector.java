package com.example.autoraidrpg.gameplay.inspector;

import com.example.autoraidrpg.R;
import com.example.autoraidrpg.gameplay.global.BattleInformationObserver;
import com.example.autoraidrpg.gameplay.subject.BattleSubject;

import java.util.Random;

public class ChanceInspector {

    private final double MAX_CHANCE = 100;
    private Random rand;
    private double dmg;

    // observers
    private BattleSubject battleSubject;

    public ChanceInspector() { 
        // set global observer
        battleSubject = BattleInformationObserver.getInstance();
        rand = new Random(); 
    }

    // critical damage probability
    public double crit(double rate, double critDmg) {
        double aCritDmg = dmg;

        if(chance(rate)) {
            aCritDmg = dmg + (dmg * (critDmg / 100));
            // update observer
            battleSubject.getCurrentObserver()
                .addDescription("This skill damage has a grevious hit!", R.drawable.icon_grevious, R.drawable.icon_grevious);
        }
        
        return aCritDmg;
    }

    // dodge probability
    public boolean evaded(double rate) {
        return chance(rate);
    }

    public ChanceInspector setDmg(double dmg) { this.dmg = dmg; return this; } // setting damage

    private boolean chance(double rate) { return rate >= rand.nextDouble() * MAX_CHANCE; } // probability check

}
