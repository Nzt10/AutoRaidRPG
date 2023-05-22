package com.example.autoraidrpg.adapter;

import java.io.Serializable;
import java.util.List;

// this will help to get only all the information about skill not all the object that is needed to be serialize
public class SkillInfoAdapter implements Serializable {

    private int image, level;
    private String name;
    private List<String> description;

    public SkillInfoAdapter(String name, int image, int level, List<String> description) {
        this.name = name;
        this.image = image;
        this.level = level;
        this.description = description;
    }

    public String getName() { return name; }
    public int getImage() { return image; }
    public int getLevel() { return level; }
    public List<String> getDescription() { return description; }

}
