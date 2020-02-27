package com.cs.ajinmathew.project.phone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
Button btnCall,btnLocation,btnWhatsapp,btnDate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        btnCall=(Button)findViewById( R.id.call );
        btnLocation=(Button)findViewById( R.id.location );
        btnLocation.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity( new Intent( getApplicationContext(),Location.class ) );
            }
        } );
        btnWhatsapp=(Button)findViewById( R.id.whatsapp );
        btnWhatsapp.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity( new Intent( getApplicationContext(),WhaisAppActivity.class ) );
            }
        } );
        btnCall.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity( new Intent( getApplicationContext(),CallActivity.class ) );
            }
        } );
        btnDate=(Button)findViewById(R.id.datepicker);
        btnDate.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity( new Intent( getApplicationContext(),DateActivity.class ) );
            }
        } );
    }
}
