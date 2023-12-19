package com.biie.tenantfeedback.fragment;

import android.annotation.SuppressLint;
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

public class NotFragment extends Fragment {
    // Initialize variable
    RecyclerView feedRV;
    ArrayList<FeedModel> feedModelArrayList = new ArrayList<FeedModel>();
    @Override
    @SuppressLint("MissingInflatedId")
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Initialize view
        View view =inflater.inflate(R.layout.fragment_not, container, false);

        feedRV = view.findViewById(R.id.idRVNot);

        getNotRequest();

        return view;
    }
    void getNotRequest(){

        API.service().getRequest("1").enqueue(new APICallback<List<RequestModel>>() {
            @Override
            protected void onSuccess(List<RequestModel> requestModels) {

                for (int i = 0; i < requestModels.size(); i++){
                    feedModelArrayList.add(new FeedModel(requestModels.get(i).getDescription(),
                            requestModels.get(i).getCreated_at(),requestModels.get(i).getImage()));

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