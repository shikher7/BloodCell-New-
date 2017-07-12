package com.example.shikher.bloodcell.Background;

import retrofit2.Call;
import retrofit2.http.GET;

public interface city_RequestInterface {

    @GET("bloodbank/bloodbank.php")
    Call<city_JSONResponse> getJSON();
}
