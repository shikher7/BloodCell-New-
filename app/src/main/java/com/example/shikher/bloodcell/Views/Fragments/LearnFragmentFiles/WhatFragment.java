package com.example.shikher.bloodcell.Views.Fragments.LearnFragmentFiles;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.shikher.bloodcell.R;

public class WhatFragment extends Fragment {

    Button button;
    Toolbar toolbar;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.viewpager_what, container, false);

        /*button = (Button) root.findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                setCurrentFragment(new QuizFragment() ,"Check Eligibility" );

            }
        });*/

        return root;

    }

    public void setCurrentFragment(Fragment newFragment, String title) {

        fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.enter_from_left, R.anim.exit_to_right, R.anim.enter_from_right, R.anim.exit_to_left);
        fragmentTransaction.replace(R.id.mainFrame, newFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

        toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);
        toolbar.setTitle(title);

    }
}
