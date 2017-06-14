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
 * Created by Shikher on 14-06-2017.
 */

public class FragmentRequest extends Fragment {
    @BindView(R.id.blood_bank_spinner)
    Spinner bloodbank;
    @BindView(R.id.blood_group_spinner)
    Spinner bloogroup;


        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

            View rootView = inflater.inflate(R.layout.fragment_request, container, false);
            ButterKnife.bind(this, rootView);
            ArrayAdapter<String> adapter= new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.Blood_Banks));
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            bloodbank.setAdapter(adapter);
            ArrayAdapter<String> adapter2= new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.Blood_Group));
            adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            bloogroup.setAdapter(adapter2);
            return rootView;

        }

        @Override
        public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);
        }
    }


