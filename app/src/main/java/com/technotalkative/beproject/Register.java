package com.technotalkative.beproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

import com.technotalkative.beproject.Education.Education;
import com.technotalkative.beproject.Hospital.Hospital;
import com.technotalkative.beproject.Individual.Individual;
import com.technotalkative.beproject.NGO.Ngo;

public class Register extends AppCompatActivity {
    RadioButton education,ngo,individual,hospital;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        education=(RadioButton)findViewById(R.id.education);
        ngo=(RadioButton)findViewById(R.id.ngo);
        individual=(RadioButton)findViewById(R.id.individual);
        hospital=(RadioButton)findViewById(R.id.hospital);
        education.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Register.this,Education.class);
                startActivity(i);
            }
        });

        ngo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Register.this, Ngo.class);
                startActivity(i);
            }
        });

        individual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Register.this,Individual.class);
                startActivity(i);
            }
        });


        hospital.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Register.this,Hospital.class);
                startActivity(i);
            }
        });
    }
}
