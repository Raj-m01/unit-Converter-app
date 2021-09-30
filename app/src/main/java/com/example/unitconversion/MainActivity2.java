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




