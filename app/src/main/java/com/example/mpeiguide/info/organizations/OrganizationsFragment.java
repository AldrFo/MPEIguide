package com.example.mpeiguide.info.organizations;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.mpeiguide.MainActivity;
import com.example.mpeiguide.R;
import com.example.mpeiguide.info.contacts.Contact;
import com.example.mpeiguide.info.contacts.ContactAdapter;

import java.util.ArrayList;
import java.util.List;

public class OrganizationsFragment extends Fragment implements TextWatcher {

    private EditText searchEditText;
    private ImageButton back;
    private RecyclerView recyclerView;
    private LayoutInflater inflater;

    private List<Organization> organizations;
    private OrganizationAdapter.OnOrganizationClickListener listener;
    private OrganizationSearcher searcher;

    private Handler handler;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        this.inflater = inflater;
        View v = inflater.inflate(R.layout.fragment_organizations, container, false);
        back = v.findViewById(R.id.organization_back_button);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().onBackPressed();
            }
        });

        searchEditText = v.findViewById(R.id.organization_search);
        searchEditText.addTextChangedListener(this);

        listener = new OrganizationAdapter.OnOrganizationClickListener() {
            @Override
            public void onOrganizationClick(Organization org, int position) {
                Toast.makeText(getContext(),"пока не работает",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getContext(),OrganizationDetailsActivity.class);
                intent.putExtra(Organization.NAME,org.getOrgName());
                intent.putExtra(Organization.VK_NAME,org.getVkName());
                intent.putExtra(Organization.VK_LINK,org.getVkLink());
                intent.putExtra(Organization.PRESIDENT,org.getPresident());
                intent.putExtra(Organization.PLACE,org.getPlace());
                intent.putExtra(Organization.DESCRIPTION,org.getDescription());
                intent.putExtra(Organization.IMAGE_ID,org.getImageId());
                startActivity(intent);
            }
        };

        recyclerView = v.findViewById(R.id.organization_recycler_view);
        OrganizationAdapter adapter = new OrganizationAdapter(inflater,organizations,listener);
        recyclerView.setAdapter(adapter);
        return v;
    }

    public static OrganizationsFragment newInstance() {
        OrganizationsFragment fragment = new OrganizationsFragment();
        fragment.organizations = Organization.getOrganizations();
        fragment.handler = new Handler();
        fragment.searcher = new OrganizationSearcher(Organization.getOrganizations());
        return fragment;
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(final CharSequence charSequence, int i, int i1, int i2) {
        Thread searchThread = new Thread(new Runnable() {
            @Override
            public void run() {
                final ArrayList<Organization> results = searcher.search(charSequence.toString());
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        OrganizationAdapter adapter;
                        if(results != null) {
                            adapter = new OrganizationAdapter(inflater, results, listener);
                        }else{
                            Log.d(MainActivity.MAIN_LOG,"contactList == null");
                            adapter = new OrganizationAdapter(inflater, organizations, listener);
                        }
                        recyclerView.setAdapter(adapter);
                    }
                });
            }
        });
        searchThread.start();
    }

    @Override
    public void afterTextChanged(Editable editable) {

    }
}