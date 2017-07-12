package com.example.shikher.bloodcell.Background;


        import retrofit2.Call;
        import retrofit2.http.GET;

public interface location_RequestInterface {

    @GET("bloodbank/location.php")
    Call<location_JSONResponse> getJSON2();
}