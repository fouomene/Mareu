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
    private String coWorkers;

    public Meeting(int id, String meetingName, int hour, int minute, String meetingPlace, String topic, String coWorkers) {
        this.id = id;
        this.meetingName = meetingName;
        this.hour = hour;
        this.minute = minute;
        this.meetingPlace = meetingPlace;
        this.topic = topic;
        this.coWorkers = coWorkers;
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

    public String getCoWorkers() {
        return coWorkers;
    }

    public void setCoWorkers(String coWorkers) {
        this.coWorkers = coWorkers;
    }
}
