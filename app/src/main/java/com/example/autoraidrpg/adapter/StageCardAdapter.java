package com.example.autoraidrpg.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.autoraidrpg.BattleFormationActivity;
import com.example.autoraidrpg.R;
import com.example.autoraidrpg.executors.LoadImageTask;
import com.example.autoraidrpg.executors.SetImageTask;
import com.example.autoraidrpg.gameplay.global.StageObserver;
import com.example.autoraidrpg.gameplay.stage.Stage;
import com.example.autoraidrpg.gameplay.stage.StageFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;

public class StageCardAdapter extends RecyclerView.Adapter<StageCardAdapter.MyViewHolder> {

    private Context context;
    private int numOfStage;
    private Consumer<Intent> consumer;
    private ExecutorService executors;

    public StageCardAdapter(Context context, int numOfStage) {
        this.context = context;
        this.numOfStage = numOfStage;
        executors = Executors.newFixedThreadPool(LoadImageTask.NUMBER_OF_THREADS);
    }

    public void setConsumer(Consumer<Intent> consumer) {
        this.consumer = consumer;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView resultTitle, resultDescription;
        public ImageButton stageImageBtn;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            this.resultTitle = itemView.findViewById(R.id.resultTitle);
            this.resultDescription = itemView.findViewById(R.id.resultDescription);
            this.stageImageBtn = itemView.findViewById(R.id.stageImagebtn);
        }

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View listItem = LayoutInflater.from(context).inflate(R.layout.layout_stage_card, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Stage stage = StageFactory.makeStage(position + 1);
        holder.resultTitle.setText("STAGE " + stage.getLevel());
        holder.resultDescription.setText(stage.getDescription());
        executors.execute(new SetImageTask((AppCompatActivity) context, holder.stageImageBtn, stage.getStageImage()));

        holder.stageImageBtn.setOnClickListener(v -> {
            StageObserver.setStage(stage);
            Intent intent = new Intent(context, BattleFormationActivity.class);
            consumer.accept(intent);
        });
    }

    @Override
    public int getItemCount() {
        return numOfStage;
    }

}
