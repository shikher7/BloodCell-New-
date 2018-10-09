package com.example.shikher.bloodcell.Views.Fragments;
import android.app.ProgressDialog;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import com.example.shikher.bloodcell.R;
import com.example.shikher.bloodcell.Utils.Constants;
import com.example.shikher.bloodcell.Utils.JsonList;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class FragmentSearch extends Fragment implements OnMapReadyCallback,LocationListener,GoogleMap.OnMarkerClickListener {


    private ProgressDialog progressDialog;
    private GoogleMap mMap;
    ListView listView;

    List<JsonList> JsonList;
    private MapView mapView;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_search, container, false);

        JsonList = new ArrayList<>();
        progressDialog = new ProgressDialog(getContext());
        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        return root;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        if (ActivityCompat.checkSelfPermission(getContext(), android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(getContext(), android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED)
        {
            return;
        }
        mMap.setMyLocationEnabled(true);

        progressDialog.setMessage("Getting Map Data...");
        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);


        progressDialog.show();

        StringRequest stringRequest = new StringRequest(
                Request.Method.GET,
                Constants.URL_SEARCH_MAP,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        progressDialog.dismiss();
                        try {
                            JSONObject obj = new JSONObject(response);

                            JSONArray heroArray = obj.getJSONArray("Coords");

                            for (int i = 0; i < heroArray.length(); i++) {

                                JSONObject jsonObject1=heroArray.getJSONObject(i);
//
                                String lat_i = jsonObject1.getString("Latitude");
                                String long_i = jsonObject1.getString("Longitude");
                                String bankName =jsonObject1.getString("bankName");
                                String city=jsonObject1.getString("city");
                                String phone=jsonObject1.getString("phone");
//                                mMap.addMarker(new MarkerOptions()
//                                        .position(new LatLng(Double.parseDouble(lat_i) , Double.parseDouble(long_i)))
//                                        .title(bankName+"\n"+"Phone: "+phone+"\n"+city+"\n"+Double.valueOf(lat_i).toString() + "," + Double.valueOf(long_i).toString())
//                                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE))
//                                );
                                mMap.addMarker(new MarkerOptions()
                                        .position(new LatLng(Double.parseDouble(lat_i) , Double.parseDouble(long_i)))
                                        .title(bankName+","+"Phone: "+phone)
                                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE))
                                );

                                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(12.972031, 79.158818

                                ), 10.0f));
                            }



                        } catch (JSONException e) {
                            Log.d("abc",e.getMessage());
                            e.printStackTrace();

                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("abc","error2");
                        error.getMessage();
                        error.getStackTrace();
                        progressDialog.hide();
                        Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

        //creating a request queue
        RequestQueue requestQueue = Volley.newRequestQueue(getContext());

        //adding the string request to request queue
        requestQueue.add(stringRequest);
    }
    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        return false;
    }
    @Override
    public void onResume() {
        super.onResume();
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        android.support.v7.app.ActionBar actionBar = activity.getSupportActionBar();
        actionBar.setTitle("Search Bloodbank");
    }
}



