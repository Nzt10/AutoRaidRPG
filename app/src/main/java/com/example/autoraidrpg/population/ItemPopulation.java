package com.example.autoraidrpg.population;

import android.database.sqlite.SQLiteOpenHelper;

import com.example.autoraidrpg.database.dao.local.InventoryLocalDAO;
import com.example.autoraidrpg.database.dao.local.ItemLocalDAO;
import com.example.autoraidrpg.gameplay.bag.Item;
import com.example.autoraidrpg.gameplay.bag.ItemFactory;
import com.example.autoraidrpg.model.Inventory;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class ItemPopulation {

    private final static String[] ITEM_NAMES = {
            "book of the arcane mage",
            "shinning sword of the legend",
            "sacred diamond necklace",
            "time warp necklace",
            "wild heart",
            "blue ginseng root",
            "frozen hammer of the gods",
            "night hunter",
            "space scroll",
            "lumen vitality power potion",
            "horror scythe",
            "enchanted hunter trap",
            "immortal thunder axe",
            "assassin finest blade",
            "berserk axe",
            "marksman sanction gun",
            "scroll of the gods",
            "the giant"
    };

    public static void generate(SQLiteOpenHelper dbHelper) {
        if(ItemLocalDAO.getCount(dbHelper) == 0) {
            Arrays.asList(ITEM_NAMES).stream().forEach(itemName -> {
                com.example.autoraidrpg.model.Item item = new com.example.autoraidrpg.model.Item(-1, itemName);
                ItemLocalDAO.store(dbHelper, item);
            });
        }
    }

    public static void seed(SQLiteOpenHelper dbHelper, int userID) {
        Inventory inventory1 = new Inventory(-1, userID, 1, 1);
        Inventory inventory2 = new Inventory(-1, userID, 2, 1);
        Inventory inventory3 = new Inventory(-1, userID, 3, 1);
        Inventory inventory4 = new Inventory(-1, userID, 4, 1);

        InventoryLocalDAO.store(dbHelper, inventory1);
        InventoryLocalDAO.store(dbHelper, inventory2);
        InventoryLocalDAO.store(dbHelper, inventory3);
        InventoryLocalDAO.store(dbHelper, inventory4);
    }

    public static void itemCollection(List<com.example.autoraidrpg.model.Item> storedItems, List<Item> items) {
        storedItems.stream().forEach(i -> items.add(ItemFactory.makeItem(i.getName())));
    }

    public static void itemCollection(List<com.example.autoraidrpg.model.Item> storedItems, List<Item> items, List<Inventory> inventories) {
        AtomicInteger index = new AtomicInteger(0);
        storedItems.stream().forEach(storedItem -> {
            items.add(ItemFactory.makeItem(storedItem.getName()).setInventoryID(
                    inventories.get(index.getAndIncrement()).getId()
            ));
        });
    }

}
