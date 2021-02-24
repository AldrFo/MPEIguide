package com.example.mpeiguide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mpeiguide.settings.SettingsFragment;

public class StartActivity extends AppCompatActivity implements TextWatcher{

    public static final String FIRST_ENTER = "first_enter";

    private EditText startEditText;
    private boolean firstEnter;

    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        sharedPreferences = getSharedPreferences(SettingsFragment.SETTING_NAME,Context.MODE_PRIVATE);
        firstEnter = sharedPreferences.getBoolean(FIRST_ENTER,true);

        if(!firstEnter){
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
        }

        startEditText = findViewById(R.id.start_edit_text);
        startEditText.addTextChangedListener(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sharedPreferences.edit().putBoolean(FIRST_ENTER,firstEnter).apply();
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        try {
            String s = startEditText.getText().toString();
            boolean enteredTypeOfGroup = false;
            boolean enteredNumOfGroup = false;
            boolean enteredYearOfGroup = false;
            int amountOfYearChars = 0;
            for (int j = 0;j<s.length();j++) {
                char lastChar = s.charAt(j);
                if (lastChar == '-' && !enteredTypeOfGroup && !enteredNumOfGroup && !enteredYearOfGroup) {
                    enteredTypeOfGroup = true;
                    Log.d(MainActivity.MAIN_LOG, "type entered");
                } else if (lastChar == '-' && enteredTypeOfGroup && !enteredNumOfGroup && !enteredYearOfGroup) {
                    enteredNumOfGroup = true;
                    Log.d(MainActivity.MAIN_LOG, "num entered");
                } else if (enteredNumOfGroup && enteredTypeOfGroup && !enteredYearOfGroup) {
                    amountOfYearChars++;
                    Log.d(MainActivity.MAIN_LOG, "year entering" + amountOfYearChars);
                    if (amountOfYearChars >= 2) {
                        enteredYearOfGroup = true;
                    }
                }
                Log.d(MainActivity.MAIN_LOG, "===" + enteredTypeOfGroup + " " + enteredNumOfGroup
                        + " " + enteredYearOfGroup + "===");
                if (enteredTypeOfGroup && enteredYearOfGroup && enteredNumOfGroup) {
                    sharedPreferences.edit()
                            .putString(SettingsFragment.GROUP_NAME,startEditText.getText().toString())
                            .apply();
                    firstEnter = false;
                    Intent intent = new Intent(this, MainActivity.class);
                    startActivity(intent);
                    break;
                }
            }
        }catch (Exception e){
            Log.d(MainActivity.MAIN_LOG,"ENTERING GROUP EXCEPTION!");
        }
    }

    @Override
    public void afterTextChanged(Editable editable) {

    }
}