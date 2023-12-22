package com.biie.tenantfeedback.activity;

import static java.lang.String.valueOf;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.biie.tenantfeedback.R;
import com.google.android.material.textfield.TextInputEditText;

public class ReportActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    String[] department = { "IT & Media", "Admin And Legal", "Estate", "GMO", "Security and Safety"};
    String[] complaint = { "Software", "Hardware", "Environment", "Building", "Other"};
    ImageView Reportview_image;
    Button Reportinput_image;
    TextInputEditText location;
    TextInputEditText nounit;
    TextInputEditText desc;
    Button confirm_report;
    int Reportselect_image = 200;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        Reportinput_image = findViewById(R.id.Reportinput_image);
        Reportview_image = findViewById(R.id.Reportview_image);
        location = findViewById(R.id.input_location);
        nounit = findViewById(R.id.input_nounit);
        desc = findViewById(R.id.input_desc);
        confirm_report = findViewById(R.id.confirm_report);

        confirm_report.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String reporting = valueOf(location.getText()) + valueOf(nounit.getText()) + valueOf(desc.getText());
                Toast.makeText( ReportActivity.this, reporting, Toast.LENGTH_LONG).show();
//                startActivity(new Intent(ReportActivity.this, ProgressActivity.class));
            }
        });
        //select image
        Reportinput_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imagechooser();
            }
        });

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

    //select image
    void imagechooser(){
        Intent i = new Intent();
        i.setType("image/*");
        i.setAction(Intent.ACTION_GET_CONTENT);

        startActivityForResult(Intent.createChooser(i, "Select Image"), Reportselect_image);
    }
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {

            // compare the resultCode with the
            // SELECT_PICTURE constant
            if (requestCode == Reportselect_image) {
                // Get the url of the image from data
                Uri selectedImageUri = data.getData();
                if (null != selectedImageUri) {
                    // update the preview image in the layout
                    Reportview_image.setImageURI(selectedImageUri);
                }
            }
        }
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

