package com.example.autoraidrpg.listener;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.example.autoraidrpg.RoleDescriptionActivity;

import java.util.function.Consumer;

public class OnClickSimpleRoleListener implements View.OnClickListener {

    private Context context;
    private Consumer<Intent> consumer;

    public OnClickSimpleRoleListener(Context context, Consumer<Intent> consumer) {
        this.context = context;
        this.consumer = consumer;
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(view.getContext(), RoleDescriptionActivity.class);
        consumer.accept(intent);
    }

}
