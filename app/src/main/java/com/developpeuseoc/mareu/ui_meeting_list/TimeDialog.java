package com.developpeuseoc.mareu.ui_meeting_list;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.TimePicker;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.developpeuseoc.mareu.DI.DI;
import com.developpeuseoc.mareu.R;
import com.developpeuseoc.mareu.model.Meeting;
import com.developpeuseoc.mareu.service.ApiService;

import java.util.List;

public class TimeDialog extends AppCompatDialogFragment {

    private List<Meeting> mFilterMeetings;
    private ApiService mApiService;
    private NoticeDialogListener listener;
    private TimePicker picker;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.layout_time_dialog, null);

        mApiService = DI.getNewInstanceApiService();


        builder.setView(view)
                .setTitle("Salle :")
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @RequiresApi(api = Build.VERSION_CODES.M)
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        int hour = picker.getHour();
                        int minute = picker.getMinute();
                        mFilterMeetings = mApiService.filterTimeMeetingList(hour, minute);
                        listener.onTimeDialogPositiveClick(mFilterMeetings);
                    }
                });

        picker = view.findViewById(R.id.dialog_timePicker);

        return builder.create();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            listener = (NoticeDialogListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() +
                    "must implement ExampleDialogListener");
        }
    }

    public interface NoticeDialogListener {
        public void onTimeDialogPositiveClick(List<Meeting> meetingsFilterList);
    }

}
