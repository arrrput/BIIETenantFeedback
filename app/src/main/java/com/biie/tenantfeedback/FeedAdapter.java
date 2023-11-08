package com.biie.tenantfeedback;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
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
        holder.feedNameTV.setText(model.getFeed_name());
        holder.feedRatingTV.setText("" + model.getFeed_rating());
        holder.feedIV.setImageResource(model.getFeed_image());
    }

    @Override
    public int getItemCount() {
        // this method is used for showing number of card items in recycler view
        return feedModelArrayList.size();
    }

    // View holder class for initializing of your views such as TextView and Imageview
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView feedIV;
        private final TextView feedNameTV;
        private final TextView feedRatingTV;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            feedIV = itemView.findViewById(R.id.idIVFeedImage);
            feedNameTV = itemView.findViewById(R.id.idTVFeedName);
            feedRatingTV = itemView.findViewById(R.id.idTVFeedRating);
        }
    }
}
