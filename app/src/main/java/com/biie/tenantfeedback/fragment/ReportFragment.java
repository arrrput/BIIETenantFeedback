//package com.biie.tenantfeedback.fragment;
//
//import android.view.View;
//import android.view.ViewGroup;
//
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.biie.tenantfeedback.R;
//import com.github.vipulasri.timelineview.TimelineView;
//
//public class ReportFragment {
//    public static class TimeLineViewHolder extends RecyclerView.ViewHolder {
//        public TimelineView mTimelineView;
//
//        public TimeLineViewHolder(View itemView, int viewType) {
//            super(itemView);
//            mTimelineView = (TimelineView) itemView.findViewById(R.id.timeline);
//            mTimelineView.initLine(viewType);
//        }
//        @Override
//        public int getItemViewType(int position) {
//            return TimelineView.getTimeLineViewType(position, getItemCount());
//        }
//
//        @Override
//        public TimeLineViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//            View view = View.inflate(parent.getContext(), R.layout.item_timeline, null);
//            return new TimeLineViewHolder(view, viewType);
//        }
//    }
//
//
//}
