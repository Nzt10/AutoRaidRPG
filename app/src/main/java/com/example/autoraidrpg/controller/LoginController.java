package com.example.autoraidrpg.controller;

import android.content.Intent;
import android.text.TextUtils;

import com.example.autoraidrpg.IView;
import com.example.autoraidrpg.LoginActivity;
import com.example.autoraidrpg.MainActivity;
import com.example.autoraidrpg.RegisterActivity;
import com.example.autoraidrpg.database.DatabaseHelper;
import com.example.autoraidrpg.database.dao.local.UserLocalDAO;
import com.example.autoraidrpg.model.User;

import org.mindrot.jbcrypt.BCrypt;

public class LoginController extends Controller {

    public LoginController(IView view) {
        super(view);
    }

    @Override
    public void init() {
        LoginActivity activity = (LoginActivity) view;
        setAuthHeader(activity.getMainHeader(), "Welcome GUEST! Login your account!");

        // login functionality
        activity.getLoginBtn().setOnClickListener(v -> {
            String email = activity.getEmailField().getText().toString();
            String password = activity.getPasswordField().getText().toString();

            // retrieve user
            DatabaseHelper databaseHelper = new DatabaseHelper(activity.getApplicationContext());
            User user = UserLocalDAO.retrieve(databaseHelper, email);
            // User user = new UserCloudDAO(activity).retrieveByEmail(email);

            // validations
            if(!TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
                if(user != null) {
                    // password validation
                    if(BCrypt.checkpw(password, user.getPassword())) {
                        // store in session session
                        session(activity, user);

                        Intent intent = new Intent(activity.getApplicationContext(), MainActivity.class);
                        activity.startActivity(intent);
                    } else {
                        alert(activity.getApplicationContext(), "Failed to login! Invalid credentials.");
                    }
                } else {
                    alert(activity.getApplicationContext(), "Email does not exist! Register first.");
                }
            } else {
                alert(activity.getApplicationContext(), "Failed to login! Some field is empty.");
            }
        });

        activity.getRegisterBtn().setOnClickListener(v -> setIntentOnListener(activity, RegisterActivity.class));
    }

    @Override
    public void setRecyclerViews() {}

}
