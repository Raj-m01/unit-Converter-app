package com.example.unitconversion;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }


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

}


