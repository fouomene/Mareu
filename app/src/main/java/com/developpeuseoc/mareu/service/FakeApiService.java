package com.developpeuseoc.mareu.service;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.developpeuseoc.mareu.model.Meeting;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FakeApiService implements ApiService{

    private List<Meeting> meetingList = FakeApiServiceGenerator.generateMeetings();
    private List<Meeting> filterMeetingList = new ArrayList<>();

    @Override
    public List<Meeting> getMeetingList() {
        return meetingList;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public List<Meeting> filterPlaceMeetingList(String place) {
        filterMeetingList = meetingList.stream()
                .filter( e -> e.getMeetingPlace().contains(place))
                .collect(Collectors.toList());
        return filterMeetingList;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public List<Meeting> filterTimeMeetingList(int hour, int minute) {
        filterMeetingList = meetingList.stream()
                .filter( e -> e.getHour() == hour)
                .filter( e -> e.getMinute() == minute)
                .collect(Collectors.toList());
        return filterMeetingList;
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
