package com.start.countyinformation.model.converter;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.List;

public class StringToListConverter implements Serializable {
    @TypeConverter // note this annotation
    public String fromAltSpellings(List<String> altSpellings) {
        if (altSpellings == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<String>>() {
        }.getType();
        String json = gson.toJson(altSpellings, type);
        return json;
    }

    @TypeConverter // note this annotation
    public List<String> toAltSpellings(String altSpellingsString) {
        if (altSpellingsString == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<String>>() {
        }.getType();
        List<String> productCategoriesList = gson.fromJson(altSpellingsString, type);
        return productCategoriesList;
    }
}
