package com.biie.tenantfeedback.activity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.biie.tenantfeedback.R;
import com.biie.tenantfeedback.api.API;
import com.biie.tenantfeedback.api.APICallback;
import com.biie.tenantfeedback.model.BadRequest;
import com.biie.tenantfeedback.model.PostModel;
import com.biie.tenantfeedback.model.RatingModel;
import com.google.android.material.textfield.TextInputEditText;

public class RatingActivity extends AppCompatActivity {
    RatingBar rateBar;
    TextInputEditText rateComment;
    String newTimeline;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


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
        setContentView(R.layout.activity_rating);

        rateBar = findViewById(R.id.RatingBar);
        rateComment = findViewById(R.id.RateComment);

        //finding the specific RatingBar with its unique ID
        LayerDrawable stars=(LayerDrawable)rateBar.getProgressDrawable();

        //Use for changing the color of RatingBar
        stars.getDrawable(2).setColorFilter(Color.GREEN, PorterDuff.Mode.SRC_ATOP);

    }

    public void Call(View v)
    {
        TextView t = findViewById(R.id.RatingText);
        t.setText("You Rated "+String.valueOf(rateBar.getRating()));
//        Toast.makeText(this, String.valueOf(rateBar.getRating()), Toast.LENGTH_SHORT).show();
        Toast.makeText(this, String.valueOf(rateComment.getText()), Toast.LENGTH_SHORT).show();
        RatingModel ratingModel = new RatingModel();
        ratingModel.setRate_point(rateBar.getRating());
        ratingModel.setMessage(rateComment.getText().toString());
        ratingModel.setId_request(Integer.parseInt(newTimeline));
        API.service().postRating(ratingModel).enqueue(new APICallback<PostModel>() {
            @Override
            protected void onSuccess(PostModel postModel) {
                Toast.makeText(RatingActivity.this, "Rating berhasil", Toast.LENGTH_SHORT).show();
                finish();
            }

            @Override
            protected void onError(BadRequest error) {
                Toast.makeText(RatingActivity.this, "Rating gagal", Toast.LENGTH_SHORT).show();
            }
        });
    }


}
