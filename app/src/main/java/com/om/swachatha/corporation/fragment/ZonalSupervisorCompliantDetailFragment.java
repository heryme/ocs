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
public class ZonalSupervisorCompliantDetailFragment extends Fragment {

    private static final String TAG = ZonalSupervisorCompliantDetailFragment.class.getSimpleName();
    private TextView tvZonalSuperCompDetailsFrgCompNumDate;
    private TextView tvZonalSuperCompDetailsFrgCompTitleDate;
    private TextView tvZonalSuperCompDetailsFrgDate;
    private TextView tvZonalSuperCompDetailsFrgName;
    private TextView tvZonalSuperCompDetailsFrgWard;
    private TextView tvZonalSuperCompDetailsFrgCompSociety;
    private TextView tvZonalSuperCompDetailsFrgFlat;
    private TextView tvZonalSuperCompDetailsFrgMobileNumber;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_zonal_supervisor_compliant_details, null);

        setUpView(view);
        return view ;
    }

    /**
     * Set Up View
     */
    private void setUpView(View view) {
        tvZonalSuperCompDetailsFrgCompNumDate = (TextView) view.findViewById(R.id.tvZonalSuperCompDetailsFrgCompNumDate);
        tvZonalSuperCompDetailsFrgCompTitleDate = (TextView) view.findViewById(R.id.tvZonalSuperCompDetailsFrgCompTitleDate);
        tvZonalSuperCompDetailsFrgDate = (TextView) view.findViewById(R.id.tvZonalSuperCompDetailsFrgDate);
        tvZonalSuperCompDetailsFrgName = (TextView) view.findViewById(R.id.tvZonalSuperCompDetailsFrgName);
        tvZonalSuperCompDetailsFrgWard = (TextView) view.findViewById(R.id.tvZonalSuperCompDetailsFrgWard);
        tvZonalSuperCompDetailsFrgCompSociety = (TextView) view.findViewById(R.id.tvZonalSuperCompDetailsFrgCompSociety);
        tvZonalSuperCompDetailsFrgFlat = (TextView) view.findViewById(R.id.tvZonalSuperCompDetailsFrgFlat);
        tvZonalSuperCompDetailsFrgMobileNumber = (TextView) view.findViewById(R.id.tvZonalSuperCompDetailsFrgMobileNumber);
    }

}
