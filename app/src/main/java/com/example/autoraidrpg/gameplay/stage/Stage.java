package com.example.autoraidrpg.gameplay.stage;

import com.example.autoraidrpg.gameplay.entity.Entity;
import com.example.autoraidrpg.gameplay.entity.role.RoleFactory;
import com.example.autoraidrpg.gameplay.global.StageState;

import java.util.ArrayList;
import java.util.List;

public class Stage {

    private int level, stageImage;
    private StageState state;
    private String description;
    private List<Entity> entities;
    private List<Position> positions;
    private Reward reward;

    public Stage() {}

    public Stage(int level, int stageImage, String description, int coin, int exp, int diamond) {
        this.level = level;
        this.stageImage = stageImage;
        this.description = description;
        entities = new ArrayList<>();
        positions = new ArrayList<>();
        reward = new Reward(coin, exp, diamond);
    }

    public void setState(StageState state) {
        this.state = state;
    }

    // add units and skills
    public Stage addUnit(String roleName, int roleLevel, int rating, int[] skillLevels, boolean front, int index) {
        Entity newEntity = RoleFactory.makeRole(roleName).setLevel(roleLevel).setRating(rating);

        for(int i = 0; i < skillLevels.length; i++) {
            newEntity.getSkillManager().getSkills().get(i).setLevel(skillLevels[i]);
        }

        entities.add(newEntity);
        positions.add(new Position(front, index));

        return this;
    }

    public int getLevel() { return level; }
    public int getStageImage() { return stageImage; }
    public String getDescription() { return description; }
    public List<Entity> getHostiles() { return entities; }
    public List<Position> getPositions() { return positions; }
    public Reward getReward() { return reward; }

    // unit position
    public class Position {

        private boolean front;
        private int index;

        public Position(boolean front, int index) {
            this.front = front;
            this.index = index;
        }

        public boolean isFront() { return front; }
        public int getIndex() { return index; }

        @Override
        public String toString() {
            return "Position{" +
                    "front=" + front +
                    ", index=" + index +
                    '}';
        }

    }

    // stage reward
    public static class Reward {

        private int coin, exp, diamond;

        public Reward(int coin, int exp, int diamond) {
            this.coin = coin;
            this.exp = exp;
            this.diamond = diamond;
        }

        public int getCoin() { return coin; }
        public int getExp() { return exp; }
        public int getDiamond() { return diamond; }

        public int getHalfCoin() {
            this.coin /= 2;
            return coin;
        }

        public int getHalfExp() {
            this.exp /= 2;
            return exp;
        }

        @Override
        public String toString() {
            return "Reward{" +
                    "coin=" + coin +
                    ", diamond=" + diamond +
                    '}';
        }

    }

    public StageState getState() {
        return state;
    }

    @Override
    public String toString() {
        return "Stage{" +
                "level=" + level +
                ", stageImage=" + stageImage +
                ", description='" + description + '\'' +
                ", entities=" + entities +
                ", positions=" + positions +
                ", reward=" + reward +
                '}';
    }

}
