package com.om.swachatha.corporation.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.om.swachatha.corporation.R;
import com.om.swachatha.corporation.activity.MainActivity;
import com.om.swachatha.corporation.utils.ValidationUtils;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Rahul Padaliya on 9/13/2016.
 */
public class AddProfileFragment extends Fragment implements View.OnClickListener {

    private static final String TAG = AddProfileFragment.class.getSimpleName();

    private EditText etAddProfileFrgName;
    //private EditText etAddProfileFrgWard;
    //private EditText etAddProfileFrgSociety;
    private EditText etAddProfileFrgFlat;
    private EditText etAddProfileFrgEmail;
    private Button btnAddProfileFrgNext;
    private Spinner spnAddProfileFrgWard;
    private Spinner spnAddProfileFrgSocity;
    private List<String> wardList;
    private List<String> socityList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_add_profile, null);
        setUpView(view);
        setClickLister();
        setAdapter();
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        menu.clear();
    }

    /**
     * Set Up View
     *
     * @param view
     */
    private void setUpView(View view) {
        etAddProfileFrgName = (EditText) view.findViewById(R.id.etAddProfileFrgName);
        //etAddProfileFrgWard = (EditText) view.findViewById(R.id.etAddProfileFrgWard);
        //etAddProfileFrgSociety = (EditText) view.findViewById(R.id.etAddProfileFrgSociety);
        etAddProfileFrgFlat = (EditText) view.findViewById(R.id.etAddProfileFrgFlat);
        etAddProfileFrgEmail = (EditText) view.findViewById(R.id.etAddProfileFrgEmail);
        btnAddProfileFrgNext = (Button) view.findViewById(R.id.btnAddProfileFrgNext);
        spnAddProfileFrgWard = (Spinner) view.findViewById(R.id.spnAddProfileFrgWard);
        spnAddProfileFrgSocity = (Spinner) view.findViewById(R.id.spnAddProfileFrgSociety);
    }

    /**
     * Set Adapter
     */
    private void setAdapter() {
        //Set Ward Spinner Adapter
        wardList = new ArrayList<String>();
        wardList.add("1");
        wardList.add("2");
        wardList.add("3");
        wardList.add("4");
        wardList.add("5");
        wardList.add("6");

        ArrayAdapter<String> wardAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, this.wardList);
        wardAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnAddProfileFrgWard.setAdapter(wardAdapter);


        //Set Society Spinner  Adapter
        socityList = new ArrayList<>();
        socityList.add("1");
        socityList.add("2");
        socityList.add("3");

        ArrayAdapter<String> cityAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, this.socityList);
        cityAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnAddProfileFrgSocity.setAdapter(cityAdapter);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnAddProfileFrgNext:
                if (ValidationUtils.isValidEditText(etAddProfileFrgName, "Enter name") &&
                        ValidationUtils.isValidEditText(etAddProfileFrgFlat, "Enter Flat/House No") &&
                        ValidationUtils.isValidEditText(etAddProfileFrgEmail, "Enter email")) {
                    if (ValidationUtils.isValidEmail(getContext(), etAddProfileFrgEmail)) {
                        //When User Go To  Home Here Then Enable Navigation Icon And Drawer
                        MainActivity.toolbar.setNavigationIcon(R.drawable.ic_nav);
                        MainActivity.drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
                        ((MainActivity) getActivity()).loadFragment(new HomeFragment(), true, "");
                    }
                }
                break;
        }
    }

    /**
     * Set Click Listener
     */
    private void setClickLister() {
        btnAddProfileFrgNext.setOnClickListener(this);
    }
}
