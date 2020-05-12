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

    private ActivityAddMeetingBinding binding;
    private ApiService mApiService;
    private int timeHour;
    private int timeMinute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityAddMeetingBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        mApiService = DI.getNewInstanceApiService();


        //Place: AutoCompleteTextView
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, FakeApiServiceGenerator.DUMMY_PLACES);
        binding.autoCompleteTextView.setAdapter(adapter);

        //Email
        binding.emailNachoTextView.addChipTerminator('\n', ChipTerminatorHandler.BEHAVIOR_CHIPIFY_ALL);

        //Time
        binding.timeEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Calendar mcurrentTime = Calendar.getInstance();
                int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                int minute = mcurrentTime.get(Calendar.MINUTE);
                TimePickerDialog mTimePicker;
                mTimePicker = new TimePickerDialog(AddMeetingActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        binding.timeEditText.setText(selectedHour + ":" + selectedMinute);
                        timeHour = selectedHour;
                        timeMinute = selectedMinute;
                    }
                }, hour, minute, true);//Yes 24 hour time
                mTimePicker.setTitle("Select Time");
                mTimePicker.show();
            }
        });

        //Button to add new meeting in the list
        binding.addNewMeetingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = mApiService.getMeetingList().size() + 1;
                String meetingName = binding.nameMeetingEditText.getText().toString();
                String meetingPlace = binding.autoCompleteTextView.getText().toString();
                String meetingTopic = binding.topicEditText.getText().toString();
                String emails = chipsToString();

                Meeting newMeeting = new Meeting(id, meetingName,timeHour, timeMinute, meetingPlace, meetingTopic, emails);
                mApiService.addMeetingList(newMeeting);

                finish();
            }
        });
    }

    public String chipsToString() {
        String text = "";
        for (Chip chip : binding.emailNachoTextView.getAllChips()) {
            text = text + ", " + chip.getText().toString();
        }
        return text;
    }
}