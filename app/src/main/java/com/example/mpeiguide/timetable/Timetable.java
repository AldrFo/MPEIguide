package com.example.mpeiguide.timetable;

import java.util.ArrayList;

public class Timetable {

    public static final int MONDAY = 0;
    public static final int TUESDAY = 1;
    public static final int WEDNESDAY = 2;
    public static final int THURSDAY = 3;
    public static final int FRIDAY = 4;
    public static final int SATURDAY = 5;
    public static final int SUNDAY = 6;

    private ArrayList<Event> timetable;

    public Timetable(int day){
        timetable = setTimetable(day);
    }

    private static ArrayList<Event> setTimetable(int day){
        Event[] events;
        switch (day){
            case MONDAY:
                events = new Event[]{
                        new Event("11:10", "12:45", "Информатика",
                                "Практика", "А-310",
                                "Аляева Юлия Владимировна", "---"),
                        new Event("13:45", "15:20", "Программирование",
                                "Лабораторная работа", "Ж-111",
                                "Гречкина Полина Викторовна", "----")
                };
                break;
            case TUESDAY:
                events = new Event[]{
                        new Event("09:20", "10:55", "Мат. Анализ",
                                "Лекция", "ЭО и ДОТ", "Симушев А. А.",
                                "---"),
                        new Event("11:10", "12:45", "Физика",
                                "Лекция", "ЭО и ДОТ", "Корецкая И. В.",
                                "----\n-----\n------"),
                        new Event("13:45", "15:20", "Программирование",
                                "Лекция", "ЭО и ДОТ", "Гречкина И.В.",
                                "-----"),
                        new Event("15:35", "17:10", "Проектная деятельность",
                                "Лекция", "ЭО и ДОТ", "Курилов С.Н.",
                                "-----")
                };
                break;
            case WEDNESDAY:
                events = new Event[]{
                        new Event("", "", "", "", "", "", ""),
                        new Event("", "", "", "", "", "", ""),
                        new Event("", "", "", "", "", "", "")
                };
                break;
            case THURSDAY:
                events = new Event[]{
                        new Event("11:10", "12:45", "Информатика",
                                "Лекция", "ЭО и ДОТ", "Крюков А.Ф.",
                                "-------")
                };
                break;
            case FRIDAY:
                events = new Event[]{
                        new Event("", "", "", "", "", "", ""),
                        new Event("", "", "", "", "", "", ""),
                        new Event("", "", "", "", "", "", ""),
                        new Event("", "", "", "", "", "", ""),
                };
                break;
            default:
                events = null;
        }

        ArrayList<Event> eventList = new ArrayList<>();
        if(events != null) {
            for (int i = 0; i < events.length; i++) {
                eventList.add(events[i]);
            }
            return eventList;
        }else{
            return null;
        }
    }

    public ArrayList<Event> getTimetable(){
        return timetable;
    }

    public void addToTimetable(Event e){
        timetable.add(e);
    }
}
