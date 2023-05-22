package com.example.autoraidrpg.sample_objects;

import java.io.Serializable;

public class SampleRole implements Serializable {

    private String name, description;
    private int roleImage;

    public SampleRole(String name, int roleImage, String description) {
        this.name = name;
        this.roleImage = roleImage;
        this.description = description;
    }

    public String getName() { return name; }
    public int getRoleImage() { return roleImage; }
    public String getDescription() { return description; }

}
