package com.biie.tenantfeedback.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.biie.tenantfeedback.R;

public class ProgressFragment extends Fragment {
    // Initialize variable
    TextView textView;
    Button timelineButton;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Initialize view
        View view =inflater.inflate(R.layout.fragment_progress, container, false);

        // Assign variable
        textView=view.findViewById(R.id.text_view);

        // Get Title
        String sTitle=getArguments().getString("title");

        // Set title on text view
        textView.setText(sTitle);

        // return view
        return view;

    }
}