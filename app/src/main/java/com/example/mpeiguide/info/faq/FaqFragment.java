package com.example.mpeiguide.info.faq;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.mpeiguide.MainActivity;
import com.example.mpeiguide.R;
import com.example.mpeiguide.info.contacts.Contact;
import com.example.mpeiguide.info.contacts.ContactAdapter;

import java.util.ArrayList;
import java.util.List;

public class FaqFragment extends Fragment implements TextWatcher {

    private ImageView backButton;
    private EditText searchEditText;

    private RecyclerView recyclerView;

    private QuestionSearcher questionSearcher;

    private List<Question> questions;
    private QuestionAdapter.OnQuestionClickListener listener;

    private LayoutInflater inflater;
    private Handler handler;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        this.inflater = inflater;
        questionSearcher = new QuestionSearcher(Question.getQuestions());
        View v = inflater.inflate(R.layout.fragment_faq, container, false);
        backButton = v.findViewById(R.id.faq_back_button);
        searchEditText = v.findViewById(R.id.faq_search_edit_text);
        recyclerView = v.findViewById(R.id.faq_recycler_view);

        searchEditText.addTextChangedListener(this);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    getActivity().onBackPressed();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

        listener = new QuestionAdapter.OnQuestionClickListener() {
            @Override
            public void onQuestionClick(Question q, int position) {
                Intent intent = new Intent(getContext(),QuestionDetailsActivity.class);
                intent.putExtra(Question.QUEST,q.getQuest());
                intent.putExtra(Question.ANSWER,q.getAnswer());
                startActivity(intent);
            }
        };

        QuestionAdapter adapter = new QuestionAdapter(inflater,questions,listener);
        recyclerView.setAdapter(adapter);
        return v;
    }

    public static FaqFragment newInstance() {
        FaqFragment fragment = new FaqFragment();
        fragment.questions = Question.getQuestions();
        fragment.handler = new Handler();
        return fragment;
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(final CharSequence charSequence, int i, int i1, int i2) {
        Thread searchThread = new Thread(new Runnable() {
            @Override
            public void run() {
                final ArrayList<Question> results = questionSearcher.search(charSequence.toString());
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        QuestionAdapter adapter;
                        if(results != null) {
                            adapter = new QuestionAdapter(inflater, results, listener);
                        }else{
                            Log.d(MainActivity.MAIN_LOG,"contactList == null");
                            adapter = new QuestionAdapter(inflater, questions, listener);
                        }
                        recyclerView.setAdapter(adapter);
                    }
                });
            }
        });
        searchThread.start();
    }

    @Override
    public void afterTextChanged(Editable editable) {

    }
}