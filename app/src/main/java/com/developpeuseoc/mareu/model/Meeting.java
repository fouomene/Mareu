package com.developpeuseoc.mareu.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Meeting {

    private int id;
    private Calendar hour;
    private Calendar minute;
    private String meetingPlace;
    private String topic;
    private List<String> coWorkerList = new ArrayList<>();

    public Meeting(int id, Calendar hour, Calendar minute, String meetingPlace, String topic, List<String> coWorkerList) {
        this.id = id;
        this.hour = hour;
        this.minute = minute;
        this.meetingPlace = meetingPlace;
        this.topic = topic;
        this.coWorkerList = coWorkerList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Calendar getHour() {
        return hour;
    }

    public void setHour(Calendar hour) {
        this.hour = hour;
    }

    public Calendar getMinute() {
        return minute;
    }

    public void setMinute(Calendar minute) {
        this.minute = minute;
    }

    public String getMeetingPlace() {
        return meetingPlace;
    }

    public void setMeetingPlace(String meetingPlace) {
        this.meetingPlace = meetingPlace;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public List<String> getCoWorkerList() {
        return coWorkerList;
    }

    public void setCoWorkerList(List<String> coWorkerList) {
        this.coWorkerList = coWorkerList;
    }
}
