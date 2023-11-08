package com.biie.tenantfeedback;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class FeedFragment extends Fragment {
    // Initialize variable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Initialize view
        View view =inflater.inflate(R.layout.fragment_feed, container, false);

        RecyclerView feedRV = view.findViewById(R.id.idRVFeed);

        // Here, we have created new array list and added data to it
        ArrayList<FeedModel> feedModelArrayList = new ArrayList<FeedModel>();
        feedModelArrayList.add(new FeedModel("DSA in Java", 4, R.drawable.logo));
        feedModelArrayList.add(new FeedModel("Java Course", 3, R.drawable.logo));
        feedModelArrayList.add(new FeedModel("C++ Course", 4, R.drawable.logo));
        feedModelArrayList.add(new FeedModel("DSA in C++", 4, R.drawable.logo));
        feedModelArrayList.add(new FeedModel("Kotlin for Android", 4, R.drawable.logo));
        feedModelArrayList.add(new FeedModel("Java for Android", 4, R.drawable.logo));
        feedModelArrayList.add(new FeedModel("HTML and CSS", 4, R.drawable.logo));

        // we are initializing our adapter class and passing our arraylist to it.
        FeedAdapter feedAdapter = new FeedAdapter(getActivity(), feedModelArrayList);

        // below line is for setting a layout manager for our recycler view.
        // here we are creating vertical list so we will provide orientation as vertical
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);

        // in below two lines we are setting layoutmanager and adapter to our recycler view.
        feedRV.setLayoutManager(linearLayoutManager);
        feedRV.setAdapter(feedAdapter);
        // return view
        return view;
    }
}