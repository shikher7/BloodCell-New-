package com.example.shikher.bloodcell.Views.Authentication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.shikher.bloodcell.Background.Background_Login;
import com.example.shikher.bloodcell.R;
import com.example.shikher.bloodcell.Views.Main.MainActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Shikher on 14-06-2017.
 */

public class LoginActivity extends AppCompatActivity {
    @BindView(R.id.login_button)
    Button loginButton;
    @BindView(R.id.editText_mobile)
    EditText editText_mobile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }
    @OnClick(R.id.login_button)
    public void onUserLogin(View v) {
        String mobile=editText_mobile.getText().toString();
        if (mobile.matches(""))
            Toast.makeText(this, "Enter mobile number.", Toast.LENGTH_SHORT).show();
        else {
            String type = "login";
            Background_Login backgroundWorker = new Background_Login(this);
            backgroundWorker.execute(type, mobile);
            this.finish();
        }
    }
    @OnClick(R.id.register_button)
    public void onUserRegister(View v) {
        Intent i = new Intent(this, RegisterActivity.class);
        this.startActivity(i);
        this.finish();
    }
}
