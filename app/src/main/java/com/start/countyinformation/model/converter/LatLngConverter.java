package com.start.countyinformation.model.converter;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.List;

public class LatLngConverter implements Serializable {
    @TypeConverter // note this annotation
    public String fromLatLng(List<Double> LatLng) {
        if (LatLng == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<String>() {
        }.getType();
        String json = gson.toJson(LatLng, type);
        return json;
    }

    @TypeConverter // note this annotation
    public List<Double> toLatLng(String LatLng) {
        if (LatLng == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<Double>>() {
        }.getType();
        List<Double> productCategoriesList = gson.fromJson(LatLng, type);
        return productCategoriesList;
    }
}
