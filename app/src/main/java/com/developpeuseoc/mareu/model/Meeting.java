package com.developpeuseoc.mareu.model;

import java.util.ArrayList;
import java.util.List;

public class Meeting {

    private int meetingTime;
    private String meetignPlace;
    private String topic;
    private List<CoWorker> coWorkerList = new ArrayList<>();

    public Meeting(int meetingTime, String meetignPlace, String topic, List<CoWorker> coWorkerList) {
        this.meetingTime = meetingTime;
        this.meetignPlace = meetignPlace;
        this.topic = topic;
        this.coWorkerList = coWorkerList;
    }

    public int getMeetingTime() {
        return meetingTime;
    }

    public void setMeetingTime(int meetingTime) {
        this.meetingTime = meetingTime;
    }

    public String getMeetignPlace() {
        return meetignPlace;
    }

    public void setMeetignPlace(String meetignPlace) {
        this.meetignPlace = meetignPlace;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public List<CoWorker> getCoWorkerList() {
        return coWorkerList;
    }

    public void setCoWorkerList(List<CoWorker> coWorkerList) {
        this.coWorkerList = coWorkerList;
    }
}
