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

import com.example.mpeiguide.MainActivity;
import com.example.mpeiguide.R;
import com.example.mpeiguide.SaveLoad;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

public class TimetableFragment extends Fragment {

    private ViewPager vp;
    private MyFragmentPagerAdapter fpa;
    private TabLayout tabs;
    private FloatingActionButton fab;

    private Timetable[] weekTimetable = new Timetable[7];

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

        try{
            weekTimetable = (Timetable[]) SaveLoad.load(getContext(),"timetable.tmt");
        }catch (Exception e) {
            Log.d(MainActivity.MAIN_LOG,"LOAD EXCEPTION");
            for (int i = 0; i < weekTimetable.length; i++) {
                weekTimetable[i] = new Timetable(i);
            }
        }

        vp = v.findViewById(R.id.viewpager);
        fpa = new MyFragmentPagerAdapter(getFragmentManager(),getContext(),weekTimetable);
        vp.setAdapter(fpa);

        tabs = v.findViewById(R.id.tabs);
        tabs.setupWithViewPager(vp);

        fab = v.findViewById(R.id.add_event);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(),CreateEventActivity.class);
                intent.putExtra(PageFragment.ARG_PAGE_NUMBER,vp.getCurrentItem());
                startActivityForResult(intent, 1);
            }
        });

        return v;
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

        Event event = new Event(startTime,endTime,name,eventType,place,teacherName,description);
        int pageNum = data.getIntExtra(PageFragment.ARG_PAGE_NUMBER,0);

        weekTimetable[pageNum].addToTimetable(event);

        fpa = new MyFragmentPagerAdapter(getFragmentManager(),getContext(),weekTimetable);
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
        try {
            SaveLoad.save(getContext(),"timetable.tmt",weekTimetable);
        }catch (Exception e){
            Log.d(MainActivity.MAIN_LOG,"SAVE EXCEPTION");
        }
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