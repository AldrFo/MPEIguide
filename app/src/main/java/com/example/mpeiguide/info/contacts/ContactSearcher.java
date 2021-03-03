package com.example.mpeiguide.info.contacts;

import android.util.Log;

import com.example.mpeiguide.MainActivity;
import com.example.mpeiguide.info.Searcher;

import java.util.ArrayList;

public class ContactSearcher implements Searcher {

    ArrayList<Contact> contacts;

    public ContactSearcher(ArrayList<Contact> contacts){
        this.contacts = contacts;
    }

    @Override
    public ArrayList search(String request) {
        if(request == null){
            Log.d(MainActivity.MAIN_LOG,"ContactSearcher: request == null");
            return null;
        }
        request = request.toLowerCase();
        ArrayList<Contact> results = new ArrayList<>();

        checkContactsAboutRequest(request,results);
        int j = 0;
        Log.d(MainActivity.MAIN_LOG,"ContactSearcher: amount of words == "
                + getAmountOfWords(request));
        for(int i =0;i < getAmountOfWords(request);i++){
            StringBuilder singleWordRequest = new StringBuilder();

            while(request.charAt(j) == ' '){
                j++;
            }

            while (j != request.length() && request.charAt(j) != ' ') {
                singleWordRequest.append(request.charAt(j));
                j++;
            }

            Log.d(MainActivity.MAIN_LOG,"ContactSearcher: full singleWordRequest == "
                    + singleWordRequest.toString());

            checkContactsAboutRequest(singleWordRequest.toString(), results);
        }
        return results;
    }

    private int getAmountOfWords(String request){
        int count = 1;
        boolean flag = false;
        for(int i = 0;i<request.length();i++){
            if(request.charAt(i) == ' '){
                flag = true;
            }
            if(flag && request.charAt(i) != ' '){
                count++;
                flag = false;
            }
        }
        return count;
    }

    private void checkContactsAboutRequest(String request, ArrayList<Contact> results){
        for (Contact contact: contacts) {
            if(isPassSearchCondition(request,contact) && !results.contains(contact)){
                results.add(contact);
                Log.d(MainActivity.MAIN_LOG,"ContactSearcher: finded " + contact.getName());
            }
        }
    }

    private boolean isPassSearchCondition(String request, Contact contact){
        String name = contact.getName().toLowerCase();
        String workPos = contact.getWorkPosition().toLowerCase();
        String phoneNumber = contact.getPhoneNumber().toLowerCase();
        String desc = contact.getDescription().toLowerCase();
        String place = contact.getPlace().toLowerCase();
        return name.contains(request) || workPos.contains(request) ||
                phoneNumber.contains(request) || desc.contains(request) || place.contains(request);
    }

}
