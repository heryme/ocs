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

public class WardCurrentComplaintAdapter extends RecyclerView.Adapter<WardCurrentComplaintAdapter.MyViewHolder> {

    private List<TrackCurrentComplaintParser> trackCurrentComplaintList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tvRowWardCurrentCompNo, tvRowWardCurrentCompDate, tvRowWardCurrentCompTitle;

        public MyViewHolder(View view) {
            super(view);
            tvRowWardCurrentCompNo = (TextView) view.findViewById(R.id.tvRowWardCurrentCompNo);
            tvRowWardCurrentCompDate = (TextView) view.findViewById(R.id.tvRowWardCurrentCompDate);
            tvRowWardCurrentCompTitle = (TextView) view.findViewById(R.id.tvRowWardCurrentCompTitle);
        }
    }


    public WardCurrentComplaintAdapter(List<TrackCurrentComplaintParser> trackCurrentComplaintList) {
        this.trackCurrentComplaintList = trackCurrentComplaintList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_ward_sub_home, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        TrackCurrentComplaintParser trackCurrentComplaintParser = trackCurrentComplaintList.get(position);
        holder.tvRowWardCurrentCompNo.setText(trackCurrentComplaintParser.getNo());
        holder.tvRowWardCurrentCompDate.setText(trackCurrentComplaintParser.getDate());
        holder.tvRowWardCurrentCompTitle.setText(trackCurrentComplaintParser.getTitle());
    }

    @Override
    public int getItemCount() {
        return trackCurrentComplaintList.size();
    }

}
