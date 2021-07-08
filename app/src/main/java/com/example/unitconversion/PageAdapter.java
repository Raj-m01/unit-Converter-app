package com.example.unitconversion;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class PageAdapter extends FragmentStateAdapter {


    public PageAdapter( FragmentManager fragmentManager, Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @Override
    public Fragment createFragment(int position) {


        if(position==0) return new LengthFragment();
        else if(position==1) return new WeightFragment();
        else if(position==2) return new TimeFragment();
        else if(position==3) return new TempFragment();
        else if(position==4) return new AngleFragment();
        else return new DataFragment();


//        switch (position) {
//
//            case 0: return new LengthFragment();
//            case 1: return new WeightFragment();
//            case 2: return new TimeFragment();
//            case 3: return new TempFragment();
//            case 4: return new AngleFragment();
//            case 5: return new DataFragment();
//
//
//        }
    }

    @Override
    public int getItemCount() {
        return 6;
    }
}
