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

import com.example.autoraidrpg.R;
import com.example.autoraidrpg.RoleBuyActivity;
import com.example.autoraidrpg.executors.LoadImageTask;
import com.example.autoraidrpg.executors.SetImageTask;
import com.example.autoraidrpg.gameplay.entity.Entity;
import com.example.autoraidrpg.utils.StarUtils;
import com.example.autoraidrpg.utils.UnitUtils;

import java.io.Serializable;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;

public class RoleShopAdapter extends RecyclerView.Adapter<RoleShopAdapter.MyViewHolder> {

    private Context context;
    private List<Entity> entities;
    private Consumer<Intent> consumer;
    private ExecutorService executor;

    public RoleShopAdapter(Context context, List<Entity> entities, Consumer<Intent> consumer) {
        this.context = context;
        this.entities = entities;
        this.consumer = consumer;
        executor = Executors.newFixedThreadPool(LoadImageTask.NUMBER_OF_THREADS);
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        public View unitImageView;
        public ImageButton unitImageBtn;
        public TextView coin;
        public Button buyBtn;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            this.unitImageView = itemView.findViewById(R.id.unitImageView);
            this.unitImageBtn = this.unitImageView.findViewById(R.id.unitImageBtn);
            this.coin = itemView.findViewById(R.id.coin);
            this.buyBtn = itemView.findViewById(R.id.buyBtn);
        }

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View listItem = LayoutInflater.from(context).inflate(R.layout.layout_character_shop_card, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Entity entity = entities.get(position);
        executor.execute(new SetImageTask((AppCompatActivity) context, holder.unitImageBtn, entity.getRoleImage()));
        holder.coin.setText(String.valueOf((int) entity.getPriceCoin()));

        // set rating
        StarUtils.rewriteStar(holder.unitImageView, entity.getRating());

        // set listener
        holder.buyBtn.setText("Buy");
        holder.buyBtn.setOnClickListener(v -> {
            Entity role = entities.get(position);

            Intent intent = new Intent(v.getContext(), RoleBuyActivity.class);
            intent.putExtra("name", role.getName());
            intent.putExtra("rating", role.getRating());
            intent.putExtra("roleDescription", role.getDescription());
            intent.putExtra("roleImage", role.getRoleImage());
            intent.putExtra("skillInfo", (Serializable) UnitUtils.setAndGetSkills(role.getSkillManager()));
            intent.putExtra("coin", role.getPriceCoin());
            intent.putExtra("diamond", role.getPriceDiamond());
            consumer.accept(intent);
        });
    }

    @Override
    public int getItemCount() {
        return entities.size();
    }

}
