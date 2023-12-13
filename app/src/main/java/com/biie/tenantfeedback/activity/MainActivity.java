package com.biie.tenantfeedback.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.biie.tenantfeedback.Dialog;
import com.biie.tenantfeedback.R;
import com.biie.tenantfeedback.api.API;
import com.biie.tenantfeedback.model.LoginModel;
import com.biie.tenantfeedback.model.ReqLogin;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
        req.setEmail(email);
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
        API.service().postLogin(req).enqueue(new Callback<LoginModel>() {
            @Override
            public void onResponse(Call<LoginModel> call, Response<LoginModel> response) {
//                API.setAccessToken(response.body().getData().getToken_type()+""+response.body().getData().getAccess_token());
//                API.setIsLogin(true);
//                API.setCurrentUser(response.body().getData().getUser());
                startActivity(new Intent(getApplicationContext(), MenuActivity.class));
                finish();
            }

            @Override
            public void onFailure(Call<LoginModel> call, Throwable t) {
                Toast.makeText(loadingdialog, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}