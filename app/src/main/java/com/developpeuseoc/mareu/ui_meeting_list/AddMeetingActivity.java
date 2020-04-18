package com.developpeuseoc.mareu.ui_meeting_list;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.developpeuseoc.mareu.DI.DI;
import com.developpeuseoc.mareu.R;
import com.developpeuseoc.mareu.model.CoWorker;
import com.developpeuseoc.mareu.service.ApiService;
import com.developpeuseoc.mareu.service.FakeApiServiceGenerator;
import com.hootsuite.nachos.NachoTextView;
import com.hootsuite.nachos.terminator.ChipTerminatorHandler;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AddMeetingActivity extends AppCompatActivity {

    @BindView(R.id.nameMeetingEditText)
    EditText nameMeetingEditText;

    @BindView(R.id.placeAutoCompleteTextView)
    AutoCompleteTextView placeAutoCompleteTextView;

    @BindView(R.id.timeEditText)
    EditText timeEditText;

    @BindView(R.id.topicEditText)
    EditText topicEditText;

    @BindView(R.id.email_nacho_text_view)
    NachoTextView emailNachoTextView;

    List<CoWorker> coWorkerList_add = new ArrayList<>();

    private Context mContext;
    ApiService mApiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_meeting);
        ButterKnife.bind(this);
        mApiService = DI.getCoWorkersApiService();

        String nameMeeting = nameMeetingEditText.getText().toString();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, FakeApiServiceGenerator.DUMMY_PLACES);
        placeAutoCompleteTextView.setAdapter(adapter);

        String placeMeeting = placeAutoCompleteTextView.getText().toString();
        String timeMeeting = timeEditText.getText().toString();
        String topicMeeting = topicEditText.getText().toString();

        emailNachoTextView.addChipTerminator('\n', ChipTerminatorHandler.BEHAVIOR_CHIPIFY_ALL);
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
