package com.example.mpeiguide.info.faq;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.mpeiguide.R;

import org.w3c.dom.Text;

public class QuestionDetailsActivity extends AppCompatActivity {

    private ImageButton back;
    private TextView question;
    private TextView answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_details);

        question = findViewById(R.id.question_details_question);
        answer = findViewById(R.id.question_details_answer);
        back = findViewById(R.id.question_details_back);

        Intent intent = getIntent();
        question.setText(intent.getStringExtra(Question.QUEST));
        answer.setText(intent.getStringExtra(Question.ANSWER));

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });


    }
}