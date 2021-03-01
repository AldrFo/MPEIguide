package com.example.mpeiguide.info.faq;

public class Question {

    private String shortQuest;
    private String quest;
    private String answer;

    public Question(String shortQuest, String quest, String answer){
        this.shortQuest = shortQuest;
        this.quest = quest;
        this.answer = answer;
    }

    public String getAnswer() {
        return answer;
    }

    public String getQuest() {
        return quest;
    }

    public String getShortQuest() {
        return shortQuest;
    }
}
