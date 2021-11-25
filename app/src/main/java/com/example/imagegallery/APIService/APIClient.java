package com.example.imagegallery.APIService;

import com.example.imagegallery.Models.ImageModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface APIClient {

@GET("search/photos")
    Call<ImageModel> GetImages(@Query(value = "query",encoded = true)String query,
                               @Query(value = "per_page",encoded = true)String per_page,
                               @Query(value = "client_id",encoded = true)String client_id);
}
