package com.example.autoraidrpg.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.autoraidrpg.R;
import com.example.autoraidrpg.gameplay.skill.Skill;

import java.util.List;

public class SkillBuyCardAdapter extends RecyclerView.Adapter<SkillBuyCardAdapter.MyViewHolder> {

    private final Context context;
    private final List<SkillInfoAdapter> skillInfo;

    public SkillBuyCardAdapter(Context context, List<SkillInfoAdapter> skillInfo) {
        this.context = context;
        this.skillInfo = skillInfo;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        public ImageView skillImage;
        public Button upgradeBtn;
        public TextView skillName, skillLevel, skillDescription, coin;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            skillImage = itemView.findViewById(R.id.skillImage);
            upgradeBtn = itemView.findViewById(R.id.upgradeBtn);
            skillName = itemView.findViewById(R.id.skillName);
            skillLevel = itemView.findViewById(R.id.skillLevel);
            skillDescription = itemView.findViewById(R.id.skillDescription);
            coin = itemView.findViewById(R.id.coin);
        }

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View listItem = LayoutInflater.from(context).inflate(R.layout.layout_skill_buy, parent, false);
        return new MyViewHolder(listItem);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        SkillInfoAdapter skill = skillInfo.get(position);
        String lastDescription = "\n" + skill.getDescription().remove(skill.getDescription().size() - 1);

        skill.getDescription().add(lastDescription);
        double price = (position >= skillInfo.size() - 1) ? Skill.ORIGINAL_PRICE + 50 : Skill.ORIGINAL_PRICE;

        holder.skillImage.setBackgroundResource(skill.getImage());
        holder.skillName.setText(skill.getName());
        holder.skillLevel.setText("level " + skill.getLevel());
        holder.skillDescription.setText(String.join("\n", skill.getDescription()));
        holder.coin.setText(String.valueOf((int) price));
    }

    @Override
    public int getItemCount() {
        return 5;
    }

}
