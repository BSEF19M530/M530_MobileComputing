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

public class ListAdapter40 extends ArrayAdapter<UrduATModel> {

    public ListAdapter40(Context context, ArrayList<UrduATModel> sal)
    {
        super(context, R.layout.list_item, sal);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @Nullable ViewGroup parent)
    {
        UrduATModel sm = getItem(position);

        if(convertView == null)
        {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item40,parent,false);

        }

        @SuppressLint("UseSwitchCompatOrMaterialCode")
        TextView ep = convertView.findViewById(R.id.Parah);
        TextView et = convertView.findViewById(R.id.UrduParah);


        position = position + 1;

        try {
            Log.d("in", sm.getAr());
            ep.setText(sm.getAr());
            et.setText(sm.getUr());
        }
        catch (Exception e)
        {
            Log.d("in", "Error");
        }

        return convertView;

    }
}
