package com.start.countyinformation.api;

import com.start.countyinformation.model.Model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CountryApi {

    @GET("v2/all")
    Call<List<Model>> getCountyFromApi();
}
