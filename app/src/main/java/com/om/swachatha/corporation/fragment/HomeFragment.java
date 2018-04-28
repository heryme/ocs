package com.om.swachatha.corporation.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.om.swachatha.corporation.R;
import com.om.swachatha.corporation.activity.MainActivity;


/**
 * Created by Rahul Padaliya on 9/13/2016.
 */
public class HomeFragment extends Fragment implements View.OnClickListener {

    private static final String TAG = HomeFragment.class.getSimpleName();
    private Button btnFrgHomeRegisterYourComplaint;
    private Button btnFrgHomeTrackYourComplaint;
    private Button btnFrgHomeNext;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_home, null);
        setUpView(view);
        registerClickEvent();

        return view;
    }

    /**
     * Set Up View
     *
     * @param view
     */
    private void setUpView(View view) {
        btnFrgHomeRegisterYourComplaint = (Button) view.findViewById(R.id.btnFrgHomeRegisterYourComplaint);
        btnFrgHomeTrackYourComplaint = (Button) view.findViewById(R.id.btnFrgHomeTrackYourComplaint);
        btnFrgHomeNext = (Button) view.findViewById(R.id.btnFrgHomeNext);
    }

    /**
     * Register Click Lister
     */
    private void registerClickEvent() {
        btnFrgHomeRegisterYourComplaint.setOnClickListener(this);
        btnFrgHomeTrackYourComplaint.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.btnFrgHomeRegisterYourComplaint:
                ((MainActivity) getActivity()).loadFragment(new SelectComplaintFragment(), false, "");
                break;
            case R.id.btnFrgHomeTrackYourComplaint:
                ((MainActivity) getActivity()).loadFragment(new TrackComplaintFragment(), false, "");
                break;
            case R.id.btnFrgHomeNext:
                break;

        }

    }
}
