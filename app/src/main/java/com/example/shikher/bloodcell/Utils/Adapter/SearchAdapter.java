package com.example.shikher.bloodcell.Utils.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.shikher.bloodcell.Views.Fragments.FragmentSearch;
import com.example.shikher.bloodcell.Views.Fragments.SearchFragmentFiles.CityFragment;
import com.example.shikher.bloodcell.Views.Fragments.SearchFragmentFiles.MapFragment;
import com.example.shikher.bloodcell.Views.Fragments.SearchFragmentFiles.NameFragment;


public class SearchAdapter extends FragmentStatePagerAdapter {

    public SearchAdapter(FragmentManager fm) {

        super(fm);

    }


    @Override
    public Fragment getItem(int position) {

        if (position == 0) {

            return new MapFragment();

        } else if (position == 1) {

            return new CityFragment();


        } else if (position == 2) {

            return new NameFragment();


        } else {

            return new FragmentSearch();
        }

    }

    @Override
    public int getCount() {
        return 3;
    }

}