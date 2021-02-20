package com.example.mpeiguide.info.organizations;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mpeiguide.R;

public class OrganizationDetailsFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_organization_details, container, false);
        return v;
    }

    public static OrganizationDetailsFragment newInstance() {
        OrganizationDetailsFragment fragment = new OrganizationDetailsFragment();
        return fragment;
    }
}