package com.example.mpeiguide.timetable;

import android.content.Context;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.mpeiguide.MainActivity;
import com.example.mpeiguide.R;

public class MyFragmentPagerAdapter extends FragmentPagerAdapter {

    public final static int AMOUNT_OF_DAYS = 7;

    private Context context;

    public MyFragmentPagerAdapter(FragmentManager fm, Context context){
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position){
        Log.d(MainActivity.MAIN_LOG,"create new page fragment");
        return PageFragment.newInstance(position);
    }

    @Override
    public int getCount(){
        return AMOUNT_OF_DAYS;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return context.getResources().getString(R.string.pn);
            case 1:
                return context.getResources().getString(R.string.vt);
            case 2:
                return context.getResources().getString(R.string.sr);
            case 3:
                return context.getResources().getString(R.string.cht);
            case 4:
                return context.getResources().getString(R.string.pt);
            case 5:
                return context.getResources().getString(R.string.sb);
            case 6:
                return context.getResources().getString(R.string.vs);
            default:
                return "title";
        }
    }
}
