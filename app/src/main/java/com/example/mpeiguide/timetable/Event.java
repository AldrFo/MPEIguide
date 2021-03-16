package com.example.mpeiguide.timetable;

import android.util.Log;

import com.example.mpeiguide.MainActivity;

import java.io.Serializable;
import java.util.ArrayList;

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
    public static final String POSITION = "position";
    public static final String EDITABLE = "editable";

    private String startTime;
    private String endTime;
    private String teacherName;
    private String eventType;
    private String place;
    private String description;
    private String eventName;

    private boolean editable;


    public Event(String startTime, String endTime, String eventName, String eventType,
                 String place, String teacherName, String description, boolean editable){
        this.startTime = startTime;
        this.endTime = endTime;
        this.eventName = eventName;
        this.eventType = eventType;
        this.place = place;
        this.teacherName = teacherName;
        this.description = description;
        this.editable = editable;
    }

    public int getStartTimeInMinutes(){
        if(startTime.equals("")){
            return 0;
        }
        int minutes;
        int[] timeNums = getIntTimeFromString(startTime);
        minutes = timeNums[0]*60;
        Log.d(MainActivity.MAIN_LOG,"Event: hours in minutes == " + minutes);
        minutes += timeNums[1];

        return minutes;

    }

    private static int[] getIntTimeFromString(String s){
        int[] timeNumbers = new int[2];
        char[] time = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (time[i] != ':'){
            sb.append(time[i]);
            i++;
        }
        timeNumbers[0] = Integer.parseInt(sb.toString());
        sb = new StringBuilder();
        for(int j = i+1; j < time.length;j++){
            sb.append(time[j]);
        }
        timeNumbers[1] = Integer.parseInt(sb.toString());
        return timeNumbers;
    }

    public static void sortEventsByTime(ArrayList<Event> timetable){
        for(int i = 0;i < timetable.size();i++){
            for(int j = 1; j < timetable.size();j++){
                if(timetable.get(j-1).getStartTimeInMinutes() > timetable.get(j).getStartTimeInMinutes()){
                    Event e = timetable.get(j-1);
                    timetable.set(j-1,timetable.get(j));
                    timetable.set(j,e);
                }
            }
        }
    }

    public static boolean isTimeCorrect(String time){
        boolean isDivided = false;

        for(int i = 0;i<time.length();i++){
            char c = time.charAt(i);
            if(c == ':' && !isDivided){
                isDivided = true;
            }else if(c == ':' && isDivided){
                return false;
            }
        }
        int[] timeNums = getIntTimeFromString(time);
        return (isDivided && timeNums[0]<24 && timeNums[1]<60);
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

    public boolean isEditable() {
        return editable;
    }
}
