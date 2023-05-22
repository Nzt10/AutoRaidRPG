package com.example.autoraidrpg.sample_objects;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SampleItem implements Serializable {

    private String name, stats, description;
    private int itemImage;

    public SampleItem(String name, int itemImage, String stats, String description) {
        this.name = name;
        this.itemImage = itemImage;
        this.stats = stats;
        this.description = description;
    }

    public String getName() { return name; }
    public int getItemImage() { return itemImage; }
    public String getStats() { return stats; }
    public String getDescription() { return description; }

}
