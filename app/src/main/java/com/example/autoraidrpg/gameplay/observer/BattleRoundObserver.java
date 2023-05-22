package com.example.autoraidrpg.gameplay.observer;

import com.example.autoraidrpg.gameplay.subject.BattleSubject;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

public class BattleRoundObserver {

    private List<String> descriptions;
    private List<Integer> leftResources, rightResources;
    private int round;
    private BiConsumer<Integer, List<String>> textViewBiConsumer;
    
    public BattleRoundObserver(BattleSubject battleSubject) {
        descriptions = new ArrayList<>();
        leftResources = new ArrayList<>();
        rightResources = new ArrayList<>();
        battleSubject.attach(this);
        // descriptions.add("ROUND " + round + "---------------------");
    }

    public void setTextViewBiConsumer(BiConsumer<Integer, List<String>> textViewBiConsumer) {
        this.textViewBiConsumer = textViewBiConsumer;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public void addDescription(String description, int leftResource, int rightResource) {
        descriptions.add(description);
        leftResources.add(leftResource);
        rightResources.add(rightResource);
    }

    public int getRound() {
        return round;
    }

    public void update() {
        textViewBiConsumer.accept(round, descriptions);
        // descriptions.forEach(description -> Log.i("BATTLE RESULT", description));
    }

    public List<String> getDescription() {
        return descriptions;
    }

    public List<Integer> getLeftResources() {
        return leftResources;
    }

    public List<Integer> getRightResources() {
        return rightResources;
    }

}
