package com.example.mpeiguide.info.organizations;

import android.util.Log;

import com.example.mpeiguide.MainActivity;
import com.example.mpeiguide.info.Searcher;

import java.util.ArrayList;
import java.util.List;

public class OrganizationSearcher extends Searcher {

    List<Organization> organizations;

    public OrganizationSearcher(List<Organization> organizations){
        this.organizations = organizations;
    }

    @Override
    public boolean isPassSearchCondition(String request, Object whereSearch) {
        Organization org = (Organization) whereSearch;
        return org.getOrgName().toLowerCase().contains(request) || org.getVkName().toLowerCase().contains(request);
    }

    @Override
    public void checkAboutRequest(String request, ArrayList results) {
        for (Organization org: organizations){
            if(isPassSearchCondition(request,org) && !results.contains(org)){
                results.add(org);
                Log.d(MainActivity.MAIN_LOG,"OrganizationSearcher: finded " + org.getOrgName());
            }
        }
    }
}
