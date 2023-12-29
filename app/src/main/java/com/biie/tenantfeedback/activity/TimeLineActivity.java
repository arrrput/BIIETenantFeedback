//package com.biie.tenantfeedback.activity;
//
//import android.os.Bundle;
//
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.recyclerview.widget.DividerItemDecoration;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.biie.tenantfeedback.R;
//import com.biie.tenantfeedback.TimeLineAdapter;
//import com.biie.tenantfeedback.model.TimeLineModel;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class TimeLineActivity extends AppCompatActivity {
//
//    RecyclerView recyclerView;
//    String[] name = {"Event 1", "Event 2", "Event 3"};
//    String[] status = {"active", "inactive", "inactive"};
//    String[] chat = {"chat 1","chat 2","chat 3"};
//    String[] time = {"11:00 PM", "10:03 AM", "10:03 PM"};
//
//    List<TimeLineModel> timeLineModelList;
//    TimeLineModel[] timeLineModel;
//    TimeLineActivity context;
//    LinearLayoutManager linearLayoutManager;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_timeline);
//
//        timeLineModelList = new ArrayList<>();
//        int size = name.length;
//        timeLineModel = new TimeLineModel[size];
//        context = TimeLineActivity.this;
//        linearLayoutManager = new LinearLayoutManager(this);
//
//        for (int i = 0; i < size; i++) {
//            timeLineModel[i] = new TimeLineModel();
//            timeLineModel[i].setTLname(name[i]);
//            timeLineModel[i].setTLstatus(status[i]);
//            timeLineModel[i].setTLchat(chat[i]);
//            timeLineModel[i].setTLtime(time[i]);
//            timeLineModelList.add(timeLineModel[i]);
//        }
//
//        recyclerView = (RecyclerView) findViewById(R.id.TimelineLine);
//        recyclerView.setLayoutManager(linearLayoutManager);
//        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(), linearLayoutManager.getOrientation());
//        recyclerView.addItemDecoration(dividerItemDecoration);  //for divider
//
//        recyclerView.setAdapter(new TimeLineAdapter(context, timeLineModelList));
//    }
//}
