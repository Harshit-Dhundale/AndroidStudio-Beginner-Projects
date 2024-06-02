package com.example.googlemaps;

import androidx.fragment.app.FragmentActivity;
import android.os.Bundle;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import androidx.annotation.NonNull;

public class MainActivity extends FragmentActivity implements OnMapReadyCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MapView mapView = findViewById(R.id.mapView);  // Local variable, casting removed
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(this);
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) { // Ensured parameter is annotated @NonNull
        GoogleMap gMap = googleMap; // Local variable if used within this method
        // Setup your map view here (e.g., set map type, add markers)
    }

    @Override
    protected void onResume() {
        super.onResume();
        MapView mapView = findViewById(R.id.mapView);
        mapView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        MapView mapView = findViewById(R.id.mapView);
        mapView.onPause();
    }

    @Override
    protected void onDestroy() {
        MapView mapView = findViewById(R.id.mapView);
        mapView.onDestroy();
        super.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        MapView mapView = findViewById(R.id.mapView);
        mapView.onLowMemory();
    }
}
