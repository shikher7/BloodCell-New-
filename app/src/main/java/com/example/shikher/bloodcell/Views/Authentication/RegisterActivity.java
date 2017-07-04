package com.example.shikher.bloodcell.Views.Authentication;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.shikher.bloodcell.Background.Background_Register;
import com.example.shikher.bloodcell.Background.Background_Request;
import com.example.shikher.bloodcell.R;

import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by shikher on 4/7/17.
 */

public class RegisterActivity extends AppCompatActivity {
    @BindView(R.id.register_calenderView)
    CalendarView dob;
    @BindView(R.id.register_first_name)
    EditText first_name;
    @BindView(R.id.register_last_name)
    EditText last_name;
    @BindView(R.id.register_city_spinner)
    Spinner city;
    @BindView(R.id.register_spinner_bloodgroup)
    Spinner bloodgroup;
    @BindView(R.id.register_email)
    EditText email;
    @BindView(R.id.register_mobile)
    EditText mobile;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        ArrayAdapter<String> adapter1= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.Blood_Group));
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        bloodgroup.setAdapter(adapter1);
        ArrayAdapter<String> adapter2= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.Cities));
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        city.setAdapter(adapter2);
    }
    @OnClick(R.id.button_register)
    public void onRegisterSubmit(View v) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String DOB = sdf.format(new Date(dob.getDate()));
        String FIRST_NAME=first_name.getText().toString();
        String LAST_NAME=last_name.getText().toString();
        String CITY=city.getSelectedItem().toString();
        String BLOODGROUP=bloodgroup.getSelectedItem().toString();
        String EMAIL=email.getText().toString();
        String MOBILE=mobile.getText().toString();
        String type = "register_submit";
        Background_Register backgroundDonate = new Background_Register(this);
        backgroundDonate.execute(type, DOB,FIRST_NAME,LAST_NAME,CITY,BLOODGROUP,EMAIL,MOBILE);

    }
}
