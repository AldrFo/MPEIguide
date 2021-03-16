package com.example.mpeiguide.info.organizations;

import java.util.ArrayList;
import java.util.List;

public class Organization {

    public static final int NONE = 0;

    public static final Organization[] organizations = {
            new Organization("Объединенный студенческий совет",
                    " Объединенный студенческий совет НИУ МЭИ", "https://vk.com/oss_mpei",
                    " Силаев Максим Андреевич", " Д-2/11",
                    " Объединенный студенческий совет был создан в целях " +
                            "обеспечения реализации прав обучающихся на участие в управлении образовательным " +
                            "процессом, решения важных вопросов жизнедеятельности студенческой молодежи, " +
                            "развития её социальной активности, поддержки и реализации социальных инициатив.",
                    NONE),
            new Organization("Профсоюзная организация студентов и аспирантов",
                    " Профком Студентов и Аспирантов МЭИ", "https://vk.com/profcom_mpei",
                    " Власов Вячеслав Александрович", " В-100",
                    " Профком оказывает социальную поддержку, защиту и " +
                            "помощь студентам. Ведется активная оздоровительная работа, включающая в себя " +
                            "организацию лечения студентов в санатории-профилактории МЭИ и отдых в " +
                            "студенческих спортивных лагерях МЭИ «Алушта» и «Энергия».",
                    NONE),
            new Organization("Союз студенческих отрядов",
                    " Союз студенческих отрядов НИУ «МЭИ» | ССО МЭИ", "https://vk.com/mpeisso",
                    " Егоров Александр Витальевич", " Э-102",
                    " Союз студенческих отрядов МЭИ – это организация, " +
                            "обеспечивающая временной трудовой занятостью студентов МЭИ на время летних " +
                            "каникул и в свободное от учебы время.",
                    NONE),
            new Organization("Студсоветы общежитий",
                    " Студенческий совет общежитий МЭИ", "https://vk.com/leforto_city",
                    " Силаев Максим Андреевич", " --- ",
                    " Студенческий совет — орган самоуправления в общежитии. Мы проводим " +
                            "развлекательные и спортивные мероприятия, участвуем в твоем общении с администрацией " +
                            "Студгородка и общежития, помогаем защищать твои интересы. В каждом общежитии " +
                            "есть свой студсовет. Смотрите информацию в группе ВК.",
                    NONE),
            new Organization("Совет старост",
                    " Совет старост МЭИ", "https://vk.com/sovet_starost",
                    " Якименко Дарья Юрьевна", " Д-417",
                    " Совет старост – это орган студенческого самоуправления, активное " +
                            "молодежное сообщество, которое помогает старостам-первокурсникам адаптироваться " +
                            "к учебному процессу и правильно выполнять свою работу, а также старается сделать " +
                            "внеучебную жизнь студентов МЭИ разнообразной, яркой и полезной.",
                    NONE),
            new Organization("Студенческий Культактив МЭИ",
                    " Культактив МЭИ | Официальная группа", "https://vk.com/cultactive_mpei",
                    " Трохин Дмитрий Александрович", " Дом Культуры МЭИ, к. 402",
                    " Основное направление - это организация и проведение досуговых, " +
                            "культурно-массовых мероприятий для студентов во внеучебное время. А также " +
                            "участие в организации и проведении программ зимних и летних лагерей МЭИ, " +
                            "обучение заинтересованных студентов организации и проведению культурно-массовых " +
                            "мероприятий в ДК МЭИ, МЭИ и за его пределами и многое другое.",
                    NONE),
            new Organization("Туристическо-поисковый клуб «Горизонт»",
                    " ТПК «Горизонт» МЭИ", "https://vk.com/tpkgorizont",
                    " Таранин Богдан Львович", " С-51",
                    " Основными направлениями работы клуба являются: пеший, водный, лыжный " +
                            "и спелеотуризм, поисковая работа в рамках Всероссийской Вахты Памяти по поиску, " +
                            "установлению личности и перезахоронению павших защитников Отечества, а также " +
                            "краеведческая работа по изучению истории района «Лефортово» и города Москвы в целом.",
                    NONE),
            new Organization("Центр карьеры",
                    " Центр карьеры МЭИ", "https://vk.com/ckmei",
                    " Безрукова Ирина Юрьевна", " В-211",
                    " Центр карьеры помогает студентам и выпускникам найти работу или " +
                            "подработку, получить знания по профориентации и освоиться на современном рынке труда.",
                    NONE),
            new Organization("Фотоклуб «Новая энергия»",
                    " Фотоклуб МЭИ «Новая энергия»", "https://vk.com/mpei_photoclub",
                    " Князев Александр Михайлович", " Дом культуры МЭИ",
                    " Фотоклуб МЭИ «Новая энергия» дает возможность поучаствовать в " +
                            "фотоконкурсах и увидеть свою работу на регулярных фотовыставках, получить новые " +
                            "навыки и расширить кругозор на множестве тематических мероприятий, найти " +
                            "единомышленников и поучаствовать в фотопоездках по Москве и Подмосковью.",
                    NONE),
            new Organization("Интернациональный совет",
                    " Интернациональный совет НИУ «МЭИ»", "https://vk.com/intersovetmpei",
                    " Евлахова Ольга Максимовна", " --- ",
                    " Интернациональный совет НИУ «МЭИ» работает с иностранными студентами " +
                            "в различных направлениях их деятельности. Структура Интерсовета базируется на " +
                            "Землячествах. Землячество – объединение представителей одной страны, либо " +
                            "нескольких стран, близких по менталитету и культурным традициям внутри вуза.",
                    NONE)
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
