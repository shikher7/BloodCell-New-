package com.example.shikher.bloodcell.Views.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.shikher.bloodcell.Background.Background_Donate;
import com.example.shikher.bloodcell.Background.Background_Login;
import com.example.shikher.bloodcell.Background.city_JSONResponse;
import com.example.shikher.bloodcell.Background.city_RequestInterface;
import com.example.shikher.bloodcell.R;
import com.example.shikher.bloodcell.Utils.Adapter.DataAdapter;
import com.example.shikher.bloodcell.Views.Main.MainActivity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Shikher on 13-06-2017.
 */

public class FragmentDonate extends Fragment
{
    public static final String BASE_URL = "http://weberservice.co.in";

    private ArrayList<city_JSONResponse.AndroidVersion> mArrayList;


        @BindView(R.id.spinner_blood_bank)
        Spinner bloodbank;
        @BindView(R.id.spinner_city)
        Spinner city;
        @BindView(R.id.spinner_time_slot)
        Spinner timeslot;
        @BindView(R.id.calendar_donate)
        DatePicker date;
        /*@BindView(R.id.button_donate)
        Button submit;*/
        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_donate, container, false);
            ButterKnife.bind(this, rootView);
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            city_RequestInterface request = retrofit.create(city_RequestInterface.class);
            Call<city_JSONResponse> call = request.getJSON();
            call.enqueue(new Callback<city_JSONResponse>() {

                @Override
                public void onResponse(Call<city_JSONResponse> call, Response<city_JSONResponse> response) {

                    city_JSONResponse jsonResponse = response.body();
                    mArrayList = new ArrayList<>(Arrays.asList(jsonResponse.getAndroid()));
                    String Blood_Banks[]=new String[mArrayList.size()];
                    for(int i=0;i<mArrayList.size();i++)
                    {
                        Blood_Banks[i]=mArrayList.get(i).getBankName().toString();
                    }

            ArrayAdapter<String> adapter1= new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,Blood_Banks);
            adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            bloodbank.setAdapter(adapter1);
            ArrayAdapter<String> adapter2= new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.Cities));
            adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            city.setAdapter(adapter2);
            ArrayAdapter<String> adapter3= new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.Time_slot));
            adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            timeslot.setAdapter(adapter3);
                }

                @Override
                public void onFailure(Call<city_JSONResponse> call, Throwable t) {
                    Log.d("Error",t.getMessage());
                }
            });
            return rootView;
    }
    @OnClick(R.id.button_donate)
    public void onDonateSubmit(View v) {
        String citys = city.getSelectedItem().toString();
        String bloodbanks = bloodbank.getSelectedItem().toString();
        String timelsots = timeslot.getSelectedItem().toString();

        int   day  = date.getDayOfMonth();
        int   month= date.getMonth();
        int   year = date.getYear();
        year=year-1900;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dates = sdf.format(new Date(year, month, day));

        if(citys.matches("")||bloodbanks.matches("")||timelsots.matches("")||dates.matches(""))
            Toast.makeText(getActivity(), "All Fields are not filled.", Toast.LENGTH_LONG).show();
        else {

            String type = "donate_submit";
            Background_Donate backgroundDonate = new Background_Donate(getActivity());
            backgroundDonate.execute(type, citys, bloodbanks, timelsots, dates);
            getActivity().finish();
        }

}


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}

