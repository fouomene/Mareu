package com.developpeuseoc.mareu.ui_meeting_list;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.developpeuseoc.mareu.R;
import com.developpeuseoc.mareu.databinding.FragmentItemMeetingBinding;
import com.developpeuseoc.mareu.model.Meeting;
import com.developpeuseoc.mareu.service.FakeApiServiceGenerator;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

public class MyMeetingRecyclerViewAdapter extends RecyclerView.Adapter<MyMeetingRecyclerViewAdapter.ViewHolder> {

    private final List<Meeting> mMeetings;

    public MyMeetingRecyclerViewAdapter(List<Meeting> items) {
        mMeetings = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        FragmentItemMeetingBinding itemBinding = FragmentItemMeetingBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(itemBinding);
    }

    @Override
    public void onBindViewHolder (ViewHolder holder, int position) {
        Meeting meeting = mMeetings.get(position);

        //detailMeeting
        String hour = meeting.getHour() + ":" + meeting.getMinute();
        String detail = meeting.getMeetingName() + " - " + hour + " - " + meeting.getMeetingPlace();
        holder.detailMeetingTextView.setText(detail);

        //email
        holder.emailTextView.setText(meeting.getCoWorkers());

        //colorImageView
        int positionPlace =  FakeApiServiceGenerator.DUMMY_PLACES.indexOf(meeting.getMeetingPlace());
        GradientDrawable myGrad = (GradientDrawable)holder.colorImageView.getDrawable();
        myGrad.setColor(Color.parseColor(FakeApiServiceGenerator.DUMMY_COLOR.get(positionPlace)));

        //deleteButton
        //TODO

    }

    @Override
    public int getItemCount() {
        return mMeetings.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView colorImageView;
        TextView detailMeetingTextView;
        TextView emailTextView;
        ImageButton deleteButton;

        public ViewHolder(FragmentItemMeetingBinding itemBinding) {
            super(itemBinding.getRoot());
            colorImageView = itemBinding.colorImageView;
            detailMeetingTextView = itemBinding.detailMeetingTextView;
            emailTextView = itemBinding.coWorkerEmailTextView;
            deleteButton = itemBinding.itemListDeleteButton;
        }
    }
}