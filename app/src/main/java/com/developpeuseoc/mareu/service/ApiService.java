package com.developpeuseoc.mareu.service;

import com.developpeuseoc.mareu.model.Meeting;

import java.util.ArrayList;
import java.util.List;

public interface ApiService {

    public List<Meeting> getMeetingList();
    public List<Meeting> getFilterMeetingList();
    public List<Meeting> filterPlaceMeetingList(String place);
    public List<Meeting> filterTimeMeetingList(int hour, int mnute);
    public void addMeetingList(Meeting meeting);
    public void deleteMeeting(Meeting meeting);
}
