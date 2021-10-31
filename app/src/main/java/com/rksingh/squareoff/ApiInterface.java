package com.rksingh.squareoff;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("config.json")
    Call<JsonResponse> getJsonData();

}
