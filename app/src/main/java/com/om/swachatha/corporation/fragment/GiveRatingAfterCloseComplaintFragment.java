package com.om.swachatha.corporation.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.om.swachatha.corporation.R;


/**
 * Created by Rahul Padaliya on 9/13/2016.
 */
public class GiveRatingAfterCloseComplaintFragment extends Fragment {

    private static final String TAG = GiveRatingAfterCloseComplaintFragment.class.getSimpleName();
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

       // View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_profile, null);
        View view = inflater.inflate(R.layout.fragment_give_rating_after_close_complaint, container, false);
        setUpView(view);
        return view ;
    }

    /**
`     * Set Up View
     */
    private void setUpView(View view) {

    }
}
