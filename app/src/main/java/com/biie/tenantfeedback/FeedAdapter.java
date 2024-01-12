package com.biie.tenantfeedback;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.biie.tenantfeedback.activity.TimeLineActivity;
import com.biie.tenantfeedback.model.FeedModel;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class FeedAdapter extends RecyclerView.Adapter<FeedAdapter.ViewHolder> {

    private final Context context;
    private final ArrayList<FeedModel> feedModelArrayList;

    // Constructor
    public FeedAdapter(Context context, ArrayList<FeedModel> feedModelArrayList) {
        this.context = context;
        this.feedModelArrayList = feedModelArrayList;
    }

    @NonNull
    @Override
    public FeedAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // to inflate the layout for each item of recycler view.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FeedAdapter.ViewHolder holder, int position) {
        // to set data to textview and imageview of each card layout
        FeedModel model = feedModelArrayList.get(position);
        holder.FeedName.setText(model.getFeed_name());
        holder.FeedTime.setText(String.valueOf(model.getFeed_time().toString()));
        Glide.with(context)
                .load("http://192.168.68.123:8080/storage/img_progress/"+model.getFeed_image())
                .into(holder.FeedImage);
        holder.rLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, TimeLineActivity.class);
                i.putExtra("ID", String.valueOf(model.getFeed_id()));
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        // this method is used for showing number of card items in recycler view
        return feedModelArrayList.size();
    }



    // View holder class for initializing of your views such as TextView and Imageview
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView FeedImage;
        private final TextView FeedName;
        private final TextView FeedTime;
        private final RelativeLayout rLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            FeedImage = itemView.findViewById(R.id.FeedImage);
            FeedName = itemView.findViewById(R.id.FeedName);
            FeedTime = itemView.findViewById(R.id.FeedTime);
            rLayout = itemView.findViewById(R.id.r_layout);
        }
    }
}
