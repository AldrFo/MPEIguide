package com.example.mpeiguide.info.sites;

import java.util.ArrayList;
import java.util.List;

public class Site {

    public static final Site[] sites = {
            new Site("http://grechkinapv.appmat.ru","Сайт Гречкины П. В.",
                    "Сайт, на котором вы сможете найти всю необходимую информацию по " +
                            "программрованию, если ваш лектор Гречкина Полина Викторовна"),
            new Site("https://mpei.ru","Сайт НИУ МЭИ","Официальный сайт НИУ МЭИ")
    };

    private String link;
    private String name;
    private String description;

    public Site(String link, String name, String description){
        this.link = link;
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getLink() {
        return link;
    }

    public String getDescription() {
        return description;
    }

    public static List<Site> getSites(){
        List<Site> s = new ArrayList<>();
        for(int i = 0; i < sites.length;i++){
            s.add(sites[i]);
        }
        return s;
    }
}
