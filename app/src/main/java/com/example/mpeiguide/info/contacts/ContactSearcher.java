package com.example.mpeiguide.info.contacts;

import android.util.Log;

import com.example.mpeiguide.MainActivity;
import com.example.mpeiguide.info.Searcher;

import java.util.ArrayList;

public class ContactSearcher extends Searcher {

    ArrayList<Contact> contacts;

    public ContactSearcher(ArrayList<Contact> contacts) {
        this.contacts = contacts;
    }

    @Override
    public void checkAboutRequest(String request, ArrayList results) {
        for (Contact contact: contacts) {
            if (isPassSearchCondition(request,contact) && !results.contains(contact)) {
                results.add(contact);
                Log.d(MainActivity.MAIN_LOG,"ContactSearcher: finded " + contact.getName());
            }
        }
    }

    @Override
    public boolean isPassSearchCondition(String request, Object whereSearch) {
        Contact contact = (Contact) whereSearch;

        String name = contact.getName().toLowerCase();

        String workPos = contact.getWorkPosition().toLowerCase();

        String phoneNumber = contact.getPhoneNumber().toLowerCase();

        String place = contact.getPlace().toLowerCase();

        return isNotTooMuchMistakes(request, name) || isNotTooMuchMistakes(request, workPos) ||
                isNotTooMuchMistakes(request, phoneNumber) || isNotTooMuchMistakes(request, place);
    }

}
