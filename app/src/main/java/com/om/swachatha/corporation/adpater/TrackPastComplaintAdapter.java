package com.om.swachatha.corporation.adpater;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
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

public class TrackPastComplaintAdapter extends RecyclerView.Adapter<TrackPastComplaintAdapter.MyViewHolder> {

    private List<TrackCurrentComplaintParser> trackCurrentComplaintList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tvRowTrackPastCompNo, tvRowTrackPastCompDate, tvRowTrackPastCompTitle;

        public MyViewHolder(View view) {
            super(view);
            tvRowTrackPastCompNo = (TextView) view.findViewById(R.id.tvRowTrackPastCompNo);
            tvRowTrackPastCompDate = (TextView) view.findViewById(R.id.tvRowTrackPastCompDate);
            tvRowTrackPastCompTitle = (TextView) view.findViewById(R.id.tvRowTrackPastCompTitle);
        }
    }

    private ClickInterface clickInterface;

    public TrackPastComplaintAdapter(List<TrackCurrentComplaintParser> trackCurrentComplaintList,ClickInterface clickInterface) {
        this.trackCurrentComplaintList = trackCurrentComplaintList;
        this.clickInterface = clickInterface;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_track_past_complaint, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        TrackCurrentComplaintParser trackCurrentComplaintParser = trackCurrentComplaintList.get(position);
        holder.tvRowTrackPastCompNo.setText(trackCurrentComplaintParser.getNo());
        holder.tvRowTrackPastCompDate.setText(trackCurrentComplaintParser.getDate());
        holder.tvRowTrackPastCompTitle.setText(trackCurrentComplaintParser.getTitle());

        holder.tvRowTrackPastCompNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("clickEvent","ffgfgfg");
                clickInterface.onClickCallBack(position,holder.tvRowTrackPastCompNo.getText().toString());
            }
        });
    }

    @Override
    public int getItemCount() {
        return trackCurrentComplaintList.size();
    }

}
