package com.biie.tenantfeedback.activity;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import com.biie.tenantfeedback.R;
import android.content.Intent;

public class ProfileActivity extends AppCompatActivity {

    Button confirm_profile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        confirm_profile = findViewById(R.id.confirm_profile);
        confirm_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProfileActivity.this, MainActivity.class));
            }
        });
    }
}