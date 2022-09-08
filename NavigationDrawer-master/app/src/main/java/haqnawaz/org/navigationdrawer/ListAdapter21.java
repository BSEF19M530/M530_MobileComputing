package haqnawaz.org.navigationdrawer;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ListAdapter21 extends ArrayAdapter<EnglishATModel> {

    public ListAdapter21(Context context, ArrayList<EnglishATModel> sal)
    {
        super(context, R.layout.list_item, sal);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @Nullable ViewGroup parent)
    {
        EnglishATModel sm = getItem(position);

        if(convertView == null)
        {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item21,parent,false);

        }

        @SuppressLint("UseSwitchCompatOrMaterialCode")
        TextView ec = convertView.findViewById(R.id.Chap);
        TextView et = convertView.findViewById(R.id.EngChap);


        position = position + 1;

        try {
            Log.d("in", sm.getAr());
            ec.setText(sm.getAr());
            et.setText(sm.getEng());
        }
        catch (Exception e)
        {
            Log.d("in", "Error");
        }

        return convertView;

    }
}
