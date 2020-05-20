package com.developpeuseoc.mareu;

import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import com.developpeuseoc.mareu.ui_meeting_list.ListMeetingActivity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.doubleClick;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static com.developpeuseoc.mareu.utils.RecyclerViewItemCountAssertion.withItemCount;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

@RunWith(AndroidJUnit4.class)
public class AddMeetingTest {

    private int ITEMS_COUNT = 6;
    private ListMeetingActivity mActivity;

    @Rule
    public ActivityTestRule<ListMeetingActivity> mActivityRule =
            new ActivityTestRule(ListMeetingActivity.class);

    @Before
    public void setUp() {
        mActivity = mActivityRule.getActivity();
        assertThat(mActivity, notNullValue());
    }

    /**
     * Adding a new Meeting
     */
    @Test
    public void myMeetingList_addNewMeeting(){
        onView(withId(R.id.addMeetingButton)).perform(click());
        onView(withId(R.id.nameMeetingEditText)).perform(replaceText("Réunion Z"));
        onView(withId(R.id.autoCompleteTextView)).perform(replaceText("Yoshi"));

        onView(withId(R.id.timeEditText)).perform(doubleClick());
        onView(withId(android.R.id.button1)).perform(click());

        onView(withId(R.id.topicEditText)).perform(scrollTo(),replaceText("Applications"));
        onView(withId(R.id.email_nacho_text_view)).perform(scrollTo(),replaceText("alexandre@lamzone.com\n  marie@lamzone.com\n laurine@lamzone.com\n"));

        onView(withId(R.id.addNewMeetingButton)).perform(scrollTo(),click());

        onView(withId(R.id.meetingListRecyclerView)).check(withItemCount(ITEMS_COUNT + 1));
    }
}
