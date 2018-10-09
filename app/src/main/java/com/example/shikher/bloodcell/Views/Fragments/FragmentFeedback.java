package com.example.shikher.bloodcell.Views.Fragments;
import butterknife.ButterKnife;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.shikher.bloodcell.R;
import com.example.shikher.bloodcell.Utils.Constants;
import com.example.shikher.bloodcell.Utils.RequestHandler;
import com.example.shikher.bloodcell.Utils.SharedPrefManager;
import com.example.shikher.bloodcell.Views.Main.MainActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;


public class FragmentFeedback extends Fragment {
        @BindView(R.id.feedback_text)
        EditText feedback;

        private ProgressDialog progressDialog;
        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_feedback, container, false);
            ButterKnife.bind(this, rootView);
            return rootView;

        }

        @Override
        public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);
        }
    @Override
    public void onResume() {
        super.onResume();
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        android.support.v7.app.ActionBar actionBar = activity.getSupportActionBar();
        actionBar.setTitle("Feedback");
    }

        @OnClick(R.id.feedback_button)
    public void FeedBackSubmit(View v) {
        InputMethodManager inputManager = (InputMethodManager)
                getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);

        inputManager.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(),
                InputMethodManager.HIDE_NOT_ALWAYS);
        progressDialog = new ProgressDialog(getContext());
        final String FEEDBACK = feedback.getText().toString().trim();
            if (FEEDBACK.matches(""))
                Toast.makeText(getActivity(), "Feedback Field is not filled.", Toast.LENGTH_LONG).show();
            else {
                progressDialog.setMessage("Sending Feedback Request...");
                progressDialog.show();

                StringRequest stringRequest = new StringRequest(Request.Method.POST,
                        Constants.URL_FEEDBACK,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                progressDialog.dismiss();

                                try {
                                    JSONObject jsonObject = new JSONObject(response);
                                    if(!jsonObject.getBoolean("error"))
                                    {
                                        Toast.makeText(getContext(), jsonObject.getString("message"), Toast.LENGTH_LONG).show();
                                        Intent i = new Intent(getContext(), MainActivity.class);
                                        getActivity().startActivity(i);
                                        ((Activity)getContext()).finish();
                                    }
                                    else
                                    {
                                        Toast.makeText(getContext(), jsonObject.getString("message"), Toast.LENGTH_LONG).show();
                                    }

                                } catch (JSONException e)
                                {
                                    e.printStackTrace();
                                }
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                progressDialog.hide();
                                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_LONG).show();
                            }
                        }) {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> params = new HashMap<>();
                        params.put("feedback", FEEDBACK);
                        params.put("user_id",SharedPrefManager.getInstance(getActivity()).getUserID());
                        return params;
                    }
                };
                RequestHandler.getInstance(getActivity()).addToRequestQueue(stringRequest);


            }

        }



    }
    //l

