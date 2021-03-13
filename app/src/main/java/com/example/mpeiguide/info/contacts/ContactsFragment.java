package com.example.mpeiguide.info.contacts;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.mpeiguide.MainActivity;
import com.example.mpeiguide.R;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class ContactsFragment extends Fragment implements TextWatcher {

    private ArrayList<Contact> contacts;

    private ImageButton backButton;
    private RecyclerView recyclerView;
    private EditText searchEditText;

    private ContactAdapter.OnContactClickListener listener;

    private ContactSearcher contactSearcher;

    private LayoutInflater inflater;
    private Handler handler;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        this.inflater = inflater;
        View v = inflater.inflate(R.layout.fragment_contact, container, false);
        recyclerView = v.findViewById(R.id.contact_recycler_view);
        backButton = v.findViewById(R.id.contacts_back_button);
        searchEditText = v.findViewById(R.id.contact_search_edit_text);

        searchEditText.addTextChangedListener(this);

        listener = new ContactAdapter.OnContactClickListener() {
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
        fragment.contactSearcher = new ContactSearcher(Contact.getContactsList());
        fragment.handler = new Handler();
        return fragment;
    }

    private void loadFragment(Fragment f){
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.addToBackStack("contacts");
        ft.replace(R.id.frag_container,f);
        ft.commit();
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }

    @Override
    public void onTextChanged(final CharSequence charSequence, int i, int i1, int i2) {
        Thread searchThread = new Thread(new Runnable() {
            @Override
            public void run() {
                final ArrayList<Contact> results = contactSearcher.search(charSequence.toString());
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        ContactAdapter adapter;
                        if(results != null) {
                            adapter = new ContactAdapter(inflater, results, listener);
                        }else{
                            Log.d(MainActivity.MAIN_LOG,"contactList == null");
                            adapter = new ContactAdapter(inflater, contacts, listener);
                        }
                        recyclerView.setAdapter(adapter);
                    }
                });
            }
        });
        searchThread.start();
    }

    @Override
    public void afterTextChanged(Editable editable) { }

    public void setContacts(ArrayList<Contact> contacts) {
        this.contacts = contacts;
    }
}