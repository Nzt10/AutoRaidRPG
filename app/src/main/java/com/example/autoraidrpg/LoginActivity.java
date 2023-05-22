package com.example.autoraidrpg;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.autoraidrpg.controller.LoginController;

public class LoginActivity extends AppCompatActivity implements IView {

    private View mainHeader;
    private EditText emailField, passwordField;
    private Button loginBtn, registerBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mainHeader = findViewById(R.id.authHeader);
        emailField = findViewById(R.id.emailField);
        passwordField = findViewById(R.id.passwordField);
        loginBtn = findViewById(R.id.loginBtn);
        registerBtn = findViewById(R.id.registerBtn);

        new LoginController(this).init();
    }

    public View getMainHeader() { return mainHeader; }
    
    public EditText getEmailField() {
        return emailField;
    }

    public EditText getPasswordField() {
        return passwordField;
    }

    public Button getLoginBtn() {
        return loginBtn;
    }

    public Button getRegisterBtn() {
        return registerBtn;
    }

}