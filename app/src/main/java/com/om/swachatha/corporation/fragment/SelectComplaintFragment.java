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
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import com.om.swachatha.corporation.R;
import com.om.swachatha.corporation.activity.MainActivity;
import com.om.swachatha.corporation.adpater.SelectComplaintAdapter;
import com.om.swachatha.corporation.adpater.TrackCurrentComplaintAdapter;
import com.om.swachatha.corporation.parser.SelectComplaintParser;
import com.om.swachatha.corporation.parser.TrackCurrentComplaintParser;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Rahul Padaliya on 9/13/2016.
 */
public class SelectComplaintFragment extends Fragment implements View.OnClickListener {

    private static final String TAG = SelectComplaintFragment.class.getSimpleName();
    private RecyclerView rvSelectComp;
    private Button btnSelectCompSubmit;
    private List<SelectComplaintParser> selectComplaintList;
    private SelectComplaintAdapter selectComplaintAdapter;
    private RadioButton rdSelectComFrgOthers;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        // View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_profile, null);
        View view = inflater.inflate(R.layout.fragment_select_complaint, container, false);
        setUpView(view);
        registerClickEvent();
        setAdapter();
        return view;
    }

    /**
     * `     * Set Up View
     */
    private void setUpView(View view) {
        btnSelectCompSubmit = (Button) view.findViewById(R.id.btnSelectCompSubmit);
        rvSelectComp = (RecyclerView) view.findViewById(R.id.rvSelectComp);
        rdSelectComFrgOthers = (RadioButton) view.findViewById(R.id.rdSelectComFrgOthers);
    }

    /**
     * Set Adapter
     */
    private void setAdapter() {
        //Set Complaint Adapter
        selectComplaintList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            SelectComplaintParser selectComplaintParser = new SelectComplaintParser();
            selectComplaintParser.setEngLang("Testing In Eng");
            selectComplaintParser.setHindiLang("Testing In Hindi");
            selectComplaintParser.setGujLang("Testing In Gujarati");
            selectComplaintList.add(selectComplaintParser);
        }


        selectComplaintAdapter = new SelectComplaintAdapter(selectComplaintList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        rvSelectComp.setLayoutManager(mLayoutManager);
        rvSelectComp.setItemAnimator(new DefaultItemAnimator());
        rvSelectComp.setAdapter(selectComplaintAdapter);

    }

    private void registerClickEvent() {
        btnSelectCompSubmit.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.btnSelectCompSubmit:
                ((MainActivity) getActivity()).loadFragment(new HomeFragment(), false, "");
                break;
        }

    }

}
