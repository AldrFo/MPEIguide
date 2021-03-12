package com.example.mpeiguide.settings;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import com.example.mpeiguide.MainActivity;
import com.example.mpeiguide.R;

public class SettingsFragment extends Fragment implements CompoundButton.OnCheckedChangeListener {

    public static final String SETTING_NAME = "settings";

    public static final String GROUP_NAME = "group";
    public static final String ALARM_BUTTON = "alarm_button";

    private SharedPreferences settings;

    private TextView currentGroup;

    private Switch alarmButton;

    public static SettingsFragment newInstance() {
        return new SettingsFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_settings, container, false);

        settings = getContext().getSharedPreferences(SETTING_NAME, Context.MODE_PRIVATE);

        currentGroup = v.findViewById(R.id.current_group);
        alarmButton = v.findViewById(R.id.alarm_button_switch);
        alarmButton.setChecked(settings.getBoolean(ALARM_BUTTON,true));
        alarmButton.setOnCheckedChangeListener(this);

        currentGroup.setText(settings.getString(GROUP_NAME,"---"));

        return v;
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        switch (compoundButton.getId()){
            case R.id.alarm_button_switch:
                settings.edit().putBoolean(ALARM_BUTTON,b).apply();
                Log.d(MainActivity.MAIN_LOG,"SettingFragment: alarm button - " + b);
                break;
        }
    }
}