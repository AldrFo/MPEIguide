package com.example.mpeiguide.settings;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.mpeiguide.MainActivity;
import com.example.mpeiguide.R;

public class SettingsFragment extends Fragment implements CompoundButton.OnCheckedChangeListener {

    public static final String SETTING_NAME = "settings";

    public static final String GROUP_NAME = "group";
    public static final String ALARM_BUTTON = "alarm_button";
    public static final String SHOW_TEACHER = "show_teacher";

    private SharedPreferences settings;

    private TextView currentGroup;

    private TableRow groupLayout;

    private Switch alarmButton;
    private Switch showTeacher;

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

        final String group = settings.getString(GROUP_NAME,"---");
        currentGroup = v.findViewById(R.id.current_group);

        groupLayout = v.findViewById(R.id.change_group_row);
        groupLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), ChangeGroupActivity.class);
                intent.putExtra(GROUP_NAME,group);
                startActivityForResult(intent,1);
            }
        });

        setSwitch(v, alarmButton, R.id.alarm_button_switch, ALARM_BUTTON);
        setSwitch(v, showTeacher, R.id.teacher_name_switch, SHOW_TEACHER);

        currentGroup.setText(group);

        return v;
    }

    private void setSwitch(View parent,Switch s, int id, String dataKey){
        s = parent.findViewById(id);
        s.setChecked(settings.getBoolean(dataKey,true));
        s.setOnCheckedChangeListener(this);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        String group = data.getStringExtra(GROUP_NAME);
        settings.edit().putString(GROUP_NAME,group).apply();
        currentGroup.setText(group);
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        switch (compoundButton.getId()){
            case R.id.alarm_button_switch:
                settings.edit().putBoolean(ALARM_BUTTON,b).apply();
                Log.d(MainActivity.MAIN_LOG,"SettingFragment: alarm button - " + b);
                break;
            case R.id.teacher_name_switch:
                settings.edit().putBoolean(SHOW_TEACHER,b).apply();
                Log.d(MainActivity.MAIN_LOG,"SettingFragment: show teacher - " + b);
                break;
        }
    }
}