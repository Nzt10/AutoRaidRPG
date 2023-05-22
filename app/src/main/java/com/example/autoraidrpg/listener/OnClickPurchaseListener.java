package com.example.autoraidrpg.listener;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.example.autoraidrpg.PurchaseDiamondActivity;

import java.util.function.Consumer;

public class OnClickPurchaseListener implements View.OnClickListener {

    private Context context;
    private Consumer<Intent> consumer;

    public OnClickPurchaseListener(Context context, Consumer<Intent> consumer) {
        this.context = context;
        this.consumer = consumer;
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(view.getContext(), PurchaseDiamondActivity.class);
        consumer.accept(intent);
    }

}
