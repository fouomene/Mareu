package com.developpeuseoc.mareu.service;


import com.developpeuseoc.mareu.model.Meeting;
import java.util.ArrayList;
import java.util.List;

public class FakeApiService implements ApiService{

    private List<Meeting> meetingList = FakeApiServiceGenerator.generateMeetings();
    private List<Meeting> filterMeetingList = new ArrayList<>();

    @Override
    public List<Meeting> getMeetingList() {
        return meetingList;
    }

    @Override
    public List<Meeting> getFilterMeetingList() {
        return filterMeetingList;
    }

    @Override
    public List<Meeting> filterPlaceMeetingList(String place) {
        for(Meeting meeting: meetingList){
            if(meeting.getMeetingPlace().equals(place)){
                filterMeetingList.add(meeting);
            }
        }
        return filterMeetingList;
    }


    @Override
    public List<Meeting> filterTimeMeetingList(int hour, int minute) {
        for(Meeting meeting: meetingList){
            if(meeting.getHour() == hour && meeting.getMinute() == minute){
                filterMeetingList.add(meeting);
            }
        }
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
