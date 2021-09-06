package com.start.countyinformation.model.converter;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.start.countyinformation.model.RegionalBloc;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.List;

public class RegionalBlocConverter implements Serializable {
    @TypeConverter // note this annotation
    public String fromRegionalBlocList(List<RegionalBloc> regionalBloc) {
        if (regionalBloc == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<String>() {
        }.getType();
        String json = gson.toJson(regionalBloc, type);
        return json;
    }

    @TypeConverter // note this annotation
    public List<RegionalBloc> toRegionalBlocsList(String regionalBlocString) {
        if (regionalBlocString == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<RegionalBloc>>() {
        }.getType();
        List<RegionalBloc> productCategoriesList = gson.fromJson(regionalBlocString, type);
        return productCategoriesList;
    }
}
