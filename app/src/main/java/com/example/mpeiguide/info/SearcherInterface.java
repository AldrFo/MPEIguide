package com.example.mpeiguide.info;

import java.util.ArrayList;

public interface SearcherInterface {

    ArrayList search(String request);

    boolean isPassSearchCondition(String request, Object whereSearch);

    int NumberOfMatches(String request, String PoleOfObject); //хз надо нет...

    int getAmountOfWords(String request);

    void checkAboutRequest(String request, ArrayList results);
}
