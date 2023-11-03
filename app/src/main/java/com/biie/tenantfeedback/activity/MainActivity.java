package com.biie.tenantfeedback.activity;

import android.content.Intent;
import android.os.Bundle;
import com.biie.tenantfeedback.R;
import com.biie.tenantfeedback.api.API;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import android.view.View;
import android.widget.Toast;
import android.widget.Button;
//import android.view.Menu;
//import android.view.MenuInflater;
//import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    CardView action_profile;
    CardView action_report;
    CardView action_progress;
    private int message;

    //    private MenuItem item;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (!API.isLogin()) {
            startActivity(new Intent(getApplicationContext(), LoginActivity.class));
            finish();
        }
        setContentView(R.layout.activity_main);

        action_profile = findViewById(R.id.action_profile);
        action_report = findViewById(R.id.action_report);
        action_progress = findViewById(R.id.action_progress);

        action_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ProfileActivity.class));
            }
        });
        action_report.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ReportActivity.class));
            }
        });
        action_progress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ProgressActivity.class));
            }
        });
    }
}

//        Button btnProfile = findViewById(R.id.action_profile);
//        Button btnReport = findViewById(R.id.action_report);
//        Button btnProgress = findViewById(R.id.action_progress);
//
//        btnProfile.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(MainActivity.this, ProfileActivity.class));
//            }
//        });
//
//        btnReport.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(MainActivity.this, ReportActivity.class));
//            }
//        });
//        btnProgress.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(MainActivity.this, ProgressActivity.class));
//            }
//        });




//        @Override
//        public boolean onCreateOptionsMenu(Menu menu) {
//            // Inflate the menu; this adds items to the action bar if it is present.
//            MenuInflater inflater = getMenuInflater();
//            inflater.inflate(R.menu.menu_main, menu);
//            // getMenuInflater().inflate(R.menu.menu_main, menu);
//            return true;
//        }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        // int id = item.getItemId();
//        // noinspection SimplifiableIfStatement
//        if (item.getItemId() == R.id.action_profile) {
//            startActivity(new Intent(this, ProfileActivity.class));
//        } else if (item.getItemId() == R.id.action_report) {
//            startActivity(new Intent(this, ReportActivity.class));
//        } else if (item.getItemId() == R.id.action_progress) {
//            startActivity(new Intent(this,ProgressActivity.class));
//        }
//        return true;
//        else if (item.getItemId() == R.id.action_settings) {
//            startActivity(new Intent(this,));
//        } else if (item.getItemId() == R.id.action_about) {
//            startActivity(new Intent(this,));
//        } else if (item.getItemId() == R.id.action_logout) {
//            startActivity(new Intent(this,));
//        }

//        return super.onOptionsItemSelected(item);
//    }
