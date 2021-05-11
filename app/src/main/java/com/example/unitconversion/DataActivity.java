package com.example.unitconversion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.text.DecimalFormat;

public class DataActivity extends AppCompatActivity {


    String[] data_units;
    Spinner data_spnr;
    Spinner data_spnr2;
    EditText s_data;
    EditText s_data2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);


        s_data = findViewById(R.id.s_data);
        s_data2 = findViewById(R.id.s_data2);

       data_units = getResources().getStringArray(R.array.data);


        data_spnr = findViewById(R.id.data_spnr);
        ArrayAdapter<CharSequence> dadapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,data_units);
        dadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        data_spnr.setAdapter(dadapter);


        data_spnr2 = findViewById(R.id.data_spnr2);
        ArrayAdapter<CharSequence> dadapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, data_units);
        dadapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        data_spnr2.setAdapter(dadapter2);


    }


    public void data_conv(View v) {

        double wvalue = Double.parseDouble(s_data.getText().toString());
        double wsetv = 0;


        int wpos1 = data_spnr.getSelectedItemPosition();
        int wpos2 = data_spnr2.getSelectedItemPosition();


        //convert to --

        if (wpos1 == 0)
            wsetv = wvalue;
        else if (wpos1 == 1)
            wsetv = wvalue*9.5367431640625E-7;
        else if (wpos1 == 2)
            wsetv = wvalue*0.0009765625;
        else if (wpos1 == 3)
            wsetv = wvalue*1024 ;
        else if (wpos1 == 4)
            wsetv = wvalue*1048576;
        else if (wpos1 == 5)
            wsetv = wvalue*1073741824;
        else if (wpos1 == 6)
            wsetv = wvalue*1099511627776.0;
        else if (wpos1 == 7)
            wsetv = wvalue*3.814697265625E-6;
        else if (wpos1 == 8)
            wsetv = wvalue*7.62939453125E-6 ;
        else if (wpos1 == 9)
            wsetv = wvalue*0.0078125 ;
        else if (wpos1 == 10)
            wsetv = wvalue*8 ;
        else if (wpos1 == 11)
            wsetv = wvalue*8192;
        else if (wpos1 == 12)
            wsetv = wvalue*8388608;
        else if (wpos1 == 13)
            wsetv = wvalue*8589934592.0;
        else if (wpos1 == 14)
            wsetv = wvalue*8796093022208.0;



        //convert from kg to desired unit--

        if (wpos2 == 0) {
            //noinspection SillyAssignment
            wsetv = wsetv;
        } else if (wpos2 == 1)
            wsetv = wsetv *1048576;
        else if (wpos2 == 2)
            wsetv = wsetv *1024;
        else if (wpos2 == 3)
            wsetv = wsetv *0.0009765625;
        else if (wpos2 == 4)
            wsetv = wsetv *9.5367431640625E-7 ;
        else if (wpos2 == 5)
            wsetv = wsetv *9.3132257461548E-10;
        else if (wpos2 == 6)
            wsetv = wsetv *9.0949470177293E-13;
        else if (wpos2 == 7)
            wsetv = wsetv *262144;
        else if (wpos2 == 8)
            wsetv = wsetv * 131072;
        else if (wpos2 == 9)
            wsetv = wsetv *128;
        else if (wpos2 == 10)
            wsetv = wsetv *0.125 ;
        else if (wpos2 == 11)
            wsetv = wsetv *0.0001220703125 ;
        else if (wpos2 == 12)
            wsetv = wsetv *1.1920928955078E-7;
        else if (wpos2 == 13)
            wsetv = wsetv *1.1641532182694E-10;
        else if (wpos2 == 14)
            wsetv = wsetv *1.1368683772162E-13;







        s_data2.setText(String.valueOf(wsetv));


    }

}