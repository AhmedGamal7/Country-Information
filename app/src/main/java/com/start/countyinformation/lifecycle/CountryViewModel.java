package com.start.countyinformation.lifecycle;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.start.countyinformation.model.Model;

import java.util.List;

public class CountryViewModel extends AndroidViewModel {
    private CountryRepository mRepository;
    private Application application;

    private LiveData<List<Model>> mAllCountry;

    public CountryViewModel(Application application) {
        super(application);
        this.application = application;
    }

    public void inti(boolean connected) {
        mRepository = new CountryRepository(application, connected);
        mAllCountry = mRepository.getAllCountries();
    }

    public LiveData<List<Model>> getAllCountries() {
        return mAllCountry;
    }

}
