package com.example.unitconversion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

//import java.text.DecimalFormat;

public class TimeActivity extends AppCompatActivity {


    String[] time_units;
    Spinner time_spnr;
    Spinner time_spnr2;
    EditText s_time;
    EditText s_time2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);

        s_time = findViewById(R.id.s_time);
        s_time2 = findViewById(R.id.s_time2);

        time_units = getResources().getStringArray(R.array.time);


        time_spnr = findViewById(R.id.time_spnr);
        ArrayAdapter<CharSequence> tadapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, time_units);
        tadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        time_spnr.setAdapter(tadapter);


        time_spnr2 = findViewById(R.id.time_spnr2);
        ArrayAdapter<CharSequence> tadapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, time_units);
        tadapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        time_spnr2.setAdapter(tadapter2);


    }


    public void time_conv(View v) {

        double tvalue = Double.parseDouble(s_time.getText().toString());
        double tsetv = 0;


        int tpos1 = time_spnr.getSelectedItemPosition();
        int tpos2 = time_spnr2.getSelectedItemPosition();


        //convert to kilogram--

        if (tpos1 == 0)
            tsetv = tvalue;
        else if (tpos1 == 1)
           tsetv = tvalue*0.0166666667;
        else if (tpos1 == 2)
            tsetv = tvalue* 0.0000166667;
        else if (tpos1 == 3)
            tsetv = tvalue*1.666666666E-8 ;
        else if (tpos1 == 4)
            tsetv = tvalue*1.666666666E-11;
        else if (tpos1 == 5)
           tsetv = tvalue*60;
        else if (tpos1 == 6)
            tsetv = tvalue*1440;
        else if (tpos1 == 7)
            tsetv = tvalue*10080;
        else if (tpos1 == 8)
            tsetv = tvalue*43830;
        else if (tpos1 == 9)
            tsetv = tvalue*525960 ;


        //convert from kg to desired unit--


        if (tpos2 == 0) {
            //noinspection SillyAssignment
            tsetv = tsetv;
        } else if (tpos2 == 1)
            tsetv = tsetv *60;
        else if (tpos2 == 2)
            tsetv = tsetv *60000 ;
        else if (tpos2 == 3)
            tsetv = tsetv *60000000 ;
        else if (tpos2 == 4)
            tsetv = tsetv * 60000000000.0;
        else if (tpos2 == 5)
           tsetv = tsetv *0.0166666667;
        else if (tpos2 == 6)
            tsetv = tsetv *0.0006944444;
        else if (tpos2 == 7)
            tsetv = tsetv *0.0000992063 ;
        else if (tpos2 == 8)
            tsetv = tsetv *0.0000228154;
        else if (tpos2 == 9)
            tsetv = tsetv * 0.0000019013;



        //DecimalFormat df = new DecimalFormat("###.######");

        //s_time2.setText(df.format(tsetv));
        s_time2.setText(String.valueOf(tsetv));



    }

}