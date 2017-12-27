package com.technotalkative.beproject.Hospital.m_UI;

import android.content.Context;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.technotalkative.beproject.R;

/**
 * Created by ADMIN on 03/04/2017.
 */

public class PicassoClient {
    public static void downloadImage(Context c, String imageUrl, ImageView img)
    {
        System.out.println("IMAGEURL HERE IS ---->>>>>>" +imageUrl);
        if(imageUrl.length()>0 && imageUrl!=null)
        {
            Picasso.with(c).load(imageUrl).placeholder(R.drawable.placeholder).into(img);

        }else {
            Picasso.with(c).load(R.drawable.placeholder).into(img);
        }
    }

}