package com.example.mpeiguide;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.icu.text.IDNA;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;

import com.example.mpeiguide.info.InfoFragment;
import com.example.mpeiguide.timetable.TimetableFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.sql.Time;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    public static final String MAIN_LOG = "my_main_log";

    private BottomNavigationView menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        menu = findViewById(R.id.bottomNavigationView);
        menu.setOnNavigationItemSelectedListener(this);
        menu.setSelectedItemId(R.id.timetable);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.timetable:
                Log.d(MAIN_LOG,"select timetable");
                loadFragment(TimetableFragment.newInstance());
                return true;
            case R.id.bars:
                Log.d(MAIN_LOG,"select bars");
                return true;
            case R.id.map:

                return true;
            case R.id.info:
                Log.d(MAIN_LOG,"select info");
                loadFragment(InfoFragment.newInstance());
                return true;
            case R.id.settings:

                return true;
        }
        return false;
    }

    private void loadFragment(Fragment f){
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.replace(R.id.frag_container,f);
        ft.commit();
    }
}