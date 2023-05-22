package com.example.autoraidrpg.gameplay.battle;

import com.example.autoraidrpg.gameplay.entity.Entity;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class SpeedGauge {
    
    private List<Entity> entities;
    private double maxSpeedMeter;
    private boolean isStopped;

    public SpeedGauge() {
        entities = new ArrayList<>();
    }

    public void add(Entity entity) {
        entities.add(entity);
    }

    public void init() {
        maxSpeedMeter = (entities.stream().map(e -> e.getSpd()).reduce((x, y) -> x + y).get() / entities.size()) * 10;
    }

    public void start() {
        isStopped = false;
    }

    public Queue<Entity> moveAndQueue() {
        Queue<Entity> readyEntities = new PriorityQueue<>();

        while(!isStopped) {
            isStopped = entities.stream().map(e -> {
                double speedMeter = e.getMove();

                if(speedMeter >= maxSpeedMeter) readyEntities.add(e);

                return speedMeter;
            }).anyMatch(speedMeter -> speedMeter >= maxSpeedMeter );
        }

        return readyEntities;
    }

    public double getMaxSpeedMeter() { return maxSpeedMeter; }

}
