package com.developpeuseoc.mareu.ui_meeting_list;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.developpeuseoc.mareu.DI.DI;
import com.developpeuseoc.mareu.R;
import com.developpeuseoc.mareu.databinding.ActivityListMeetingBinding;
import com.developpeuseoc.mareu.events.DeleteMeetingEvent;
import com.developpeuseoc.mareu.model.Meeting;
import com.developpeuseoc.mareu.service.ApiService;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;


public class ListMeetingActivity extends AppCompatActivity implements PlaceDialog.NoticeDialogListener, TimeDialog.NoticeDialogListener {

    private ActivityListMeetingBinding binding;
    private List<Meeting> mMeetings;
    private ApiService mApiService;
    private RecyclerView rv;
    private MyMeetingRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityListMeetingBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        mApiService = DI.getNewInstanceApiService();

        rv = binding.meetingListRecyclerView;

        mMeetings = mApiService.getMeetingList();
        adapter = new MyMeetingRecyclerViewAdapter(getApplicationContext(), mMeetings);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(adapter);

        binding.addMeetingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AddMeetingActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.placeFilterSubItem:
                openPlaceDialog();
                return true;

            case R.id.timeFilterSubItem:
                openTimeDialog();
                return true;

            case R.id.listSubItem:
                initList();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void openPlaceDialog() {
        PlaceDialog placeDialog = new PlaceDialog();
        placeDialog.show(getSupportFragmentManager(), "place dialog");
    }

    private void openTimeDialog() {
        TimeDialog timeDialog = new TimeDialog();
        timeDialog.show(getSupportFragmentManager(), "time dialog");
    }

    @Override
    public void onPlaceDialogPositiveClick(List<Meeting> meetingsFilterList) {
        adapter.setListMeetings(meetingsFilterList);
    }

    @Override
    public void onTimeDialogPositiveClick(List<Meeting> meetingsFilterList) {
        adapter.setListMeetings(meetingsFilterList);
    }

    /**
     * Init the List of meetings
     */
    private void initList() {
        mMeetings = mApiService.getMeetingList();
        adapter.setListMeetings(mMeetings);
    }

    @Override
    public void onResume() {
        super.onResume();
        initList();
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    /**
     * Fired if the user clicks on a delete button
     * @param event
     */
    @Subscribe
    public void onDeleteMeeting(DeleteMeetingEvent event) {
        mApiService.deleteMeeting(event.meeting);
        initList();
    }
}
