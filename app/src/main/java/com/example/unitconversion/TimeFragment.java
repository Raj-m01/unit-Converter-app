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

public class TimeFragment extends Fragment {

    String[] time_units;
    Spinner spnr1;
    Spinner spnr2;
    EditText ed1;
    EditText ed2;
    Button button;

    public TimeFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view =  inflater.inflate(R.layout.design_for_all, container, false);

        //Toast.makeText(getContext(), "time frag", Toast.LENGTH_SHORT).show();

        ed1 = view.findViewById(R.id.ed1);
        ed2 = view.findViewById(R.id.ed2);
        button = view.findViewById(R.id.button);

        time_units = getResources().getStringArray(R.array.time);


        spnr1 = view.findViewById(R.id.spnr1);
        ArrayAdapter<CharSequence> wadapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, time_units);
        wadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnr1.setAdapter(wadapter);


        spnr2 = view.findViewById(R.id.spnr2);
        ArrayAdapter<CharSequence> wadapter2 = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, time_units);
        wadapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnr2.setAdapter(wadapter2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double tvalue = Double.parseDouble(ed1.getText().toString());
                double tsetv = 0;


                int tpos1 = spnr1.getSelectedItemPosition();
                int tpos2 = spnr2.getSelectedItemPosition();


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


                if (tpos2 == 1)
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
                ed2.setText(String.valueOf(tsetv));
            }
        });

        return view;
    }
}