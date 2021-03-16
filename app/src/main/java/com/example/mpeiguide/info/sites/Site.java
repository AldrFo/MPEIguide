package com.example.mpeiguide.info.sites;

import java.util.ArrayList;
import java.util.List;

public class Site {

    public static final Site[] sites = {
            new Site("http://grechkinapv.appmat.ru", "Сайт Гречкиной Полины Викторовны",
                    "На сайте размещены материалы лекций, семинаров Полины Викторовны, " +
                    "план  занятий на семестр и важная информация оот преподавателя." ),

            new Site("https://mpei.ru", "Сайт Национального Исследовательского Университета «МЭИ»",
                    "Главный сайт НИУ МЭИ."),

            new Site("https://avti.mpei.ru", "Сайт ИВТИ",
                    "Главный Сайт Института Информационных и Вычислительных Технологий."),

            new Site("http://opac.mpei.ru", "Сайт Библиотеки",
                    "Сайт электронной библиотеки НИУ МЭИ."),

            new Site("https://www.pkmpei.ru/", "Сайт ПК НИУ МЭИ",
                    "Сайт приемной комиссии."),

            new Site("https://bars.mpei.ru", "Сайт БАРС",
                    "Сайт бально-рейтинговой системы НИУ МЭИ."),

            new Site("https://legacy.mpei.ru", "Сайт почты НИУ МЭИ",
                    "Сайт почты НИУ МЭИ."),

            new Site("http://ts.mpei.ru/ruz/main", "Сайт расписания",
                    "Сайт с расписанием занятий групп, аудиторий и преподавателей."),

            new Site("https://mpeisport.ru/", "Сайт СТЦ МЭИ",
                    "Сайт Спортивно Технического центра МЭИ.")
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
