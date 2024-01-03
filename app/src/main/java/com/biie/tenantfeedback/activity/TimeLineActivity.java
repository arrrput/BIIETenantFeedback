package com.biie.tenantfeedback.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.biie.tenantfeedback.R;

public class TimeLineActivity extends AppCompatActivity {
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        String newTimeline;
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                newTimeline= null;
            } else {
                newTimeline= extras.getString("ID");
            }
        } else {
            newTimeline= (String) savedInstanceState.getSerializable("ID");
        }

        Toast.makeText(this, newTimeline, Toast.LENGTH_SHORT).show();

        setContentView(R.layout.activity_timeline);

        getTimeline();

    }

    void getTimeline(){

    }
}
