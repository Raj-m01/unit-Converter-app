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


public class LengthFragment extends Fragment {

    String[] units;
    EditText ed1;
    EditText ed2;
    //  public String choice1;
    // public String choice2;
    Spinner spnr1;
    Spinner spnr2;
    Button button;



    public LengthFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.design_for_all, container, false);

        //Toast.makeText(getContext(), "this is length frag", Toast.LENGTH_SHORT).show();

        units = getResources().getStringArray(R.array.len);
        ed1 = view.findViewById(R.id.ed1);
        ed2 = view.findViewById(R.id.ed2);
        button = view.findViewById(R.id.button);

        spnr1 = view.findViewById(R.id.spnr1);
        ArrayAdapter<CharSequence> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, units);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnr1.setAdapter(adapter);


        spnr2 = view.findViewById(R.id.spnr2);
        ArrayAdapter<CharSequence> adapter2 = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, units);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnr2.setAdapter(adapter2);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                double value = Double.parseDouble(ed1.getText().toString());
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


                int pos1 = spnr1.getSelectedItemPosition();
                int pos2 = spnr2.getSelectedItemPosition();


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

                if (pos2 == 1)
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

                ed2.setText(String.valueOf(df.format(setv)));




            }
        });


        return view;
    }



//
//    public void Lconvert(View view) {
//
//
//    }

}