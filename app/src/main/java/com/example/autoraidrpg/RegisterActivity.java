package com.example.autoraidrpg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.autoraidrpg.controller.RegisterController;

public class RegisterActivity extends AppCompatActivity implements IView {

    private View mainHeader;
    private EditText usernameField, emailField, passwordField, confirmPasswordField;
    private TextView hasAccountBtn;
    private ImageButton backBtn;
    private Button registerBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mainHeader = findViewById(R.id.authHeader);
        usernameField = findViewById(R.id.usernameField);
        emailField = findViewById(R.id.emailField);
        passwordField = findViewById(R.id.passwordField);
        confirmPasswordField = findViewById(R.id.confirmPasswordField);
        hasAccountBtn = findViewById(R.id.hasAccountBtn);
        registerBtn = findViewById(R.id.registerBtn);
        backBtn = findViewById(R.id.backBtn);

        new RegisterController(this).init();
    }

    public View getMainHeader() { return mainHeader; }

    public EditText getUsernameField() {
        return usernameField;
    }

    public EditText getEmailField() {
        return emailField;
    }

    public EditText getPasswordField() {
        return passwordField;
    }

    public EditText getConfirmPasswordField() {
        return confirmPasswordField;
    }

    public TextView getHasAccountBtn() { return hasAccountBtn; }

    public ImageButton getBackBtn() {
        return backBtn;
    }

    public Button getRegisterBtn() {
        return registerBtn;
    }

}