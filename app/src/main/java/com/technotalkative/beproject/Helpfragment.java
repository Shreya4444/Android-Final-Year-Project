package com.technotalkative.beproject;

/**
 * Created by ADMIN on 02/05/2017.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.technotalkative.beproject.Education.List_edu;


public class Helpfragment extends Fragment {


    public Helpfragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_helpus, container, false);
        Intent i3=new Intent(getActivity(),Helpus.class);
        startActivity(i3);
        return v;
    }

}
