package com.example.mpeiguide.timetable;

import android.util.Log;

import com.example.mpeiguide.MainActivity;

import java.io.Serializable;
import java.util.ArrayList;

public class Timetable implements Serializable {

    public static final int MONDAY = 0;
    public static final int TUESDAY = 1;
    public static final int WEDNESDAY = 2;
    public static final int THURSDAY = 3;
    public static final int FRIDAY = 4;
    public static final int SATURDAY = 5;
    public static final int SUNDAY = 6;

    private ArrayList<Event> timetable;

    public Timetable(int day, boolean even){
        if(even) {
            timetable = setTimetableEven(day);
        }else{
            timetable = setTimetableNotEven(day);
        }
    }

    private static ArrayList<Event> setTimetableNotEven(int day){
        Event[] events;
        switch (day){
            case MONDAY:
                events = new Event[]{
                        new Event("11:10", "12:45", "Информатика",
                                Event.SEMINAR, "А-310",
                                "Аляева Юлия Владимировна", "...",false),
                        new Event("13:45", "15:20", "Программирование",
                                Event.LAB, "Ж-111",
                                "Гречкина Полина Викторовна", "...",false),
                        new Event("18:55", "20:25", "Математический анализ",
                                "Консультация", "ЭО и ДОТ", "Симушев А. А.",
                                "...",false)
                };
                break;
            case TUESDAY:
                events = new Event[]{
                        new Event("09:20", "10:55", "Математический анализ",
                                Event.LECTURE, "ЭО и ДОТ", "Симушев А. А.",
                                "...",false),
                        new Event("11:10", "12:45", "Физика",
                                Event.LECTURE, "ЭО и ДОТ", "Корецкая И. В.",
                                "...",false),
                        new Event("13:45", "15:20", "Программирование",
                                Event.LECTURE, "ЭО и ДОТ", "Гречкина И.В.",
                                "...",false),
                        new Event("15:35", "17:10", "Проектная деятельность",
                                Event.LECTURE, "ЭО и ДОТ", "Курилов С.Н.",
                                "...",false)
                };
                break;
            case WEDNESDAY:
                events = new Event[]{
                        new Event("09:20", "10:55", "Математический анализ",
                                Event.SEMINAR, "А-306", "Боровиков И.А.",
                                "...",false),
                        new Event("11:10", "12:45", "Физика",
                                Event.SEMINAR, "A-204", "Коротких И.И.",
                                "...",false),
                        new Event("13:45", "15:20",
                                "Элективные курсы по физической культуре и спорту",
                                Event.SEMINAR, "Спортзал", "", "...",false)
                };
                break;
            case THURSDAY:
                events = new Event[]{
                        new Event("11:10", "12:45", "Информатика",
                                Event.LECTURE, "ЭО и ДОТ", "Крюков А.Ф.",
                                "...",false),
                        new Event("17:20", "18:50", "Математический анализ",
                                "Консультация", "ЭО и ДОТ", "Симушев А. А.",
                                "...",false)
                };
                break;
            case FRIDAY:
                events = new Event[]{
                        new Event("11:10", "12:45", "Математический анализ",
                                Event.SEMINAR, "Д-411", "Боровиков И.А.",
                                "...",false),
                        new Event("13:45", "15:20", "Иностранный язык",
                                Event.SEMINAR, "M-912/M-809", "", "...",false),
                        new Event("15:35", "17:10",
                                "Элективные курсы по физической культуре и спорту",
                                Event.SEMINAR, "Спортзал", "", "...",false)
                };
                break;
            default:
                Log.d(MainActivity.MAIN_LOG,"Timetable: timetable is null");
                events = null;
        }

        return arrayToList(events);
    }

    private static ArrayList<Event> setTimetableEven(int day){
        Event[] events;
        switch (day){
            case MONDAY:
                events = new Event[]{
                        new Event("11:10", "12:45", "Физика",
                                Event.LAB, "А-102/ЭО и ДОТ",
                                "Бадамшина Э.Б./Печинская О.В.", "...",false),
                        new Event("13:45", "15:20", "Программирование",
                                Event.LAB, "Ж-111",
                                "Гречкина Полина Викторовна", "...",false),
                        new Event("18:55", "20:25", "Математический анализ",
                                "Консультация", "ЭО и ДОТ", "Симушев А. А.",
                                "...",false)
                };
                break;
            case TUESDAY:
                events = new Event[]{
                        new Event("09:20", "10:55", "Математический анализ",
                                "Лекция", "ЭО и ДОТ", "Симушев А. А.",
                                "...",false),
                        new Event("11:10", "12:45", "Физика",
                                "Лекция", "ЭО и ДОТ", "Корецкая И. В.",
                                "...",false),
                        new Event("13:45", "15:20", "Программирование",
                                "Лекция", "ЭО и ДОТ", "Гречкина И.В.",
                                "...",false),
                        new Event("15:35", "17:10", "Проектная деятельность",
                                "Лекция", "ЭО и ДОТ", "Курилов С.Н.",
                                "...",false)
                };
                break;
            case WEDNESDAY:
                events = new Event[]{
                        new Event("09:20", "10:55", "Математический анализ",
                                Event.SEMINAR, "А-306", "Боровиков И.А.",
                                "...",false),
                        new Event("11:10", "12:45", "Физика",
                                Event.SEMINAR, "A-204", "Коротких И.И.",
                                "...",false),
                        new Event("13:45", "15:20",
                                "Элективные курсы по физической культуре и спорту",
                                Event.SEMINAR, "Спортзал", "", "...",false)
                };
                break;
            case THURSDAY:
                events = new Event[]{
                        new Event("09:20", "10:55", "Математический анализ",
                                "Лекция", "ЭО и ДОТ", "Симушев А. А.",
                                "...",false),
                        new Event("11:10", "12:45", "Информатика",
                                Event.LECTURE, "ЭО и ДОТ", "Крюков А.Ф.",
                                "...",false),
                        new Event("17:20", "18:50", "Математический анализ",
                                "Консультация", "ЭО и ДОТ", "Симушев А. А.",
                                "...",false)
                };
                break;
            case FRIDAY:
                events = new Event[]{
                        new Event("9:20", "10:55", "Проектная деятельность",
                                Event.SEMINAR, "Д-411", "Воронкина А.А.",
                                "...",false),
                        new Event("11:10", "12:45", "Математический анализ",
                                Event.SEMINAR, "Д-411", "Боровиков И.А.",
                                "...",false),
                        new Event("13:45", "15:20", "Иностранный язык",
                                Event.SEMINAR, "M-912/M-809", "", "...",false),
                        new Event("15:35", "17:10",
                                "Элективные курсы по физической культуре и спорту",
                                Event.SEMINAR, "Спортзал", "", "...",false)
                };
                break;
            default:
                Log.d(MainActivity.MAIN_LOG,"Timetable: timetable is null");
                events = null;
        }

        return arrayToList(events);
    }

    private static ArrayList<Event> arrayToList(Event[] events){
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

    public void setTimetable(ArrayList<Event> events){
        timetable = events;
    }

    public void addToTimetable(Event e){
        timetable.add(e);
    }
}
