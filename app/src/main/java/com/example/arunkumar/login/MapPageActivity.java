package com.example.arunkumar.login;

import android.location.Location;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.esri.android.map.GraphicsLayer;
import com.esri.android.map.MapView;
import com.esri.android.map.ags.ArcGISFeatureLayer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;

public class MapPageActivity extends AppCompatActivity {

    MapView mMapView;
    ArcGISFeatureLayer mFeatureLayer;
    GraphicsLayer mGraphicsLayer;
    String mFeatureServiceURL;

    private GPSTracker gpsTracker;
    private Location mLocation;
    double latitude, longitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_page);

        // Retrieve the map and initial extent from XML layout
        mMapView = (MapView) findViewById(R.id.map);
// Get the feature service URL from values->strings.xml
        mFeatureServiceURL = this.getResources().getString(R.string.featureServiceURL);
// Add Feature layer to the MapView
        mFeatureLayer = new ArcGISFeatureLayer(mFeatureServiceURL, ArcGISFeatureLayer.MODE.ONDEMAND);
        mMapView.addLayer(mFeatureLayer);
// Add Graphics layer to the MapView
        mGraphicsLayer = new GraphicsLayer();
        mMapView.addLayer(mGraphicsLayer);

        gpsTracker = new GPSTracker(getApplicationContext());
        mLocation = gpsTracker.getLocation();

        latitude = mLocation.getLatitude();
        longitude = mLocation.getLongitude();


    }
}
