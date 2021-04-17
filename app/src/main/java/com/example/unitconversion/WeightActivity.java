package com.example.unitconversion;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class WeightActivity extends AppCompatActivity {


    String[] weight_units;
    Spinner weight_spnr;
    Spinner weight_spnr2;
    EditText s_weight;
    EditText s_weight2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight);

        s_weight = findViewById(R.id.s_weight);
        s_weight2 = findViewById(R.id.s_weight2);

        weight_units = getResources().getStringArray(R.array.weight);


        weight_spnr = findViewById(R.id.weight_spnr);
        ArrayAdapter<CharSequence> wadapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, weight_units);
        wadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        weight_spnr.setAdapter(wadapter);


        weight_spnr2 = findViewById(R.id.weight_spnr2);
        ArrayAdapter<CharSequence> wadapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, weight_units);
        wadapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        weight_spnr2.setAdapter(wadapter2);


    }


    public void weight_conv(View v) {

        double wvalue = Double.parseDouble(s_weight.getText().toString());
        double wsetv = 0;


        int wpos1 = weight_spnr.getSelectedItemPosition();
        int wpos2 = weight_spnr2.getSelectedItemPosition();


        //convert to kilogram--

        if (wpos1 == 0)
            wsetv = wvalue;
        else if (wpos1 == 1)
            wsetv = wvalue*0.000001;
        else if (wpos1 == 2)
            wsetv = wvalue*0.001;
        else if (wpos1 == 3)
            wsetv = wvalue*0.453592 ;
        else if (wpos1 == 4)
            wsetv = wvalue*1000;
        else if (wpos1 == 5)
            wsetv = wvalue* 0.0002;



        //convert from kg to desired unit--

        if (wpos2 == 0) {
            //noinspection SillyAssignment
            wsetv = wsetv;
        } else if (wpos2 == 1)
            wsetv = wsetv *1000000;
        else if (wpos2 == 2)
            wsetv = wsetv *1000;
        else if (wpos2 == 3)
            wsetv = wsetv *2.2046244202 ;
        else if (wpos2 == 4)
            wsetv = wsetv * 0.001;
        else if (wpos2 == 5)
            wsetv = wsetv * 5000;





        DecimalFormat df = new DecimalFormat("###.######");

        s_weight2.setText(df.format(wsetv));


    }

}