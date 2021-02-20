package com.example.mpeiguide.info.contacts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mpeiguide.R;


public class ContactDetailsActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView name;
    private TextView workPos;
    private TextView phoneNum;
    private TextView osepMail;
    private TextView classroom;
    private TextView description;
    private ImageButton back;
    private ImageView avatar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_details);

        name = findViewById(R.id.contact_name_text);
        workPos = findViewById(R.id.contact_work_pos_text);
        phoneNum = findViewById(R.id.contact_phone_number_text);
        osepMail = findViewById(R.id.contact_osep_mail_text);
        classroom = findViewById(R.id.contact_classroom_text);
        description = findViewById(R.id.contact_description_text);
        back = findViewById(R.id.contact_backButton);
        avatar = findViewById(R.id.contact_avatar);

        Intent intent = getIntent();

        name.setText(intent.getStringExtra(Contact.NAME));
        workPos.setText(intent.getStringExtra(Contact.WORK_POS));
        phoneNum.setText(intent.getStringExtra(Contact.PHONE_NUM));
        osepMail.setText(intent.getStringExtra(Contact.EMAIL));
        classroom.setText(intent.getStringExtra(Contact.PLACE));
        description.setText(intent.getStringExtra(Contact.DESCRIPTION));
        back.setOnClickListener(this);
        int imageId = intent.getIntExtra(Contact.IMAGE_ID,0);
        if(imageId != 0){
            avatar.setImageResource(imageId);
        }
    }

    @Override
    public void onClick(View view) {
        onBackPressed();
    }
}