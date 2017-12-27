package com.technotalkative.beproject.Individual;

/**
 * Created by ADMIN on 17/04/2017.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.technotalkative.beproject.Individual.m_MySQL.Downloader;
import com.technotalkative.beproject.NGO.List_ngo;
import com.technotalkative.beproject.R;

public class List_indi extends AppCompatActivity {
    Button bhpindi,bupindi;
    final static String urlAddress="http://192.168.43.134/spacecraft_individualhp.php";
    final static String urlAddress1="http://192.168.43.134/listview_individual.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
               setContentView(R.layout.activity_list_indi);
        bupindi = (Button) findViewById(R.id.bupindi);
        bhpindi = (Button) findViewById(R.id.bhpindi);

        Intent i=this.getIntent();
        final ListView lv= (ListView) findViewById(R.id.lv);
        String type=i.getExtras().getString("Type");
        System.out.println("TYPE IS "+type);
        bhpindi.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(List_indi.this,List_indi.class);
                String type="helpprovider";
                i1.putExtra("Type",type);
                startActivity(i1);
                System.out.println("In Intent");
            }
        });

        bupindi.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v) {
                Intent i2=new Intent(List_indi.this,List_indi.class);
                String type="helpseeker";
                i2.putExtra("Type",type);
                startActivity(i2);
            }
        });

        if(type.equalsIgnoreCase("helpprovider"))
        {
                    new Downloader(List_indi.this,urlAddress,lv).execute();
        }
        if(type.equalsIgnoreCase("helpseeker"))
        {
            new Downloader(List_indi.this,urlAddress1,lv).execute();
        }
    }
}