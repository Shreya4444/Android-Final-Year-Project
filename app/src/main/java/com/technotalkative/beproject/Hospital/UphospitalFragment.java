package com.technotalkative.beproject.Hospital;


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
public class UphospitalFragment extends Fragment {


    public UphospitalFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_uphospital, container, false);
        Intent i2=new Intent(getActivity(),List_hospital.class);
        String type="helpseeker";
        i2.putExtra("Type",type);
        startActivity(i2);
        return v;
    }

}
