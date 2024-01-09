package com.biie.tenantfeedback.activity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.biie.tenantfeedback.R;

public class RatingActivity extends AppCompatActivity {
    RatingBar rateBar;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating);

        rateBar = findViewById(R.id.RatingBar);

        //finding the specific RatingBar with its unique ID
        LayerDrawable stars=(LayerDrawable)rateBar.getProgressDrawable();

        //Use for changing the color of RatingBar
        stars.getDrawable(2).setColorFilter(Color.GREEN, PorterDuff.Mode.SRC_ATOP);

    }

    public void Call(View v)
    {
        TextView t = findViewById(R.id.RatingText);
        t.setText("You Rated "+String.valueOf(rateBar.getRating()));
    }
}
