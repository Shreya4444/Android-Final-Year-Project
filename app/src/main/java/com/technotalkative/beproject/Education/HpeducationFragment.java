package com.technotalkative.beproject.Education;


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
public class HpeducationFragment extends Fragment {


    public HpeducationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_hpeducation, container, false);
        Intent i1=new Intent(getActivity(),List_edu.class);
        String type="helpprovider";
        i1.putExtra("Type",type);
        startActivity(i1);
        System.out.println("In Intent");
        return v;
    }

}
