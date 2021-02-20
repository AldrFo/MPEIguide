package com.example.mpeiguide.timetable;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mpeiguide.MainActivity;
import com.example.mpeiguide.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class PageFragment extends Fragment {

    public static final String ARG_PAGE_NUMBER = "arg_page_number";

    private RecyclerView recyclerView;
    private ArrayList<Event> timetable = new ArrayList<>();
    private FloatingActionButton fab;
    EventAdapter.OnEventClickListener eventClickListener;

    private int page;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.d(MainActivity.MAIN_LOG,"pageFragment: ====onAttach()====" + " " + page);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(MainActivity.MAIN_LOG,"pageFragment: ====onCreate()====" + " " + page);
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(MainActivity.MAIN_LOG,"PageFragment: ====onCreateView===");
        View v = inflater.inflate(R.layout.fragment_page, container, false);

        page = getArguments().getInt(ARG_PAGE_NUMBER);

        recyclerView = v.findViewById(R.id.recycler_view);
        fab = v.findViewById(R.id.add_event);

        eventClickListener = new EventAdapter.OnEventClickListener() {
            @Override
            public void onEventClick(Event e, int position) {

            }
        };

        Log.d(MainActivity.MAIN_LOG,"PageFragment: Timetable is null? " + (timetable == null));

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(),CreateEventActivity.class);
                Log.d(MainActivity.MAIN_LOG,"PageFragment: create new event start");
                startActivityForResult(intent, 1);
                Log.d(MainActivity.MAIN_LOG,"PageFragment: new event created");
            }
        });

        EventAdapter adapter = new EventAdapter(getContext(),timetable,eventClickListener);
        recyclerView.setAdapter(adapter);

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
        timetable.add(event);
        EventAdapter adapter = new EventAdapter(getContext(),timetable,eventClickListener);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(MainActivity.MAIN_LOG,"pageFragment: ====onStart()===="+ " " + page);
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(MainActivity.MAIN_LOG,"pageFragment: ====onResume()===="+ " " + page);
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(MainActivity.MAIN_LOG,"pageFragment: ====onPause()===="+ " " + page);
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(MainActivity.MAIN_LOG,"pageFragment: ====onStop()===="+ " " + page);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(MainActivity.MAIN_LOG,"pageFragment: ====onDestroyView()===="+ " " + page);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(MainActivity.MAIN_LOG,"pageFragment: ====onDestroy()===="+ " " + page);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(MainActivity.MAIN_LOG,"pageFragment: ====onDetach()===="+ " " + page);
    }

    public static PageFragment newInstance(int page){
        Log.d(MainActivity.MAIN_LOG,"PageFragment: newInstance");
        PageFragment pageFragment = new PageFragment();
        Bundle arguments = new Bundle();
        arguments.putInt(ARG_PAGE_NUMBER,page);
        pageFragment.setArguments(arguments);

        ArrayList<Event> list = WeekTimetable.getTimetable(page);
        if(list != null) {
            Log.d(MainActivity.MAIN_LOG,"PageFragment: Set timetable!");
            pageFragment.timetable = list;
        }
        return pageFragment;
    }
}