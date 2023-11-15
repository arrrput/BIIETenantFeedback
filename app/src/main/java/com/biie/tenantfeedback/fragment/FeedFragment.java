package com.biie.tenantfeedback.fragment;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.biie.tenantfeedback.FeedAdapter;
import com.biie.tenantfeedback.FeedModel;
import com.biie.tenantfeedback.R;
import com.biie.tenantfeedback.api.API;
import com.biie.tenantfeedback.api.APICallback;
import com.biie.tenantfeedback.model.BadRequest;
import com.biie.tenantfeedback.model.Simplist;

import java.util.ArrayList;

public class FeedFragment extends Fragment {
    // Initialize variable
    RecyclerView feedRV;
    ArrayList<FeedModel> feedModelArrayList = new ArrayList<FeedModel>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Initialize view
        View view =inflater.inflate(R.layout.fragment_feed, container, false);

        feedRV = view.findViewById(R.id.idRVFeed);

        getProduct();
        // return view
        return view;
    }
    void getProduct(){
        API.service().getProduct().enqueue(new APICallback<Simplist>() {
            @Override
            protected void onSuccess(Simplist simplist) {
                simplist.getList().get(0).getDescription();
                Toast.makeText(getContext(), simplist.getList().get(0).getDescription(), Toast.LENGTH_SHORT).show();
                for(int i = 0; i < simplist.getList().size(); i++){
                    feedModelArrayList.add(new FeedModel(simplist.getList().get(i).getTitle(), simplist.getList().get(i).getId(), R.drawable.logo));
//                    feedModelArrayList.add(new FeedModel("Jaringan WiFi lelet", 3, R.drawable.logo));
                }
                FeedAdapter feedAdapter = new FeedAdapter(getActivity(), feedModelArrayList);

                // below line is for setting a layout manager for our recycler view.
                // here we are creating vertical list so we will provide orientation as vertical
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);

                // in below two lines we are setting layoutmanager and adapter to our recycler view.
                feedRV.setLayoutManager(linearLayoutManager);
                feedRV.setAdapter(feedAdapter);
            }

            @Override
            protected void onError(BadRequest error) {

            }
        });
    }
}