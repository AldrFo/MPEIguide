package com.example.mpeiguide.info.faq;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mpeiguide.R;

import java.util.List;
import java.util.zip.Inflater;

public class QuestionAdapter extends RecyclerView.Adapter<QuestionAdapter.ViewHolder> {

    interface OnQuestionClickListener{
        public void onQuestionClick(Question q, int position);
    }

    public static final int MAX_DESC_LENGTH = 150;

    private LayoutInflater inflater;
    private OnQuestionClickListener listener;
    private List<Question> questions;

    public QuestionAdapter(LayoutInflater inflater, List<Question> questions, OnQuestionClickListener listener){
        this.inflater = inflater;
        this.questions = questions;
        this.listener = listener;
    }

    @NonNull
    @Override
    public QuestionAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.question_item,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull QuestionAdapter.ViewHolder holder, final int position) {
        final Question question = questions.get(position);

        holder.shortQuest.setText(question.getShortQuest());

        char[] shortDescChar = question.getAnswer().toCharArray();
        StringBuilder shortDesc = new StringBuilder();
        if(shortDescChar.length >= MAX_DESC_LENGTH) {
            for (int i = 0; i < MAX_DESC_LENGTH; i++) {
                shortDesc.append(shortDescChar[i]);
            }
            shortDesc.append("...");
        }else{
            shortDesc.append(shortDescChar);
        }

        holder.shortDesc.setText(shortDesc.toString());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onQuestionClick(question, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return questions.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        final TextView shortQuest;
        final TextView shortDesc;

        public ViewHolder(View v){
            super(v);

            shortQuest = v.findViewById(R.id.short_quest);
            shortDesc = v.findViewById(R.id.short_desc);
        }
    }
}
