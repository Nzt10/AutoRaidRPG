package com.example.autoraidrpg.utils;

import com.example.autoraidrpg.gameplay.entity.Entity;

import java.util.Comparator;
import java.util.List;

public class OrderUtils {

    public static void sortByNames(List<Entity> entities) {
        entities.sort(Comparator.comparing(Entity::getName));
    }

}
