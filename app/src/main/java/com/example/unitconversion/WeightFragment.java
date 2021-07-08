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


public class WeightFragment extends Fragment {

    String[] weight_units;
    Spinner spnr1;
    Spinner spnr2;
    EditText ed1;
    EditText ed2;
    Button button;

    public WeightFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.design_for_all, container, false);

        //Toast.makeText(getContext(), "weight frag", Toast.LENGTH_SHORT).show();

        ed1 = view.findViewById(R.id.ed1);
        ed2 = view.findViewById(R.id.ed2);
        button = view.findViewById(R.id.button);

        weight_units = getResources().getStringArray(R.array.weight);


        spnr1 = view.findViewById(R.id.spnr1);
        ArrayAdapter<CharSequence> wadapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, weight_units);
        wadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnr1.setAdapter(wadapter);


        spnr2 = view.findViewById(R.id.spnr2);
        ArrayAdapter<CharSequence> wadapter2 = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, weight_units);
        wadapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnr2.setAdapter(wadapter2);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double wvalue = Double.parseDouble(ed1.getText().toString());
                double wsetv = 0;


                int wpos1 = spnr1.getSelectedItemPosition();
                int wpos2 = spnr2.getSelectedItemPosition();


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

                if (wpos2 == 1)
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

                ed2.setText(df.format(wsetv));


            }
        });


return view;
    }
}