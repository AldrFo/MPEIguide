package com.example.mpeiguide.info.sites;

import android.content.Intent;
import android.net.Uri;
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
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.mpeiguide.MainActivity;
import com.example.mpeiguide.R;
import com.example.mpeiguide.info.organizations.Organization;
import com.example.mpeiguide.info.organizations.OrganizationAdapter;

import java.util.ArrayList;
import java.util.List;


public class SitesFragment extends Fragment implements TextWatcher {

    private EditText search;
    private RecyclerView recyclerView;
    private ImageButton back;

    private SitesAdapter.OnSiteClickListener listener;
    private List<Site> sites;

    private SitesSearcher searcher;

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
        search.addTextChangedListener(this);
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
        fragment.searcher = new SitesSearcher(fragment.sites);
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
                final ArrayList<Site> results = searcher.search(charSequence.toString());
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        SitesAdapter adapter;
                        if(results != null) {
                            adapter = new SitesAdapter(inflater, results, listener);
                        }else{
                            Log.d(MainActivity.MAIN_LOG,"contactList == null");
                            adapter = new SitesAdapter(inflater, sites, listener);
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