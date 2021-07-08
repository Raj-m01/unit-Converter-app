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

import java.text.DecimalFormat;

public class TempFragment extends Fragment {

    String[] temp_units;
    Spinner spnr1;
    Spinner spnr2;
    EditText ed1;
    EditText ed2;
    Button button;

    public TempFragment() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.design_for_all, container, false);

        //Toast.makeText(getContext(), "temp frag", Toast.LENGTH_SHORT).show();

        ed1 = view.findViewById(R.id.ed1);
        ed2 = view.findViewById(R.id.ed2);
        button = view.findViewById(R.id.button);

        temp_units = getResources().getStringArray(R.array.temp);


        spnr1 = view.findViewById(R.id.spnr1);
        ArrayAdapter<CharSequence> wadapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, temp_units);
        wadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnr1.setAdapter(wadapter);


        spnr2 = view.findViewById(R.id.spnr2);
        ArrayAdapter<CharSequence> wadapter2 = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, temp_units);
        wadapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnr2.setAdapter(wadapter2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                double wvalue = Double.parseDouble(ed1.getText().toString());
                double wsetv = 0;


                int wpos1 = spnr1.getSelectedItemPosition();
                int wpos2 = spnr2.getSelectedItemPosition();


                //convert to --



                if (wpos1 == 0)
                    wsetv = wvalue;
                else if (wpos1 == 1)
                    wsetv = wvalue-273.15;
                else if (wpos1 == 2)
                    wsetv = (wvalue-32)*0.55555555555;

                //convert  to desired unit--


               if (wpos2 == 1)
                    wsetv = wsetv+273.15;
                else if (wpos2 == 2)
                    wsetv = (wsetv*1.8)+32;



                DecimalFormat df = new DecimalFormat("###.######");

                ed2.setText(df.format(wsetv));
            }
        });


                return view;
    }
}