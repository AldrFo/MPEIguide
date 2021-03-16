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

        Log.d(MainActivity.MAIN_LOG,"Searcher: amount of words == "
                + getAmountOfWords(request));

        String[] singleWords = getSingleWords(request);

        for( int i = 0; i < singleWords.length; ++i) {
            checkAboutRequest(singleWords[i], results);
        }
        return results;
    }

    @Override
    public boolean isPassSearchCondition(String request, Object whereSearch) {
        return true;
    }

    @Override
    public boolean isContainsRequest(String request, String poleOfObject) {
        String[] singleWords = getSingleWords(poleOfObject);

        for(int j = 0; j < singleWords.length;j++) {
            if(singleWords[j].length() <= 3){
                return false;
            }
            double quantity = 0;
            int length;

            if(request.length() <= singleWords[j].length()) {
                length = request.length();
            } else {
                length = singleWords[j].length();
            }

            for (int i = 0; i < length; i++) {
                if (request.charAt(i) != singleWords[j].charAt(i)) {
                    ++quantity;
                }
            }
            Log.d(MainActivity.MAIN_LOG,"Searcher: request - " + request + " single word - " + singleWords[j]);
            Log.d(MainActivity.MAIN_LOG,"Searcher: percent of mistakes = " + quantity/request.length());

            if(quantity / request.length() < 0.25 || poleOfObject.contains(request)){
                return true;
            }
        }
        return false;
    }

    private String[] getSingleWords(String s){
        int amount = getAmountOfWords(s);
        String[] singleWords = new String[amount];
        int j = 0;
        for(int i = 0; i < amount;i++) {
            StringBuilder singleWordRequest = new StringBuilder();

            while (j<s.length() && s.charAt(j) == ' ') {
                ++j;
            }

            while (j != s.length() && s.charAt(j) != ' ') {
                singleWordRequest.append(s.charAt(j));
                ++j;
            }

            singleWords[i] = singleWordRequest.toString();
        }
        return singleWords;
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
