package com.example.mpeiguide.timetable;

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

    private String startTime;
    private String endTime;
    private String teacherName;
    private String eventType;
    private String place;
    private String description;
    private String eventName;

    public Event(String startTime, String endTime, String eventName, String eventType,
                 String place, String teacherName, String description){
        this.startTime = startTime;
        this.endTime = endTime;
        this.eventName = eventName;
        this.eventType = eventType;
        this.place = place;
        this.teacherName = teacherName;
        this.description = description;
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
