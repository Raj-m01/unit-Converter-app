package com.example.unitconversion;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        ArrayList<unitModel> units = new ArrayList<>(10);
                //{"length","Weight","time","Temperature","Angle","Data"};

        units.add(new unitModel("LENGTH"));
        units.add(new unitModel("WEIGHT"));
        units.add(new unitModel("TIME"));
        units.add(new unitModel("TEMPERATURE"));
        units.add(new unitModel("ANGLE"));
        units.add(new unitModel("DATA"));




        custom Units = new custom(this,0, units);

        GridView  Grid = (GridView)findViewById(R.id.smp);

        Grid.setAdapter(Units);

Grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        final Intent i;
        switch (position) {
            case 0:   i = new Intent(view.getContext(), LengthActivity.class);
                break;
            case 1:   i = new Intent(view.getContext(), WeightActivity.class);
                break;
            case 2:   i = new Intent(view.getContext(), TimeActivity.class);
                break;
            case 3:   i = new Intent(view.getContext(), TempActivity.class);
                break;
            case 4:   i = new Intent(view.getContext(), AngleActivity.class);
                break;
            case 5:   i = new Intent(view.getContext(), DataActivity.class);
                break;
            default:  i = new Intent(view.getContext(), MainActivity2.class);




        }startActivity(i);

    }
}) ;

    }


}








/*
    public void length_page(View view) {

        Button len_button = (Button) findViewById(R.id.len_button);

        Intent i = new Intent(this, LengthActivity.class);


        startActivity(i);


    }


    public void weight_page(View view) {

        Button weight_button = (Button) findViewById(R.id.weight_button);

        Intent i2 = new Intent(this, WeightActivity.class);


        startActivity(i2);


    }


    public void time_page(View view) {

        Button time_button = (Button) findViewById(R.id.time_button);

        Intent i3 = new Intent(this, TimeActivity.class);


        startActivity(i3);


    }

    public void temp_page(View view) {

        Button temp_button = (Button) findViewById(R.id.temp_button);

        Intent i4 = new Intent(this, TempActivity.class);


        startActivity(i4);


    }

    public void ang_page(View view) {

        Button ang_button = (Button) findViewById(R.id.ang_button);

        Intent i5 = new Intent(this, AngleActivity.class);


        startActivity(i5);


    }

    public void data_page(View view) {

        Button data_button = (Button) findViewById(R.id.data_button);

        Intent i6 = new Intent(this, DataActivity.class);


        startActivity(i6);


    }
 */




