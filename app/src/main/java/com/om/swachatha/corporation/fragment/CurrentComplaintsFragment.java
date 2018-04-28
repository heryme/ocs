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
import com.om.swachatha.corporation.activity.MainActivity;


/**
 * Created by Rahul Padaliya on 9/13/2016.
 */
public class CurrentComplaintsFragment extends Fragment implements View.OnClickListener {

    private static final String TAG = CurrentComplaintsFragment.class.getSimpleName();
    private TextView tvCurrentCompFrgDate;
    private Button btnCurrentCompFrgCloseComp;
    private Button btnCurrentCompFrgReopnenComp;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_current_complaint, null);

        setUpView(view);
        setClickListener();
        return view;
    }

    /**
     * Set Up View
     */
    private void setUpView(View view) {
        btnCurrentCompFrgCloseComp = (Button) view.findViewById(R.id.btnCurrentCompFrgCloseComp);
        btnCurrentCompFrgReopnenComp = (Button) view.findViewById(R.id.btnCurrentCompFrgReopnenComp);
        tvCurrentCompFrgDate = (TextView) view.findViewById(R.id.tvCurrentCompFrgDate);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnCurrentCompFrgCloseComp:
                ((MainActivity) getActivity()).loadFragment(new GiveRatingAfterCloseComplaintFragment(), false, "");
                break;
            case R.id.btnCurrentCompFrgReopnenComp:
                break;
        }
    }

    /**
     * Set Click Listener
     */
    private void setClickListener() {
        btnCurrentCompFrgCloseComp.setOnClickListener(this);
        btnCurrentCompFrgReopnenComp.setOnClickListener(this);
    }
}
