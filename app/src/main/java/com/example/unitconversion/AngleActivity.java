package com.example.unitconversion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.text.DecimalFormat;

public class AngleActivity extends AppCompatActivity {


    String[] angle_units;
    Spinner angle_spnr;
    Spinner angle_spnr2;
    EditText s_angle;
    EditText s_angle2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_angle);



        s_angle = findViewById(R.id.s_angle);
        s_angle2 = findViewById(R.id.s_angle2);

        angle_units = getResources().getStringArray(R.array.angle);


        angle_spnr = findViewById(R.id.angle_spnr);
        ArrayAdapter<CharSequence> wadapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, angle_units);
        wadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        angle_spnr.setAdapter(wadapter);


        angle_spnr2 = findViewById(R.id.angle_spnr2);
        ArrayAdapter<CharSequence> wadapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, angle_units);
        wadapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        angle_spnr2.setAdapter(wadapter2);


    }

    public void angle_conv(View v) {

        double avalue = Double.parseDouble(s_angle.getText().toString());
        double asetv = 0;


        int apos1 = angle_spnr.getSelectedItemPosition();
        int apos2 = angle_spnr2.getSelectedItemPosition();


        //convert to degree

        if (apos1 == 0)
            asetv = avalue;
        else if (apos1 == 1)
            asetv = avalue*57.295779513082;
        else if (apos1 == 2)
            asetv = avalue*0.016666666666667;
        else if (apos1 == 3)
            asetv = avalue*0.00027777777777778;
        else if (apos1 == 4)
            asetv = avalue*30;
        else if (apos1 == 5)
            asetv = avalue*45;
        else if (apos1 == 6)
            asetv = avalue*60;
        else if (apos1 == 7)
            asetv = avalue*90;
        else if (apos1 == 8)
            asetv = avalue*360;
        else if (apos1 == 9)
            asetv = avalue*0.9;
        else if (apos1 == 10)
            asetv = avalue*0.05625;

    //convert from degree to desired unit ---

        if (apos2 == 0)
            asetv = asetv;
        else if (apos2 == 1)
            asetv = asetv*0.017453292519943;
        else if (apos2 == 2)
            asetv = asetv*60;
        else if (apos2 == 3)
            asetv = asetv*3600;
        else if (apos2 == 4)
            asetv = asetv*0.033333333333333;
        else if (apos2 == 5)
            asetv = asetv*0.022222222222222;
        else if (apos2 == 6)
            asetv = asetv*0.016666666666667;
        else if (apos2 == 7)
            asetv = asetv*0.011111111111111;
        else if (apos2 == 8)
            asetv = asetv*0.0027777777777778;
        else if (apos2 == 9)
            asetv = asetv*1.1111111111111;
        else if (apos2 == 10)
            asetv = asetv*17.777777777778;




        //DecimalFormat df = new DecimalFormat("###.######");

        //s_angle2.setText(df.format(asetv));

        s_angle2.setText(String.valueOf(asetv));

    }

}