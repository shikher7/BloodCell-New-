package com.example.shikher.bloodcell.Views.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.shikher.bloodcell.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Shikher on 13-06-2017.
 */

public class FragmentDonate extends Fragment
{

        @BindView(R.id.blood_bank_spinner2)
        Spinner bloodbank;
        @BindView(R.id.spinner)
        Spinner city;
        @BindView(R.id.time_slot)
        Spinner timeSlot;
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
            timeSlot.setAdapter(adapter3);
            return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}

