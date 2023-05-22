package com.example.autoraidrpg.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.autoraidrpg.R;
import com.example.autoraidrpg.gameplay.global.BattleInformationObserver;
import com.example.autoraidrpg.gameplay.observer.BattleRoundObserver;
import com.example.autoraidrpg.gameplay.subject.BattleSubject;

public class BattleInformationAdapter extends RecyclerView.Adapter<BattleInformationAdapter.MyViewHolder> {

    private Context context;
    private BattleSubject battleSubject;

    public BattleInformationAdapter(Context context) {
        this.context = context;
        battleSubject = BattleInformationObserver.getInstance();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        public View roundView;
        public RecyclerView battleInformationRecyclerView;
        public TextView roundNum;
        public Context childContext;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            roundView = itemView.findViewById(R.id.roundView);
            battleInformationRecyclerView = itemView.findViewById(R.id.battleInformationRecyclerView);

            roundNum = roundView.findViewById(R.id.roundNum);
            childContext = itemView.getContext();
        }

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View listItem = LayoutInflater.from(context).inflate(R.layout.layout_battle_information, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        BattleRoundObserver observer = battleSubject.getObservers().get(position);
        holder.roundNum.setText(position == 0 ? "START" : String.valueOf(observer.getRound()));

        SingleBattleInformationAdapter singleBattleInformationAdapter =
                new SingleBattleInformationAdapter(holder.childContext, observer.getDescription(), observer.getLeftResources(), observer.getRightResources());

        holder.battleInformationRecyclerView.setLayoutManager(new LinearLayoutManager(holder.childContext, LinearLayoutManager.VERTICAL, false));
        holder.battleInformationRecyclerView.setAdapter(singleBattleInformationAdapter);
        singleBattleInformationAdapter.notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return battleSubject.getObservers().size();
    }

}
