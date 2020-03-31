package com.developpeuseoc.mareu.ui_meeting_list;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import com.developpeuseoc.mareu.R;
import com.developpeuseoc.mareu.service.FakeApiServiceGenerator;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AddMeetingActivity extends AppCompatActivity {

    @BindView(R.id.placeAutoCompleteTextView)
    AutoCompleteTextView placeAutoCompleteTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_meeting);
        ButterKnife.bind(this);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, FakeApiServiceGenerator.DUMMY_PLACES);
        placeAutoCompleteTextView.setAdapter(adapter);
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
