package com.example.shikher.bloodcell.Views.Authentication;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shikher.bloodcell.Background.Background_Register;
import com.example.shikher.bloodcell.Background.Background_Request;
import com.example.shikher.bloodcell.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by shikher on 4/7/17.
 */

public class RegisterActivity extends AppCompatActivity {
    @BindView(R.id.register_calenderView)
    TextView dob;
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
    @BindView(R.id.editText_mobile_register)
    EditText mobile;
    @BindView(R.id.button_register)
    Button submit;
    private int mYear, mMonth, mDay;
    private int mYear2, mMonth2, mDay2;

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

        mYear2=mYear2-1900;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String DOB = sdf.format(new Date(mYear2, mMonth2, mDay2));
        String FIRST_NAME=first_name.getText().toString();
        String LAST_NAME=last_name.getText().toString();
        String CITY=city.getSelectedItem().toString();
        String BLOODGROUP=bloodgroup.getSelectedItem().toString();
        String EMAIL=email.getText().toString();
        String MOBILE=mobile.getText().toString();
        if(DOB.matches("")||FIRST_NAME.matches("")||LAST_NAME.matches("")||CITY.matches("")||BLOODGROUP.matches("")||EMAIL.matches("")||MOBILE.matches(""))
            Toast.makeText(this, "All Fields are not filled.", Toast.LENGTH_LONG).show();
        else {
            submit.setEnabled(false);
            String type = "register_submit";
            Background_Register backgroundDonate = new Background_Register(this);
            Intent i = new Intent(this, LoginActivity.class);
            this.startActivity(i);
            backgroundDonate.execute(type, DOB, FIRST_NAME, LAST_NAME, CITY, BLOODGROUP, EMAIL, MOBILE);

        }

    }
    @OnClick(R.id.register_calenderView)
    public void calendar_dialog()
    {

        // Get Current Date
        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);


        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {

                        dob.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                        mYear2=year;
                        mDay2=dayOfMonth;
                        mMonth2=monthOfYear;
                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.show();
    }
}
