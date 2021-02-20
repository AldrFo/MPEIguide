package com.example.mpeiguide.timetable;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
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
    private ArrayList<Event> timetable = new ArrayList<>();

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

        Log.d(MainActivity.MAIN_LOG,"PageFragment: Timetable is null? " + (timetable == null));

        EventAdapter adapter = new EventAdapter(getContext(),timetable,eventClickListener);
        recyclerView.setAdapter(adapter);
        return v;
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