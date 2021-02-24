package com.example.mpeiguide.settings;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mpeiguide.R;

public class SettingsFragment extends Fragment {

    public static final String SETTING_NAME = "settings";

    public static final String GROUP_NAME = "group";

    private SharedPreferences settings;

    private TextView currentGroup;

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
        currentGroup.setText(settings.getString(GROUP_NAME,"---"));

        return v;
    }
}