package com.biie.tenantfeedback.activity;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.Button;
import android.net.Uri;
import com.biie.tenantfeedback.R;
import android.content.Intent;

public class ReportActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    String[] department = { "A", "B", "C", "D", "E"};
    String[] complaint = { "F", "G", "H", "I", "J"};

    Button input_image;
    ImageView view_image;
    int select_image = 200;
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

        input_image = findViewById(R.id.input_image);
        view_image = findViewById(R.id.view_image);

        input_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imagechooser();
            }
        });
    }

    void imagechooser(){
        Intent i = new Intent();
        i.setType("image/*");
        i.setAction(Intent.ACTION_GET_CONTENT);

        startActivityForResult(Intent.createChooser(i, "Select Image"), select_image);
    }
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {

            // compare the resultCode with the
            // SELECT_PICTURE constant
            if (requestCode == select_image) {
                // Get the url of the image from data
                Uri selectedImageUri = data.getData();
                if (null != selectedImageUri) {
                    // update the preview image in the layout
                    view_image.setImageURI(selectedImageUri);
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

