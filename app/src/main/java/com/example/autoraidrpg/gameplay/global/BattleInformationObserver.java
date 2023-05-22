package com.example.autoraidrpg.gameplay.global;

import com.example.autoraidrpg.gameplay.subject.BattleSubject;

public class BattleInformationObserver {

    private static BattleSubject battleSubject = null;

    private BattleInformationObserver() {}

    public static BattleSubject getInstance() {
        if(battleSubject == null)
            battleSubject = new BattleSubject();

        return battleSubject;
    }
    
}
