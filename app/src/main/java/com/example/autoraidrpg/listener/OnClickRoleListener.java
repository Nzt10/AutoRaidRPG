package com.example.autoraidrpg.listener;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.example.autoraidrpg.RoleBuyActivity;

import java.util.function.Consumer;

public class OnClickRoleListener implements View.OnClickListener {

    private Context context;
    private Consumer<Intent> consumer;

    public OnClickRoleListener(Context context, Consumer<Intent> consumer) {
        this.context = context;
        this.consumer = consumer;
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(view.getContext(), RoleBuyActivity.class);
        consumer.accept(intent);
    }

}
