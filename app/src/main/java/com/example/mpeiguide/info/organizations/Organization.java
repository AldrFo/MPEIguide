package com.example.mpeiguide.info.organizations;

import java.util.ArrayList;
import java.util.List;

public class Organization {

    public static final int NONE = 0;

    public static final Organization[] organizations = {
            new Organization("Профком","Профком вк","https://vk.com",
                    "Ну кто-то лять, я не помню","та хуй его знает",
                    "да идите куда подальше, мне лень думать надо нормальным описанием " +
                            "вы бы еще сказали мне официальное поисание с группы в вк скатать, " +
                            "делать мне больше нечего епта",NONE),
            new Organization("РОкКлуБ", "хз","vk.com",
                    "Горшок блин","Нирвана","Нет его",NONE)
    };

    public static final String NAME = "name";
    public static final String VK_NAME = "vk_name";
    public static final String VK_LINK = "vk_link";
    public static final String PRESIDENT = "president";
    public static final String PLACE = "place";
    public static final String DESCRIPTION = "description";
    public static final String IMAGE_ID = "image_id";

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

    public static List<Organization> getOrganizations(){
        List<Organization> orgs = new ArrayList<>();
        for(int i = 0;i<organizations.length;i++){
            orgs.add(organizations[i]);
        }
        return orgs;
    }

}
