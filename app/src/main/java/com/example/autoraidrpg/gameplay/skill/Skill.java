package com.example.autoraidrpg.gameplay.skill;

import com.example.autoraidrpg.gameplay.proxy.Discount;
import com.example.autoraidrpg.gameplay.buff.Buff;
import com.example.autoraidrpg.gameplay.entity.Entity;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public abstract class Skill implements Discount {

    public static final double ORIGINAL_PRICE = 100;

    protected String name;
    protected List<String> description;
    protected List<Buff> buffs;
    protected int itemImage, level, cooldown, turn = 0;
    protected SkillType type;
    
    // set condition for conditional passive skills
    protected Predicate<Entity> conditioning;

    // set extra moves
    protected Consumer<Entity> extra;

    public Skill(String name, int itemImage, SkillType type, List<String> description) {
        this.name = name;
        this.type = type;
        this.itemImage = itemImage;
        this.description = description;
        buffs = new ArrayList<>();
        level = 1;
    }

    public void decrementCooldown() { turn--; }
    public void incrementCooldown() { turn++; }
    public void levelUp() { level++; }
    public void setLevel(int level) { this.level = level; }
    
    public abstract void activate(Entity entity);
    public abstract void activateToAll(List<Entity> entities);

    public String getName() { return name; }
    public int getItemImage() { return itemImage; }
    public SkillType getSkillType() { return type; }
    public int getLevel() { return level; }
    public List<String> getDescription() { return description; }
    public boolean isReadyToActivate() { return turn <= 0; }

    public boolean isApplicable(Entity entity) { return (conditioning != null) ? conditioning.test(entity) : true; }

}
