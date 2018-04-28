package com.om.swachatha.corporation.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.om.swachatha.corporation.R;


/**
 * Created by Rahul Padaliya on 9/13/2016.
 */
public class WardSupervisorCompliantDetailFragment extends Fragment {

    private static final String TAG = WardSupervisorCompliantDetailFragment.class.getSimpleName();
    private TextView tvWardSuperCompDetailsFrgCompNumDate;
    private TextView tvWardSuperCompDetailsFrgCompTitleDate;
    private TextView tvWardSuperCompDetailsFrgDate;
    private TextView tvWardSuperCompDetailsFrgName;
    private TextView tvWardSuperCompDetailsFrgWard;
    private TextView tvWardSuperCompDetailsFrgCompSociety;
    private TextView tvWardSuperCompDetailsFrgFlat;
    private TextView tvWardSuperCompDetailsFrgMobileNumber;
    private Button btnWardSuperCompDetailsFrgNext;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_ward_supervisor_compliant_details, null);

        setUpView(view);
        return view ;
    }

    /**
     * Set Up View
     */
    private void setUpView(View view) {
        tvWardSuperCompDetailsFrgCompNumDate = (TextView) view.findViewById(R.id.tvWardSuperCompDetailsFrgCompNumDate);
        tvWardSuperCompDetailsFrgCompTitleDate = (TextView) view.findViewById(R.id.tvWardSuperCompDetailsFrgCompTitleDate);
        tvWardSuperCompDetailsFrgDate = (TextView) view.findViewById(R.id.tvWardSuperCompDetailsFrgDate);
        tvWardSuperCompDetailsFrgName = (TextView) view.findViewById(R.id.tvWardSuperCompDetailsFrgName);
        tvWardSuperCompDetailsFrgWard = (TextView) view.findViewById(R.id.tvWardSuperCompDetailsFrgWard);
        tvWardSuperCompDetailsFrgCompSociety = (TextView) view.findViewById(R.id.tvWardSuperCompDetailsFrgCompSociety);
        tvWardSuperCompDetailsFrgFlat = (TextView) view.findViewById(R.id.tvWardSuperCompDetailsFrgFlat);
        tvWardSuperCompDetailsFrgMobileNumber = (TextView) view.findViewById(R.id.tvWardSuperCompDetailsFrgMobileNumber);
        btnWardSuperCompDetailsFrgNext = (Button) view.findViewById(R.id.btnWardSuperCompDetailsFrgNext);
    }

}
