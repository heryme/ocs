package com.om.swachatha.corporation.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.om.swachatha.corporation.R;
import com.om.swachatha.corporation.adpater.ClickInterface;
import com.om.swachatha.corporation.adpater.TrackCurrentComplaintAdapter;
import com.om.swachatha.corporation.adpater.TrackPastComplaintAdapter;
import com.om.swachatha.corporation.parser.TrackCurrentComplaintParser;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Rahul Padaliya on 9/13/2016.
 */
public class TrackComplaintFragment extends Fragment implements ClickInterface {
    private static final String TAG = TrackComplaintFragment.class.getSimpleName();

    private RecyclerView rvFrgTrackCurrentComplaint;
    private RecyclerView rvFrgTrackPastComplaint;
    private TrackCurrentComplaintAdapter trackCurrentComplaintAdapter;
    private TrackPastComplaintAdapter trackPastComplaintAdapter;
    private List<TrackCurrentComplaintParser> currentComplaintList;
    private List<TrackCurrentComplaintParser> pastComplaintList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_track_complaint, null);
        setUpView(view);
        setAdapter();
        return view ;
    }

    /**
     * Set Up View
     * @param view
     */
    private void setUpView(View view) {
        rvFrgTrackCurrentComplaint = (RecyclerView) view.findViewById(R.id.rvFrgTrackCurrentComplaint);
        rvFrgTrackPastComplaint = (RecyclerView) view.findViewById(R.id.rvFrgTrackPastComplaint);

    }

    /**
     * Set Adapter
     */
    private void setAdapter() {

        //Set Complaint Adapter
        currentComplaintList = new ArrayList<>();
        TrackCurrentComplaintParser trackCurrentComplaintParser = new TrackCurrentComplaintParser();
        trackCurrentComplaintParser.setNo("#5949985");
        trackCurrentComplaintParser.setTitle("Test");
        trackCurrentComplaintParser.setDate("14-03-2018");
        currentComplaintList.add(trackCurrentComplaintParser);


        trackCurrentComplaintAdapter = new TrackCurrentComplaintAdapter(currentComplaintList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        rvFrgTrackCurrentComplaint.setLayoutManager(mLayoutManager);
        rvFrgTrackCurrentComplaint.setItemAnimator(new DefaultItemAnimator());
        rvFrgTrackCurrentComplaint.setAdapter(trackCurrentComplaintAdapter);

        //Set Past Complaint Adapter
        pastComplaintList = new ArrayList<>();
        pastComplaintList.add(trackCurrentComplaintParser);

        trackPastComplaintAdapter = new TrackPastComplaintAdapter(currentComplaintList,this);
        RecyclerView.LayoutManager mLayoutManagerPast = new LinearLayoutManager(getActivity());
        rvFrgTrackPastComplaint.setLayoutManager(mLayoutManagerPast);
        rvFrgTrackPastComplaint.setItemAnimator(new DefaultItemAnimator());
        rvFrgTrackPastComplaint.setAdapter(trackPastComplaintAdapter);



    }

    @Override
    public void onClickCallBack(int position, String txtValue) {
        Log.d("clickEvent","position : "+ position + " values : " + txtValue);
    }
}
