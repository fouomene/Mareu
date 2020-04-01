package com.developpeuseoc.mareu.ui_meeting_list;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.developpeuseoc.mareu.R;
import com.developpeuseoc.mareu.model.CoWorker;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyCoWorkerRecyclerViewAdapter extends RecyclerView.Adapter<MyCoWorkerRecyclerViewAdapter.ViewHolder>{

    private final List<CoWorker> mCoWorkers;
    private Context mContext;

    public MyCoWorkerRecyclerViewAdapter(Context context, List<CoWorker> items) {
        mContext = context;
        mCoWorkers = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_coworkers, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        CoWorker coWorker = mCoWorkers.get(position);
        holder.mCoWorkerName.setText(coWorker.getName());
        holder.mCoWorkerEmail.setText(coWorker.getEmail());
        Glide.with(holder.mCoWorkerAvatar.getContext())
                .load(coWorker.getAvatarUrl())
                .apply(RequestOptions.circleCropTransform())
                .into(holder.mCoWorkerAvatar);

    }

    @Override
    public int getItemCount() {
        return mCoWorkers.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.item_list_avatar)
        public ImageView mCoWorkerAvatar;
        @BindView(R.id.item_list_name)
        public TextView mCoWorkerName;
        @BindView(R.id.item_list_email)
        public TextView mCoWorkerEmail;
        @BindView(R.id.checkBox)
        public CheckBox checkBox;
        @BindView(R.id.parentLayout_fragment_coworkers)
        public RelativeLayout parentLayout;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
