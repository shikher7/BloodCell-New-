package com.example.shikher.bloodcell.Utils;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RequestInterface {

    @GET("bloodbank/bloodbank.php")
    Call<JSONResponse> getJSON();
}
