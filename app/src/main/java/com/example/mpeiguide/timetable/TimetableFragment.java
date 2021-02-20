package com.example.mpeiguide.timetable;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
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
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.d(MainActivity.MAIN_LOG,"TimetableFragment: ====onAttach()====");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(MainActivity.MAIN_LOG,"TimetableFragment: ====onCreate()====");
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

    @Override
    public void onStart() {
        super.onStart();
        Log.d(MainActivity.MAIN_LOG,"TimetableFragment: ====onStart()====");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(MainActivity.MAIN_LOG,"TimetableFragment: ====onResume()====");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(MainActivity.MAIN_LOG,"TimetableFragment: ====onPause()====");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(MainActivity.MAIN_LOG,"TimetableFragment: ====onStop()====");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(MainActivity.MAIN_LOG,"TimetableFragment: ====onDestroyView()====");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(MainActivity.MAIN_LOG,"TimetableFragment: ====onDestroy()====");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(MainActivity.MAIN_LOG,"TimetableFragment: ====onDetach()====");
    }

    public static TimetableFragment newInstance(){
        return new TimetableFragment();
    }
}