package com.example.autoraidrpg.controller;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.autoraidrpg.IView;
import com.example.autoraidrpg.ItemDescriptionActivity;
import com.example.autoraidrpg.ItemSettingActivity;
import com.example.autoraidrpg.R;
import com.example.autoraidrpg.adapter.ItemCardAdapter;
import com.example.autoraidrpg.database.DatabaseHelper;
import com.example.autoraidrpg.database.dao.local.BagLocalDAO;
import com.example.autoraidrpg.database.dao.local.InventoryLocalDAO;
import com.example.autoraidrpg.database.dao.local.ItemLocalDAO;
import com.example.autoraidrpg.database.dao.local.RoleCollectionLocalDAO;
import com.example.autoraidrpg.executors.LoadImageTask;
import com.example.autoraidrpg.executors.SetImageTask;
import com.example.autoraidrpg.gameplay.bag.Inventory;
import com.example.autoraidrpg.gameplay.bag.Item;
import com.example.autoraidrpg.gameplay.bag.ItemFactory;
import com.example.autoraidrpg.gameplay.entity.Entity;
import com.example.autoraidrpg.gameplay.entity.role.RoleFactory;
import com.example.autoraidrpg.model.Bag;
import com.example.autoraidrpg.model.RoleCollection;
import com.example.autoraidrpg.model.User;
import com.example.autoraidrpg.population.ItemPopulation;
import com.example.autoraidrpg.utils.UnitUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ItemSettingController extends Controller {

    private ItemSettingActivity activity;
    private Entity entity;
    private Inventory inventory;
    private List<View> itemSlots;
    private Item[] itemArray;
    private Bag currentBag;
    private int index;
    private Set<String> equippedItemNames;
    private List<Item> items;
    private ExecutorService executor;
    private DatabaseHelper databaseHelper;
    private User user;
    private String name;
    private int roleCollectionID, currentLevel, currentRating;
    private List<com.example.autoraidrpg.model.Inventory> inventories;
    private List<com.example.autoraidrpg.model.Item> storedItems;

    public ItemSettingController(IView view) {
        super(view);
    }

    @Override
    public void start() {
        // clear all list first
        items.clear();
        itemSlots.clear();
        equippedItemNames.clear();
        itemArray = new Item[12];
        index = 0;

        // retrieve authenticated user session
        user = user(activity, databaseHelper);
        setMainHeader(activity.getMainHeader(), user);

        // set values
        RoleCollection roleCollection = RoleCollectionLocalDAO.retrieve(databaseHelper, user.getId(), roleCollectionID);
        currentBag = BagLocalDAO.retrieve(databaseHelper, roleCollectionID);

        // set entity & inventory
        entity = RoleFactory.makeRole(name).setLevel(currentLevel).setRating(currentRating);
        entity.initStats();
        UnitUtils.setSingleStats(entity, roleCollection);
        inventory = entity.getInventory();

        // set description
        UnitUtils.setStats(entity, activity);

        // get all acquired items
        ItemPopulation.itemCollection(storedItems, items, inventories);

        setItemSlots();
        setRecyclerViews();
    }

    @Override
    public void init() {
        activity = (ItemSettingActivity) view;
        executor = Executors.newFixedThreadPool(LoadImageTask.NUMBER_OF_THREADS);
        items = new ArrayList<>();

        // retrieve authenticated user session
        databaseHelper = new DatabaseHelper(activity.getApplicationContext());
        user = user(activity, databaseHelper);
        inventories = InventoryLocalDAO.all(databaseHelper, user.getId());
        storedItems = ItemLocalDAO.allByInventory(databaseHelper, inventories);

        Intent intent = activity.getIntent();

        // set values
        roleCollectionID = intent.getIntExtra("roleCollectionID", 0);
        name = intent.getStringExtra("name");
        currentRating = intent.getIntExtra("rating", 0);
        currentLevel = intent.getIntExtra("level", 0);

        activity.getLevel().setText("Level " + String.valueOf(currentLevel));
        RoleCollection roleCollection = RoleCollectionLocalDAO.retrieve(databaseHelper, user.getId(), roleCollectionID);
        currentBag = BagLocalDAO.retrieve(databaseHelper, roleCollectionID);

        // set entity & inventory
        entity = RoleFactory.makeRole(name).setLevel(currentLevel).setRating(currentRating);
        entity.initStats();
        UnitUtils.setSingleStats(entity, roleCollection);
        inventory = entity.getInventory();

        // set description
        executor.execute(new SetImageTask(activity, activity.getUnitImageBtn(), entity.getRoleImage()));
        activity.getRoleName().setText(entity.getName());
        UnitUtils.setStats(entity, activity);

        // get all acquired items
        ItemPopulation.itemCollection(storedItems, items, inventories);
        itemSlots = new ArrayList<>();
        equippedItemNames = new HashSet<>();

        itemArray = new Item[12];
        index = 0;

        setItemSlots();
        setRecyclerViews();

        activity.getBackBtn().setOnClickListener(v -> activity.finish());
    }

    @Override
    public void setRecyclerViews() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(activity, ItemShopController.ITEM_COLUMN, LinearLayoutManager.VERTICAL,false);
        ItemCardAdapter itemCardAdapter = new ItemCardAdapter(
                activity, items, null, activity.getSelectedItem(), activity.getEquipBtn(), activity.getShowBtn(), intent -> activity.startActivity(intent));

        setOnClickListeners();

        itemCardAdapter.setItemSettingController(this);
        setAdapter(activity.getRecyclerView(), gridLayoutManager, itemCardAdapter);
        itemCardAdapter.notifyDataSetChanged();

    }

    // set item slots view
    private void setItemSlots() {
        // set displayable views
        itemSlots.add(activity.findViewById(R.id.itemSlot1));
        itemSlots.add(activity.findViewById(R.id.itemSlot2));
        itemSlots.add(activity.findViewById(R.id.itemSlot3));
        itemSlots.add(activity.findViewById(R.id.itemSlot4));
        itemSlots.add(activity.findViewById(R.id.itemSlot5));
        itemSlots.add(activity.findViewById(R.id.itemSlot6));
        itemSlots.add(activity.findViewById(R.id.itemSlot7));
        itemSlots.add(activity.findViewById(R.id.itemSlot8));
        itemSlots.add(activity.findViewById(R.id.itemSlot9));
        itemSlots.add(activity.findViewById(R.id.itemSlot10));
        itemSlots.add(activity.findViewById(R.id.itemSlot11));
        itemSlots.add(activity.findViewById(R.id.itemSlot12));

        // set existing items at the bag
        setEquippedItem(currentBag.getInventoryID_A(), 0);
        setEquippedItem(currentBag.getInventoryID_B(), 1);
        setEquippedItem(currentBag.getInventoryID_C(), 2);
        setEquippedItem(currentBag.getInventoryID_D(), 3);
        setEquippedItem(currentBag.getInventoryID_E(), 4);
        setEquippedItem(currentBag.getInventoryID_F(), 5);
        setEquippedItem(currentBag.getInventoryID_G(), 6);
        setEquippedItem(currentBag.getInventoryID_H(), 7);
        setEquippedItem(currentBag.getInventoryID_I(), 8);
        setEquippedItem(currentBag.getInventoryID_G(), 9);
        setEquippedItem(currentBag.getInventoryID_K(), 10);
        setEquippedItem(currentBag.getInventoryID_L(), 11);
    }

    // set existing items in the bag
    private void setEquippedItem(int inventoryID, int index) {
        com.example.autoraidrpg.model.Inventory tempInventory = InventoryLocalDAO.retrieve(databaseHelper, user.getId(), inventoryID);

        if(tempInventory != null) {
            com.example.autoraidrpg.model.Item tempItem = ItemLocalDAO.retrieve(databaseHelper, tempInventory.getItemID());
            Item item = ItemFactory.makeItem(tempItem.getName());
            ImageButton emptyItemBtn = itemSlots.get(index).findViewById(R.id.emptyItemBtn);

            inventory.equip(item, index); // equip inventory
            UnitUtils.setStats(entity, activity);
            equippedItemNames.add(item.getName());

            executor.execute(new SetImageTask(activity, emptyItemBtn, item.getItemImage()));
            emptyItemBtn.setOnClickListener(new OnClickEquippedItemListener(item, index));
            itemArray[index] = item;
        }
    }

    // set item to bag
    private void putToBag(int inventoryID, int index) {
        BagLocalDAO.put(databaseHelper, currentBag.getId(), inventoryID, index);
    }

    // remove item in bag
    private void removeToBag(int index) {
        BagLocalDAO.put(databaseHelper, currentBag.getId(), -1, index);
    }

    private void setOnClickListeners() {
        for(int i = 0; i < itemSlots.size(); i++) {
            Item item = itemArray[i];
            ImageButton emptyItemBtn = itemSlots.get(i).findViewById(R.id.emptyItemBtn);

            if(i == 0 && item == null)
                executor.execute(new SetImageTask(activity, emptyItemBtn, R.color.yellow));

            if(item == null) emptyItemBtn.setOnClickListener(new OnClickEmptySlotListener(null, i));
            else emptyItemBtn.setOnClickListener(new OnClickEquippedItemListener(item, i));
        }
    }

    private void cleanSlots() {
        for(int i = 0; i < itemSlots.size(); i++) {
            Item item = itemArray[i];
            ImageButton emptyItemBtn = itemSlots.get(i).findViewById(R.id.emptyItemBtn);
            if(item == null) executor.execute(new SetImageTask(activity, emptyItemBtn, R.color.dark_gray));
        }
    }

    // equip item
    public void equip(Item item) {
        if(!equippedItemNames.contains(item.getName())) {
            itemArray[index] = item;
            inventory.equip(item, index); // equip inventory
            UnitUtils.setStats(entity, activity);
            equippedItemNames.add(item.getName());

            ImageButton emptyItemBtn = itemSlots.get(index).findViewById(R.id.emptyItemBtn);
            executor.execute(new SetImageTask(activity, emptyItemBtn, item.getItemImage()));
            emptyItemBtn.setOnClickListener(new OnClickEquippedItemListener(itemArray[index], index));

            // update
            putToBag(item.getInventoryID(), index);
        } else {
            Toast toast = Toast.makeText(activity.getApplicationContext(),
                    String.format("%s already exists in the equipped bag!", item.getName()), Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    // unequip item
    @SuppressLint("SetTextI18n")
    public void unequip() {
        equippedItemNames.remove(itemArray[index].getName());
        inventory.unequip(index); // unequip inventory
        UnitUtils.setStats(entity, activity);
        itemArray[index] = null;

        ImageButton emptyItemBtn = itemSlots.get(index).findViewById(R.id.emptyItemBtn);
        executor.execute(new SetImageTask(activity, emptyItemBtn, R.color.dark_gray));
        emptyItemBtn.setOnClickListener(new OnClickEmptySlotListener(itemArray[index], index));

        activity.getEquipBtn().setText("EQUIP");
        activity.getEquipBtn().setBackgroundResource(R.drawable.border_light_green_black);

        // update
        removeToBag(index);
    }

    // interface on empty slot buttons
    public class OnClickEmptySlotListener implements View.OnClickListener {

        private final Item item;
        private final int current;

        public OnClickEmptySlotListener(Item item, int current) {
            this.item = item;
            this.current = current;
        }

        @SuppressLint("SetTextI18n")
        @Override
        public void onClick(View view) {
            activity.getEquipBtn().setText("EQUIP");
            activity.getEquipBtn().setBackgroundResource(R.drawable.border_light_green_black);

            if(item != null) {
                executor.execute(new SetImageTask(activity, activity.getSelectedItem(), item.getItemImage()));

                // show description on new page
                activity.getShowBtn().setOnClickListener(v -> {
                    Intent intent = new Intent(activity.getApplicationContext(), ItemDescriptionActivity.class);
                    intent.putExtra("sampleItem", item);
                    activity.startActivity(intent);
                });
            }

            index = current;

            for(int j = 0; j < itemSlots.size(); j++) {
                ImageButton tempImageBtn = itemSlots.get(j).findViewById(R.id.emptyItemBtn);
                if(itemArray[j] == null) executor.execute(new SetImageTask(activity, tempImageBtn, R.color.dark_gray));
                if(j == index && itemArray[j] == null) executor.execute(new SetImageTask(activity, tempImageBtn, R.color.yellow));
            }
        }

    }

    // interface on empty slot buttons
    public class OnClickEquippedItemListener implements View.OnClickListener {

        private final Item item;
        private final int current;

        public OnClickEquippedItemListener(Item item, int current) {
            this.item = item;
            this.current = current;
        }

        @SuppressLint("SetTextI18n")
        @Override
        public void onClick(View view) {
            cleanSlots();
            executor.execute(new SetImageTask(activity, activity.getSelectedItem(), item.getItemImage()));
            activity.getEquipBtn().setText("UNEQUIP");
            activity.getEquipBtn().setBackgroundResource(R.drawable.border_red_black);

            index = current;

            // show description on new page
            activity.getShowBtn().setOnClickListener(v -> {
                Intent intent = new Intent(activity.getApplicationContext(), ItemDescriptionActivity.class);
                intent.putExtra("item", item);
                activity.startActivity(intent);
            });
        }

    }

}
