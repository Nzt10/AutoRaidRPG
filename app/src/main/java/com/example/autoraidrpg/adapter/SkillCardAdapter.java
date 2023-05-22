package com.example.autoraidrpg.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.autoraidrpg.R;
import com.example.autoraidrpg.executors.SetImageTask;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SkillCardAdapter extends RecyclerView.Adapter<SkillCardAdapter.MyViewHolder> {

    private final Context context;
    private final List<SkillInfoAdapter> skillInfo;
    private ExecutorService executor;

    public SkillCardAdapter(Context context, List<SkillInfoAdapter> skillInfo) {
        this.context = context;
        this.skillInfo = skillInfo;
        executor = Executors.newSingleThreadExecutor();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        public ImageView skillImage;
        public TextView skillName, skillLevel, skillDescription;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            skillImage = itemView.findViewById(R.id.skillImage);
            skillName = itemView.findViewById(R.id.skillName);
            skillLevel = itemView.findViewById(R.id.skillLevel);
            skillDescription = itemView.findViewById(R.id.skillDescription);
        }

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View listItem = LayoutInflater.from(context).inflate(R.layout.layout_skill_description, parent, false);
        return new MyViewHolder(listItem);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        SkillInfoAdapter skill = skillInfo.get(position);
        String lastDescription = "\n" + skill.getDescription().remove(skill.getDescription().size() - 1);
        skill.getDescription().add(lastDescription);

        executor.execute(new SetImageTask((AppCompatActivity) context, holder.skillImage, skill.getImage()));
        holder.skillName.setText(skill.getName());
        holder.skillLevel.setText("level " + skill.getLevel());
        holder.skillDescription.setText(String.join("\n", skill.getDescription()));
    }

    @Override
    public int getItemCount() {
        return 5;
    }

}
