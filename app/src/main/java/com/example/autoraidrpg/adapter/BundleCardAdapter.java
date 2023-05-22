package com.example.autoraidrpg.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.autoraidrpg.R;
import com.example.autoraidrpg.listener.OnClickPurchaseListener;

public class BundleCardAdapter extends RecyclerView.Adapter<BundleCardAdapter.MyViewHolder> {

    private Context context;
    private OnClickPurchaseListener listener;

    public BundleCardAdapter(Context context) {
        this.context = context;
    }

    public void setOnClickPurchaseListener(OnClickPurchaseListener listener) {
        this.listener = listener;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView bundleType, price;
        public ImageView bundleImage;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            this.bundleType = itemView.findViewById(R.id.bundleType);
            this.price = itemView.findViewById(R.id.price);
            this.bundleImage = itemView.findViewById(R.id.bundleImage);
        }

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View listItem = LayoutInflater.from(context).inflate(R.layout.layout_purchase_card, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.bundleType.setText("Bundle Type " + (position + 1));
        holder.bundleImage.setBackgroundResource(R.drawable.treasure_chest_1);
        holder.price.setText(String.valueOf((position + 1) * 250));
        holder.price.setOnClickListener(listener);
    }

    @Override
    public int getItemCount() {
        return 18;
    }

}
