package com.technotalkative.beproject.Hospital;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

import com.technotalkative.beproject.R;

public class Hospital extends AppCompatActivity {
    RadioButton hosp1,hosp2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital);
        hosp1=(RadioButton)findViewById(R.id.hosp1);
        hosp2=(RadioButton)findViewById(R.id.hosp2);


        hosp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Hospital.this,Hosp_HP.class);
                startActivity(i);
            }
        });

        hosp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Hospital.this,Hosp_UP.class);
                startActivity(i);
            }
        });

    }
}
