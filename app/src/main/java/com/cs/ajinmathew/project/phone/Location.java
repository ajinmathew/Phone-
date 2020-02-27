package com.cs.ajinmathew.project.phone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

import java.util.Locale;

public class Location extends AppCompatActivity {
Button btnLoca;
String lat,log;
TextView txt;

FusedLocationProviderClient fusedLocationProviderClient;
    private LocationRequest locationRequest;
    private LocationCallback locationCallback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_location );

        fusedLocationProviderClient= LocationServices.getFusedLocationProviderClient( this );

        txt=(TextView)findViewById(R.id.loc);
        locationRequest = LocationRequest.create();
        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        locationRequest.setInterval(20 * 1000);

        locationCallback = new LocationCallback() {
            @Override
            public void onLocationResult(LocationResult locationResult) {
                if (locationResult == null) {
                    return;
                }
                for (android.location.Location location : locationResult.getLocations()) {
                    if (location != null) {
                        double wayLatitude = location.getLatitude();
                        double wayLongitude = location.getLongitude();
                        txt.setText(String.format(Locale.US, "%s -- %s", wayLatitude, wayLongitude));
                    }
                }
            }
        };


        fusedLocationProviderClient.getLastLocation().addOnSuccessListener( this, new OnSuccessListener<android.location.Location>() {
            @Override
            public void onSuccess(android.location.Location location) {
                if(location!=null){
                    lat=String.valueOf( location.getLatitude() );
                    log=String.valueOf( location.getLongitude() );
                    fusedLocationProviderClient.removeLocationUpdates(locationCallback);


                    Log.i("log",log);
                    Log.i("lat",lat);


                }
                Toast.makeText( getApplicationContext(),"lat : "+lat+"  Long :"+log,Toast.LENGTH_LONG ).show();
            }
        } );

        btnLoca=(Button)findViewById( R.id.mylocation );
        btnLoca.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText( getApplicationContext(),"lat : "+lat+"  Long :"+log,Toast.LENGTH_LONG ).show();
            }
        } );
    }
}
