package com.example.mpeiguide.info;

import android.util.Log;

import com.example.mpeiguide.MainActivity;
import com.example.mpeiguide.info.SearcherInterface;
import com.example.mpeiguide.info.contacts.Contact;

import java.util.ArrayList;

public class Searcher implements SearcherInterface {

    @Override
    public ArrayList search(String request) {

        if(request == null || request.length() == 0) {
            Log.d(MainActivity.MAIN_LOG,"Searcher: request == null");
            return null;
        }

        request = request.toLowerCase();
        ArrayList<Contact> results = new ArrayList<>();

        int j = 0;

        Log.d(MainActivity.MAIN_LOG,"Searcher: amount of words == "
                + getAmountOfWords(request));

        for( int i = 0; i < getAmountOfWords(request); ++i) {
            StringBuilder singleWordRequest = new StringBuilder();

            while(request.charAt(j) == ' ') {
                ++j;
            }

            while (j != request.length() && request.charAt(j) != ' ') {
                singleWordRequest.append(request.charAt(j));
                ++j;
            }

            Log.d(MainActivity.MAIN_LOG,"Searcher: full singleWordRequest == "
                     + singleWordRequest.toString());

            checkAboutRequest(singleWordRequest.toString(), results);
        }
        return results;
    }

    @Override
    public boolean isPassSearchCondition(String request, Object whereSearch) {
        return true;
    }

    @Override
    public boolean isNotTooMuchMistakes(String request, String poleOfObject) {
        double quantity = 0;
        int length;

        if(request.length() <= poleOfObject.length()) {
            length = request.length();
        }else{
            length = poleOfObject.length();
        }

        for (int i = 0; i < length; i++) {
            if(request.charAt(i) != poleOfObject.charAt(i)){
                ++quantity;
            }
        }
        return (quantity/request.length() < 0.30 ); // считает запрос верным при наличии в нём 30% ошибок
    }

    @Override
    public int getAmountOfWords(String request) {

        int count = 1;
        boolean flag = false;

        for(int i = 0; i < request.length(); i++) {
            if(request.charAt(i) == ' '){
                flag = true;
            }

            if(flag && request.charAt(i) != ' ') {
                ++count;
                flag = false;
            }
        }
        return count;
    }

    @Override
    public void checkAboutRequest(String request, ArrayList results) { }
}
