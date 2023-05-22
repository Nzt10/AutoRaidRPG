package com.example.autoraidrpg.controller;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.autoraidrpg.IView;
import com.example.autoraidrpg.R;
import com.example.autoraidrpg.authentication.AuthConfig;
import com.example.autoraidrpg.database.DatabaseHelper;
import com.example.autoraidrpg.database.dao.local.UserLocalDAO;
import com.example.autoraidrpg.model.User;
import com.google.gson.Gson;

public abstract class Controller {

    protected IView view;
    private Gson gson;

    public Controller(IView view){
        this.view = view;
        gson = new Gson();
    }

    public abstract void init();
    public abstract void setRecyclerViews();

    public void setIntentOnListener(AppCompatActivity activity, Class<?> cls) {
        Intent intent = new Intent(activity.getApplicationContext(), cls);
        activity.startActivity(intent);
    }

    public void setAdapter(RecyclerView recyclerView, RecyclerView.LayoutManager layoutManager, RecyclerView.Adapter adapter) {
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    public void alert(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    public void session(AppCompatActivity activity, Object object) {
        SharedPreferences sharedPreferences = activity.getSharedPreferences(AuthConfig.USER_SESSION, MODE_PRIVATE);

        // JSON serialization
        String json = gson.toJson(object);

        // Edit preferences
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(AuthConfig.SESSION_KEY_USER, json);
        editor.apply();
    }

    public User user(AppCompatActivity activity, DatabaseHelper databaseHelper) {
        String json = activity.getSharedPreferences(AuthConfig.USER_SESSION, MODE_PRIVATE).getString(AuthConfig.SESSION_KEY_USER, "");
        User user = gson.fromJson(json, User.class);
        return UserLocalDAO.retrieveByID(databaseHelper, user.getId());
    }

    public boolean isAuthenticated(AppCompatActivity activity) {
        return !TextUtils.isEmpty(activity.getSharedPreferences(AuthConfig.USER_SESSION, MODE_PRIVATE).getString(AuthConfig.SESSION_KEY_USER, ""));
    }

    public void logout(AppCompatActivity activity) {
        SharedPreferences sharedPreferences = activity.getSharedPreferences(AuthConfig.USER_SESSION, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove(AuthConfig.SESSION_KEY_USER);
        editor.apply();
    }

    // main view modification
    public void setMainHeader(View mainHeader, User user) {
        TextView unitName = mainHeader.findViewById(R.id.unitName);
        TextView coin = mainHeader.findViewById(R.id.coin);
        TextView exp = mainHeader.findViewById(R.id.exp);
        TextView diamond = mainHeader.findViewById(R.id.diamond);

        unitName.setText(user.getUsername());
        coin.setText(String.valueOf((int) user.getCoin()));
        exp.setText(String.valueOf((int) user.getExp()));
        diamond.setText(String.valueOf((int) user.getDiamond()));
    }

    // auth view modification
    public void setAuthHeader(View mainHeader, String header) {
        TextView unitName = mainHeader.findViewById(R.id.unitName);
        unitName.setText(header);
    }

    // activity life cycle
    public void create() {}
    public void start() {}
    public void resume() {}
    public void restart() {}
    public void pause() {}
    public void stop() {}
    public void destroy() {}

}
