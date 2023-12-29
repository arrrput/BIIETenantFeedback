//package com.biie.tenantfeedback;
//
//import android.content.Context;
//import android.os.Build;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import androidx.annotation.RequiresApi;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.biie.tenantfeedback.model.TimeLineModel;
//import com.github.vipulasri.timelineview.TimelineView;
//
//import java.util.List;
//
//public class TimeLineAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
//
//        private List<TimeLineModel> timeLineModelList;
//        private Context context;
//
//        public TimeLineAdapter(Context context, List<TimeLineModel> timeLineModelList) {
//            this.timeLineModelList = timeLineModelList;
//            this.context = context;
//        }
//
//        @Override
//        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_timeline, parent, false);
//            return new ViewHolder(view, viewType);
//        }
//
//        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
//        @Override
//        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
//            ((ViewHolder) holder).tlname.setTextDirection(Integer.parseInt(timeLineModelList.get(position).getTLname()));
//            ((ViewHolder) holder).tltime.setTextDirection(Integer.parseInt(timeLineModelList.get(position).getTLtime()));
//            ((ViewHolder) holder).tlchat.setTextDirection(Integer.parseInt(timeLineModelList.get(position).getTLchat()));
//
//            if (timeLineModelList.get(position).getTLstatus().equals("inactive"))
//                ((ViewHolder) holder).timelineView.setMarker(context.getDrawable(ic_remove_circle_outline_black_24dp));
//            else
//                ((ViewHolder) holder).timelineView.setMarker(context.getDrawable(ic_remove_check_circle_black_24dp));
//        }
//
//        @Override
//        public int getItemViewType(int position) {
//            return TimelineView.getTimeLineViewType(position, getItemCount());
//        }
//
//        @Override
//        public int getItemCount() {
//            return timeLineModelList.size();
//        }
//
//        private class ViewHolder extends RecyclerView.ViewHolder {
//
//            TimelineView timelineView;
//            ImageView tlimage;
//            TextView tlname, tltime, tlchat;
//
//            ViewHolder(View itemView, int viewType) {
//                super(itemView);
//                timelineView = itemView.findViewById(R.id.);
//                tlimage = itemView.findViewById(R.id.TimelineImage);
//                tlname = itemView.findViewById(R.id.TimelineName);
//                tltime = itemView.findViewById(R.id.TimelineTime);
//                tlchat = itemView.findViewById(R.id.TimelineChat);
//
//
//                timelineView.initLine(viewType);
//            }
//        }
//}
