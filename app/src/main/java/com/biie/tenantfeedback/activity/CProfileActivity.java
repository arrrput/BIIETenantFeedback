package com.biie.tenantfeedback.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.biie.tenantfeedback.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import de.hdodenhof.circleimageview.CircleImageView;

public class CProfileActivity extends AppCompatActivity {
    Button confirm_profile;
    FloatingActionButton Profilinput_image;
    CircleImageView Profilview_image;

    int Profilselect_image = 100;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cprofile);

        confirm_profile = findViewById(R.id.confirm_profile);
        Profilinput_image = findViewById(R.id.Profilinput_image);
        Profilview_image = findViewById(R.id.Profilview_image);
        confirm_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CProfileActivity.this, ProfileActivity.class));
            }
        });

        Profilinput_image.setOnClickListener(new View.OnClickListener() {
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

        startActivityForResult(Intent.createChooser(i, "Select Image"), Profilselect_image);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {

            // compare the resultCode with the
            // SELECT_PICTURE constant
            if (requestCode == Profilselect_image) {
                // Get the url of the image from data
                Uri selectedImageUri = data.getData();
                if (null != selectedImageUri) {
                    // update the preview image in the layout
                    Profilview_image.setImageURI(selectedImageUri);
                }
            }
        }
    }
}