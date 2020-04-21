package com.developpeuseoc.mareu.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Meeting {

    private int id;
    private int hour;
    private int minute;
    private String meetingName;
    private String meetingPlace;
    private String topic;
    private List<String> coWorkerList = new ArrayList<>();

    public Meeting(int id, String meetingName, int hour, int minute, String meetingPlace, String topic, List<String> coWorkerList) {
        this.id = id;
        this.meetingName = meetingName;
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

    public String getMeetingName() {
        return meetingName;
    }

    public void setMeetingName(String meetingName) {
        this.meetingName = meetingName;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
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
