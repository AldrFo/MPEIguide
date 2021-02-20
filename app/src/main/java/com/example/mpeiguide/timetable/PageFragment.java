package com.example.mpeiguide.timetable;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mpeiguide.MainActivity;
import com.example.mpeiguide.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class PageFragment extends Fragment {

    public static final String ARG_PAGE_NUMBER = "arg_page_number";

    private RecyclerView recyclerView;
    private ArrayList<Event> timetable = new ArrayList<Event>();

    private int page;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(MainActivity.MAIN_LOG,"PageFragment: ====onCreateView===");
        View v = inflater.inflate(R.layout.fragment_page, container, false);

        page = getArguments().getInt(ARG_PAGE_NUMBER);

        recyclerView = v.findViewById(R.id.recycler_view);

        EventAdapter.OnEventClickListener eventClickListener = new EventAdapter.OnEventClickListener() {
            @Override
            public void onEventClick(Event e, int position) {

            }
        };

        Log.d(MainActivity.MAIN_LOG,"Timetable is null? " + (timetable == null));

        EventAdapter adapter = new EventAdapter(getContext(),timetable,eventClickListener);
        recyclerView.setAdapter(adapter);
        return v;
    }

    public static PageFragment newInstance(int page){
        Log.d(MainActivity.MAIN_LOG,"Creating new page fragment...");
        PageFragment pageFragment = new PageFragment();
        Bundle arguments = new Bundle();
        arguments.putInt(ARG_PAGE_NUMBER,page);
        pageFragment.setArguments(arguments);

        ArrayList<Event> list = WeekTimetable.getTimetable(page);
        if(list != null) {
            Log.d(MainActivity.MAIN_LOG,"Set timetable!");
            pageFragment.timetable = list;
        }
        Log.d(MainActivity.MAIN_LOG,"Page fragment was created!");
        return pageFragment;
    }
}