package com.start.countyinformation.model.converter;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.start.countyinformation.model.Currency;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.List;

public class CurrencyConverter implements Serializable {
    @TypeConverter // note this annotation
    public String fromCurrencyList(List<Currency> currency) {
        if (currency == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<String>() {
        }.getType();
        String json = gson.toJson(currency, type);
        return json;
    }

    @TypeConverter // note this annotation
    public List<Currency> toCurrencyList(String currencyString) {
        if (currencyString == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<Currency>>() {
        }.getType();
        List<Currency> productCategoriesList = gson.fromJson(currencyString, type);
        return productCategoriesList;
    }
}
