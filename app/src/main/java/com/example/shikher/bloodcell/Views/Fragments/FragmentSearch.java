package com.example.shikher.bloodcell.Views.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.shikher.bloodcell.R;
import com.example.shikher.bloodcell.Utils.Adapter.SearchAdapter;
import com.example.shikher.bloodcell.Utils.DataGenerator;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Shikher on 14-06-2017.
 */

public class FragmentSearch extends Fragment {


    @BindView(R.id.search_recycler_view)
    RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_search, container, false);
        ButterKnife.bind(this, rootView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mAdapter = new SearchAdapter(getDataSet());
        recyclerView.setAdapter(mAdapter);
        recyclerView.setNestedScrollingEnabled(false);

        return rootView;
    }

    private ArrayList<DataGenerator> getDataSet() {
        ArrayList<DataGenerator> results = new ArrayList<>();
        for (int index = 0; index < 10; index++) {
            DataGenerator obj = new DataGenerator("name" + index, "place" + index, "phone" + index);
            results.add(index, obj);
        }
        return results;
    }
}

