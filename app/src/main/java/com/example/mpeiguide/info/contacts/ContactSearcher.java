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

        int i = 0;
        while(true) {
            StringBuilder singleWordRequest = new StringBuilder();
            if(i != request.length()-1) {
                while (request.charAt(i) != ' ' && i != request.length()-1) {
                    singleWordRequest.append(request.charAt(i));
                    i++;
                }
                Log.d(MainActivity.MAIN_LOG,"ContactSearcher: full singleWordRequest == "
                        + singleWordRequest.toString());
                checkContactsAboutRequest(singleWordRequest.toString(), results);
                i++;
            }else{
                break;
            }
        }
        return results;
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
