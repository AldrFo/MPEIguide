package com.example.mpeiguide.info.contacts;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.mpeiguide.R;

import java.util.ArrayList;

public class ContactsFragment extends Fragment {

    private RecyclerView recyclerView;
    private ArrayList<Contact> contacts;
    private ImageButton backButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_contact, container, false);
        recyclerView = v.findViewById(R.id.contact_recycler_view);
        backButton = v.findViewById(R.id.contacts_back_button);

        ContactAdapter.OnContactClickListener listener = new ContactAdapter.OnContactClickListener() {
            @Override
            public void onContactClick(Contact contact, int position) {
                Intent intent = new Intent(getContext(),ContactDetailsActivity.class);

                intent.putExtra(Contact.WORK_POS, contact.getWorkPosition());
                intent.putExtra(Contact.NAME,contact.getName());
                intent.putExtra(Contact.PHONE_NUM, contact.getPhoneNumber());
                intent.putExtra(Contact.EMAIL, contact.getEmail());
                intent.putExtra(Contact.PLACE,contact.getPlace());
                intent.putExtra(Contact.DESCRIPTION,contact.getDescription());
                intent.putExtra(Contact.IMAGE_ID,contact.getImageId());

                startActivity(intent);
            }
        };

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    getActivity().onBackPressed();
                }catch (NullPointerException e){
                    return;
                }
            }
        });

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