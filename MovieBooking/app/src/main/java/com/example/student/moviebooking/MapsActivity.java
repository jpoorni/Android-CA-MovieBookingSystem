package com.example.student.moviebooking;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    public  String s;
    public static LatLng source;

//    static String[] Long1 = {null};
//    static String[] Long2 = {null};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        s = getIntent().getStringExtra("tid1");
        Log.e(s,"thea");
//        Log.e(s,"theatre id");
//        Long1[0] = getIntent().getStringExtra("Long");
//        Long2[0] = getIntent().getStringExtra("Latt");
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
//        if (s == "TMPGLD")
//        {
//            Log.e(s,"theatre id");
//            source = new LatLng(1.333003,103.743692);
//        }


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
     * installed Google Play services and renew LatLng(turned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
//        LatLng sydney = new LatLng(-34, 151);
//        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

        mMap.addMarker(new MarkerOptions()
                .position(TMPGLD)
                .title("GV Tampines")
                .snippet("Pincode : 529510"));
        mMap.addMarker(new MarkerOptions()
                .position(WSTCNP)
                .title("CinePlex Westcoast")
                .snippet("Pincode : 658713"));
        mMap.addMarker(new MarkerOptions()
                .position(HARGLD)
                .title("The Cathay")
                .snippet("Pincode : 098585"));
        mMap.addMarker(new MarkerOptions()
                .position(SUNGLD)
                .title("GV Suntect")
                .snippet("Pincode : 038983"));
        mMap.addMarker(new MarkerOptions()
                .position(SHAWBG)
                .title("ShawTheatre Bugis")
                .snippet("Pincode : 188021"));
        mMap.addMarker(new MarkerOptions()
                .position(CINCAT)
                .title("The Cathay Cineplex")
                .snippet("Pincode : 229233"));
        mMap.addMarker(new MarkerOptions()
                .position(CAPCAT)
                .title("The Cathay - Causeway Point")
                .snippet("Pincode : 738099"));
        mMap.addMarker(new MarkerOptions()
                .position(DTECAT)
                .title("The Cathay - Downtown East")
                .snippet("Pincode : 519599"));
        mMap.addMarker(new MarkerOptions()
                .position(JEMCAT)
                .title("The Cathay - JEM")
                .snippet("Pincode : 608549"));



        if (s.equals("TMPGLD")) {
            CameraPosition c = new CameraPosition.Builder()
                    .target(TMPGLD)
                    .zoom(18)
                    .build();
            mMap.animateCamera(CameraUpdateFactory.newCameraPosition(c));
        }
         else if (s.equals("SHAWBG"))
        {
            CameraPosition c = new CameraPosition.Builder()
                    .target(SHAWBG)
                    .zoom(18)
                    .build();
            mMap.animateCamera(CameraUpdateFactory.newCameraPosition(c));
        }
        else if (s.equals("WSTCNP"))
        {
            CameraPosition c = new CameraPosition.Builder()
                    .target(WSTCNP)
                    .zoom(18)
                    .build();
            mMap.animateCamera(CameraUpdateFactory.newCameraPosition(c));
        }
        else if (s.equals("HARGLD"))
        {
            CameraPosition c = new CameraPosition.Builder()
                    .target(HARGLD)
                    .zoom(18)
                    .build();
            mMap.animateCamera(CameraUpdateFactory.newCameraPosition(c));
        }
        else if (s.equals("SUNGLD"))
        {
            CameraPosition c = new CameraPosition.Builder()
                    .target(SUNGLD)
                    .zoom(18)
                    .build();
            mMap.animateCamera(CameraUpdateFactory.newCameraPosition(c));
        }
        else if (s.equals("CINCAT"))
        {
            CameraPosition c = new CameraPosition.Builder()
                    .target(CINCAT)
                    .zoom(18)
                    .build();
            mMap.animateCamera(CameraUpdateFactory.newCameraPosition(c));
        }
        else if (s.equals("CAPCAT"))
        {
            CameraPosition c = new CameraPosition.Builder()
                    .target(CAPCAT)
                    .zoom(18)
                    .build();
            mMap.animateCamera(CameraUpdateFactory.newCameraPosition(c));
        }
        else if (s.equals("DTECAT"))
        {
            CameraPosition c = new CameraPosition.Builder()
                    .target(DTECAT)
                    .zoom(18)
                    .build();
            mMap.animateCamera(CameraUpdateFactory.newCameraPosition(c));
        }
        else if (s.equals("JEMCAT"))
        {
            CameraPosition c = new CameraPosition.Builder()
                    .target(JEMCAT)
                    .zoom(18)
                    .build();
            mMap.animateCamera(CameraUpdateFactory.newCameraPosition(c));
        }


    }

    static final LatLng WSTCNP =new LatLng(1.349763,103.749171);
    static final LatLng TMPGLD =new LatLng(1.353069,103.945280);
    static final LatLng HARGLD =new LatLng(1.265179,103.821784);
    static final LatLng SUNGLD =new LatLng(1.296247,103.859085);
    static final LatLng SHAWBG =new LatLng(1.299015,103.855318);
    static final LatLng CINCAT =new LatLng(1.299362,103.847403);
    static final LatLng CAPCAT =new LatLng(1.435844,103.786190);
    static final LatLng DTECAT =new LatLng(1.379160,103.955000);
    static final LatLng JEMCAT =new LatLng(1.333003,103.743692);
}

