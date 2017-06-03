package com.jard.testmap;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private int localidad;
    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        Bundle bundle = getIntent().getExtras();
        localidad = bundle.getInt("localidad");
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
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
        LatLng ubicacionFavorita;
        // Add a marker in Sydney and move the camera
        switch (localidad){
            case R.id.imgBtnAltacia :
                ubicacionFavorita = new LatLng(21.09264350612536, -101.62628170000005);
                mMap.addMarker(new MarkerOptions().position(ubicacionFavorita).title(getString(R.string.marker_altacia)));
                break;

            case R.id.imgBtnCalzada:
                ubicacionFavorita = new LatLng(21.118909506133726, -101.67206610000005);
                mMap.addMarker(new MarkerOptions().position(ubicacionFavorita).title(getString(R.string.marker_calzada)));
                break;

            case R.id.imgBtnExplora:
                ubicacionFavorita = new LatLng(21.111801706131452, -101.66027399999996);
                mMap.addMarker(new MarkerOptions().position(ubicacionFavorita).title(getString(R.string.marker_explora)));
                break;

            case R.id.imgBtnMetropolitano:
                ubicacionFavorita = new LatLng(21.170421906150136, -101.69522254999998);
                mMap.addMarker(new MarkerOptions().position(ubicacionFavorita).title(getString(R.string.marker_metropolinato)));
                break;

            default:
                ubicacionFavorita = new LatLng(21.12861, -101.67278);
                mMap.addMarker(new MarkerOptions().position(ubicacionFavorita).title(getString(R.string.marker_leon)));
                break;
        }


        mMap.moveCamera(CameraUpdateFactory.newLatLng(ubicacionFavorita));
    }
}
