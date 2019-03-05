package com.example.rudra.crimepetrol;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class ViewPagerAdapter1 extends FragmentPagerAdapter {
    private String title[] = {"Edit Prfile", "Complate", "Delete"};
    public ViewPagerAdapter1(FragmentManager manager) {
        super(manager);
    }
    @Override
    public Fragment getItem(int position) {

//        return TabFragment.getInstance(position);
        Fragment fragment = new TabFragment1();
        Bundle args = new Bundle();
        args.putInt(TabFragment1.ARG_SECTION_NUMBER, position + 1);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public int getCount() {
        return title.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return title[position];
    }
}
