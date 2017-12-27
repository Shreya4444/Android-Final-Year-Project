package com.technotalkative.beproject.Education;

/**
 * Created by Dell on 18/01/2017.
 */

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

import com.technotalkative.beproject.R;

import java.io.File;
        import java.io.FileNotFoundException;
        import java.io.FileOutputStream;
        import java.io.IOException;
        import java.io.OutputStream;

import static android.R.attr.data;


public class Education extends AppCompatActivity {
    RadioButton edu1,edu2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_education);
        edu1=(RadioButton)findViewById(R.id.edu1);
        edu2=(RadioButton)findViewById(R.id.edu2);


        edu1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Education.this,Edu_HP.class);
                startActivity(i);
            }
        });

        edu2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Education.this,Edu_UP.class);
                startActivity(i);
            }
        });

    }
}
