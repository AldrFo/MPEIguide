package com.example.mpeiguide.info.organizations;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mpeiguide.R;

public class OrganizationsFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_organizations, container, false);
        return v;
    }

    public static OrganizationsFragment newInstance() {
        OrganizationsFragment fragment = new OrganizationsFragment();
        return fragment;
    }
}