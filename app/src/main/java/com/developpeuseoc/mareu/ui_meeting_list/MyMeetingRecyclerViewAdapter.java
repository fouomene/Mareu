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
import com.developpeuseoc.mareu.events.DeleteMeetingEvent;
import com.developpeuseoc.mareu.model.Meeting;
import com.developpeuseoc.mareu.service.FakeApiServiceGenerator;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

public class MyMeetingRecyclerViewAdapter extends RecyclerView.Adapter<MyMeetingRecyclerViewAdapter.ViewHolder> {

    private List<Meeting> mMeetings;
    private Context context;

    public MyMeetingRecyclerViewAdapter(Context context, List<Meeting> items) {
        this.context = context;
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
        holder.deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().post(new DeleteMeetingEvent(meeting));
            }
        });

    }

    @Override
    public int getItemCount() {
        return mMeetings.size();
    }

    /**
    * Lorsque les données changent, cette méthode met à jour la liste des réunions  et informe
    * l'adaptateur d'utiliser les nouvelles valeurs qu'il contient.
     */
    public void setListMeetings(List<Meeting> listMeetings) {
        this.mMeetings = listMeetings;
        notifyDataSetChanged();
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