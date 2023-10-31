package com.biie.tenantfeedback.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.biie.tenantfeedback.R;

public class MainReport {

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

    public class MainReport extends AppCompatActivity implements
            AdapterView.OnItemSelectedListener {
        String[] country = { "A", "B", "C", "D", "E"};

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.report_main);
            //Getting the instance of Spinner and applying OnItemSelectedListener on it
            Spinner spin = (Spinner) findViewById(R.id.select_complaint);
            spin.setOnItemSelectedListener(this);

            //Creating the ArrayAdapter instance having the country list
            ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,country);
            aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            //Setting the ArrayAdapter data on the Spinner
            spin.setAdapter(aa);

        }
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.report_main);
            //Getting the instance of Spinner and applying OnItemSelectedListener on it
            Spinner spin = (Spinner) findViewById(R.id.select_department);
            spin.setOnItemSelectedListener(this);

            //Creating the ArrayAdapter instance having the country list
            ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,country);
            aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            //Setting the ArrayAdapter data on the Spinner
            spin.setAdapter(aa);

        }

        //Performing action onItemSelected and onNothing selected
        @Override
        public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
            Toast.makeText(getApplicationContext(),country[position] , Toast.LENGTH_LONG).show();
        }
        @Override
        public void onNothingSelected(AdapterView<?> arg0) {
            // TODO Auto-generated method stub
        }
//    // Main Activity implements Adapter view
//    public class MainReport
//            extends AppCompatActivity
//            implements AdapterView.OnItemSelectedListener {
//
//        // create array of Strings
//        // and store name of courses
//        String[] courses = { "C", "Data structures",
//                "Interview prep", "Algorithms",
//                "DSA with java", "OS" };
//
//        @Override
//        protected void onCreate(Bundle savedInstanceState)
//        {
//            super.onCreate(savedInstanceState);
//            setContentView(R.layout.activity_main);
//
//            // Take the instance of Spinner and
//            // apply OnItemSelectedListener on it which
//            // tells which item of spinner is clicked
//            Spinner spino = findViewById(R.id.coursesspinner);
//            spin.setOnItemSelectedListener(this);
//
//            // Create the instance of ArrayAdapter
//            // having the list of courses
//            ArrayAdapter ad
//                    = new ArrayAdapter(
//                    this,
//                    android.R.layout.simple_spinner_item,
//                    courses);
//
//            // set simple layout resource file
//            // for each item of spinner
//            ad.setDropDownViewResource(
//                    android.R.layout
//                            .simple_spinner_dropdown_item);
//
//            // Set the ArrayAdapter (ad) data on the
//            // Spinner which binds data to spinner
//            spino.setAdapter(ad);
//        }
//
//        // Performing action when ItemSelected
//        // from spinner, Overriding onItemSelected method
//        @Override
//        public void onItemSelected(AdapterView<*> arg0,
//                                   View arg1,
//                                   int position,
//                                   long id)
//        {
//
//            // make toastof name of course
//            // which is selected in spinner
//            Toast.makeText(getApplicationContext(),
//                            courses[position],
//                            Toast.LENGTH_LONG)
//                    .show();
//        }
//
//        @Override
//        public void onNothingSelected(AdapterView<*> arg0)
//        {
//            // Auto-generated method stub
//        }
//    }
}
