package com.technotalkative.beproject.Hospital;

/**
 * Created by ADMIN on 17/04/2017.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.technotalkative.beproject.Hospital.m_MySQL.Downloader;
import com.technotalkative.beproject.NGO.List_ngo;
import com.technotalkative.beproject.R;

public class List_hospital extends AppCompatActivity {
    Button buphospital,bhphospital;
    final static String urlAddress="http://192.168.43.134/spacecraft_hospitalhp.php";
    final static String urlAddress1="http://192.168.43.134/listview_hospital.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
               setContentView(R.layout.activity_list_hospital);
        buphospital = (Button) findViewById(R.id.buphospital);
        bhphospital = (Button) findViewById(R.id.bhphospital);

        Intent i=this.getIntent();
        final ListView lv= (ListView) findViewById(R.id.lv);
        String type=i.getExtras().getString("Type");
        System.out.println("TYPE IS "+type);
        bhphospital.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(List_hospital.this,List_hospital.class);
                String type="helpprovider";
                i1.putExtra("Type",type);
                startActivity(i1);
                System.out.println("In Intent");
            }
        });

        buphospital.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v) {
                Intent i2=new Intent(List_hospital.this,List_hospital.class);
                String type="helpseeker";
                i2.putExtra("Type",type);
                startActivity(i2);
            }
        });

        if(type.equalsIgnoreCase("helpprovider"))
        {
                    new Downloader(List_hospital.this,urlAddress,lv).execute();
        }
        if(type.equalsIgnoreCase("helpseeker"))
        {
            new Downloader(List_hospital.this,urlAddress1,lv).execute();
        }
    }
}