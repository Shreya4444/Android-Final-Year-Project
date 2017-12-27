package com.technotalkative.beproject.Individual;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

import com.technotalkative.beproject.R;

public class Individual extends AppCompatActivity {
    RadioButton indi1,indi2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_individual);
        indi1=(RadioButton)findViewById(R.id.indi1);
        indi2=(RadioButton)findViewById(R.id.indi2);


        indi1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Individual.this,Indi_HP.class);
                startActivity(i);
            }
        });

        indi2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Individual.this,Indi_UP.class);
                startActivity(i);
            }
        });

    }
}
