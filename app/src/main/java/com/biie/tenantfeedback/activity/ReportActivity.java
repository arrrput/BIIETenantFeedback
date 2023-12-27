package com.biie.tenantfeedback.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.biie.tenantfeedback.Dialog;
import com.biie.tenantfeedback.R;
import com.biie.tenantfeedback.api.API;
import com.biie.tenantfeedback.api.APICallback;
import com.biie.tenantfeedback.model.BadRequest;
import com.biie.tenantfeedback.model.PostModel;
import com.bumptech.glide.Glide;
import com.github.dhaval2404.imagepicker.ImagePicker;
import com.google.android.material.textfield.TextInputEditText;

import java.io.File;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

public class ReportActivity extends AppCompatActivity  {
    String depselect, partselect;
    String[] department = { "IT & Media", "Admin And Legal", "Estate", "Environtment", "Security and Safety",
            "Business Development and Villa", "Project & Port Ops", "Finance", "GMO", "HR and GA",
            "Integrated Management System", "Community Development", "Customer Relations"};
    int[] depvalue = {1, 2, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
    String[] part = { "Internet Did not work", "Wifi Unstable", "Parmit", "Export Import", "Building", "Infrastructure",
            "Power Supply", "Water Supply", "Plumbing and Sanitary", "Area Cleaning", "Pest Control", "Security",
            "Animal Disturbance", "Others", "Grass cutting", "Others", "Traffic", "Fire", "Others", "Contract",
            "Compliance", "Others", "Villa", "EV Resto", "Township apartment"};
    int[] partvalue = {1, 2, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25};
//    {1, 1, 2, 2, 4, 4, 4, 4, 4, 5, 5, 6, 6, 4, 5, 5, 6, 6, 6, 2, 2, 2, 7, 7, 7};
    ImageView Reportview_image;
    Button Reportinput_image;
    TextInputEditText location;
    TextInputEditText nounit;
    TextInputEditText desc;
    Button confirm_report;
    final Dialog loadingdialog = new Dialog(ReportActivity.this);
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

                loadingdialog.startLoadingdialog();

                // using handler class to set time delay methods
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // after 0.5 seconds
                        loadingdialog.dismissdialog();
                    }
                }, 500); // 0.5 seconds

                File file =new File( mCameraUri.getPath());
                RequestBody requestBody = RequestBody.create(MediaType.parse("multipart/form-data"),file);

                MultipartBody.Part image = MultipartBody.Part.createFormData("image",file.getName(),requestBody);
                RequestBody lokasi = RequestBody.create(MediaType.parse("text/plain"), location.getText().toString());
                RequestBody no_unit = RequestBody.create(MediaType.parse("text/plain"), nounit.getText().toString());
                RequestBody id_department = RequestBody.create(MediaType.parse("text/plain"), depselect.toString());
                RequestBody id_part = RequestBody.create(MediaType.parse("text/plain"), partselect.toString());
                RequestBody description = RequestBody.create(MediaType.parse("text/plain"), desc.getText().toString());

                API.service().callUploadApi(image, lokasi, no_unit, id_department, id_part, description).enqueue(new APICallback<PostModel>() {
                    @Override
                    protected void onSuccess(PostModel postModel) {
                        Toast.makeText(ReportActivity.this, "Reporting Success", Toast.LENGTH_SHORT).show();
                        finish();
                    }

                    @Override
                    protected void onError(BadRequest error) {
                        Toast.makeText(ReportActivity.this, "Reporting Failed", Toast.LENGTH_SHORT).show();

                    }
                });
//                String reporting = valueOf(location.getText()) + " "
//                        + valueOf(nounit.getText()) + System.getProperty("line.separator") + valueOf(desc.getText()) ;
//                Toast.makeText( ReportActivity.this, reporting, Toast.LENGTH_LONG).show();

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
        Spinner spin2 = findViewById(R.id.select_part);
        //Creating the ArrayAdapter instance having the part list
        ArrayAdapter aa2 = new ArrayAdapter(this,android.R.layout.simple_spinner_item,part);
        aa2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spin2.setAdapter(aa2);

        spin1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                depselect = String.valueOf(depvalue[position]);
                Log.e("departmentrelevant", String.valueOf(depselect));
            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Auto-generated method stub
            }

        });

        spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                partselect = String.valueOf(partvalue[position]);
                Log.e("partrelevant", String.valueOf(partselect));
            }


            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Auto-generated method stub
            }

        });
    }

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

