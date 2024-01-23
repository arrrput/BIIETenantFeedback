package com.biie.tenantfeedback.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.biie.tenantfeedback.R;
import com.biie.tenantfeedback.api.API;
import com.biie.tenantfeedback.api.APICallback;
import com.biie.tenantfeedback.model.BadRequest;
import com.biie.tenantfeedback.model.TimeLineModel;
import com.bumptech.glide.Glide;


public class TimeLineActivity extends AppCompatActivity {

    String newTimeline;
    LinearLayout linear_response, linear_progress, linear_finish;
    ImageView imageRequest, imageProgress, imageFinished;
    TextView nameRequest, timeRequest, descRequest;
    TextView nameResponse, timeResponse, descResponse;
    TextView nameProgress, timeProgress, descProgress;
    TextView nameFinish, timeFinish, descFinish;
    Button rateFinish;
    TextView commentView;

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

        setContentView(R.layout.activity_timeline);

        linear_response = findViewById(R.id.Linear_response);
        linear_progress = findViewById(R.id.Linear_progress);
        linear_finish = findViewById(R.id.Linear_finish);

        imageRequest = findViewById(R.id.ImageViewRequest);
        nameRequest = findViewById(R.id.NameRequest);
        timeRequest = findViewById(R.id.TimeRequest);
        descRequest = findViewById(R.id.DescRequest);

        nameResponse = findViewById(R.id.NameResponse);
        timeResponse = findViewById(R.id.TimeResponse);
        descResponse = findViewById(R.id.DescResponse);

        nameProgress = findViewById(R.id.NameProgress);
        timeProgress = findViewById(R.id.TimeProgress);
        descProgress = findViewById(R.id.DescProgress);
        imageProgress = findViewById(R.id.imageProgress);

        imageFinished = findViewById(R.id.imageFinished);
        rateFinish = findViewById(R.id.RatingFinish);
        commentView = findViewById(R.id.CommentView);
        nameFinish = findViewById(R.id.NameFinish);
        timeFinish = findViewById(R.id.TimeFinish);
        descFinish = findViewById(R.id.DescFinish);

        getTimeline();

    }

    void getTimeline(){
        API.service().getTimeline(newTimeline).enqueue(new APICallback<TimeLineModel>() {
            @Override
            protected void onSuccess(TimeLineModel timeLineModel) {

                Glide.with(getApplicationContext())
                        .load("http://192.168.68.114:8080/storage/img_progress/"+timeLineModel.getImage_request())
                        .into(imageRequest);
                imageRequest.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(getApplicationContext(),TLImageActivity.class);
                        i.putExtra("ID","http://192.168.68.114:8080/storage/img_progress/"+timeLineModel.getImage_request());
                        startActivity(i);
                    }
                });

                nameRequest.setText(timeLineModel.getUsername());
                timeRequest.setText(timeLineModel.getRequests_created_at());
                descRequest.setText(timeLineModel.getUser_desc());

                if (timeLineModel.getStatus() == 2){
                    linear_response.setVisibility(View.VISIBLE);
                    nameResponse.setText(timeLineModel.getDept_response());
                    timeResponse.setText(timeLineModel.getResponse_created_at());
                    descResponse.setText(timeLineModel.getResponse_desc());
                }
                else if (timeLineModel.getStatus() == 3){
                    linear_response.setVisibility(View.VISIBLE);
                    nameResponse.setText(timeLineModel.getDept_response());
                    timeResponse.setText(timeLineModel.getResponse_created_at());
                    descResponse.setText(timeLineModel.getResponse_desc());

                    Glide.with(getApplicationContext())
                            .load("http://192.168.68.114:8080/storage/img_progress/"+timeLineModel.getImage_pg())
                            .into(imageProgress);
                    linear_progress.setVisibility(View.VISIBLE);
                    nameProgress.setText(timeLineModel.getDept_response());
                    timeProgress.setText(timeLineModel.getProgress_created_at());
                    descProgress.setText(timeLineModel.getProgress_desc());
                    imageProgress.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent i = new Intent(getApplicationContext(),TLImageActivity.class);
                            i.putExtra("ID","http://192.168.68.114:8080/storage/img_progress/"+timeLineModel.getImage_pg());
                            startActivity(i);
                        }
                    });
                }
                else if (timeLineModel.getStatus() == 4){

//                    RatingModel ratingModel = new RatingModel();
//                    commentView.setText(ratingModel.getMessage());

                    if(timeLineModel.getStatus_rate() == 1){
                        rateFinish.setVisibility(View.GONE);
                    }
                    else{
                        rateFinish.setVisibility(View.VISIBLE);
                    }

                    linear_response.setVisibility(View.VISIBLE);
                    nameResponse.setText(timeLineModel.getDept_response());
                    timeResponse.setText(timeLineModel.getResponse_created_at());
                    descResponse.setText(timeLineModel.getResponse_desc());

                    Glide.with(getApplicationContext())
                            .load("http://192.168.68.114:8080/storage/img_progress/"+timeLineModel.getImage_pg())
                            .into(imageProgress);
                    linear_progress.setVisibility(View.VISIBLE);
                    imageProgress.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent i = new Intent(getApplicationContext(),TLImageActivity.class);
                            i.putExtra("ID","http://192.168.68.114:8080/storage/img_progress/"+timeLineModel.getImage_pg());
                            startActivity(i);
                        }
                    });
                    nameProgress.setText(timeLineModel.getDept_response());
                    timeProgress.setText(timeLineModel.getProgress_created_at());
                    descProgress.setText(timeLineModel.getProgress_desc());

                    Glide.with(getApplicationContext())
                            .load("http://192.168.68.114:8080/storage/img_finish/"+timeLineModel.getImage_finish())
                            .into(imageFinished);

                    imageFinished.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent i = new Intent(getApplicationContext(),TLImageActivity.class);
                            i.putExtra("ID","http://192.168.68.114:8080/storage/img_finish/"+timeLineModel.getImage_finish());
                            startActivity(i);
                        }
                    });
                    linear_finish.setVisibility(View.VISIBLE);
                    nameFinish.setText(timeLineModel.getDept_response());
                    timeFinish.setText(timeLineModel.getFinish_created_at());
                    descFinish.setText(timeLineModel.getFinish_desc());

                    rateFinish.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent i = new Intent(getApplicationContext(), RatingActivity.class);
                            i.putExtra("ID", String.valueOf(newTimeline));
                            startActivity(i);
                        }
                    });

                }
                else {}
            }

            @Override
            protected void onError(BadRequest error) {

            }
        });

    }
}
