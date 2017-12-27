package com.technotalkative.beproject.Education;

/**
 * Created by ADMIN on 17/04/2017.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.technotalkative.beproject.Education.m_MySQL.Downloader;
import com.technotalkative.beproject.R;

public class List_edu extends AppCompatActivity {
    Button bupeducation,bhpeducation;
    final static String urlAddress="http://192.168.43.134/spacecraft_educationhp.php";
    final static String urlAddress1="http://192.168.43.134/listview_education.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
               setContentView(R.layout.activity_list_edu);
        bupeducation = (Button) findViewById(R.id.bupeducation);
        bhpeducation = (Button) findViewById(R.id.bhpeducation);
        Intent i=this.getIntent();
        final ListView lv= (ListView) findViewById(R.id.lv);
        String type=i.getExtras().getString("Type");
        System.out.println("TYPE IS "+type);
        bhpeducation.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(List_edu.this,List_edu.class);
                String type="helpprovider";
                i1.putExtra("Type",type);
                startActivity(i1);
                System.out.println("In Intent");
            }
        });

        bupeducation.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v) {
                Intent i2=new Intent(List_edu.this,List_edu.class);
                String type="helpseeker";
                i2.putExtra("Type",type);
                startActivity(i2);
            }
        });

        if(type.equalsIgnoreCase("helpprovider"))
        {
                    new Downloader(List_edu.this,urlAddress,lv).execute();
        }
        if(type.equalsIgnoreCase("helpseeker"))
        {
            new Downloader(List_edu.this,urlAddress1,lv).execute();
        }
    }
}