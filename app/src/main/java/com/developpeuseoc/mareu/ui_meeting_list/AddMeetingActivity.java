package com.developpeuseoc.mareu.ui_meeting_list;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TimePicker;

import com.developpeuseoc.mareu.DI.DI;
import com.developpeuseoc.mareu.databinding.ActivityAddMeetingBinding;
import com.developpeuseoc.mareu.model.Meeting;
import com.developpeuseoc.mareu.service.ApiService;
import com.developpeuseoc.mareu.service.FakeApiServiceGenerator;
import com.hootsuite.nachos.chip.Chip;
import com.hootsuite.nachos.terminator.ChipTerminatorHandler;

import java.util.Calendar;
import java.util.List;


public class AddMeetingActivity extends AppCompatActivity {

    ActivityAddMeetingBinding binding;
    ApiService mApiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityAddMeetingBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        mApiService = DI.getNewInstanceApiService();

        binding.addNewMeetingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  Meeting meeting = new Meeting(3, "Réunion H", 12, 30, "Saturne", "I do'nt know", "Emails");
                  mApiService.addMeetingList(meeting);
                  finish();
            }
        });
    }

}
