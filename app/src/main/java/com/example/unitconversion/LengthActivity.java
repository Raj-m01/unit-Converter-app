package com.example.unitconversion;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;


public class LengthActivity extends AppCompatActivity {


    String[] units;
    EditText show_len1;
    EditText s_len2;
    //  public String choice1;
    // public String choice2;
    Spinner len_spnr;
    Spinner len_spnr2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_length);

        units = getResources().getStringArray(R.array.len);
        show_len1 = findViewById(R.id.show_len1);

        s_len2 = findViewById(R.id.s_len2);



        len_spnr = findViewById(R.id.len_spnr);
        ArrayAdapter<CharSequence> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, units);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        len_spnr.setAdapter(adapter);


        len_spnr2 = findViewById(R.id.len_spnr2);
        ArrayAdapter<CharSequence> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, units);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        len_spnr2.setAdapter(adapter2);


    }

    public void Lconvert(View view) {

        double value = Double.parseDouble(show_len1.getText().toString());
        double setv = 0;


//        int b = 0;
//        if(choice1 == "meter" && choice2 == "meter"){
//
//            b = a*2;
//            show_len2.setText(String.valueOf(b));
//        } else {
//            if (choice1 == "meter" && choice2 == "centimeter") {
//
//                b = a * 3;
//                show_len2.setText(String.valueOf(b));
//            }
//        }


        int pos1 = len_spnr.getSelectedItemPosition();
        int pos2 = len_spnr2.getSelectedItemPosition();


        // Convert value to meter --

        if (pos1 == 0)
            setv = value;
        else if (pos1 == 1)
            setv = value / 100;
        else if (pos1 == 2)
            setv = value * 1000;
        else if (pos1 == 3)
            setv = value * 0.9144;
        else if (pos1 == 4)
            setv = value * 0.3048;
        else if (pos1 == 5)
            setv = value * 0.0254;
        else if (pos1 == 6)
            setv = value * 1609.35;
        else if (pos1 == 7)
            setv = value * 0.001;


        // Convert meter to desired unit --

        if (pos2 == 0) {
            //noinspection SillyAssignment
            setv = setv;
        } else if (pos2 == 1)
            setv = setv * 100;
        else if (pos2 == 2)
            setv = setv / 1000;
        else if (pos2 == 3)
            setv = setv * 1.0936132983;
        else if (pos2 == 4)
            setv = setv * 3.280839895;
        else if (pos2 == 5)
            setv = setv * 39.37007874;
        else if (pos2 == 6)
            setv = setv * 0.0006213689;
        else if (pos2 == 7)
            setv = setv * 1000;


        DecimalFormat df = new DecimalFormat("###.######");

        s_len2.setText(String.valueOf(df.format(setv)));


    }

}
