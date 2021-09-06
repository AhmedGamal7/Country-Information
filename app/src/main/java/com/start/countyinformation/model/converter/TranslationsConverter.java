package com.start.countyinformation.model.converter;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.start.countyinformation.model.Translations;

import java.io.Serializable;
import java.lang.reflect.Type;

public class TranslationsConverter implements Serializable {
    @TypeConverter // note this annotation
    public String fromTranslations(Translations translations) {
        if (translations == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<String>() {
        }.getType();
        String json = gson.toJson(translations, type);
        return json;
    }

    @TypeConverter // note this annotation
    public Translations toTranslations(String TranslationsString) {
        if (TranslationsString == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<Translations>() {
        }.getType();
        Translations productCategoriesList = gson.fromJson(TranslationsString, type);
        return productCategoriesList;
    }
}
