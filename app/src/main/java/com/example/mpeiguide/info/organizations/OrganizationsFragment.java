package com.example.mpeiguide.info.organizations;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.mpeiguide.R;

import java.util.List;

public class OrganizationsFragment extends Fragment implements TextWatcher {

    private EditText searchEditText;
    private ImageButton back;
    private RecyclerView recyclerView;

    private List<Organization> organizations;
    private OrganizationAdapter.OnOrganizationClickListener listener;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
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
        return fragment;
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {

    }
}