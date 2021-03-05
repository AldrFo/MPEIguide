package com.example.mpeiguide.info.sites;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.mpeiguide.R;

import java.util.List;


public class SitesFragment extends Fragment {

    private EditText search;
    private RecyclerView recyclerView;
    private ImageButton back;

    private SitesAdapter.OnSiteClickListener listener;
    private List<Site> sites;

    private LayoutInflater inflater;
    private Handler handler;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        this.inflater = inflater;
        View v = inflater.inflate(R.layout.fragment_sites, container, false);
        search = v.findViewById(R.id.sites_search);
        back = v.findViewById(R.id.sites_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().onBackPressed();
            }
        });

        listener = new SitesAdapter.OnSiteClickListener() {
            @Override
            public void onSiteClick(Site site, int position) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(site.getLink()));
                startActivity(intent);
            }
        };
        recyclerView = v.findViewById(R.id.sites_recycler_view);

        SitesAdapter adapter = new SitesAdapter(inflater,sites,listener);
        recyclerView.setAdapter(adapter);
        return v;
    }

    public static SitesFragment newInstance() {
        SitesFragment fragment = new SitesFragment();
        fragment.handler = new Handler();
        fragment.sites = Site.getSites();
        return fragment;
    }
}