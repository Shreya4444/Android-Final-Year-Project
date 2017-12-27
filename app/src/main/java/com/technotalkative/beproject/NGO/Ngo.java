package com.technotalkative.beproject.NGO;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.technotalkative.beproject.R;
import android.content.Intent;
import android.view.View;
import android.widget.RadioButton;

public class Ngo extends AppCompatActivity {
    RadioButton ngo1,ngo2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ngo);
        ngo1=(RadioButton)findViewById(R.id.ngo1);
        ngo2=(RadioButton)findViewById(R.id.ngo2);


        ngo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Ngo.this,NGO_HP.class);
                startActivity(i);
            }
        });

        ngo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Ngo.this,NGO_UP.class);
                startActivity(i);
            }
        });

    }
}
