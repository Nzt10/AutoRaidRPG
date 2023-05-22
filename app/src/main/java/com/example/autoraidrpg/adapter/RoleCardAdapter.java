package com.example.autoraidrpg.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.autoraidrpg.R;
import com.example.autoraidrpg.RoleDescriptionActivity;
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

public class RoleCardAdapter extends RecyclerView.Adapter<RoleCardAdapter.MyViewHolder> {

    private Context context;
    private List<Entity> entities;
    private Consumer<Intent> consumer;
    private ExecutorService executor;

    public RoleCardAdapter(Context context, List<Entity> entities, Consumer<Intent> consumer) {
        this.context = context;
        this.entities = entities;
        this.consumer = consumer;
        executor = Executors.newFixedThreadPool(LoadImageTask.NUMBER_OF_THREADS);
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        public ImageButton unitImageBtn;
        public View itemView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            this.unitImageBtn = itemView.findViewById(R.id.unitImageBtn);
            this.itemView = itemView;
        }

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View listItem = LayoutInflater.from(context).inflate(R.layout.layout_character_card, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        executor.execute(new SetImageTask((AppCompatActivity) context, holder.unitImageBtn, entities.get(position).getRoleImage()));

        holder.unitImageBtn.setOnClickListener(v -> {
            Entity role = entities.get(position);

            Intent intent = new Intent(v.getContext(), RoleDescriptionActivity.class);
            intent.putExtra("roleCollectionID", role.getRoleCollectionID());
            intent.putExtra("roleID", role.getRoleID());
            intent.putExtra("name", role.getName());
            intent.putExtra("roleDescription", role.getDescription());
            intent.putExtra("roleImage", role.getRoleImage());
            intent.putExtra("level", role.getLevel());
            intent.putExtra("rating", role.getRating());
            intent.putExtra("skillInfo", (Serializable) UnitUtils.setAndGetSkills(role.getSkillManager()));
            consumer.accept(intent);
        });

        // set rating
        StarUtils.rewriteStar(holder.itemView, entities.get(position).getRating());
    }

    @Override
    public int getItemCount() {
        return entities.size();
    }

}
