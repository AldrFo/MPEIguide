package com.example.mpeiguide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class StartActivity extends AppCompatActivity implements TextWatcher{

    //TODO: Добавить передачу введенной группы в MainActivity.
    //TODO: Добавить сохранение того факта, что первый вход уже осуществлялся через SharedPreferences

    public static final String FIRST_ENTER = "first_enter";

    private EditText startEditText;
    private boolean firstEnter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        startEditText = findViewById(R.id.start_edit_text);
        startEditText.addTextChangedListener(this);

    }

    @Override
    protected void onPause() {
        super.onPause();
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
                    Intent intent = new Intent(this, MainActivity.class);
                    startActivity(intent);
                    break;
                }
            }
        }catch (Exception e){ }
    }

    @Override
    public void afterTextChanged(Editable editable) {

    }

}