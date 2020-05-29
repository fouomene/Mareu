package com.developpeuseoc.mareu;

import com.developpeuseoc.mareu.DI.DI;
import com.developpeuseoc.mareu.model.Meeting;
import com.developpeuseoc.mareu.service.ApiService;
import com.developpeuseoc.mareu.service.FakeApiServiceGenerator;

import org.hamcrest.collection.IsIterableContainingInAnyOrder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Unit test on Meeting service
 */
@RunWith(JUnit4.class)
public class MeetingServiceTest {

    private ApiService service;

    @Before
    public void setup() {
        service = DI.getNewInstanceApiService();
    }

    /**
     * Get the meeting list
     */
    @Test
    public void getMeetingListWithSuccess() {
        List<Meeting> meetings = service.getMeetingList();
        assertFalse(meetings.isEmpty());
    }


    /**
     * Filter with place
     */
    @Test
    public void filterPlaceMeetingListWithSuccess() {
        String place = FakeApiServiceGenerator.DUMMY_PLACES.get(0);

        List<Meeting> meetings = service.getMeetingList().stream()
                .filter( e -> e.getMeetingPlace().contains(place))
                .collect(Collectors.toList());

        List<Meeting> expectedMeetings = service.filterPlaceMeetingList(place);

        assertThat(meetings, IsIterableContainingInAnyOrder.containsInAnyOrder(expectedMeetings.toArray()));
    }


    /**
     * Filter with time
     */
    @Test
    public void filterTimeMeetingListWithSuccess() {
        int hour = 10;
        int minute = 00;

        List<Meeting> meetings = service.getMeetingList().stream()
                .filter( e -> e.getHour() == hour)
                .filter( e -> e.getMinute() == minute)
                .collect(Collectors.toList());

        List<Meeting> expectedMeetings = service.filterTimeMeetingList(hour, minute);

        assertThat(meetings, IsIterableContainingInAnyOrder.containsInAnyOrder(expectedMeetings.toArray()));
    }

    /**
     * Add a new meeting
     */
    @Test
    public void addMeetingListWithSuccess() {
        int id = service.getMeetingList().size() + 1;
        Meeting meetingToAdd = new Meeting(id, "Réunion AA", 18, 00, "Cappy", "add meeting", "alexandre@lamzone.com, francis@lamzone.com, helena@lamzone.com");
        service.addMeetingList(meetingToAdd);
        assertTrue(service.getMeetingList().contains(meetingToAdd));

    }


    /**
     * Delete a meeting
     */
    @Test
    public void deleteMeetingWithSuccess() {
        Meeting meetingToDelete = service.getMeetingList().get(0);
        service.deleteMeeting(meetingToDelete);
        assertFalse(service.getMeetingList().contains(meetingToDelete));
    }

}