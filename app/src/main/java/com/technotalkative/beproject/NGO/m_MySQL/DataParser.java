package com.technotalkative.beproject.NGO.m_MySQL;

/**
 * Created by ADMIN on 31/03/2017.
 */

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.provider.Settings;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.technotalkative.beproject.NGO.m_DataObject.Spacecraft;
import com.technotalkative.beproject.NGO.m_UI.CustomAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
/**
 * Created by Oclemy on 6/30/2016 for ProgrammingWizards Channel and http://www.camposha.com.
 */
public class DataParser extends AsyncTask<Void,Void,Integer> {
    Context c;
    String jsonData;
    ListView lv;
    ProgressDialog pd;
    ArrayList<Spacecraft> spacecrafts=new ArrayList<>();
    public DataParser(Context c, String jsonData, ListView lv) {
        this.c = c;
        this.jsonData = jsonData;
        this.lv = lv;
    }
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        pd=new ProgressDialog(c);
        pd.setTitle("Parse");
        pd.setMessage("Parsing...Please wait");
        pd.show();
    }
    @Override
    protected Integer doInBackground(Void... params) {
        return this.parseData();
    }
    @Override
    protected void onPostExecute(Integer result) {
        super.onPostExecute(result);
        pd.dismiss();
        if(result==0)
        {
            Toast.makeText(c,"Unable To Parse",Toast.LENGTH_SHORT).show();
        }else {
            //BIND DATA TO LISTVIEW
            CustomAdapter adapter=new CustomAdapter(c,spacecrafts);
            lv.setAdapter(adapter);
        }
    }
    private int parseData()
    {
        System.out.println("IN PARSE");
        try
        {
            System.out.println("IN TRY");
            JSONArray ja=new JSONArray(jsonData);
            JSONObject jo=null;
            spacecrafts.clear();
            Spacecraft spacecraft;
            for(int i=0;i<ja.length();i++)
            {
                System.out.println("IN FOR");
                jo=ja.getJSONObject(i);
                int id=jo.getInt("id");
                String name=jo.getString("name");
                String imageUrl=jo.getString("url");
                String imageUrl2=jo.getString("url2");
                String imageUrl3=jo.getString("url3");
                String email=jo.getString("emailid");
                String uname=jo.getString("username");
                String address=jo.getString("address");
                String phoneno=jo.getString("phoneno");
                String amount=jo.getString("amount");
                System.out.println("JSON OBJECT IS----"+jo);
                spacecraft=new Spacecraft();
                spacecraft.setId(id);
                spacecraft.setName(name);
                spacecraft.setEmail(email);
                spacecraft.setUname(uname);
                spacecraft.setAddress(address);
                spacecraft.setAmount(amount);
                spacecraft.setPhoneno(phoneno);
                spacecraft.setImageUrl(imageUrl);
                spacecraft.setImageUrl2(imageUrl2);
                spacecraft.setImageUrl3(imageUrl3);
                spacecrafts.add(spacecraft);
            }
            return 1;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return 0;
    }
}