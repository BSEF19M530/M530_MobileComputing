package com.example.dbandcustomlistview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Switch;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ListAdapter extends ArrayAdapter<StudentModel> {

    public ListAdapter(Context context, ArrayList<StudentModel> sal)
    {
        super(context, R.layout.list_item, sal);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @Nullable ViewGroup parent)
    {
        StudentModel sm = getItem(position);

        if(convertView == null)
        {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);

        }

        @SuppressLint("UseSwitchCompatOrMaterialCode")
        Switch s = convertView.findViewById(R.id.switchMan);
        TextView sName = convertView.findViewById(R.id.NameMan);
        TextView rn = convertView.findViewById(R.id.RollNumMan);

        Log.d("in", sm.getName());
        try {
            s.setChecked(sm.isEnroll());
            sName.setText(sm.getName());
            rn.setText(String.valueOf(sm.getRollNmber()));
        }
        catch (Exception e)
        {
            Log.d("in", "Error");
        }

        return convertView;

    }
}
