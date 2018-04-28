package com.om.swachatha.corporation.adpater;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.om.swachatha.corporation.R;
import com.om.swachatha.corporation.parser.SelectComplaintParser;
import com.om.swachatha.corporation.parser.TrackCurrentComplaintParser;

import java.util.List;

/**
 * Created by Rid's Patel on 14-03-2018.
 */

public class SelectComplaintAdapter extends RecyclerView.Adapter<SelectComplaintAdapter.MyViewHolder> {

    private List<SelectComplaintParser> selectComplaintList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tvRowSelectCompEng, tvRowSelectCompGuj, tvRowSelectCompHind;

        public MyViewHolder(View view) {
            super(view);
            tvRowSelectCompEng = (TextView) view.findViewById(R.id.tvRowSelectCompEng);
            tvRowSelectCompGuj = (TextView) view.findViewById(R.id.tvRowSelectCompGuj);
            tvRowSelectCompHind = (TextView) view.findViewById(R.id.tvRowSelectCompHind);
        }
    }


    public SelectComplaintAdapter(List<SelectComplaintParser> selectComplaintList) {
        this.selectComplaintList = selectComplaintList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_select_complaint, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        SelectComplaintParser selectComplaintParser = selectComplaintList.get(position);
        holder.tvRowSelectCompEng.setText(selectComplaintParser.getEngLang());
        holder.tvRowSelectCompGuj.setText(selectComplaintParser.getGujLang());
        holder.tvRowSelectCompHind.setText(selectComplaintParser.getHindiLang());
    }

    @Override
    public int getItemCount() {
        return selectComplaintList.size();
    }

}
