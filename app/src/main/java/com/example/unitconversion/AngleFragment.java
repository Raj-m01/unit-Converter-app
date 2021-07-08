package com.example.unitconversion;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class AngleFragment extends Fragment {

    String[] angle_units;
    Spinner spnr1;
    Spinner spnr2;
    EditText ed1;
    EditText ed2;
    Button button;

    public AngleFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.design_for_all, container, false);

        //Toast.makeText(getContext(), "angle frag", Toast.LENGTH_SHORT).show();

        ed1 = view.findViewById(R.id.ed1);
        ed2 = view.findViewById(R.id.ed2);
        button = view.findViewById(R.id.button);

        angle_units = getResources().getStringArray(R.array.angle);


        spnr1 = view.findViewById(R.id.spnr1);
        ArrayAdapter<CharSequence> wadapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, angle_units);
        wadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnr1.setAdapter(wadapter);


        spnr2 = view.findViewById(R.id.spnr2);
        ArrayAdapter<CharSequence> wadapter2 = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, angle_units);
        wadapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnr2.setAdapter(wadapter2);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                double avalue = Double.parseDouble(ed1.getText().toString());
                double asetv = 0;


                int apos1 = spnr1.getSelectedItemPosition();
                int apos2 = spnr2.getSelectedItemPosition();


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

                if (apos2 == 1)
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

                ed2.setText(String.valueOf(asetv));

        }
    });

        return view;

    }
}