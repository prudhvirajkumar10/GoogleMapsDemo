package com.assessment.googlemapsdemo;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;

import com.assessment.googlemapsdemo.database.DataManager;
import com.assessment.googlemapsdemo.database.Place;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private DataManager manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        manager = new DataManager(this);
        manager.savePlace( saveData(createID(),"12.9716", "77.5946", "Bangalore"));
        manager.savePlace(saveData(createID(),"17.3850", "78.4867", "Hyderabad"));
        manager.savePlace(saveData(createID(),"13.0827", "80.2707", "Chennai"));
        manager.savePlace(saveData(createID(),"19.0760", "72.8777", "Mumbai"));
        manager.savePlace(saveData(createID(),"12.2958", "76.6394", "Mysore"));
        manager.savePlace(saveData(createID(),"28.6139", "77.2090", "New Delhi"));
    }

    public static int createID(){
        Date date = new Date();
        return Integer.parseInt(new SimpleDateFormat("ddHHmmss",  Locale.US).format(date));
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        List<Place> places = manager.getAllPlaces();

        Place delplace = places.get(5);
        LatLng delhi = new LatLng(Double.parseDouble(delplace.getLatitude()), Double.parseDouble(delplace.getLongitude()));
        mMap.addMarker(new MarkerOptions().position(delhi).title("Marker in " + delplace.getName()));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(delhi));

        Place banplace = places.get(0);
        LatLng bangalore = new LatLng(Double.parseDouble(banplace.getLatitude()), Double.parseDouble(banplace.getLongitude()));
        mMap.addMarker(new MarkerOptions().position(bangalore).title("Marker in " + banplace.getName()));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(bangalore));

        Place hydplace = places.get(1);
        LatLng hyderabad = new LatLng(Double.parseDouble(hydplace.getLatitude()), Double.parseDouble(hydplace.getLongitude()));
        mMap.addMarker(new MarkerOptions().position(hyderabad).title("Marker in " + hydplace.getName()));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(hyderabad));

        Place chenplace = places.get(2);
        LatLng chennai = new LatLng(Double.parseDouble(chenplace.getLatitude()), Double.parseDouble(chenplace.getLongitude()));
        mMap.addMarker(new MarkerOptions().position(chennai).title("Marker in " + chenplace.getName()));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(chennai));

        Place mumplace = places.get(3);
        LatLng mumbai = new LatLng(Double.parseDouble(mumplace.getLatitude()), Double.parseDouble(mumplace.getLongitude()));
        mMap.addMarker(new MarkerOptions().position(mumbai).title("Marker in " + mumplace.getName()));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(mumbai));

        Place place = places.get(4);
        LatLng mysore = new LatLng(Double.parseDouble(place.getLatitude()), Double.parseDouble(place.getLongitude()));
        mMap.addMarker(new MarkerOptions().position(mysore).title("Marker in " + place.getName()));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(mysore));

    }

    private Place saveData(int id, String lat, String lon, String name){
        Log.d("Values", id+  "," + lat + "," + lon + "," + name);
        Place place = new Place();
        place.setPlace_id(id);
        place.setLatitude(lat);
        place.setLongitude(lon);
        place.setName(name);
        return place;
    }
}
