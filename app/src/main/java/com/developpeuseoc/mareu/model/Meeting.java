package com.developpeuseoc.mareu.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Meeting {

    private Date meetingTime;
    private String meetingPlace;
    private String topic;
    private List<CoWorker> coWorkerList = new ArrayList<>();

    public Meeting(Date meetingTime, String meetingPlace, String topic, List<CoWorker> coWorkerList) {
        this.meetingTime = meetingTime;
        this.meetingPlace = meetingPlace;
        this.topic = topic;
        this.coWorkerList = coWorkerList;
    }

    public Date getMeetingTime() {
        return meetingTime;
    }

    public void setMeetingTime(Date meetingTime) {
        this.meetingTime = meetingTime;
    }

    public String getMeetignPlace() {
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

    public List<CoWorker> getCoWorkerList() {
        return coWorkerList;
    }

    public void setCoWorkerList(List<CoWorker> coWorkerList) {
        this.coWorkerList = coWorkerList;
    }
}
