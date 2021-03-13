package com.example.mpeiguide.info.sites;

import com.example.mpeiguide.info.Searcher;

import java.util.ArrayList;
import java.util.List;

public class SitesSearcher extends Searcher {

    List<Site> sites;

    public SitesSearcher(List<Site> sites){
        this.sites = sites;
    }

    @Override
    public boolean isPassSearchCondition(String request, Object whereSearch) {
        Site site = (Site) whereSearch;
        return site.getName().toLowerCase().contains(request);
    }

    @Override
    public void checkAboutRequest(String request, ArrayList results) {
        for(Site s: sites){
            if(isPassSearchCondition(request,s) && !results.contains(s)){
                results.add(s);
            }
        }
    }
}
