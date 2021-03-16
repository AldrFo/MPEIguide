package com.example.mpeiguide.info;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.mpeiguide.R;
import com.example.mpeiguide.info.contacts.ContactsFragment;
import com.example.mpeiguide.info.faq.FaqFragment;
import com.example.mpeiguide.info.organizations.OrganizationsFragment;
import com.example.mpeiguide.info.sites.SitesFragment;
import com.example.mpeiguide.settings.SettingsFragment;

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

        SharedPreferences settings = getContext()
                .getSharedPreferences(SettingsFragment.SETTING_NAME, Context.MODE_PRIVATE);

        if(!settings.getBoolean(SettingsFragment.ALARM_BUTTON,true)){
            LinearLayout layout = v.findViewById(R.id.info_layout);
            layout.removeView(psihButton);
        }
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
                loadFragment(SitesFragment.newInstance());
                break;
            case R.id.FAQ_button:
                loadFragment(FaqFragment.newInstance());
                break;
            case R.id.da_ya_psih_button:
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+7 495 362-74-71"));
                startActivity(intent);
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