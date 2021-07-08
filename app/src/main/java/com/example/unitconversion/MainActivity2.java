package com.example.unitconversion;


import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    String[] unitName = {"Length","Weight","Time","Temp","Angle","Data"};

    private ViewPager2 viewpager;
    private FragmentStateAdapter fragmentStateAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        getSupportActionBar().setElevation(0);

        TabLayout tabLayout = findViewById(R.id.tabLayout);
        viewpager = findViewById(R.id.viewpager);
        fragmentStateAdapter = new PageAdapter(getSupportFragmentManager(),getLifecycle());
        viewpager.setAdapter(fragmentStateAdapter);


        new TabLayoutMediator(tabLayout,viewpager,(tab, position) ->tab.setText(unitName[position]) ).attach();


    }
    public void onBackPressed() {
        if (viewpager.getCurrentItem() == 0) {
            super.onBackPressed();
        }
        else {
            viewpager.setCurrentItem(0);
        }
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




