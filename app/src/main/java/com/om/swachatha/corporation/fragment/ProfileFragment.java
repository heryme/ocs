package com.om.swachatha.corporation.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.om.swachatha.corporation.R;
import com.om.swachatha.corporation.activity.MainActivity;


/**
 * Created by Rahul Padaliya on 9/13/2016.
 */
public class ProfileFragment extends Fragment {

    private static final String TAG = ProfileFragment.class.getSimpleName();
    private TextView tvProfileFrgName;
    private TextView tvProfileFrgWard;
    private TextView tvProfileFrgSociety;
    private TextView tvProfileFrgFlat;
    private TextView tvProfileFrgEmail;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

       // View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_profile, null);
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        setUpView(view);
        return view ;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == 1){
            ((MainActivity)getContext()).loadFragment(new AddProfileFragment(),false,"");
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        menu.add(0,1, 0,
                getResources().getString(R.string.add_note))
                .setIcon(R.mipmap.ic_profile_edit)
                .setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
    }

    /**
`     * Set Up View
     */
    private void setUpView(View view) {
        tvProfileFrgName = (TextView) view.findViewById(R.id.tvProfileFrgName);
        tvProfileFrgWard = (TextView) view.findViewById(R.id.tvProfileFrgWard);
        tvProfileFrgSociety = (TextView) view.findViewById(R.id.tvProfileFrgSociety);
        tvProfileFrgFlat = (TextView) view.findViewById(R.id.tvProfileFrgFlat);
        tvProfileFrgEmail = (TextView) view.findViewById(R.id.tvProfileFrgEmail);
    }
}
