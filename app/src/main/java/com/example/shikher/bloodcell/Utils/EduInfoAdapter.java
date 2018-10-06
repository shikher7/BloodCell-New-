package com.example.shikher.bloodcell.Utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.shikher.bloodcell.Views.Fragments.LearnFragment;
import com.example.shikher.bloodcell.Views.Fragments.LearnFragmentFiles.FactsFragment;
import com.example.shikher.bloodcell.Views.Fragments.LearnFragmentFiles.TypesFragment;
import com.example.shikher.bloodcell.Views.Fragments.LearnFragmentFiles.WhatFragment;
import com.example.shikher.bloodcell.Views.Fragments.LearnFragmentFiles.WhyFragment;


public class EduInfoAdapter extends FragmentStatePagerAdapter {

    public EduInfoAdapter(FragmentManager fm) {

        super(fm);

    }


    @Override
    public Fragment getItem(int position) {

        if (position == 0) {

            return new WhatFragment();

        } else if (position == 1) {

            return new WhyFragment();


        } else if (position == 2) {

            return new TypesFragment();


        } else if (position == 3) {


            return new FactsFragment();

        } else {

            return new LearnFragment();
        }

    }

    @Override
    public int getCount() {
        return 4;
    }

}