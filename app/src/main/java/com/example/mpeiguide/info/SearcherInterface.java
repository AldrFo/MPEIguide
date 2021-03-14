package com.example.mpeiguide.info;

import java.util.ArrayList;

public interface SearcherInterface {

    ArrayList search(String request);

    boolean isPassSearchCondition(String request, Object whereSearch);

    boolean isNotTooMuchMistakes(String request, String PoleOfObject);

    int getAmountOfWords(String request);

    void checkAboutRequest(String request, ArrayList results);
}
