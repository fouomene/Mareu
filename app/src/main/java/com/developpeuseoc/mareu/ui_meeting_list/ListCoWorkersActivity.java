package com.developpeuseoc.mareu.ui_meeting_list;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.developpeuseoc.mareu.DI.DI;
import com.developpeuseoc.mareu.R;
import com.developpeuseoc.mareu.model.CoWorker;
import com.developpeuseoc.mareu.service.ApiService;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListCoWorkersActivity extends AppCompatActivity {

    ApiService mApiService;

    @BindView(R.id.list_coworkers)
    RecyclerView rv;

    @BindView(R.id.sendListCoWorkersButton)
    FloatingActionButton sendListCoWorkersButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_co_workers);
        ButterKnife.bind(this);
        mApiService = DI.getNeighbourApiService();

        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new MyCoWorkerRecyclerViewAdapter(this, mApiService.getCoWorkers()));

        sendListCoWorkersButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AddMeetingActivity.class);
                intent.putExtra("coworkers", "coworkers");
                startActivity(intent);
            }
        });
    }
}
