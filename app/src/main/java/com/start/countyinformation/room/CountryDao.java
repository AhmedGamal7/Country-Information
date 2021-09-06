package com.start.countyinformation.room;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.start.countyinformation.model.Model;

import java.util.List;

@Dao
public interface CountryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<Model> model);

    //get all country
    @Query("Select * From country")
    LiveData<List<Model>> getAllCountry();

    //delete all Country
    @Query("Delete From Country")
    void deleteAll();

}
