package com.example.mpeiguide.info.organizations;

public class Organization {

    public static final int NONE = 0;

    private String orgName;
    private String vkName;
    private String vkLink;
    private String president;
    private String place;
    private String description;

    private int imageId;

    public Organization(String orgName, String vkName, String vkLink, String president, String place,
                        String description, int imageId){
        this.orgName = orgName;
        this.vkName = vkName;
        this.vkLink = vkLink;
        this.president = president;
        this.place = place;
        this.description = description;
        this.imageId = imageId;
    }

    public String getOrgName() {
        return orgName;
    }

    public String getVkName() {
        return vkName;
    }

    public String getVkLink() {
        return vkLink;
    }

    public String getPresident() {
        return president;
    }

    public String getPlace() {
        return place;
    }

    public String getDescription() {
        return description;
    }

    public int getImageId() {
        return imageId;
    }

}
