package com.start.countyinformation.model.converter;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class TopLevelDomainConverter {
    @TypeConverter // note this annotation
    public String fromTopLevelDomain(List<Object> TopLevelDomain) {
        if (TopLevelDomain == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<String>() {
        }.getType();
        String json = gson.toJson(TopLevelDomain, type);
        return json;
    }

    @TypeConverter // note this annotation
    public List<Object> toTopLevelDomain(String TopLevelDomainString) {
        if (TopLevelDomainString == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<Object>>() {
        }.getType();
        List<Object> productCategoriesList = gson.fromJson(TopLevelDomainString, type);
        return productCategoriesList;
    }

}
