package com.example.shikher.bloodcell.Background;

import android.app.AlertDialog;
import android.content.Context;
import android.os.AsyncTask;

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
 * Created by shikher on 1/7/17.
 */

public class Background_Request extends AsyncTask<String,Void,String> {
    Context context;
    AlertDialog alertDialog;
    public Background_Request(Context ctx) {
        context = ctx;
    }
    @Override
    protected String doInBackground(String... params) {
        String type = params[0];
        String result="";
        String login_url = "http://192.168.43.176/bloodbank/request.php";
        if(type.equals("request_submit")) {
            try {
                String city = params[1];
                String bloodbank = params[2];
                String bloodgroup = params[3];
                String firstname = params[4];
                String lastname = params[5];
                String description = params[6];
                String age = params[7];
                String doctor = params[8];
                String hospital = params[9];
                String date = params[10];/*
                type,citys,bloodbanks,bloodgroups,first_name,last_name,
                        descriptions,ages,doctor_name,hospital_name,dates);*/
                URL url = new URL(login_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("city","UTF-8")+"="+URLEncoder.encode(city,"UTF-8")+"&"
                        +URLEncoder.encode("bloodbank","UTF-8")+"="+URLEncoder.encode(bloodbank,"UTF-8")+"&"
                        +URLEncoder.encode("bloodgroup","UTF-8")+"="+URLEncoder.encode(bloodgroup,"UTF-8")+"&"
                        +URLEncoder.encode("firstname","UTF-8")+"="+URLEncoder.encode(firstname,"UTF-8")+"&"
                        +URLEncoder.encode("lastname","UTF-8")+"="+URLEncoder.encode(lastname,"UTF-8")+"&"
                        +URLEncoder.encode("description","UTF-8")+"="+URLEncoder.encode(description,"UTF-8")+"&"
                        +URLEncoder.encode("age","UTF-8")+"="+URLEncoder.encode(age,"UTF-8")+"&"
                        +URLEncoder.encode("doctor","UTF-8")+"="+URLEncoder.encode(doctor,"UTF-8")+"&"
                        +URLEncoder.encode("hospital","UTF-8")+"="+URLEncoder.encode(hospital,"UTF-8")+"&"
                        +URLEncoder.encode("date","UTF-8")+"="+URLEncoder.encode(date,"UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
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
    }





    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
}