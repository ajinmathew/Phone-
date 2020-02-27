package com.cs.ajinmathew.project.phone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.niwattep.materialslidedatepicker.SlideDatePickerDialog;
import com.niwattep.materialslidedatepicker.SlideDatePickerDialogCallback;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class DateActivity extends AppCompatActivity implements SlideDatePickerDialogCallback {
TextView txtDisplayDate;
Button btnSelectDate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date);

        txtDisplayDate=(TextView)findViewById(R.id.displayDate);
        btnSelectDate=(Button)findViewById(R.id.selectDate);

        btnSelectDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SlideDatePickerDialog.Builder builder=new SlideDatePickerDialog.Builder();
                SlideDatePickerDialog dialog=builder.build();
                dialog.show(getSupportFragmentManager(),"Dialog");
            }
        });
    }

    @Override
    public void onPositiveClick(int day, int month, int year, Calendar calendar) {
        //use EEEE in pattern for impliment the day such as Sunday....
        SimpleDateFormat format=new SimpleDateFormat("dd MMM , YYYY", Locale.getDefault());
        txtDisplayDate.setText(format.format(calendar.getTime()));
    }
}
