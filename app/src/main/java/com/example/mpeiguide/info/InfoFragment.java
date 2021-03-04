package com.example.mpeiguide.info;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.mpeiguide.R;
import com.example.mpeiguide.info.contacts.ContactsFragment;
import com.example.mpeiguide.info.faq.FaqFragment;
import com.example.mpeiguide.info.organizations.OrganizationsFragment;

public class InfoFragment extends Fragment implements View.OnClickListener{

    private Button contactsButton;
    private Button orgButton;
    private Button sitesButton;
    private Button faqButton;
    private Button psihButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_info, container, false);
        contactsButton = v.findViewById(R.id.contacts_button);
        orgButton = v.findViewById(R.id.organization_button);
        sitesButton = v.findViewById(R.id.sites_button);
        faqButton = v.findViewById(R.id.FAQ_button);
        psihButton = v.findViewById(R.id.da_ya_psih_button);

        contactsButton.setOnClickListener(this);
        orgButton.setOnClickListener(this);
        sitesButton.setOnClickListener(this);
        faqButton.setOnClickListener(this);
        psihButton.setOnClickListener(this);
        return v;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.contacts_button:
                loadFragment(ContactsFragment.newInstance());
                break;
            case R.id.organization_button:
                loadFragment(OrganizationsFragment.newInstance());
                break;
            case R.id.sites_button:
                break;
            case R.id.FAQ_button:
                loadFragment(FaqFragment.newInstance());
                break;
            case R.id.da_ya_psih_button:
                break;
        }
    }

    public static InfoFragment newInstance(){
        return new InfoFragment();
    }

    private void loadFragment(Fragment f){
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.replace(R.id.frag_container,f);
        ft.addToBackStack("toSomeInfo");
        ft.commit();
    }
}