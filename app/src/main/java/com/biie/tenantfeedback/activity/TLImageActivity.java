package com.biie.tenantfeedback.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.biie.tenantfeedback.R;
import com.bumptech.glide.Glide;

public class TLImageActivity extends AppCompatActivity {

    ImageView timelineImage;
    String viewImage;

    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                viewImage= null;
            } else {
                viewImage= extras.getString("ID");
            }
        } else {
            viewImage= (String) savedInstanceState.getSerializable("ID");
        }
        setContentView(R.layout.activity_tlimage);

        timelineImage = findViewById(R.id.imageTLFinish);
        Glide.with(getApplicationContext())
                .load(viewImage)
                .into(timelineImage);


    }
}
