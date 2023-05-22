package com.example.autoraidrpg.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.autoraidrpg.R;
import com.example.autoraidrpg.executors.LoadImageTask;
import com.example.autoraidrpg.executors.SetImageTask;
import com.example.autoraidrpg.gameplay.entity.Entity;
import com.example.autoraidrpg.utils.StarUtils;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;

public class PreparationCharacterCardAdapter extends RecyclerView.Adapter<PreparationCharacterCardAdapter.MyViewHolder> {

    private Context context;
    List<Entity> entities;
    private Consumer<Integer> consumer;
    private ExecutorService executors;

    public PreparationCharacterCardAdapter(Context context, List<Entity> entities, Consumer<Integer> consumer) {
        this.context = context;
        this.entities = entities;
        this.consumer = consumer;
        executors = Executors.newFixedThreadPool(LoadImageTask.NUMBER_OF_THREADS);
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
        View listItem = LayoutInflater.from(context).inflate(R.layout.layout_preparation_character_card, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Entity entity = entities.get(position);
        AppCompatActivity activity = (AppCompatActivity) context;

        // set loading images
        executors.execute(new SetImageTask(activity, holder.unitImageBtn, entity.getRoleImage()));
        holder.unitImageBtn.setOnClickListener(v -> consumer.accept(position));

        // set rating
        StarUtils.rewriteStar(holder.itemView, entities.get(position).getRating());
    }

    @Override
    public int getItemCount() {
        return entities.size();
    }

}
