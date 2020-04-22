package com.developpeuseoc.mareu.ui_meeting_list;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.developpeuseoc.mareu.DI.DI;
import com.developpeuseoc.mareu.databinding.ActivityListMeetingBinding;
import com.developpeuseoc.mareu.model.Meeting;
import com.developpeuseoc.mareu.service.ApiService;


public class ListMeetingActivity extends AppCompatActivity {

    ActivityListMeetingBinding binding;
    ApiService mApiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityListMeetingBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        mApiService = DI.getNewInstanceApiService();
        mApiService.addMeetingList(new Meeting(1, "Réunion B", 12, 30, "Saturne", "I do'nt know", "Emails"));

        RecyclerView rv = binding.meetingListRecyclerView;
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new MyMeetingRecyclerViewAdapter(mApiService.getMeetingList()));

        binding.addMeetingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AddMeetingActivity.class);
                startActivity(intent);
            }
        });

    }


}
