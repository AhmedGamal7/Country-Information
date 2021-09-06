package com.start.countyinformation.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.start.countyinformation.model.Model;
import com.start.countyinformation.model.converter.StringToListConverter;
import com.start.countyinformation.model.converter.CurrencyConverter;
import com.start.countyinformation.model.converter.LanguageConverter;
import com.start.countyinformation.model.converter.LatLngConverter;
import com.start.countyinformation.model.converter.RegionalBlocConverter;
import com.start.countyinformation.model.converter.TopLevelDomainConverter;
import com.start.countyinformation.model.converter.TranslationsConverter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Model.class}, version = 2, exportSchema = false)
@TypeConverters({CurrencyConverter.class, LanguageConverter.class, RegionalBlocConverter.class, TranslationsConverter.class
        , TopLevelDomainConverter.class, LatLngConverter.class, StringToListConverter.class})
public abstract class CountryDataBase extends RoomDatabase {

    public abstract CountryDao countryDao();

    private static volatile CountryDataBase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static CountryDataBase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (CountryDataBase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            CountryDataBase.class, "country_database")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }

}
