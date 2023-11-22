package com.biie.tenantfeedback.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.biie.tenantfeedback.Dialog;
import com.biie.tenantfeedback.R;
import com.biie.tenantfeedback.api.API;
import com.biie.tenantfeedback.api.APICallback;
import com.biie.tenantfeedback.model.BadRequest;
import com.biie.tenantfeedback.model.ReqLogin;
import com.biie.tenantfeedback.model.UserResp;

public class MainActivity extends AppCompatActivity {

    private EditText mEmailEditText;
    private EditText mPasswordEditText;
    private Button mLoginButton;
    final Dialog loadingdialog = new Dialog(MainActivity.this);

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        mEmailEditText = findViewById(R.id.email);
        mPasswordEditText = findViewById(R.id.password);
        mLoginButton = findViewById(R.id.login_button);
        final EditText passwordInput = findViewById(R.id.password);
        // Set click listener for login button
        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the entered email and password
                String email = mEmailEditText.getText().toString();
                String password = mPasswordEditText.getText().toString();
                if (!email.isEmpty() && !password.isEmpty()){
                    login(email, password);
                }
            }
        });
    }

    public void login(String email, String password){
        ReqLogin req = new ReqLogin();
        req.setUsername(email);
        req.setPassword(password);

//        loadingdialog.startLoadingdialog()

//        // using handler class to set time delay methods
//        Handler handler = new Handler();
//        handler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                // after 2 seconds
//                loadingdialog.dismissdialog();
//            }
//        }, 2000); // 2 seconds
        API.service().postLogin(req).enqueue(new APICallback<UserResp>() {
            @Override
            protected void onSuccess(UserResp userResp) {
                API.setAccessToken(userResp.getToken());
                API.setIsLogin(true);
                API.setCurrentUser(userResp);
                startActivity(new Intent(getApplicationContext(), MenuActivity.class));
                finish();
            }

            @Override
            protected void onError(BadRequest error) {

            }
        });
    }
}