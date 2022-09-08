package haqnawaz.org.navigationdrawer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private Context context;
    private ArrayList ArT, EngT, UrT;

    public CustomAdapter(Context context, ArrayList ArT, ArrayList EngT, ArrayList UrT)
    {
        this.context = context;
        this.ArT = ArT;
        this.EngT = EngT;
        this.UrT = UrT;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.ArTx.setText(String.valueOf(ArT.get(position)));
        holder.EnTx.setText(String.valueOf(EngT.get(position)));
        holder.UrTx.setText(String.valueOf(UrT.get(position)));
    }

    @Override
    public int getItemCount() {
        return ArT.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView ArTx, EnTx, UrTx;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ArTx = itemView.findViewById(R.id.ArabicTexttv);
            EnTx = itemView.findViewById(R.id.EngTexttv);
            UrTx = itemView.findViewById(R.id.UrduTexttv);
        }
    }

}
