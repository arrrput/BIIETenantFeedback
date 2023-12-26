package com.biie.tenantfeedback.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.biie.tenantfeedback.R;
import com.bumptech.glide.Glide;
import com.github.dhaval2404.imagepicker.ImagePicker;
import com.google.android.material.textfield.TextInputEditText;

import java.io.File;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

public class ReportActivity extends AppCompatActivity  {
    String depselect, compselect;
    String[] department = { "IT & Media", "Admin And Legal", "Estate", "GMO", "Security and Safety"};
    String[] complaint = { "Software", "Hardware", "Environment", "Building", "Other"};
    ImageView Reportview_image;
    Button Reportinput_image;
    TextInputEditText location;
    TextInputEditText nounit;
    TextInputEditText desc;
    Button confirm_report;
    int Reportselect_image = 200;

    private Uri mCameraUri;
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

                File file =new File( mCameraUri.getPath());
                RequestBody requestBody = RequestBody.create(MediaType.parse("multipart/form-data"),file);

                MultipartBody.Part image = MultipartBody.Part.createFormData("sendimage",file.getName(),requestBody);
                RequestBody lokasi = RequestBody.create(MediaType.parse("text/plain"), location.getText().toString());
                RequestBody no_unit = RequestBody.create(MediaType.parse("text/plain"), nounit.getText().toString());
                RequestBody description = RequestBody.create(MediaType.parse("text/plain"), desc.getText().toString());
                RequestBody id_department = RequestBody.create(MediaType.parse("text/plain"), department.getClass().toString());
                RequestBody id_part = RequestBody.create(MediaType.parse("text/plain"), complaint.getClass().toString());



//                String reporting = valueOf(location.getText()) + " "
//                        + valueOf(nounit.getText()) + System.getProperty("line.separator") + valueOf(desc.getText()) ;
//                Toast.makeText( ReportActivity.this, reporting, Toast.LENGTH_LONG).show();

                startActivity(new Intent(ReportActivity.this, ProgressActivity.class));
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
        Spinner spin1 = findViewById(R.id.select_department);
        //Creating the ArrayAdapter instance having the department list
        ArrayAdapter aa1 = new ArrayAdapter(this,android.R.layout.simple_spinner_item,department);
        aa1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spin1.setAdapter(aa1);

        //Getting the instance of Spinner and applying OnItemSelectedListener on it
        Spinner spin2 = findViewById(R.id.select_complaint);
        //Creating the ArrayAdapter instance having the complaint list
        ArrayAdapter aa2 = new ArrayAdapter(this,android.R.layout.simple_spinner_item,complaint);
        aa2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spin2.setAdapter(aa2);

        spin1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                depselect = department[position];
                Toast.makeText(ReportActivity.this, department[position], Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Auto-generated method stub
            }

        });

        spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                compselect = complaint[position];
                Toast.makeText(ReportActivity.this, complaint[position], Toast.LENGTH_SHORT).show();
            }


            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Auto-generated method stub
            }

        });
    }

//    void PostReport(){
//        API.service().callUploadApi().enqueue(new APICallback<PostModel>() {
//            @Override
//            protected void onSuccess(PostModel postModel) {
//
//            }
//
//
//            @Override
//            protected void onError(BadRequest error) {
//
//            }
//        });
//    }
    //select image
    void imagechooser(){
        ImagePicker.with(this)
                .cropSquare()                   //Crop image(Optional), Check Customization for more option
                .saveDir(getApplicationContext().getExternalFilesDir(Environment.DIRECTORY_PICTURES))
                .compress(512)          //Final image size will be less than 1 MB(Optional)
                .maxResultSize(420, 420)    //Final image resolution will be less than 1080 x 1080(Optional)
                .createIntent(intent -> {
                    startActivityForResult(intent, 0);
                    return null;
                });
    }
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Uri uri = data.getData();
        if (resultCode == RESULT_OK){
            if (requestCode == 0){
                mCameraUri = uri;
                Glide.with(getApplicationContext())
                        .load(uri)
                        .into(Reportview_image);
//                uploadPhoto();
            }
        }
    }

}

