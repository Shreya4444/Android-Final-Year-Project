package com.technotalkative.beproject.Individual.m_UI;

/**
 * Created by ADMIN on 03/04/2017.
 */
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.technotalkative.beproject.Individual.DetailActivity_indi;
import com.technotalkative.beproject.R;
import com.technotalkative.beproject.Individual.m_DataObject.Spacecraft;

import java.util.ArrayList;


public class CustomAdapter extends BaseAdapter {
    Context c;
    ArrayList<Spacecraft> spacecrafts;
    LayoutInflater inflater;
    int imageid;

    public CustomAdapter(Context c, ArrayList<Spacecraft> spacecrafts) {
        this.c = c;
        this.spacecrafts = spacecrafts;
        inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return spacecrafts.size();
    }

    @Override
    public Object getItem(int position) {
        return spacecrafts.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.model_indi, parent, false);
        }
        TextView nametxt = (TextView) convertView.findViewById(R.id.nameTxt);
        TextView emailtxt = (TextView) convertView.findViewById(R.id.emailTxt);

        ImageView img = (ImageView) convertView.findViewById(R.id.movieImage);
        //BIND DATA
        Spacecraft spacecraft = spacecrafts.get(position);
        final String name = spacecraft.getName();
        final String email = spacecraft.getEmail();
        final String uname=spacecraft.getUname();
        final String address=spacecraft.getAddress();
        final String phoneno=spacecraft.getPhoneno();
        final String amount=spacecraft.getAmount();
        final  String profileurl=spacecraft.getImageUrl();
        final  String aadharurl=spacecraft.getImageUrl3();
        final  String panurl=spacecraft.getImageUrl2();
        nametxt.setText(name);
        emailtxt.setText(email);

        //IMG
        System.out.println("IMAGE ID IS " + imageid);

        PicassoClient.downloadImage(c, spacecraft.getImageUrl(), img);


        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //OPEN DETAIL ACTIVITY
                openDetailActivity(name,email,uname,profileurl,address,phoneno,amount,panurl,aadharurl);
            }
        });
        return convertView;
    }

    private void openDetailActivity(String... details) {
        Intent i = new Intent(c, DetailActivity_indi.class);
        i.putExtra("NAME_KEY", details[0]);
        i.putExtra("EMAIL_KEY", details[1]);
        i.putExtra("USERNAME",details[2]);
        i.putExtra("PROFILEURL",details[3]);
        i.putExtra("ADDRESS",details[4]);
        i.putExtra("PHONENO",details[5]);
        i.putExtra("AMOUNT",details[6]);
        i.putExtra("PANURL",details[7]);
        i.putExtra("AADHARURL",details[8]);
        c.startActivity(i);
    }

}


