package com.example.mpeiguide.info.contacts;

import java.util.ArrayList;

public class Contact {

    public static Contact[] contacts ={
            new Contact("Коротких Татьяна Николаевна","Начальник 2 курса (бакалавриат)",
                    "+7-495-362-76-64","Г-317",
                    "Очень большое описание, которое мне лень писать, главное, чтобы оно было больше 50 символов",
                    "KorotkikhTN@mpei.ru",Contact.NONE),
            new Contact("Быстрый займ!","Начальник никакого курса",
                    "8-800-555-35-35","нигде",
                    "Проще позвонить, чем мать свою продать!","hahahaha",Contact.NONE),
            new Contact("Фофанов Александр Васильевич","тупа дебик",
                    "8-964-511-03-55","у компа","грустный мальчик(9(",
                    "pupailupa@gmail.com",Contact.NONE),
            new Contact("ФофАнов","тупа дебик",
                    "8-964-511-03-55","у компа","грустный мальчик(9(",
                    "pupailupa@gmail.com",Contact.NONE)
    };

    public static final int NONE = 0;

    public static final String NAME = "name";
    public static final String WORK_POS = "work_pos";
    public static final String PHONE_NUM = "phone_num";
    public static final String PLACE = "place";
    public static final String DESCRIPTION = "description";
    public static final String EMAIL = "email";
    public static final String IMAGE_ID = "image_view";

    private int imageId;
    private String name;
    private String workPosition;
    private String phoneNumber;
    private String place;
    private String description;
    private String email;

    public Contact(String name, String workPosition, String phoneNumber, String place,
                   String description, String email,int imageId){
        this.name = name;
        this.workPosition = workPosition;
        this.phoneNumber = phoneNumber;
        this.place = place;
        this.description = description;
        this.email = email;
        this.imageId = imageId;
    }

    public static ArrayList<Contact> getContactsList(){
        ArrayList<Contact> contacts = new ArrayList<>();
        for(int i = 0;i<Contact.contacts.length;i++){
            contacts.add(Contact.contacts[i]);
        }
        return contacts;
    }

    public String getName() {
        return name;
    }

    public String getWorkPosition() {
        return workPosition;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getPlace() {
        return place;
    }

    public String getDescription() {
        return description;
    }

    public String getEmail() {
        return email;
    }

    public int getImageId(){
        return imageId;
    }
}
