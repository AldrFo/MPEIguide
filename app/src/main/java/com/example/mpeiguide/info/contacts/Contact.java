package com.example.mpeiguide.info.contacts;

import java.util.ArrayList;

public class Contact {

    public static Contact[] contacts = {
            new Contact(
                    "Бобряков Александр Владимирович",
                    "Заведующий кафедрой управления и интеллектуальных технологий",
                    "+7 495 362-74-07",
                    "М-313","",
                    "BobriakovAV@mpei.ru",
                    Contact.NONE),
            new Contact(
                    "Варшавский Павел Романович",
                    "Заведующий кафедрой прикладной математики и искусственного интеллекта",
                    "+7 495 362-79-62, 61-14",
                    "М-703","",
                    "VarshavskyPR@mpei.ru",
                    Contact.NONE),
            new Contact(
                    "Вишняков Сергей Викторович",
                    "Директор, заведующий кафедрой вычислительных машин, систем и сетей",
                    "+7 495 362-75-39, 76-64",
                    "Г-313","",
                    "VishniakovSV@mpei.ru",
                    Contact.NONE),
            new Contact(
                    "Желбаков Игорь Николаевич",
                    "Заведующий кафедрой диагностических информационных технологий",
                    "+7 495 362-77-47",
                    "В-310","",
                    "ZhelbakovIgN@mpei.ru",
                    Contact.NONE),
            new Contact(
                    "Зубков Павел Валерьевич",
                    "Заведующий кафедрой математического и компьютерного моделирования",
                    "+7 495 362-77-72",
                    "М-705","",
                    "ZubkovPV@mpei.ru",
                    Contact.NONE),
            new Contact(
                    "Коротких Татьяна Николаевна",
                    "Начальник 2 курса (бакалавриат)",
                    "+7 495 362-76-64",
                    "Г-317","",
                    "KorotkikhTN@mpei.ru",
                    Contact.NONE),
            new Contact(
                    "Костина Мария Борисовна",
                    "Начальник 3 курса (бакалавриат) и 1 курса (магистратура)",
                    "+7 495 362-76-64",
                    "Г-315","",
                    "KostinaMB@mpei.ru",
                    Contact.NONE),
            new Contact(
                    "Русинова Наталия Николаевна",
                    "Начальник 2 курса (магистратура)",
                    "+7 495 362-76-64",
                    "Г-315","",
                    "RusinovaNN@mpei.ru",
                    Contact.NONE),
            new Contact(
                    "Топорков Виктор Васильевич",
                    "Заведующий кафедрой вычислительных технологий",
                    "+7 495 362-71-45",
                    "","",
                    "ToporkovVV@mpei.ru",
                    Contact.NONE),
            new Contact(
                    "Шагов Никита Сергеевич",
                    "Начальник 4 курса (бакалавриат)",
                    "+7 495 362-76-64",
                    "Г-313","",
                    "ShagovNS@mpei.ru",
                    Contact.NONE),
            new Contact(
                    "Щёголев Павел",
                    "Начальник 1 курса (бакалавриат)",
                    "+7 495 362-76-64",
                    "Г-315","",
                    "ShchegolevsP@mpei.ru",
                    Contact.NONE),
            new Contact(
                    "Абросимов Леонид Иванович",
                    "Профессор",
                    "",
                    "","",
                    "AbrosimovLI@mpei.ru",
                    Contact.NONE),
            new Contact(
                    "Борисова Светлана Вячеславовна",
                    "Старший преподаватель",
                    "",
                    "","",
                    "BorisovaSV@mpei.ru",
                    Contact.NONE),
            new Contact(
                    "Геворкян Владимир Мушегович",
                    "Профессор",
                    "",
                    "","",
                    "GevorkianVM@mpei.ru",
                    Contact.NONE),
            new Contact(
                    "Казанцев Юрий Алексеевич",
                    "Профессор",
                    "",
                    "","",
                    "KazantsevYA@mpei.ru",
                    Contact.NONE),
            new Contact(
                    "Кобяк Александр Трофимович",
                    "Доцент",
                    "",
                    "","",
                    "KobiakAT@mpei.ru",
                    Contact.NONE),
            new Contact(
                    "Ковалева Татьяна Юрьевна",
                    "Доцент",
                    "",
                    "","",
                    "KovalevaTY@mpei.ru",
                    Contact.NONE),
            new Contact(
                    "Краюшкин Владимир Валентинович",
                    "Доцент",
                    "",
                    "","",
                    "KrayushkinVV@mpei.ru",
                    Contact.NONE),
            new Contact(
                    "Ладыгин Игорь Иванович",
                    "Профессор",
                    "",
                    "","",
                    "LadyginII@mpei.ru",
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
