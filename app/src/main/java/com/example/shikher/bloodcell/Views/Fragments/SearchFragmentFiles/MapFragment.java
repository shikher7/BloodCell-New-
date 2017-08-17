package com.example.shikher.bloodcell.Views.Fragments.SearchFragmentFiles;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.shikher.bloodcell.Background.location_JSONResponse;
import com.example.shikher.bloodcell.Background.location_RequestInterface;
import com.example.shikher.bloodcell.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by shikher on 12/7/17.
 */

public class MapFragment extends Fragment {
    MapView mMapView;
    private GoogleMap googleMap;
    public static final String BASE_URL = "http://weberservice.co.in";
    private ArrayList<location_JSONResponse.AndroidVersion> mArrayList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab_map, container, false);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        mMapView = (MapView) rootView.findViewById(R.id.mapview);
        mMapView.onCreate(savedInstanceState);

        location_RequestInterface request = retrofit.create(location_RequestInterface.class);

        Call<location_JSONResponse> call = request.getJSON2();
        call.enqueue(new Callback<location_JSONResponse>() {

            @Override
            public void onResponse(Call<location_JSONResponse> call, Response<location_JSONResponse> response) {

                location_JSONResponse jsonResponse = response.body();
                mArrayList = new ArrayList<>(Arrays.asList(jsonResponse.getAndroid()));



                mMapView.onResume(); // needed to get the map to display immediately

                try {
                    MapsInitializer.initialize(getActivity().getApplicationContext());
                } catch (Exception e) {
                    e.printStackTrace();
                }

                mMapView.getMapAsync(new OnMapReadyCallback() {
                    @Override
                    public void onMapReady(GoogleMap mMap) {
                        googleMap = mMap;

                        // For showing a move to my location button
                        if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {


                            // TODO: Consider calling
                            //    ActivityCompat#requestPermissions
                            // here to request the missing permissions, and then overriding
                            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                            //                                          int[] grantResults)
                            // to handle the case where the user grants the permission. See the documentation
                            // for ActivityCompat#requestPermissions for more details.
                            return;
                        }
                        googleMap.setMyLocationEnabled(true);

                        // For dropping a marker at a point on the Map
//              LatLng sydney = new LatLng(-34, 151);
                        LatLng lucknow = new LatLng(26.8467, 80.9462);

                int cnt=mArrayList.size();
                for(int i=0;i<cnt;i++)
                {   Log.d("array",mArrayList.get(i).getCoordinateY());
                    Log.d("array",mArrayList.get(i).getCoordinateX());
                    Log.d("array",mArrayList.get(i).getBankName());
                    LatLng location = new LatLng(Double.parseDouble(mArrayList.get(i).getCoordinateX()),
                            Double.parseDouble(mArrayList.get(i).getCoordinateY()));
                    googleMap.addMarker(new MarkerOptions().position(location).title(mArrayList.get(i).getBankName()).snippet("Description"));

                }

                        // For zooming automatically to the location of the marker
                        CameraPosition cameraPosition = new CameraPosition.Builder().target(lucknow).zoom(12).build();
                        googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
                    }
                });

            }

            @Override
            public void onFailure(Call<location_JSONResponse> call, Throwable t) {
                Log.d("Error",t.getMessage());
            }
        });


        return rootView;
    }




    @Override
    public void onPause() {
        super.onPause();
        mMapView.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mMapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mMapView.onLowMemory();
    }
    @Override
    public void onResume() {
        super.onResume();
        AppCompatActivity activity = (AppCompatActivity) getActivity();

    }
}