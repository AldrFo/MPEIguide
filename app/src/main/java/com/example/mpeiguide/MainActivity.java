package com.example.mpeiguide;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;

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
                Log.d(MAIN_LOG,"go to timetable");
                loadFragment(TimetableFragment.newInstance());
                return true;
            case R.id.bars:

                return true;
            case R.id.map:

                return true;
            case R.id.info:

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