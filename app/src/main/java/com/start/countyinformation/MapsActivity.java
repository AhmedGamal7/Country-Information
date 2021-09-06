package com.start.countyinformation;

import android.os.Bundle;
import android.util.Log;

import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        Double lat = getIntent().getDoubleExtra("Lat",0);
        Double log = getIntent().getDoubleExtra("Log",0);
        String name = getIntent().getStringExtra("Name");
        Log.i("MapActivity","Lat :"+lat+" Log : "+log+" Name :"+name);

        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng LatLog = new LatLng(lat, log);

        mMap.addMarker(new MarkerOptions().position(LatLog).title(name));

        mMap.moveCamera(CameraUpdateFactory.newLatLng(LatLog));
    }
}