package com.biie.tenantfeedback.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.biie.tenantfeedback.FeedAdapter;
import com.biie.tenantfeedback.R;
import com.biie.tenantfeedback.api.API;
import com.biie.tenantfeedback.api.APICallback;
import com.biie.tenantfeedback.model.BadRequest;
import com.biie.tenantfeedback.model.FeedModel;
import com.biie.tenantfeedback.model.RequestModel;

import java.util.ArrayList;
import java.util.List;

public class FeedFragment extends Fragment {
    // Initialize variable
    RecyclerView feedRV;
    ArrayList<FeedModel> feedModelArrayList = new ArrayList<FeedModel>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Initialize view
        View view =inflater.inflate(R.layout.fragment_feed, container, false);

        feedRV = view.findViewById(R.id.idRVFeed);

        getOnRequest();
        // return view
        return view;
    }
    void getOnRequest(){

        API.service().getRequest("2").enqueue(new APICallback<List<RequestModel>>() {
            @Override
            protected void onSuccess(List<RequestModel> requestModels) {
                for (int i = 0; i < requestModels.size(); i++){
                    feedModelArrayList.add(new FeedModel(requestModels.get(i).getDescription(),
                            requestModels.get(i).getProgress_request(), R.drawable.logo));

                }
                FeedAdapter feedAdapter = new FeedAdapter(getActivity(), feedModelArrayList);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);

                feedRV.setLayoutManager(linearLayoutManager);
                feedRV.setAdapter(feedAdapter);
            }

            @Override
            protected void onError(BadRequest error) {

            }
        });
    }
}