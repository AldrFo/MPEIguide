package com.example.mpeiguide.info.contacts;

import com.example.mpeiguide.R;

import java.util.ArrayList;

public class Contact {

    public static Contact[] contacts = {
            new Contact(
                    "Бобряков \nАлександр \nВладимирович",
                    "Заведующий кафедрой управления и интеллектуальных технологий",
                    "+7 495 362-74-07",
                    "М-313","",
                    "BobriakovAV@mpei.ru",
                    R.drawable.babryakov),
            new Contact(
                    "Варшавский \nПавел \nРоманович",
                    "Заведующий кафедрой прикладной математики и искусственного интеллекта",
                    "+7 495 362-79-62, 61-14",
                    "М-703","",
                    "VarshavskyPR@mpei.ru",
                    R.drawable.varshvky),
            new Contact(
                    "Вишняков \nСергей \nВикторович",
                    "Директор, заведующий кафедрой вычислительных машин, систем и сетей",
                    "+7 495 362-75-39, 76-64",
                    "Г-313","",
                    "VishniakovSV@mpei.ru",
                    R.drawable.vishnyakov),
            new Contact(
                    "Желбаков \nИгорь \nНиколаевич",
                    "Заведующий кафедрой диагностических информационных технологий",
                    "+7 495 362-77-47",
                    "В-310","",
                    "ZhelbakovIgN@mpei.ru",
                    Contact.NONE),
            new Contact(
                    "Зубков \nПавел \nВалерьевич",
                    "Заведующий кафедрой математического и компьютерного моделирования",
                    "+7 495 362-77-72",
                    "М-705","",
                    "ZubkovPV@mpei.ru",
                    Contact.NONE),
            new Contact(
                    "Коротких \nТатьяна \nНиколаевна",
                    "Начальник 2 курса (бакалавриат)",
                    "+7 495 362-76-64",
                    "Г-317","",
                    "KorotkikhTN@mpei.ru",
                    Contact.NONE),
            new Contact(
                    "Костина \nМария \nБорисовна",
                    "Начальник 3 курса (бакалавриат) и 1 курса (магистратура)",
                    "+7 495 362-76-64",
                    "Г-315","",
                    "KostinaMB@mpei.ru",
                    Contact.NONE),
            new Contact(
                    "Русинова \nНаталия \nНиколаевна",
                    "Начальник 2 курса (магистратура)",
                    "+7 495 362-76-64",
                    "Г-315","",
                    "RusinovaNN@mpei.ru",
                    Contact.NONE),
            new Contact(
                    "Топорков \nВиктор \nВасильевич",
                    "Заведующий кафедрой вычислительных технологий",
                    "+7 495 362-71-45",
                    "","",
                    "ToporkovVV@mpei.ru",
                    R.drawable.toporkov),
            new Contact(
                    "Шагов \nНикита \nСергеевич",
                    "Начальник 4 курса (бакалавриат)",
                    "+7 495 362-76-64",
                    "Г-313","",
                    "ShagovNS@mpei.ru",
                    R.drawable.shagov),
            new Contact(
                    "Щёголев Павел",
                    "Начальник 1 курса (бакалавриат)",
                    "+7 495 362-76-64",
                    "Г-315","",
                    "ShchegolevsP@mpei.ru",
                    Contact.NONE),
            new Contact(
                    "Абросимов \nЛеонид \nИванович",
                    "Профессор",
                    "",
                    "","",
                    "AbrosimovLI@mpei.ru",
                    Contact.NONE),
            new Contact(
                    "Борисова \nСветлана \nВячеславовна",
                    "Старший преподаватель",
                    "",
                    "","",
                    "BorisovaSV@mpei.ru",
                    Contact.NONE),
            new Contact(
                    "Геворкян \nВладимир \nМушегович",
                    "Профессор",
                    "",
                    "","",
                    "GevorkianVM@mpei.ru",
                    Contact.NONE),
            new Contact(
                    "Казанцев \nЮрий \nАлексеевич",
                    "Профессор",
                    "",
                    "","",
                    "KazantsevYA@mpei.ru",
                    Contact.NONE),
            new Contact(
                    "Кобяк \nАлександр \nТрофимович",
                    "Доцент",
                    "",
                    "","",
                    "KobiakAT@mpei.ru",
                    Contact.NONE),
            new Contact(
                    "Ковалева \nТатьяна \nЮрьевна",
                    "Доцент",
                    "",
                    "","",
                    "KovalevaTY@mpei.ru",
                    Contact.NONE),
            new Contact(
                    "Краюшкин \nВладимир \nВалентинович",
                    "Доцент",
                    "",
                    "","",
                    "KrayushkinVV@mpei.ru",
                    Contact.NONE),
            new Contact(
                    "Ладыгин \nИгорь \nИванович",
                    "Профессор",
                    "",
                    "","",
                    "LadyginII@mpei.ru",
                    Contact.NONE),
            new Contact(
                    "Зорин \nАндрей \nЮрьевич",
                    "Профессор",
                    "",
                    "","",
                    "ZorinAY@mpei.ru",
                    Contact.NONE),
            new Contact(
                    "Желбаков \nИгорь \nНиколаевич",
                    "Профессор",
                    "",
                    "","",
                    "ZhelbakovIgN@mpei.ru",
                    Contact.NONE),
            new Contact(
                    "Соколов \nИгорь \nВячеславович",
                    "Профессор",
                    "",
                    "","",
                    "SokolovIV@mpei.ru",
                    Contact.NONE),
            new Contact(
                    "Шкатов \nПетр \nНиколаевич",
                    "Профессор",
                    "",
                    "","",
                    "ShkatovPN@mpei.ru",
                    Contact.NONE),
            new Contact(
                    "Самокрутов \nАндрей \nАнатольевич",
                    "Профессор",
                    "",
                    "","",
                    "SamokrutovAA@mpei.ru",
                    Contact.NONE),
            new Contact(
                    "Лунин \nВалерий \nПавлович",
                    "Профессор",
                    "",
                    "","",
                    "LuninVP@mpei.ru",
                    Contact.NONE),
            new Contact(
                    "Кузнецов \nЭдуард \nВасильевич",
                    "Профессор",
                    "",
                    "","",
                    "KuznetsovEV@mpei.ru",
                    Contact.NONE),
            new Contact(
                    "Косарина \nЕкатерина \nИвановна",
                    "Профессор",
                    "",
                    "","",
                    "KosarinaYI@mpei.ru",
                    Contact.NONE),
            new Contact(
                    "Качанов \nВладимир \nКлиментьевич",
                    "Профессор",
                    "",
                    "","",
                    "KachanovVK@mpei.ru",
                    Contact.NONE),
            new Contact(
                    "Диденко \nВалерий \nИванович",
                    "Профессор",
                    "",
                    "","",
                    "DidenkoVI@mpei.ru",
                    Contact.NONE),
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
