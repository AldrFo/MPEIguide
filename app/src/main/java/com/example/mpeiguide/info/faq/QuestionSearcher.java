package com.example.mpeiguide.info.faq;

import com.example.mpeiguide.info.Searcher;

import java.util.ArrayList;

public class QuestionSearcher extends Searcher {

    ArrayList<Question> questions;

    public QuestionSearcher(ArrayList<Question> questions){
        this.questions = questions;
    }

    @Override
    public boolean isPassSearchCondition(String request, Object whereSearch) {
        Question question = (Question) whereSearch;
        return isNotTooMuchMistakes(request, question.getQuest().toLowerCase());
    }

    @Override
    public void checkAboutRequest(String request, ArrayList results) {
        for(Question question: questions){
            if(isPassSearchCondition(request, question) && !results.contains(question)){
                results.add(question);
            }
        }
    }
}
