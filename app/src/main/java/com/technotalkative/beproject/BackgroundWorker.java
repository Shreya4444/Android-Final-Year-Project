
package com.technotalkative.beproject;

/**
 * Created by ADMIN on 13/03/2017.
 */

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import com.technotalkative.beproject.Education.Choose_edu;
import com.technotalkative.beproject.Hospital.Choose_hospital;
import com.technotalkative.beproject.Individual.Choose_indi;
import com.technotalkative.beproject.NGO.Choose_ngo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by ProgrammingKnowledge on 1/5/2016.
 */
public class BackgroundWorker extends AsyncTask<String,Void,String> {
    Context context;
    static String asso;
    static String usname;
    AlertDialog alertDialog;
    BackgroundWorker (Context ctx) {
        context = ctx;
    }
    @Override
    protected String doInBackground(String... params) {
        String type = params[0];
        String user_name = params[1];
        String password = params[2];
        String associate=params[3];
        asso=associate;
        usname=user_name;
        String login_url = "http://192.168.43.134/login.php";
        if(type.equals("login")) {
                try {

                    URL url = new URL(login_url);
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setDoInput(true);
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                    String post_data = URLEncoder.encode("user_name", "UTF-8") + "=" + URLEncoder.encode(user_name, "UTF-8") + "&"
                            + URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(password, "UTF-8");
                    bufferedWriter.write(post_data);
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    outputStream.close();
                    InputStream inputStream = httpURLConnection.getInputStream();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                    String result = "";
                    String line = "";
                    while ((line = bufferedReader.readLine()) != null) {
                        result += line;
                    }
                    bufferedReader.close();
                    inputStream.close();
                    httpURLConnection.disconnect();
                    return result;
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        return null;
    }

    @Override
    protected void onPreExecute() {
        alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle("Login Status");
    }

    @Override
    protected void onPostExecute(String result) {
        alertDialog.setMessage(result);
        alertDialog.show();
        System.out.println(result);
        if (result.contains("success")) {
            if (asso.equalsIgnoreCase("Education")) {
                System.out.println("Education Intent");
                Intent intent = new Intent(context, Choose_edu.class);
                intent.putExtra("USERNAME",usname);
                context.startActivity(intent);
            }
            else if (asso.equalsIgnoreCase("Ngo")) {
                System.out.println("Ngo Intent");
                Intent intent = new Intent(context, Choose_ngo.class);
                intent.putExtra("USERNAME",usname);
                context.startActivity(intent);
            }
            else if (asso.equalsIgnoreCase("Individual")) {
                System.out.println("Individual Intent");
                Intent intent = new Intent(context, Choose_indi.class);
                intent.putExtra("USERNAME",usname);
                context.startActivity(intent);
            }
            else if (asso.equalsIgnoreCase("Hospital")) {
                System.out.println("Hospital Intent");
                Intent intent = new Intent(context, Choose_hospital.class);
                intent.putExtra("USERNAME",usname);
                context.startActivity(intent);
            }
        }

    }
    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

}