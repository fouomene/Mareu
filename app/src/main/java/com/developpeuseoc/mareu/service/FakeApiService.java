package com.developpeuseoc.mareu.service;

import com.developpeuseoc.mareu.model.Meeting;

import java.util.ArrayList;
import java.util.List;

public class FakeApiService implements ApiService{

    private List<Meeting> meetingList = new ArrayList<>();

    @Override
    public List<Meeting> getMeetingList() {
        return meetingList;
    }

    @Override
    public void addMeetingList(Meeting meeting) {
        meetingList.add(meeting);
    }

    @Override
    public void deleteMeeting(Meeting meeting) {
        meetingList.remove(meeting);
    }
}
