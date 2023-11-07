package com.biie.tenantfeedback.activity;

import static com.biie.tenantfeedback.R.id.view_pager;
import androidx.annotation.ContentView;
import androidx.core.content.ContextCompat;
import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.Spanned;
import java.lang.reflect.Array;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import android.os.Bundle;
import android.text.SpannableString;
import com.biie.tenantfeedback.CourseAdapter;
import com.biie.tenantfeedback.CourseModel;
import com.biie.tenantfeedback.ProgressFragment;
import com.biie.tenantfeedback.R;
import com.google.android.material.tabs.TabLayout;
import java.util.ArrayList;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ProgressActivity extends AppCompatActivity {

    // assign variable
    // Initialize variables
    TabLayout tabLayout;
    ViewPager viewPager;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);

        tabLayout=findViewById(R.id.tab_layout);
        viewPager=findViewById(R.id.view_pager);

        // Initialize array list
        ArrayList<String> arrayList=new ArrayList<>(0);

        // Add title in array list
        arrayList.add("Not Yet Accepted");
        arrayList.add("Progress");
        arrayList.add("Finished");
        arrayList.add("Canceled");

        // Setup tab layout
        tabLayout.setupWithViewPager(viewPager);

        // Prepare view pager
        prepareViewPager(viewPager,arrayList);

        RecyclerView courseRV = findViewById(R.id.idRVCourse);

        // Here, we have created new array list and added data to it
        ArrayList<CourseModel> courseModelArrayList = new ArrayList<CourseModel>();
        courseModelArrayList.add(new CourseModel("DSA in Java", 4, R.drawable.logo));
        courseModelArrayList.add(new CourseModel("Java Course", 3, R.drawable.logo));
        courseModelArrayList.add(new CourseModel("C++ Course", 4, R.drawable.logo));
        courseModelArrayList.add(new CourseModel("DSA in C++", 4, R.drawable.logo));
        courseModelArrayList.add(new CourseModel("Kotlin for Android", 4, R.drawable.logo));
        courseModelArrayList.add(new CourseModel("Java for Android", 4, R.drawable.logo));
        courseModelArrayList.add(new CourseModel("HTML and CSS", 4, R.drawable.logo));

        // we are initializing our adapter class and passing our arraylist to it.
        CourseAdapter courseAdapter = new CourseAdapter(this, courseModelArrayList);

        // below line is for setting a layout manager for our recycler view.
        // here we are creating vertical list so we will provide orientation as vertical
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        // in below two lines we are setting layoutmanager and adapter to our recycler view.
        courseRV.setLayoutManager(linearLayoutManager);
        courseRV.setAdapter(courseAdapter);
    }

    private void prepareViewPager(ViewPager viewPager, ArrayList<String> arrayList) {
        // Initialize main adapter
        MainAdapter adapter = new MainAdapter(getSupportFragmentManager());

        // Initialize main fragment
        ProgressFragment progressFragment = new ProgressFragment();

        // Use for loop
        for (int i = 0; i < arrayList.size(); i++) {
            // Initialize bundle
            Bundle bundle = new Bundle();

            // Put title
            bundle.putString("title", arrayList.get(i));

            // set argument
            progressFragment.setArguments(bundle);

            // Add fragment
            adapter.addFragment(progressFragment, arrayList.get(i));
            progressFragment = new ProgressFragment();
        }
        // set adapter
        viewPager.setAdapter(adapter);
    }
}

