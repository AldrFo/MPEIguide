package com.example.mpeiguide.info.faq;

import java.util.ArrayList;

public class Question {

    public static final Question[] questions = {
            new Question("Как получить матпомощь?", "Как получить матпомощь?",
                    "Необходимо сходить в профбюро, составить там заявку на материальную " +
                            "помощь а дальше я хрен его знает, что мне надо написать, но главное " +
                            "чтобы в сумме получилось больше ста пятидесяти символов. И да, я написал" +
                            " 150 словами, чтобы получилось больше символов."),
            new Question("Как получить общежитие?","Как получить место в общежитии уже после начала обучения?",
                    "Вот честно, хрен его знает, мне бы кто подсказал..."),
            new Question("Кто такие ИВТИшники?","Кто такие студенты института ИВТИ?",
                    "Ну что за глупый вопрос? Очевидно же, геи и развратники, гачи мучи их конек, " +
                            "а легенды о их гействе слагаются по всему Московскому Этиловому и даже " +
                            "за его пределами!")
    };

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

    public static ArrayList<Question> getQuestions(){
        ArrayList<Question> list = new ArrayList<>();
        for(int i = 0;i<questions.length;i++){
            list.add(questions[i]);
        }
        return list;
    }
}
