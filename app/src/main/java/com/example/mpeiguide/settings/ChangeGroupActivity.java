package com.example.mpeiguide.settings;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.mpeiguide.R;

public class ChangeGroupActivity extends AppCompatActivity {

    private EditText editGroup;
    private Button ok;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_group);

        editGroup = findViewById(R.id.editEduGroup);
        editGroup.setText(getIntent().getStringExtra(SettingsFragment.GROUP_NAME));

        ok = findViewById(R.id.change_gr_ok_button);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent data = new Intent();
                data.putExtra(SettingsFragment.GROUP_NAME,editGroup.getText().toString());
                setResult(1,data);
                finish();
            }
        });
    }
}