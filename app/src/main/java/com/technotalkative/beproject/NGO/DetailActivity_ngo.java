package com.technotalkative.beproject.NGO;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;


import com.squareup.picasso.Picasso;
import com.technotalkative.beproject.NGO.m_DataObject.Spacecraft;
import com.technotalkative.beproject.NGO.m_UI.PicassoClient;
import com.technotalkative.beproject.R;


public class DetailActivity_ngo extends AppCompatActivity {
    TextView nameTxt,emailTxt, usernameTxt,addressTxt,phoneTxt,amountTxt;
    ImageView profile,pan,aadhar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Spacecraft spacecraft=new Spacecraft();
        setContentView(R.layout.activity_detail_n);
        nameTxt = (TextView) findViewById(R.id.name);
        emailTxt= (TextView) findViewById(R.id.emailTxt);
        addressTxt= (TextView) findViewById(R.id.addressTxt);
        phoneTxt= (TextView) findViewById(R.id.phoneTxt);
        amountTxt= (TextView) findViewById(R.id.amountTxt);
        usernameTxt=(TextView)findViewById(R.id.username) ;
        profile=(ImageView)findViewById(R.id.profile);
        pan=(ImageView)findViewById(R.id.pan);
        aadhar=(ImageView)findViewById(R.id.aadhar);

        //GET INTENT
        Intent i=this.getIntent();
        //RECEIVE DATA
        String name=i.getExtras().getString("NAME_KEY");
        String email=i.getExtras().getString("EMAIL_KEY");
        String username=i.getExtras().getString("USERNAME");
        String profileurl=i.getExtras().getString("PROFILEURL");
        String address=i.getExtras().getString("ADDRESS");
        String phoneno=i.getExtras().getString("PHONENO");
        String amount=i.getExtras().getString("AMOUNT");
        String aadharurl=i.getExtras().getString("AADHARURL");
        String panurl=i.getExtras().getString("PANURL");
        //BIND DATA
        nameTxt.setText(name);
        emailTxt.setText(email);
        usernameTxt.setText(username);
        addressTxt.setText(address);
        phoneTxt.setText(phoneno);
        amountTxt.setText(amount);
        PicassoClient.downloadImage(this, profileurl, profile);
        PicassoClient.downloadImage(this, panurl, pan);
        PicassoClient.downloadImage(this, aadharurl, aadhar);
    }
}