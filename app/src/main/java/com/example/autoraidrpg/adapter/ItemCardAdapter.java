package com.example.autoraidrpg.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.autoraidrpg.ItemDescriptionActivity;
import com.example.autoraidrpg.R;
import com.example.autoraidrpg.controller.ItemCollectionController;
import com.example.autoraidrpg.controller.ItemSettingController;
import com.example.autoraidrpg.executors.LoadItemImageTask;
import com.example.autoraidrpg.executors.SetImageTask;
import com.example.autoraidrpg.gameplay.bag.Item;
import com.example.autoraidrpg.utils.ItemUtils;
import com.example.autoraidrpg.utils.StarUtils;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;

public class ItemCardAdapter extends RecyclerView.Adapter<ItemCardAdapter.MyViewHolder> {

    private Context context;
    private List<Item> items;
    private View layoutItemDescription;
    private ImageButton itemImageBtn, selectedItem;
    private Button equipBtn, showBtn;
    private TextView itemName, stats, description;
    private Consumer<Intent> consumer;
    private ItemSettingController itemSettingController;
    private ItemCollectionController itemCollectionController;
    private ExecutorService executor;

    // for shop components
    private Button buyBtn;

    public ItemCardAdapter(
            Context context, List<Item> items, View layoutItemDescription,
            ImageButton selectedItem, Button equipBtn, Button showBtn, Consumer<Intent> consumer
    ) {
        this.context = context;
        this.items = items;
        this.layoutItemDescription = layoutItemDescription;
        executor = Executors.newFixedThreadPool(LoadItemImageTask.NUMBER_OF_THREADS);

        if(layoutItemDescription != null) {
            itemImageBtn = layoutItemDescription.findViewById(R.id.itemImageBtn);
            itemName = layoutItemDescription.findViewById(R.id.itemName);
            stats = layoutItemDescription.findViewById(R.id.stats);
            description = layoutItemDescription.findViewById(R.id.description);
        } else {
            this.selectedItem = selectedItem;
            this.equipBtn = equipBtn;
            this.showBtn = showBtn;
        }

        this.consumer = consumer;
    }

    public void setItemSettingController(ItemSettingController itemSettingController) {
        this.itemSettingController = itemSettingController;
    }

    public void setItemCollectionController(ItemCollectionController itemCollectionController) {
        this.itemCollectionController = itemCollectionController;
    }

    public void setShopComponent(Button buyBtn) {
        this.buyBtn = buyBtn;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        public ImageButton itemBtn;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemBtn = itemView.findViewById(R.id.itemBtn);
        }

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View listItem = LayoutInflater.from(context).inflate(R.layout.layout_item_card, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        AppCompatActivity activity = (AppCompatActivity) context;
        Item item = items.get(position);
        executor.execute(new LoadItemImageTask(activity, holder.itemBtn, item.getItemImage()));
        StarUtils.rewriteStar(holder.itemBtn.getRootView(), item.getRating());

        if(layoutItemDescription != null) {

            // show description on page
            holder.itemBtn.setOnClickListener(v -> {
                ItemUtils.designItem(item, itemImageBtn, itemName, stats, description);
                StarUtils.rewriteStar(layoutItemDescription, item.getRating());

                if(itemCollectionController != null)
                    itemCollectionController.setCurrentItem(item);

                if(buyBtn != null)
                    buyBtn.setText(String.format("BUY FOR %d COINS", (int) item.getPrice()));
            });

        } else {

            holder.itemBtn.setOnClickListener(v -> {
                executor.execute(new SetImageTask(activity, selectedItem, item.getItemImage()));
                equipBtn.setText("EQUIP");
                equipBtn.setBackgroundResource(R.drawable.border_light_green_black);

                // show description on new page
                showBtn.setOnClickListener(view -> {
                    Intent intent = new Intent(view.getContext(), ItemDescriptionActivity.class);
                    intent.putExtra("item", item);
                    consumer.accept(intent);
                });

                // equip item
                equipBtn.setOnClickListener(view -> {
                    switch(equipBtn.getText().toString()) {
                        case "EQUIP":
                            itemSettingController.equip(item);
                            break;
                        case "UNEQUIP":
                            itemSettingController.unequip();
                            break;
                    }
                });
            });

            if(position == 0) holder.itemBtn.performClick();

        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

}
