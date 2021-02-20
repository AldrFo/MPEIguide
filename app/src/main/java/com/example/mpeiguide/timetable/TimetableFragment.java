package com.example.mpeiguide.timetable;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mpeiguide.MainActivity;
import com.example.mpeiguide.R;
import com.google.android.material.tabs.TabLayout;

public class TimetableFragment extends Fragment {

    private ViewPager vp;
    private MyFragmentPagerAdapter fpa;
    private TabLayout tabs;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(MainActivity.MAIN_LOG,"TimetableFragment: ====onCreateView===");
        View v = inflater.inflate(R.layout.fragment_timetable, container, false);

        vp = v.findViewById(R.id.viewpager);
        fpa = new MyFragmentPagerAdapter(getFragmentManager(),getContext());
        vp.setAdapter(fpa);

        tabs = v.findViewById(R.id.tabs);
        tabs.setupWithViewPager(vp);
        return v;
    }

    public static TimetableFragment newInstance(){
        return new TimetableFragment();
    }
}