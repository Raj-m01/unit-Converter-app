package com.example.unitconversion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.text.DecimalFormat;

public class TempActivity extends AppCompatActivity {



    String[] temp_units;
    Spinner temp_spnr;
    Spinner temp_spnr2;
    EditText s_temp;
    EditText s_temp2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp);

        s_temp = findViewById(R.id.s_temp);
        s_temp2 = findViewById(R.id.s_temp2);

        temp_units = getResources().getStringArray(R.array.temp);


        temp_spnr = findViewById(R.id.temp_spnr);
        ArrayAdapter<CharSequence> tadapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, temp_units);
        tadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        temp_spnr.setAdapter(tadapter);


        temp_spnr2 = findViewById(R.id.temp_spnr2);
        ArrayAdapter<CharSequence> tadapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, temp_units);
        tadapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        temp_spnr2.setAdapter(tadapter2);

    }


    public void temp_conv(View v) {

        double wvalue = Double.parseDouble(s_temp.getText().toString());
        double wsetv = 0;


        int wpos1 = temp_spnr.getSelectedItemPosition();
        int wpos2 = temp_spnr2.getSelectedItemPosition();


        //convert to --



        if (wpos1 == 0)
            wsetv = wvalue;
        else if (wpos1 == 1)
            wsetv = wvalue-273.15;
        else if (wpos1 == 2)
            wsetv = (wvalue-32)*0.55555555555;

        //convert  to desired unit--


        if (wpos2 == 0) {
            //noinspection SillyAssignment
            wsetv = wsetv;
        } else if (wpos2 == 1)
            wsetv = wsetv+273.15;
        else if (wpos2 == 2)
            wsetv = (wsetv*1.8)+32;



        DecimalFormat df = new DecimalFormat("###.######");

        s_temp2.setText(df.format(wsetv));


    }

}
