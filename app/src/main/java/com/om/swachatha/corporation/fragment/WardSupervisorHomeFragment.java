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
import com.om.swachatha.corporation.adpater.TrackCurrentComplaintAdapter;
import com.om.swachatha.corporation.adpater.TrackPastComplaintAdapter;
import com.om.swachatha.corporation.adpater.WardCurrentComplaintAdapter;
import com.om.swachatha.corporation.parser.TrackCurrentComplaintParser;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Rahul Padaliya on 9/13/2016.
 */
public class WardSupervisorHomeFragment extends Fragment {

    private static final String TAG = WardSupervisorHomeFragment.class.getSimpleName();
    private RecyclerView rvWardSuperHome;
    private WardCurrentComplaintAdapter wardCurrentComplaintAdapter;
    private List<TrackCurrentComplaintParser> wardCurrentComplaintList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_ward_supervisor_home, null);
        setUpView (view);
        setAdapter();

        return view ;
    }

    /**
     * Set Up View
     */
    private void setUpView(View view) {
        rvWardSuperHome = (RecyclerView) view.findViewById(R.id.rvWardSuperHome);
    }

    /**
     * Set Adapter
     */
    private void setAdapter() {
        //Set Complaint Adapter
        wardCurrentComplaintList = new ArrayList<>();
        TrackCurrentComplaintParser trackCurrentComplaintParser = new TrackCurrentComplaintParser();
        trackCurrentComplaintParser.setNo("#5949985");
        trackCurrentComplaintParser.setTitle("Test");
        trackCurrentComplaintParser.setDate("14-03-2018");
        wardCurrentComplaintList.add(trackCurrentComplaintParser);


        wardCurrentComplaintAdapter = new WardCurrentComplaintAdapter(wardCurrentComplaintList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        rvWardSuperHome.setLayoutManager(mLayoutManager);
        rvWardSuperHome.setItemAnimator(new DefaultItemAnimator());
        rvWardSuperHome.setAdapter(wardCurrentComplaintAdapter);

    }
}
