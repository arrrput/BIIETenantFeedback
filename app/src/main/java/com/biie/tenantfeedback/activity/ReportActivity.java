package com.biie.tenantfeedback.activity;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import com.biie.tenantfeedback.R;


public class ReportActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    String[] department = { "A", "B", "C", "D", "E"};
    String[] complaint = { "F", "G", "H", "I", "J"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        //Getting the instance of Spinner and applying OnItemSelectedListener on it
        Spinner spin1 = (Spinner) findViewById(R.id.select_department);
        spin1.setOnItemSelectedListener(this);
        //Creating the ArrayAdapter instance having the department list
        ArrayAdapter aa1 = new ArrayAdapter(this,android.R.layout.simple_spinner_item,department);
        aa1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spin1.setAdapter(aa1);

        //Getting the instance of Spinner and applying OnItemSelectedListener on it
        Spinner spin2 = (Spinner) findViewById(R.id.select_complaint);
        spin2.setOnItemSelectedListener(this);
        //Creating the ArrayAdapter instance having the complaint list
        ArrayAdapter aa2 = new ArrayAdapter(this,android.R.layout.simple_spinner_item,complaint);
        aa2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spin2.setAdapter(aa2);

    }

    //Performing action onItemSelected and onNothing selected
    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
        Toast.makeText(getApplicationContext(),department[position] , Toast.LENGTH_SHORT).show();
        Toast.makeText(getApplicationContext(),complaint[position] , Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }

}

