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
public class PastComplaintsFragment extends Fragment {

    private static final String TAG = PastComplaintsFragment.class.getSimpleName();

    private TextView tvPastCompFrgDate;
    private TextView tvPastCompFrgEndDate;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_past_complaint, null);

        setUpView(view);
        return view;
    }

    /**
     * Set Up View
     */
    private void setUpView(View view) {
        tvPastCompFrgDate = (TextView) view.findViewById(R.id.tvPastCompFrgDate);
        tvPastCompFrgEndDate = (TextView) view.findViewById(R.id.tvPastCompFrgEndDate);
    }


}
