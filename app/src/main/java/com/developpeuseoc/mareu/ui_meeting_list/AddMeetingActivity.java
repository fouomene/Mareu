package com.developpeuseoc.mareu.ui_meeting_list;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TimePicker;
import android.widget.Toast;

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

        binding.addNewMeetingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(binding.nameMeetingEditText.getText().toString().length() == 00 || binding.autoCompleteTextView.getText().toString().length() == 0 || binding.timeEditText.getText().toString().length() == 0 || binding.topicEditText.getText().toString().length() == 0 || binding.emailNachoTextView.getText().toString().length() == 00){

                    Toast.makeText(getApplicationContext(), "Il faut remplir tout les champs", Toast.LENGTH_SHORT).show();

                } else {
                    Meeting newMeeting = new Meeting(
                            mApiService.getMeetingList().size() + 1,
                            binding.nameMeetingEditText.getText().toString(),
                            timeHour,
                            timeMinute,
                            binding.autoCompleteTextView.getText().toString(),
                            binding.topicEditText.getText().toString(),
                            chipsToString());

                    mApiService.addMeetingList(newMeeting);
                    finish();
                }
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