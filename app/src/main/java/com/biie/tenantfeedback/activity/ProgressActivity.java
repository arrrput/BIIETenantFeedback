package com.biie.tenantfeedback.activity;

import android.annotation.SuppressLint;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.biie.tenantfeedback.FeedFragment;
import com.biie.tenantfeedback.ProgressFragment;
import com.biie.tenantfeedback.R;
import com.google.android.material.tabs.TabLayout;
import java.util.ArrayList;

public class ProgressActivity extends AppCompatActivity {

    // assign variable
    // Initialize variables
    TabLayout tabLayout;
    ViewPager viewPager;
    FrameLayout frameLayout;
    Fragment fragment = null;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);


        tabLayout=findViewById(R.id.tab_layout);
        viewPager=findViewById(R.id.view_pager);
        frameLayout = findViewById(R.id.frame_layout);

        fragment = new FeedFragment();
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fragmentTransaction.commit();

        // Initialize array list
//        ArrayList<String> arrayList=new ArrayList<>(0);
//
//        // Add title in array list
//        arrayList.add("Not Yet Accepted");
//        arrayList.add("Progress");
//        arrayList.add("Finished");
//        arrayList.add("Canceled");
//
//        // Setup tab layout
//        tabLayout.setupWithViewPager(viewPager);
//
//        // Prepare view pager
//        prepareViewPager(viewPager,arrayList);


        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                // Fragment fragment = null;
                switch (tab.getPosition()) {
                    case 0:
                        fragment = new FeedFragment();
                        break;
                    case 1:
                        fragment = new FeedFragment();
                        break;
                    case 2:
                        fragment = new FeedFragment();
                        break;
                    case 3:
                        fragment = new FeedFragment();
                        break;

                }
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.frame_layout, fragment);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                ft.commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }

        });
    }

    private void prepareViewPager(ViewPager viewPager, ArrayList<String> arrayList) {
        // Initialize main adapter
        MainAdapter adapter = new MainAdapter(getSupportFragmentManager());

        // Initialize main fragment
        ProgressFragment progressFragment = new ProgressFragment();
        Fragment fragment = null;
        switch (tabLayout.getSelectedTabPosition())
        {
            case 0:
                fragment = new FeedFragment();
                adapter.addFragment(fragment, arrayList.get(0));
                break;
            case 1:
                fragment = new ProgressFragment();
                adapter.addFragment(fragment, arrayList.get(1));
                break;

        }
        // Use for loop
//        for (int i = 0; i < arrayList.size(); i++) {
//            // Initialize bundle
//            Bundle bundle = new Bundle();
//
//            // Put title
//            bundle.putString("title", arrayList.get(i));
//
//            // set argument
//            progressFragment.setArguments(bundle);
//
//            // Add fragment
//            adapter.addFragment(progressFragment, arrayList.get(i));
//            progressFragment = new ProgressFragment();
//        }
        // set adapter
        viewPager.setAdapter(adapter);
    }
}

