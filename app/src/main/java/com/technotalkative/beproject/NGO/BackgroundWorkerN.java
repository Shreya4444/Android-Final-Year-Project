package com.technotalkative.beproject.NGO;

/**
 * Created by ADMIN on 28/03/2017.
 */

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

import com.technotalkative.beproject.Education.Choose_edu;
import com.technotalkative.beproject.Hospital.Choose_hospital;
import com.technotalkative.beproject.Individual.Choose_indi;

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
public class BackgroundWorkerN extends AsyncTask<String,Void,String> {
    Context context;
    AlertDialog alertDialog;
    String usname;
    BackgroundWorkerN(Context ctx) {
        context = ctx;
    }
    @Override
    public String doInBackground(String... params) {
        String type = params[0];
        String login_url = "http://localhost/login.php";
        String registerhp_url = "http://192.168.43.134/Nhregister.php";
        String registerup_url="http://192.168.43.134/Nuregister.php";
        if(type.equals("login")) {
            try {
                String user_name = params[1];
                String password = params[2];
                URL url = new URL(login_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("user_name","UTF-8")+"="+URLEncoder.encode(user_name,"UTF-8")+"&"
                        +URLEncoder.encode("password","UTF-8")+"="+URLEncoder.encode(password,"UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                String result="";
                String line="";
                while((line = bufferedReader.readLine())!= null) {
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
        else
        {
            if(type.equals("registerhp"))
            {
                System.out.println("IN REGISTERHP");
                try {

                    String name = params[1];
                    String user_name = params[2];
                    String password = params[3];
                    String address = params[4];
                    String emailid = params[5];
                    String phoneno = params[6];
                    String website = params[7];
                    String help = params[8];
                    String amount=params[9];
                    usname=user_name;
                    URL url = new URL(registerhp_url);
                    HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setDoInput(true);
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                    String post_data = URLEncoder.encode("name","UTF-8")+"="+URLEncoder.encode(name,"UTF-8")+"&"
                            +URLEncoder.encode("username","UTF-8")+"="+URLEncoder.encode(user_name,"UTF-8")+"&"
                            +URLEncoder.encode("password","UTF-8")+"="+URLEncoder.encode(password,"UTF-8")+"&"
                            +URLEncoder.encode("address","UTF-8")+"="+URLEncoder.encode(address,"UTF-8")+"&"
                            +URLEncoder.encode("emailid","UTF-8")+"="+URLEncoder.encode(emailid,"UTF-8")+"&"
                            +URLEncoder.encode("phoneno","UTF-8")+"="+URLEncoder.encode(phoneno,"UTF-8")+"&"
                            +URLEncoder.encode("website","UTF-8")+"="+URLEncoder.encode(website,"UTF-8")+"&"
                            +URLEncoder.encode("help","UTF-8")+"="+URLEncoder.encode(help,"UTF-8")+"&"
                            +URLEncoder.encode("amount","UTF-8")+"="+URLEncoder.encode(amount,"UTF-8");
                    bufferedWriter.write(post_data);
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    outputStream.close();
                    InputStream inputStream = httpURLConnection.getInputStream();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                    String result="";
                    String line="";
                    while((line = bufferedReader.readLine())!= null) {
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
            else
            {
                if(type.equals("registerup"))
                { try {

                    String name = params[1];
                    String user_name = params[2];
                    String password = params[3];
                    String address = params[4];
                    String emailid = params[5];
                    String phoneno = params[6];
                    String help = params[7];
                    String amount=params[8];
                    String reason=params[9];
                    usname=user_name;
                    URL url = new URL(registerup_url);
                    HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setDoInput(true);
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                    String post_data = URLEncoder.encode("name","UTF-8")+"="+URLEncoder.encode(name,"UTF-8")+"&"
                            +URLEncoder.encode("username","UTF-8")+"="+URLEncoder.encode(user_name,"UTF-8")+"&"
                            +URLEncoder.encode("password","UTF-8")+"="+URLEncoder.encode(password,"UTF-8")+"&"
                            +URLEncoder.encode("address","UTF-8")+"="+URLEncoder.encode(address,"UTF-8")+"&"
                            +URLEncoder.encode("emailid","UTF-8")+"="+URLEncoder.encode(emailid,"UTF-8")+"&"
                            +URLEncoder.encode("phoneno","UTF-8")+"="+URLEncoder.encode(phoneno,"UTF-8")+"&"
                            +URLEncoder.encode("help","UTF-8")+"="+URLEncoder.encode(help,"UTF-8")+"&"
                            +URLEncoder.encode("amount","UTF-8")+"="+URLEncoder.encode(amount,"UTF-8")+"&"
                            +URLEncoder.encode("reason","UTF-8")+"="+URLEncoder.encode(reason,"UTF-8");
                    bufferedWriter.write(post_data);
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    outputStream.close();
                    InputStream inputStream = httpURLConnection.getInputStream();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                    String result="";
                    String line="";
                    while((line = bufferedReader.readLine())!= null) {
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

        System.out.println(" Result is " +result);
        //if (result.contains("success")) {
          //  Intent intent = new Intent(context, Choose_ngo.class);

            //context.startActivity(intent);
        //}
        if (result.contains("Success")) {
            Intent intent = new Intent(context, Choose_ngo.class);
            context.startActivity(intent);
            intent.putExtra("USERNAME",usname);
            context.startActivity(intent);
        }
    }
    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

}