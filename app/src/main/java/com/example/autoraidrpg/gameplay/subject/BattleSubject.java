package com.example.autoraidrpg.gameplay.subject;

import com.example.autoraidrpg.gameplay.observer.BattleRoundObserver;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

public class BattleSubject {
    
    private List<BattleRoundObserver> roundObservers;
    private BattleRoundObserver currentObserver;
    private int round = 0;
    private BiConsumer<Integer, List<String>> textViewBiConsumer;

    public BattleSubject() {
        roundObservers = new ArrayList<>();
    }

    public void attach(BattleRoundObserver observer) {
        currentObserver = null;
        observer.setRound(round);
        roundObservers.add(observer);
        currentObserver = observer;
        currentObserver.setTextViewBiConsumer(textViewBiConsumer);
        round++;
    }

    public BattleSubject setTextViewBiConsumer(BiConsumer<Integer, List<String>> textViewBiConsumer) {
        this.textViewBiConsumer = textViewBiConsumer;
        return this;
    }

    public BattleRoundObserver getCurrentObserver() {
        return currentObserver;
    }

    public void notifyObserver() {
        currentObserver.update();
    }

    public void notifyAllObserver() { roundObservers.forEach(observer -> observer.update()); }

    public List<BattleRoundObserver> getObservers() { return roundObservers; }

    public void clearAll() {
        round = 0;
        roundObservers.clear();
    }

}
