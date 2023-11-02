package com.biie.tenantfeedback.activity;

import android.content.Intent;
import android.os.Bundle;

import com.biie.tenantfeedback.R;
import com.biie.tenantfeedback.api.API;

import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(!API.isLogin()){
            startActivity(new Intent(getApplicationContext(), LoginActivity.class ));
            finish();
        }
        setContentView(R.layout.activity_main);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        // getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        // int id = item.getItemId();
        // noinspection SimplifiableIfStatement
        if (item.getItemId() == R.id.action_profile) {
            startActivity(new Intent(this, ProfileActivity.class));
        } else if (item.getItemId() == R.id.action_report) {
            startActivity(new Intent(this, ReportActivity.class));
        } else if (item.getItemId() == R.id.action_progress) {
            startActivity(new Intent(this,ProgressActivity.class));
        }
//        else if (item.getItemId() == R.id.action_settings) {
//            startActivity(new Intent(this,));
//        } else if (item.getItemId() == R.id.action_about) {
//            startActivity(new Intent(this,));
//        } else if (item.getItemId() == R.id.action_logout) {
//            startActivity(new Intent(this,));
//        }

        return super.onOptionsItemSelected(item);
    }
}
