package com.developpeuseoc.mareu;

import android.widget.TimePicker;

import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.contrib.PickerActions;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import com.developpeuseoc.mareu.DI.DI;
import com.developpeuseoc.mareu.service.ApiService;
import com.developpeuseoc.mareu.ui_meeting_list.ListMeetingActivity;
import com.developpeuseoc.mareu.utils.DeleteViewAction;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.doubleClick;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.hasMinimumChildCount;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static com.developpeuseoc.mareu.utils.RecyclerViewItemCountAssertion.withItemCount;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class MeetingListInstrumentedTest {

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
     * We ensure that our recyclerview is displaying at least on item
     */
    @Test
    public void myMeetingList_shouldNotBeEmpty() {
        onView(withId(R.id.meetingListRecyclerView))
                .check(matches(hasMinimumChildCount(1)));
    }

    /**
     * When we delete an item, the item is no more shown
     */
    @Test
    public void myMeetingsList_deleteAction_shouldRemoveItem() {
        onView(withId(R.id.meetingListRecyclerView)).check(withItemCount(ITEMS_COUNT));

        onView(withId(R.id.meetingListRecyclerView))
                .perform(RecyclerViewActions.actionOnItemAtPosition(1, new DeleteViewAction()));

        onView(withId(R.id.meetingListRecyclerView)).check(withItemCount(ITEMS_COUNT - 1));
    }


    /**
     * Run AddMeetingActivity
     */
    @Test
    public void addMeetingActivity_hasToBeRunWhenYouClickOnTheButton() {
        onView(withId(R.id.addMeetingButton)).perform(click());
        onView(withId(R.id.addMeetinActivity_parentLayout));
    }


    /**
     * Filter meeting place
     */
    @Test
    public void myMeetingList_filterPlace(){
        onView(withId(R.id.filterItem)).perform(click());
        onView(withText("Sélectionner une salle :")).perform(click());
        onView(withId(R.id.dialog_place_AutoCompleteTextView)).perform(replaceText("Luigi"));
        onView(withText("OK")).perform(doubleClick());
        onView(withId(R.id.meetingListRecyclerView)).check(withItemCount(1));
    }

    /**
     * Filter meeting time
     */
    @Test
    public void myMeetingList_filterTime(){
        int hour = 11;
        int minutes = 30;
        onView(withId(R.id.filterItem)).perform(click());
        onView(withText("Sélectionner une heure :")).perform(click());
        onView(withClassName(Matchers.equalTo(TimePicker.class.getName()))).perform(PickerActions.setTime(hour, minutes));
        onView(withId(android.R.id.button1)).perform(click());
        onView(withId(R.id.meetingListRecyclerView)).check(withItemCount(1));
    }

    /**
     * Display the list
     */
    @Test
    public void myMeetingList_displayMeetingsList(){
        onView(withId(R.id.filterItem)).perform(click());
        onView(withText("Afficher la liste")).perform(click());
        onView(withId(R.id.meetingListRecyclerView)).check(withItemCount(ITEMS_COUNT));
    }


}
