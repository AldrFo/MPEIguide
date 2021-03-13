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

        String desc = contact.getDescription().toLowerCase();

        String place = contact.getPlace().toLowerCase();

        return name.contains(request) || workPos.contains(request) ||
                phoneNumber.contains(request) || desc.contains(request) || place.contains(request);
    }

    public int NumberOfMatches(String request, String PoleOfObject) {  //сравнивает строку запроса со строкой объекта
        int Quantity = 0;                                              //допускать будет до 1-2 несовпадений (считать это верным)
        int j = 0;                                                    //этот метод вставить в метод обрабатывающий запрос (какие записи показывать)
        for ( int i = 0; i < request.length(); ++i) {
            if( request.charAt(j) != PoleOfObject.charAt(j)) {
                ++Quantity;
            }
        }
        return Quantity;
    }
}
