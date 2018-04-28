package com.om.swachatha.corporation.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.om.swachatha.corporation.R;


/**
 * Created by Rahul Padaliya on 9/13/2016.
 */
public class WardSupervisorCompliantSubmitFragment extends Fragment {

    private static final String TAG = WardSupervisorCompliantSubmitFragment.class.getSimpleName();
    private TextView etWardSuperCompSubmitFrgAddNote;
    private TextView tvWardSuperCompSubmitFrgAddImage;
    private Button btnWardSuperCompSubmitFrgClose;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_ward_supervisor_compliant_submit, null);

        setUpView(view);
        return view ;
    }

    /**
     * Set Up View
     */
    private void setUpView(View view) {
        btnWardSuperCompSubmitFrgClose = (Button) view.findViewById(R.id.btnWardSuperCompSubmitFrgClose);
        tvWardSuperCompSubmitFrgAddImage = (TextView) view.findViewById(R.id.tvWardSuperCompSubmitFrgAddImage);
        etWardSuperCompSubmitFrgAddNote = (EditText) view.findViewById(R.id.etWardSuperCompSubmitFrgAddNote);
    }

}
