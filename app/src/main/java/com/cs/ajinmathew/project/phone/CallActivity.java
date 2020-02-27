package com.cs.ajinmathew.project.phone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CallActivity extends AppCompatActivity {
Button btnCall;
EditText edPhone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_call );

        edPhone=(EditText)findViewById( R.id.phonenumber );
        btnCall=(Button)findViewById( R.id.callCall );
        btnCall.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mobile=edPhone.getText().toString().trim();
                Toast.makeText( getApplicationContext(),mobile,Toast.LENGTH_LONG ).show();

                Intent intent=new Intent( Intent.ACTION_CALL );
                intent.setData( Uri.parse("tel:"+mobile) );

                if(ActivityCompat.checkSelfPermission( getApplicationContext(), Manifest.permission.CALL_PHONE )!= PackageManager.PERMISSION_GRANTED)
                {
                    return;
                }

                startActivity( intent );
            }

        } );
    }
}
