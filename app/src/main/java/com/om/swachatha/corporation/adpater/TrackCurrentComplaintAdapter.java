package com.om.swachatha.corporation.adpater;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.om.swachatha.corporation.R;
import com.om.swachatha.corporation.parser.TrackCurrentComplaintParser;

import java.util.List;

/**
 * Created by Rid's Patel on 14-03-2018.
 */

public class TrackCurrentComplaintAdapter extends RecyclerView.Adapter<TrackCurrentComplaintAdapter.MyViewHolder> {

    private List<TrackCurrentComplaintParser> trackCurrentComplaintList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tvRowTrackCurrentCompNo, tvRowTrackCurrentCompDate, tvRowTrackCurrentCompTitle;

        public MyViewHolder(View view) {
            super(view);
            tvRowTrackCurrentCompNo = (TextView) view.findViewById(R.id.tvRowTrackCurrentCompNo);
            tvRowTrackCurrentCompDate = (TextView) view.findViewById(R.id.tvRowTrackCurrentCompDate);
            tvRowTrackCurrentCompTitle = (TextView) view.findViewById(R.id.tvRowTrackCurrentCompTitle);
        }
    }


    public TrackCurrentComplaintAdapter(List<TrackCurrentComplaintParser> trackCurrentComplaintList) {
        this.trackCurrentComplaintList = trackCurrentComplaintList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_track_current_complaint, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        TrackCurrentComplaintParser trackCurrentComplaintParser = trackCurrentComplaintList.get(position);
        holder.tvRowTrackCurrentCompNo.setText(trackCurrentComplaintParser.getNo());
        holder.tvRowTrackCurrentCompDate.setText(trackCurrentComplaintParser.getDate());
        holder.tvRowTrackCurrentCompTitle.setText(trackCurrentComplaintParser.getTitle());
    }

    @Override
    public int getItemCount() {
        return trackCurrentComplaintList.size();
    }

}
