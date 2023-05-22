package com.example.autoraidrpg.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.autoraidrpg.R;
import com.example.autoraidrpg.executors.LoadImageTask;
import com.example.autoraidrpg.executors.SetImageTask;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleBattleInformationAdapter extends RecyclerView.Adapter<SingleBattleInformationAdapter.MyViewHolder> {

    private Context context;
    private List<String> descriptions;
    private List<Integer> leftResources, rightResources;
    private ExecutorService executor;

    public SingleBattleInformationAdapter(Context context, List<String> descriptions, List<Integer> leftResources, List<Integer> rightResources) {
        this.context = context;
        this.descriptions = descriptions;
        this.leftResources = leftResources;
        this.rightResources = rightResources;
        executor = Executors.newFixedThreadPool(LoadImageTask.NUMBER_OF_THREADS);
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        public View leftRoleImageView, rightRoleImageView;
        public ImageButton leftUnitImageBtn, rightUnitImageBtn;
        public TextView battleInformation;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            this.leftRoleImageView = itemView.findViewById(R.id.leftRoleImageView);
            this.rightRoleImageView = itemView.findViewById(R.id.rightRoleImageView);
            this.battleInformation = itemView.findViewById(R.id.battleInformation);
            this.leftUnitImageBtn = leftRoleImageView.findViewById(R.id.unitImageBtn);
            this.rightUnitImageBtn = rightRoleImageView.findViewById(R.id.unitImageBtn);
        }

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View listItem = LayoutInflater.from(context).inflate(R.layout.layout_single_battle_information, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        AppCompatActivity activity = (AppCompatActivity) context;
        executor.execute(new SetImageTask(activity, holder.leftUnitImageBtn, leftResources.get(position)));
        executor.execute(new SetImageTask(activity, holder.rightUnitImageBtn, leftResources.get(position)));
        holder.battleInformation.setText(descriptions.get(position));
    }

    @Override
    public int getItemCount() {
        return descriptions.size();
    }

}
