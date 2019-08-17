package com.yptask.views;

import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.yptask.R;
import com.yptask.models.CityResponse;
import com.yptask.models.CompanyResponse;

import java.io.IOException;
import java.util.List;

import androidx.fragment.app.FragmentActivity;

public class Locations extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    SupportMapFragment mapFragment;
    int type;
    List<CityResponse> cityList;
    List<CompanyResponse> companyList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_locations);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.

        mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        //onMapReady(mMap);
        type = getIntent().getIntExtra("type",0);
        if (type == 1)
            cityList = (List<CityResponse>) getIntent().getSerializableExtra("City");
        else
            companyList = (List<CompanyResponse>) getIntent().getSerializableExtra("Company");

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

        if (type == 1) {
            for (int i = 0; cityList.size() > i; i++) {

                // Add a marker in Sydney and move the camera
                LatLng sydney = new LatLng(Double.valueOf(cityList.get(i).getLat()), Double.valueOf(cityList.get(i).getLng()));
                mMap.addMarker(new MarkerOptions().position(sydney).title(cityList.get(i).getCity()));

            }

           /* try {
                List<Address> address = new Geocoder(this).getFromLocationName("Egypt", 1);
                LatLng loc;
                if (address == null) {
                    loc = new LatLng(Double.valueOf(cityList.get(0).getLat()), Double.valueOf(cityList.get(0).getLng()));
                }else {
                    loc = new LatLng(Double.valueOf(address.get(0).getLatitude()), Double.valueOf(address.get(0).getLongitude()));
                    Toast.makeText(this, "Done", Toast.LENGTH_SHORT).show();
                }

                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(loc,10));
            } catch (IOException e) {
                e.printStackTrace();
            }*/
        } else {

            for (int i = 0; companyList.size() > i; i++) {

                // Add a marker in Sydney and move the camera
                LatLng sydney = new LatLng(Double.valueOf(companyList.get(i).getLatLng().getLatitude()), Double.valueOf(companyList.get(i).getLatLng().getLongitude()));
                mMap.addMarker(new MarkerOptions().position(sydney).title(companyList.get(i).getCity()));
               // mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

            }

        }
    }
}
