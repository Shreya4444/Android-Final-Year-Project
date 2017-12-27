package com.technotalkative.beproject.NGO;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.technotalkative.beproject.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class UpngoFragment extends Fragment {


    public UpngoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container2,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_upngo, container2, false);
        Intent i2=new Intent(getActivity(),List_ngo.class);
        String type="helpseeker";
        i2.putExtra("Type",type);
        startActivity(i2);
        return v;
    }

}
