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

public class ListAdapter3 extends ArrayAdapter<String> {

    public ListAdapter3(Context context, ArrayList<String> sal)
    {
        super(context, R.layout.list_item, sal);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @Nullable ViewGroup parent)
    {
        String sm = getItem(position);

        if(convertView == null)
        {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item3,parent,false);

        }

        @SuppressLint("UseSwitchCompatOrMaterialCode")
        TextView ap = convertView.findViewById(R.id.ArSurah);

        position = position + 1;

        try {
            Log.d("in", sm);
            //.setText(String.valueOf(position));
            ap.setText(sm);
        }
        catch (Exception e)
        {
            Log.d("in", "Error");
        }

        return convertView;

    }
}
