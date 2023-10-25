package com.biie.tenantfeedback.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.biie.tenantfeedback.MainActivity;
import com.biie.tenantfeedback.R;

public class LoginActivity extends AppCompatActivity {

    Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin = findViewById(R.id.btn_login);

        login();
    }

    void login(){
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
    }
}