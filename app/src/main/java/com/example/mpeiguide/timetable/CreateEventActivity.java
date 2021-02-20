package com.example.mpeiguide.timetable;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.mpeiguide.R;

public class CreateEventActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText startTimeEdit;
    private EditText endTimeEdit;
    private EditText editName;
    private EditText editType;
    private EditText editPlace;
    private EditText editTeacherName;
    private EditText editDescription;
    private Button okButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event);

        startTimeEdit = findViewById(R.id.event_start_time_edit_text);
        endTimeEdit = findViewById(R.id.event_end_time_edit_text);
        editName = findViewById(R.id.event_name_edit_text);
        editType = findViewById(R.id.event_type_edit_text);
        editPlace = findViewById(R.id.event_place_edit_text);
        editTeacherName = findViewById(R.id.teacher_name_edit_text);
        editDescription = findViewById(R.id.event_description_edit_text);
        okButton = findViewById(R.id.create_event_button);
        okButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent data = new Intent();
        data.putExtra(Event.START_TIME,startTimeEdit.getText().toString());
        data.putExtra(Event.END_TIME,endTimeEdit.getText().toString());
        data.putExtra(Event.EVENT_NAME,editName.getText().toString());
        data.putExtra(Event.EVENT_TYPE,editType.getText().toString());
        data.putExtra(Event.PLACE,editPlace.getText().toString());
        data.putExtra(Event.TEACHER_NAME,editTeacherName.getText().toString());
        data.putExtra(Event.DESCRIPTION,editDescription.getText().toString());
        setResult(2,data);
        finish();
    }
}