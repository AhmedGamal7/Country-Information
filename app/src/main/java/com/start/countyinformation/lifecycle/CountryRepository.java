package com.start.countyinformation.lifecycle;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.LiveData;

import com.start.countyinformation.api.CountryApi;
import com.start.countyinformation.model.Model;
import com.start.countyinformation.room.CountryDao;
import com.start.countyinformation.room.CountryDataBase;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CountryRepository {
    private static final String baseUrl = "https://restcountries.eu/rest/";
    CountryApi countryApi;
    CountryDao countryDao;

    private LiveData<List<Model>> mAllCountry;

    public CountryRepository(Application application, boolean connected) {
        CountryDataBase countryDataBase = CountryDataBase.getDatabase(application);
        countryDao = countryDataBase.countryDao();
        if (connected) {
            getCountryFromApi();
        }

        getCountryFromDB();
    }

    public void getCountryFromDB() {
        mAllCountry = countryDao.getAllCountry();
    }

    public void getCountryFromApi() {
        //init retrofit object
        countryApi = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(CountryApi.class);
        getCountry();
    }

    public void getCountry() {
        Log.i("getCountryFromApi", baseUrl);
        countryApi.getCountyFromApi().enqueue(new Callback<List<Model>>() {
            @Override
            public void onResponse(Call<List<Model>> call, Response<List<Model>> response) {
                if (response != null) {
                    Log.i("ahmed", call.request() + "//");
                    insert(response.body());
                    Log.i("Response", response.body().size() + "//");
                }
            }

            @Override
            public void onFailure(Call<List<Model>> call, Throwable t) {
                Log.i("onFailure", "fail");
            }
        });
    }

    void insert(List<Model> c) {
        CountryDataBase.databaseWriteExecutor.execute(() -> {
            countryDao.deleteAll();
            Log.i("insert", c.size() + "//");
            countryDao.insert(c);
        });
    }

    LiveData<List<Model>> getAllCountries() {
        return mAllCountry;
    }
}
