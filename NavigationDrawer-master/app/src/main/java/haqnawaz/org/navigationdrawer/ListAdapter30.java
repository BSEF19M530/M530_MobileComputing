package haqnawaz.org.navigationdrawer;

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

public class ListAdapter30 extends ArrayAdapter<String> {

    public ListAdapter30(Context context, ArrayList<String> sal)
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
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item30,parent,false);

        }

        @SuppressLint("UseSwitchCompatOrMaterialCode")
        TextView api = convertView.findViewById(R.id.ParahIndextv);
        TextView apn = convertView.findViewById(R.id.UrParahNmtv);

        position = position + 1;

        try {
            Log.d("in", sm);
            api.setText(String.valueOf(position));
            apn.setText(sm);
        }
        catch (Exception e)
        {
            Log.d("in", "Error");
        }

        return convertView;

    }
}
