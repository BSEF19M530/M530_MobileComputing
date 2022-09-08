package haqnawaz.org.navigationdrawer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import haqnawaz.org.navigationdrawer.databinding.ActivityEngPartListBinding;
import haqnawaz.org.navigationdrawer.databinding.ActivityUrduParahListBinding;

public class UrduParahList extends AppCompatActivity {

    ActivityUrduParahListBinding binding;
    ListView UrduParahlv;
    String selectedFromList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUrduParahListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        UrduParahlv = findViewById(R.id.UrParahList);

        QDH qdh = new QDH();
        ArrayList<String> list = (ArrayList<String>) qdh.GetParaNames();

        ListAdapter30 listAdapter = new ListAdapter30(this, list);

        //ArrayAdapter<StudentModel> arrayAdapter = new ArrayAdapter<StudentModel>
        //(MainActivity.this, R.layout.list_item, R.id.NameMan, list);
        binding.UrParahList.setAdapter(listAdapter);

        UrduParahlv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.d("in", String.valueOf(i));
                launchParah(i);
            }
        });
    }

    public void launchParah(int s) {
        Intent in = new Intent(this, Parah.class);
        in.putExtra("ParahId", s);
        startActivity(in);
    }
}