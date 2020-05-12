package com.developpeuseoc.mareu.ui_meeting_list;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AutoCompleteTextView;

import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.fragment.app.DialogFragment;

import com.developpeuseoc.mareu.DI.DI;
import com.developpeuseoc.mareu.R;
import com.developpeuseoc.mareu.model.Meeting;
import com.developpeuseoc.mareu.service.ApiService;

import java.util.List;

public class PlaceDialog extends AppCompatDialogFragment {

    private AutoCompleteTextView dialog_place_AutoCompleteTextView;
    private List<Meeting> mFilterMeetings;
    private ApiService mApiService;
    private NoticeDialogListener listener;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.layout_place_dialog, null);

        mApiService = DI.getNewInstanceApiService();


        builder.setView(view)
                .setTitle("Salle :")
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String place = dialog_place_AutoCompleteTextView.getText().toString();
                        mFilterMeetings = mApiService.filterPlaceMeetingList(place);
                        listener.onPlaceDialogPositiveClick(mFilterMeetings);
                    }
                });

        dialog_place_AutoCompleteTextView = view.findViewById(R.id.dialog_place_AutoCompleteTextView);

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
        public void onPlaceDialogPositiveClick(List<Meeting> meetingsFilterList);
    }

}
