package com.example.shikher.bloodcell.Views.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Spinner;

import com.example.shikher.bloodcell.R;
import com.example.shikher.bloodcell.Views.Main.MainActivity;

import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Shikher on 13-06-2017.
 */

public class FragmentDonate extends Fragment
{

        @BindView(R.id.spinner_blood_bank)
        Spinner bloodbank;
        @BindView(R.id.spinner_city)
        Spinner city;
        @BindView(R.id.spinner_time_slot)
        Spinner timeslot;
        @BindView(R.id.calendar_donate)
        CalendarView date;
        /*@BindView(R.id.button_donate)
        Button submit;*/
        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_donate, container, false);
            ButterKnife.bind(this, rootView);
            ArrayAdapter<String> adapter1= new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.Blood_Banks));
            adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            bloodbank.setAdapter(adapter1);
            ArrayAdapter<String> adapter2= new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.Cities));
            adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            city.setAdapter(adapter2);
            ArrayAdapter<String> adapter3= new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.Time_slot));
            adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            timeslot.setAdapter(adapter3);
            return rootView;
    }
    @OnClick(R.id.button_donate)
    public void onDonateSubmit(View v) {
        String citys = city.getSelectedItem().toString();
        String bloodbanks = bloodbank.getSelectedItem().toString();
        String timelsots = timeslot.getSelectedItem().toString();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String dates = sdf.format(new Date(date.getDate()));
        String type = "donate_submit";
       /* Background_Donate backgroundLogin = new Background_Donate(getActivity());
        backgroundLogin.execute(type, citys,bloodbanks,timelsots,dates);*/

/*
        Intent intent = new Intent(LoginActivity.this,MainActivity.class);
        startActivity(intent);
        finish();*/
    }
    @OnClick(R.id.button_donate)
    void onDonateSubmit()
    {
        Intent intent = new Intent(getContext(), MainActivity.class);
        startActivity(intent);

    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}

