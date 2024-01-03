package com.biie.tenantfeedback.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import com.biie.tenantfeedback.Dialog;
import com.biie.tenantfeedback.R;
import com.biie.tenantfeedback.fragment.CancelFragment;
import com.biie.tenantfeedback.fragment.FeedFragment;
import com.biie.tenantfeedback.fragment.FinishFragment;
import com.biie.tenantfeedback.fragment.NotFragment;
import com.biie.tenantfeedback.fragment.ProgressFragment;
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

    final Dialog loadingdialog = new Dialog(ProgressActivity.this);


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);

        tabLayout=findViewById(R.id.tab_layout);
        viewPager=findViewById(R.id.view_pager);
        frameLayout = findViewById(R.id.frame_layout);

        fragment = new NotFragment();
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fragmentTransaction.commit();


        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                loadingdialog.startLoadingdialog();

                // using handler class to set time delay methods
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // after 0.5 seconds
                        loadingdialog.dismissdialog();
                    }
                }, 500); // 0.5 seconds

                // Fragment fragment = null;
                switch (tab.getPosition()) {
                    case 0:
                        fragment = new NotFragment();
                        break;
                    case 1:
                        fragment = new FeedFragment();
                        break;
                    case 2:
                        fragment = new FinishFragment();
                        break;
                    case 3:
                        fragment = new CancelFragment();
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
                fragment = new NotFragment();
                adapter.addFragment(fragment, arrayList.get(0));
                break;
            case 1:
                fragment = new ProgressFragment();
                adapter.addFragment(fragment, arrayList.get(1));
                break;

        }

        viewPager.setAdapter(adapter);
    }
}

