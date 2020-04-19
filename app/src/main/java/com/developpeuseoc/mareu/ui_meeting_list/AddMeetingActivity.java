package com.developpeuseoc.mareu.ui_meeting_list;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.app.Activity;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TimePicker;

import com.developpeuseoc.mareu.R;
import com.developpeuseoc.mareu.service.FakeApiService;
import com.developpeuseoc.mareu.service.FakeApiServiceGenerator;
import com.google.android.material.textfield.TextInputEditText;
import com.hootsuite.nachos.NachoTextView;
import com.hootsuite.nachos.terminator.ChipTerminatorHandler;

import java.util.Calendar;

import static java.security.AccessController.getContext;

public class AddMeetingActivity extends AppCompatActivity {

    TextInputEditText nameMeetingEditText;
    AutoCompleteTextView autoCompleteTextView;
    TextInputEditText timeEditText;
    TextInputEditText topicEditText;
    NachoTextView emailNachoTextView;
    Button addNewMeetingButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_meeting);

        //FindViewByID
        nameMeetingEditText = findViewById(R.id.nameMeetingEditText);
        autoCompleteTextView = findViewById(R.id.autoCompleteTextView);
        timeEditText = findViewById(R.id.timeEditText);
        topicEditText = findViewById(R.id.topicEditText);
        emailNachoTextView = findViewById(R.id.email_nacho_text_view);
        addNewMeetingButton = findViewById(R.id.addNewMeetingButton);

        //New meeting

        //AutoCompleteTextView
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, FakeApiServiceGenerator.DUMMY_PLACES);
        autoCompleteTextView.setAdapter(adapter);

        //Email
        emailNachoTextView.addChipTerminator('\n', ChipTerminatorHandler.BEHAVIOR_CHIPIFY_ALL);

        //Time
        timeEditText.setOnClickListener(new View.OnClickListener() {
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
                        timeEditText.setText( selectedHour + ":" + selectedMinute);
                    }
                }, hour, minute, true);//Yes 24 hour time
                mTimePicker.setTitle("Select Time");
                mTimePicker.show();

            }
        });
    }

    /**
     * Used to navigate to this activity
     * @param activity
     */
    public static void navigate(Activity activity) {
        Intent intent = new Intent(activity, AddMeetingActivity.class);
        ActivityCompat.startActivity(activity, intent, null);
    }
}
