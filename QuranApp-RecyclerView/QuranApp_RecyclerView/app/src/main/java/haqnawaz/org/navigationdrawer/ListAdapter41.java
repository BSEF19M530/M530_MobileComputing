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

    public class ListAdapter41 extends ArrayAdapter<UrduATModel> {

    public ListAdapter41(Context context, ArrayList<UrduATModel> sal)
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
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item41,parent,false);

        }

        @SuppressLint("UseSwitchCompatOrMaterialCode")
        TextView ec = convertView.findViewById(R.id.Surat);
        TextView et = convertView.findViewById(R.id.UrSurat);


        position = position + 1;

        try {
            Log.d("in", sm.getAr());
            ec.setText(sm.getAr());
            et.setText(sm.getUr());
        }
        catch (Exception e)
        {
            Log.d("in", "Error");
        }

        return convertView;

    }
}
