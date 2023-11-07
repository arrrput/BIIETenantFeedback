package com.biie.tenantfeedback.activity;

import android.text.SpannableString;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import java.util.ArrayList;

class MainAdapter extends FragmentPagerAdapter {
    // Initialize arrayList
    ArrayList<Fragment> fragmentArrayList = new ArrayList<>();
    ArrayList<String> stringArrayList = new ArrayList<>();

    // Create constructor
    public void addFragment(Fragment fragment, String s) {
        // Add fragment
        fragmentArrayList.add(fragment);
        // Add title
        stringArrayList.add(s);
    }

    public MainAdapter(FragmentManager supportFragmentManager) {
        super(supportFragmentManager);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        // return fragment position
        return fragmentArrayList.get(position);
    }

    @Override
    public int getCount() {
        // Return fragment array list size
        return fragmentArrayList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        // Initialize spannable image
        SpannableString spannableString = new SpannableString("" + stringArrayList.get(position));

        // return spannable string
        return spannableString;
    }
}
