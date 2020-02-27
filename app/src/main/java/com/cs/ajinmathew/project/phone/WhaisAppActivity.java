package com.cs.ajinmathew.project.phone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class WhaisAppActivity extends AppCompatActivity {
    Button btnSend;
    EditText edMsgNumber,edMsg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_whais_app );

        edMsgNumber=(EditText)findViewById( R.id.phonenumberWhts );
        edMsg=(EditText) findViewById( R.id.message );
        btnSend=(Button)findViewById( R.id.sendmessage );
        btnSend.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mobile=edMsgNumber.getText().toString().trim();
                String mesg=edMsg.getText().toString().trim();
                Toast.makeText( getApplicationContext(),mobile+mesg,Toast.LENGTH_LONG ).show();

                Intent intent=new Intent( Intent.ACTION_VIEW );
                intent.setData( Uri.parse( "https://api.whatsapp.com/send?phone="+mobile+"&text="+mesg ) );
                startActivity( intent );


            }

        } );
    }
}
