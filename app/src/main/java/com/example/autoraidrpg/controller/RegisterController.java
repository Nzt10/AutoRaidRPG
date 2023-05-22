package com.example.autoraidrpg.controller;

import android.content.Intent;
import android.text.TextUtils;

import com.example.autoraidrpg.IView;
import com.example.autoraidrpg.LoginActivity;
import com.example.autoraidrpg.MainActivity;
import com.example.autoraidrpg.RegisterActivity;
import com.example.autoraidrpg.database.DatabaseHelper;
import com.example.autoraidrpg.database.dao.cloud.UserCloudDAO;
import com.example.autoraidrpg.database.dao.local.BagLocalDAO;
import com.example.autoraidrpg.database.dao.local.UserLocalDAO;
import com.example.autoraidrpg.model.Bag;
import com.example.autoraidrpg.model.RoleCollection;
import com.example.autoraidrpg.model.User;
import com.example.autoraidrpg.population.ItemPopulation;
import com.example.autoraidrpg.population.RolePopulation;
import com.example.autoraidrpg.population.StagePopulation;

import org.mindrot.jbcrypt.BCrypt;

public class RegisterController extends Controller {

    public RegisterController(IView view) {
        super(view);
    }

    @Override
    public void init() {
        RegisterActivity activity = (RegisterActivity) view;
        setAuthHeader(activity.getMainHeader(), "Create your OWN account!");

        // register functionality
        activity.getRegisterBtn().setOnClickListener(v -> {
            String username =  activity.getUsernameField().getText().toString();
            String email = activity.getEmailField().getText().toString();
            String password = activity.getPasswordField().getText().toString();
            String confirmPassword = activity.getConfirmPasswordField().getText().toString();

            // default values
            double longitude = 0, latitude = 0, coin = 1000, exp = 25000, diamond = 50;

            // validations
            if(!TextUtils.isEmpty(username) || !TextUtils.isEmpty(email) || !TextUtils.isEmpty(password) || !TextUtils.isEmpty(confirmPassword)) {

                // store user
                String salt = BCrypt.gensalt();
                DatabaseHelper databaseHelper = new DatabaseHelper(activity.getApplicationContext());
                User newUser = new User(-1, username, email, BCrypt.hashpw(password, salt), longitude, latitude, coin, exp, diamond);
                int newID = (int) UserLocalDAO.store(databaseHelper, newUser);

                if (newID != -1) {
                    // set new id before storing it in the session
                    newUser.setId((int) newID);
                    new UserCloudDAO(activity).store(newUser);

                    // store in session session
                    session(activity, newUser);

                    // success alert
                    this.alert(activity.getApplicationContext(), "You successfully register!");

                    // generate seeder using role & item population
                    RolePopulation.generate(databaseHelper);
                    ItemPopulation.generate(databaseHelper);

                    RoleCollection roleCollection = RolePopulation.generateFirstRole(databaseHelper, newID);
                    RolePopulation.generateFormation(databaseHelper, newID, roleCollection.getId());
                    ItemPopulation.seed(databaseHelper, newID);
                    StagePopulation.generate(databaseHelper, newID);

                    // create first unit bag
                    Bag bag = new Bag(-1, newID, roleCollection.getId(), -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1);
                    BagLocalDAO.store(databaseHelper, bag);

                    // set intent to listener
                    Intent intent = new Intent(activity.getApplicationContext(), MainActivity.class);
                    activity.startActivity(intent);
                } else {
                    this.alert(activity.getApplicationContext(), "Failed to register! Try again.");
                }

            } else {
                this.alert(activity.getApplicationContext(), "Failed to register! Some field is empty.");
            }
        });

        activity.getHasAccountBtn().setOnClickListener(v -> activity.finish());
        activity.getBackBtn().setOnClickListener(v -> setIntentOnListener(activity, LoginActivity.class));
    }

    @Override
    public void setRecyclerViews() {}

}
