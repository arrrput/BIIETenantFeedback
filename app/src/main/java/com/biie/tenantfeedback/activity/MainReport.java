package com.biie.tenantfeedback.activity;

public class MainReport {

import android.support.v7.app.AppCompatActivity;
import android.widget.AdapterView;
import android.view.View;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.os.Bundle;

    // Main Activity implements Adapter view
    public class MainActivity
            extends AppCompatActivity
            implements AdapterView.OnItemSelectedListener {

        // create array of Strings
        // and store name of courses
        String[] courses = { "C", "Data structures",
                "Interview prep", "Algorithms",
                "DSA with java", "OS" };

        @Override
        protected void onCreate(Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            // Take the instance of Spinner and
            // apply OnItemSelectedListener on it which
            // tells which item of spinner is clicked
            Spinner spino = findViewById(R.id.coursesspinner);
            spin.setOnItemSelectedListener(this);

            // Create the instance of ArrayAdapter
            // having the list of courses
            ArrayAdapter ad
                    = new ArrayAdapter(
                    this,
                    android.R.layout.simple_spinner_item,
                    courses);

            // set simple layout resource file
            // for each item of spinner
            ad.setDropDownViewResource(
                    android.R.layout
                            .simple_spinner_dropdown_item);

            // Set the ArrayAdapter (ad) data on the
            // Spinner which binds data to spinner
            spino.setAdapter(ad);
        }

        // Performing action when ItemSelected
        // from spinner, Overriding onItemSelected method
        @Override
        public void onItemSelected(AdapterView<*> arg0,
                                   View arg1,
                                   int position,
                                   long id)
        {

            // make toastof name of course
            // which is selected in spinner
            Toast.makeText(getApplicationContext(),
                            courses[position],
                            Toast.LENGTH_LONG)
                    .show();
        }

        @Override
        public void onNothingSelected(AdapterView<*> arg0)
        {
            // Auto-generated method stub
        }
    }
}
