package com.start.countyinformation;

import android.os.Bundle;
import android.util.Log;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.start.countyinformation.lifecycle.CountryViewModel;
import com.start.countyinformation.model.Model;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    RecyclerView mRecyclerView;
    SearchView mSearchView;
    CountryAdapter countryAdapter;
    List<Model> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        Configuration config = getResources().getConfiguration();
//
//
//        if (config.smallestScreenWidthDp >= 600) {
//            setContentView(R.layout.layout-w600dp);
//        } else {
//            setContentView(R.layout.main_activity);
//        }
        setContentView(R.layout.activity_main);
        CountryViewModel countryViewModel = new ViewModelProvider(this).get(CountryViewModel.class);

        //handel screen
        if (findViewById(R.id.mFrameLayout) != null) {

        }

        mRecyclerView = findViewById(R.id.mCountryRecyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        list = new ArrayList<>();
        countryAdapter = new CountryAdapter(list, this);
        mRecyclerView.setAdapter(countryAdapter);
        mSearchView = findViewById(R.id.mSearchView);
        mSearchView.setOnQueryTextListener(this);

        countryViewModel.inti(false);
        LiveData<List<Model>> data = countryViewModel.getAllCountries();
        if (data != null) {
            data.observe(MainActivity.this, (List<Model> models) -> {
                //Toast.makeText(MainActivity.this, models.size() + "!!!", Toast.LENGTH_LONG).show();
                if (findViewById(R.id.mFrameLayout) != null) {
                    countryAdapter.setLayout(1);
                }
                countryAdapter.setList(models);
                countryAdapter.notifyDataSetChanged();
                //Log.i("Main//", models.size() + "!!!");
            });
        } else {
            Toast.makeText(MainActivity.this, "null", Toast.LENGTH_SHORT).show();
        }
    }

    /* public boolean isInternetAvailable() {
         try {
             InetAddress ipAddress = InetAddress.getByName("google.com");
             //You can replace it with your name
             return !ipAddress.equals("");

         } catch (Exception e) {
             return false;
         }
     }

     @RequiresApi(api = Build.VERSION_CODES.M)
     private boolean isNetworkConnected() {
         ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

         return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected();
     }
 */
    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        if (newText != null) {
            countryAdapter.getFilter().filter(newText);
            Log.i("Change", newText);
        }
        return false;
    }
}