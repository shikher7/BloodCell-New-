package com.example.shikher.bloodcell.Views.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.shikher.bloodcell.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Shikher on 14-06-2017.
 */

public class FragmentRequest1 extends Fragment {

Button request;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_request1, container, false);
        request= (Button) rootView.findViewById(R.id.requestNext);
        request.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View rootView){
                        Fragment fragment = null;
                        fragment = new FragmentRequest2();
                        final FragmentTransaction ft = getFragmentManager().beginTransaction();
                        ft.replace(R.id.content_main, fragment);
                        ft.commit();
                        ft.addToBackStack(null);
                    }
                }
        );
        ButterKnife.bind(this, rootView);
        return rootView;

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

}


