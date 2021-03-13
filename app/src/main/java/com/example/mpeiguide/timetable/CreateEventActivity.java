package com.example.mpeiguide.timetable;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.mpeiguide.MainActivity;
import com.example.mpeiguide.R;

public class CreateEventActivity extends AppCompatActivity implements View.OnClickListener{

    public static final String TITLE = "title";

    public static final String CREATE = "Создание события";
    public static final String EDIT = "Редактировать событие";

    public static final int DELETE_CODE = 0;
    public static final int CREATE_CODE = 1;

    private LinearLayout layout;

    private TextView title;

    private EditText startTimeEdit;
    private EditText endTimeEdit;
    private EditText editName;
    private EditText editType;
    private EditText editPlace;
    private EditText editTeacherName;
    private EditText editDescription;

    private Button okButton;
    private Button deleteButton;
    private ImageButton backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event);

        layout = findViewById(R.id.create_event_layout);

        title = findViewById(R.id.create_event_title);

        startTimeEdit = findViewById(R.id.event_start_time_edit_text);
        endTimeEdit = findViewById(R.id.event_end_time_edit_text);
        editName = findViewById(R.id.event_name_edit_text);
        editType = findViewById(R.id.event_type_edit_text);
        editPlace = findViewById(R.id.event_place_edit_text);
        editTeacherName = findViewById(R.id.teacher_name_edit_text);
        editDescription = findViewById(R.id.event_description_edit_text);

        okButton = findViewById(R.id.create_event_button);
        okButton.setOnClickListener(this);

        deleteButton = findViewById(R.id.create_event_delete);

        backButton = findViewById(R.id.create_event_back_button);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        try {
            final Intent intent = getIntent();
            title.setText(intent.getStringExtra(TITLE));
            startTimeEdit.setText(intent.getStringExtra(Event.START_TIME));
            endTimeEdit.setText(intent.getStringExtra(Event.END_TIME));
            editName.setText(intent.getStringExtra(Event.EVENT_NAME));
            editType.setText(intent.getStringExtra(Event.EVENT_TYPE));
            editPlace.setText(intent.getStringExtra(Event.PLACE));
            editTeacherName.setText(intent.getStringExtra(Event.TEACHER_NAME));
            editDescription.setText(intent.getStringExtra(Event.DESCRIPTION));

            deleteButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent data = new Intent();
                    data.putExtra(Event.POSITION, intent.getIntExtra(Event.POSITION,0));
                    setResult(DELETE_CODE, data);
                    finish();
                }
            });

            if(!intent.getStringExtra(TITLE).equals(EDIT)) {
                layout.removeView(deleteButton);
                Log.d(MainActivity.MAIN_LOG, "CreateEventActivity: remove delete button");
            }
        }catch (Exception e){

        }
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
        data.putExtra(PageFragment.ARG_PAGE_NUMBER,
                getIntent().getIntExtra(PageFragment.ARG_PAGE_NUMBER,0));
        setResult(CREATE_CODE,data);
        finish();
    }
}