package com.example.mpeiguide.info.sites;

public class Site {

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
}
