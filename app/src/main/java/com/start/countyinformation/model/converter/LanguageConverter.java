package com.start.countyinformation.model.converter;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.start.countyinformation.model.Language;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.List;

public class LanguageConverter implements Serializable {
    @TypeConverter // note this annotation
    public String fromLanguageList(List<Language> language) {
        if (language == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<String>() {
        }.getType();
        String json = gson.toJson(language, type);
        return json;
    }

    @TypeConverter // note this annotation
    public List<Language> toLanguageList(String languageString) {
        if (languageString == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<Language>>() {
        }.getType();
        List<Language> productCategoriesList = gson.fromJson(languageString, type);
        return productCategoriesList;
    }
}
