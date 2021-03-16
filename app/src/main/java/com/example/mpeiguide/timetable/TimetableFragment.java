package com.example.mpeiguide.timetable;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mpeiguide.MainActivity;
import com.example.mpeiguide.R;
import com.example.mpeiguide.SaveLoad;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class TimetableFragment extends Fragment {

    private ViewPager vp;
    private MyFragmentPagerAdapter fpa;
    private TabLayout tabs;
    private FloatingActionButton fab;
    private FloatingActionButton nextWeekButton;
    private TextView weekNum;

    private boolean even;

    private Timetable[] weekTimetableNotEven = new Timetable[7];
    private Timetable[] weekTimetableEven = new Timetable[7];

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

        weekNum = v.findViewById(R.id.timetable_week_num);
        vp = v.findViewById(R.id.viewpager);

        even = false;
        initTimetables();
        loadTimetable();

        tabs = v.findViewById(R.id.tabs);
        tabs.setupWithViewPager(vp);

        fab = v.findViewById(R.id.add_event);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(),CreateEventActivity.class);
                intent.putExtra(PageFragment.ARG_PAGE_NUMBER,vp.getCurrentItem());
                intent.putExtra(CreateEventActivity.TITLE,CreateEventActivity.CREATE);
                startActivityForResult(intent, 1);
            }
        });

        nextWeekButton = v.findViewById(R.id.next_week_button);
        nextWeekButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(even) {
                    even = false;
                }else{
                    even = true;
                }
                loadTimetable();
            }
        });

        return v;
    }

    private void loadTimetable(){
        if (even) {
            weekNum.setText("Четная неделя");
            fpa = new MyFragmentPagerAdapter(getFragmentManager(), getContext(), weekTimetableEven);
        }else{
            weekNum.setText("Нечетная неделя");
            fpa = new MyFragmentPagerAdapter(getFragmentManager(), getContext(), weekTimetableNotEven);
        }
        vp.setAdapter(fpa);
    }

    private void initTimetables(){
        try {
            weekTimetableEven = (Timetable[]) SaveLoad.load(getContext(), "timetableEven.tmt");
            Log.d(MainActivity.MAIN_LOG,"TimetableFragment: is timetable even " + even);
        } catch (Exception e) {
            Log.d(MainActivity.MAIN_LOG, "LOAD EXCEPTION");
            for (int i = 0; i < weekTimetableEven.length; i++) {
                weekTimetableEven[i] = new Timetable(i, even);
            }
        }
        try {
            weekTimetableNotEven = (Timetable[]) SaveLoad.load(getContext(), "timetableNotEven.tmt");
        } catch (Exception e) {
            Log.d(MainActivity.MAIN_LOG, "LOAD EXCEPTION");

            for (int i = 0; i < weekTimetableNotEven.length; i++) {
                weekTimetableNotEven[i] = new Timetable(i,even);
            }
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(data == null){
            return;
        }
        Log.d(MainActivity.MAIN_LOG,"PageFragment: new event creating...");
        String name = data.getStringExtra(Event.EVENT_NAME);
        String startTime = data.getStringExtra(Event.START_TIME);
        String endTime = data.getStringExtra(Event.END_TIME);
        String teacherName = data.getStringExtra(Event.TEACHER_NAME);
        String eventType = data.getStringExtra(Event.EVENT_TYPE);
        String place = data.getStringExtra(Event.PLACE);
        String description = data.getStringExtra(Event.DESCRIPTION);
        boolean editable = data.getBooleanExtra(Event.EDITABLE,true);

        Event event = new Event(startTime,endTime,name,eventType,place,teacherName,description,editable);
        int pageNum = data.getIntExtra(PageFragment.ARG_PAGE_NUMBER,0);
        if(even) {
            weekTimetableEven[pageNum].addToTimetable(event);
            Event.sortEventsByTime(weekTimetableEven[pageNum].getTimetable());
            fpa = new MyFragmentPagerAdapter(getFragmentManager(),getContext(),weekTimetableEven);
        }else{
            weekTimetableNotEven[pageNum].addToTimetable(event);
            Event.sortEventsByTime(weekTimetableNotEven[pageNum].getTimetable());
            fpa = new MyFragmentPagerAdapter(getFragmentManager(),getContext(),weekTimetableNotEven);
        }

        vp.setAdapter(fpa);
        vp.setCurrentItem(pageNum);
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
        try {
            SaveLoad.save(getContext(), "timetableEven.tmt", weekTimetableEven);
            SaveLoad.save(getContext(), "timetableNotEven.tmt", weekTimetableNotEven);
        }catch (Exception e){
            Log.d(MainActivity.MAIN_LOG,"SAVE EXCEPTION");
        }
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