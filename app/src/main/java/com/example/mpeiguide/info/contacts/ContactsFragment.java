package com.example.mpeiguide.info.contacts;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.mpeiguide.R;

import java.util.ArrayList;

public class ContactsFragment extends Fragment {

    private RecyclerView recyclerView;
    private ArrayList<Contact> contacts;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_contact, container, false);
        recyclerView = v.findViewById(R.id.contact_recycler_view);

        ContactAdapter.OnContactClickListener listener = new ContactAdapter.OnContactClickListener() {
            @Override
            public void onContactClick(ContactAdapter.ViewHolder holder, int position) {
                Toast.makeText(getContext(),"пока это не работает",Toast.LENGTH_LONG).show();
            }
        };

        ContactAdapter adapter = new ContactAdapter(inflater,contacts,listener);
        recyclerView.setAdapter(adapter);
        return v;
    }

    public static ContactsFragment newInstance(){
        ContactsFragment fragment = new ContactsFragment();
        fragment.setContacts(Contact.getContactsList());
        return fragment;
    }

    public void setContacts(ArrayList<Contact> contacts) {
        this.contacts = contacts;
    }
}