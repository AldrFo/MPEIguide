package com.example.mpeiguide.timetable;

import android.util.Log;

import com.example.mpeiguide.MainActivity;

import java.io.Serializable;

public class Event implements Serializable {

    public static final String LECTURE = "Лекция";
    public static final String SEMINAR = "Практика";
    public static final String LAB = "Лабораторная работа";

    public static final String START_TIME = "start_time";
    public static final String END_TIME = "end_time";
    public static final String TEACHER_NAME = "teacher_name";
    public static final String EVENT_TYPE = "event_type";
    public static final String PLACE = "place";
    public static final String DESCRIPTION = "description";
    public static final String EVENT_NAME = "event_name";
    public static final String ID = "id";
    public static final String POSITION = "position";

    private String startTime;
    private String endTime;
    private String teacherName;
    private String eventType;
    private String place;
    private String description;
    private String eventName;

    private int id;

    public Event(String startTime, String endTime, String eventName, String eventType,
                 String place, String teacherName, String description){
        this.startTime = startTime;
        this.endTime = endTime;
        this.eventName = eventName;
        this.eventType = eventType;
        this.place = place;
        this.teacherName = teacherName;
        this.description = description;

        id = description.hashCode() + place.hashCode();
    }

    public int getStartTimeInMinutes(){
        if(startTime.equals("")){
            return 0;
        }
        int minutes;
        char[] time = startTime.toCharArray();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (time[i] != ':'){
            sb.append(time[i]);
            i++;
        }
        minutes = Integer.parseInt(sb.toString())*60;
        Log.d(MainActivity.MAIN_LOG,"Event: hours in minutes == " + minutes);
        sb = new StringBuilder();
        for(int j = i+1; j < time.length;j++){
            sb.append(time[j]);
        }
        minutes += Integer.parseInt(sb.toString());

        return minutes;

    }

    public int getId(){
        return id;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public String getEventName() {
        return eventName;
    }

    public String getEventType() {
        return eventType;
    }

    public String getPlace() {
        return place;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public String getDescription() {
        return description;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
