package com.biie.tenantfeedback;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.biie.tenantfeedback.model.TimeLineModel;
import com.github.vipulasri.timelineview.TimelineView;

import java.util.List;

public class TimeLineAdapter {

    class TimeLineAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        private List<TimeLineModel> timeLineModelList;
        private Context context;

        TimeLineAdapter(Context context, List<TimeLineModel> timeLineModelList) {
            this.timeLineModelList = timeLineModelList;
            this.context = context;
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_timeline_layout, parent, false);
            return new ViewHolder(view, viewType);
        }

        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            ((ViewHolder) holder).textView.setText(timeLineModelList.get(position).getName());
            ((ViewHolder) holder).textViewDescription.setText(timeLineModelList.get(position).getDescription());
            ((ViewHolder)holder).textViewTime.setText(timeLineModelList.get(position).getTime());

            if (timeLineModelList.get(position).getStatus().equals("inactive"))
                ((ViewHolder) holder).timelineView.setMarker(context.getDrawable(ic_remove_circle_outline_black_24dp));
            else
                ((ViewHolder) holder).timelineView.setMarker(context.getDrawable(ic_check_circle_black_24dp));
        }

        @Override
        public int getItemViewType(int position) {
            return TimelineView.getTimeLineViewType(position, getItemCount());
        }

        @Override
        public int getItemCount() {
            return timeLineModelList.size();
        }

        private class ViewHolder extends RecyclerView.ViewHolder {

            TimelineView timelineView;
            TextView textView, textViewDescription, textViewTime;

            ViewHolder(View itemView, int viewType) {
                super(itemView);
                timelineView = itemView.findViewById(R.id.);
                textView = itemView.findViewById(R.id.TimelineName);
                textViewDescription = itemView.findViewById(R.id.);
                textViewTime = itemView.findViewById(R.id.TimelineTime);

                timelineView.initLine(viewType);
            }
        }
}
