package com.example.mpeiguide.info.faq;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.mpeiguide.R;

import java.util.List;

public class FaqFragment extends Fragment implements TextWatcher {

    private ImageView backButton;
    private EditText searchEditText;

    private RecyclerView recyclerView;

    private List<Question> questions;
    private QuestionAdapter.OnQuestionClickListener listener;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
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
                Toast.makeText(getContext(),"пока не работает", Toast.LENGTH_LONG).show();
            }
        };

        QuestionAdapter adapter = new QuestionAdapter(inflater,questions,listener);
        recyclerView.setAdapter(adapter);
        return v;
    }

    public static FaqFragment newInstance() {
        FaqFragment fragment = new FaqFragment();
        fragment.questions = Question.getQuestions();
        return fragment;
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {

    }
}