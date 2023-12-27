package com.biie.tenantfeedback.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.biie.tenantfeedback.R;
import com.biie.tenantfeedback.api.API;
import com.biie.tenantfeedback.api.APICallback;
import com.biie.tenantfeedback.model.BadRequest;
import com.biie.tenantfeedback.model.LogoutModel;

public class MenuActivity extends AppCompatActivity {

    CardView action_profile;
    CardView action_report;
    CardView action_progress;
    CardView action_logout;
    private int message;

    //    private MenuItem item;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (!API.isLogin()) {
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            finish();
        }
        setContentView(R.layout.activity_menu);
        Log.e("token", API.getAccessToken());
        action_profile = findViewById(R.id.action_profile);
        action_report = findViewById(R.id.action_report);
        action_progress = findViewById(R.id.action_progress);
        action_logout = findViewById(R.id.action_logout);

        action_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuActivity.this, ProfileActivity.class));
            }
        });
        action_report.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuActivity.this, ReportActivity.class));
            }
        });
        action_progress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuActivity.this, ProgressActivity.class));
            }
        });

        action_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                API.service().postLogout().enqueue(new APICallback<LogoutModel>() {
                    @Override
                    protected void onSuccess(LogoutModel logoutModel) {
                        Toast.makeText(MenuActivity.this, logoutModel.getMetaLogout().getMessage(), Toast.LENGTH_SHORT).show();
                        API.setCurrentUser(null);
                        API.setIsLogin(false);
                        API.setAccessToken("");

                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        finish();
                    }

                    @Override
                    protected void onError(BadRequest error) {
                        API.setCurrentUser(null);
                        API.setIsLogin(false);
                        API.setAccessToken("");

                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        finish();                    }
                });
            }
        });
    }
}
