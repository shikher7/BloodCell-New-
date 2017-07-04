package com.example.shikher.bloodcell.Views.Authentication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

import com.example.shikher.bloodcell.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by shikher on 4/7/17.
 */

public class RegisterActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
    }
}
