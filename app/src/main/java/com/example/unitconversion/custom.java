package com.example.unitconversion;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class custom extends ArrayAdapter<unitModel> {
    public custom(@NonNull Context context, int resource, @NonNull ArrayList<unitModel> units ) {
        super(context, 0, units);
    }



    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list, parent, false);
        }


        unitModel uname = getItem(position);

        TextView nameTextView = (TextView) listItemView.findViewById(R.id.u1);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        nameTextView.setText(uname.giveUnit());


        return listItemView;
       // return super.getView(position, convertView, parent);



    }
}
