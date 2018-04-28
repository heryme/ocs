package com.om.swachatha.corporation.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.om.swachatha.corporation.R;
import com.om.swachatha.corporation.adpater.WardCurrentComplaintAdapter;
import com.om.swachatha.corporation.parser.TrackCurrentComplaintParser;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Rahul Padaliya on 9/13/2016.
 */
public class ZonalSupervisorHomeFragment extends Fragment {

    private static final String TAG = ZonalSupervisorHomeFragment.class.getSimpleName();
    private RecyclerView rvZonalSuperHome;
    private WardCurrentComplaintAdapter wardCurrentComplaintAdapter;
    private List<TrackCurrentComplaintParser> zonalCurrentComplaintList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_zonal_supervisor_home, null);
        setUpView (view);
        setAdapter();

        return view ;
    }

    /**
     * Set Up View
     */
    private void setUpView(View view) {
        rvZonalSuperHome = (RecyclerView) view.findViewById(R.id.rvZonalSuperHome);
    }

    /**
     * Set Adapter
     */
    private void setAdapter() {
        //Set Complaint Adapter
        zonalCurrentComplaintList = new ArrayList<>();
        TrackCurrentComplaintParser trackCurrentComplaintParser = new TrackCurrentComplaintParser();
        trackCurrentComplaintParser.setNo("#5949985");
        trackCurrentComplaintParser.setTitle("Test");
        trackCurrentComplaintParser.setDate("14-03-2018");
        zonalCurrentComplaintList.add(trackCurrentComplaintParser);


        wardCurrentComplaintAdapter = new WardCurrentComplaintAdapter(zonalCurrentComplaintList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        rvZonalSuperHome.setLayoutManager(mLayoutManager);
        rvZonalSuperHome.setItemAnimator(new DefaultItemAnimator());
        rvZonalSuperHome.setAdapter(wardCurrentComplaintAdapter);

    }
}
