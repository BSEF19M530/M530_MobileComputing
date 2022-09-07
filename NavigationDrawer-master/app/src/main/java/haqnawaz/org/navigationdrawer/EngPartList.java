package haqnawaz.org.navigationdrawer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import haqnawaz.org.navigationdrawer.databinding.ActivityArParaListBinding;
import haqnawaz.org.navigationdrawer.databinding.ActivityEngPartListBinding;

public class EngPartList extends AppCompatActivity {

    ActivityEngPartListBinding binding;
    ListView EngPartlv;
    String selectedFromList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEngPartListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        EngPartlv = findViewById(R.id.EngPartList);

        QDH qdh = new QDH();
        ArrayList<String> list = (ArrayList<String>) qdh.GetPartNames();

        ListAdapter10 listAdapter = new ListAdapter10(this, list);

        //ArrayAdapter<StudentModel> arrayAdapter = new ArrayAdapter<StudentModel>
        //(MainActivity.this, R.layout.list_item, R.id.NameMan, list);
        binding.EngPartList.setAdapter(listAdapter);

        EngPartlv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //selectedFromList = (String) (ArParalv.getItemAtPosition(i));
                Log.d("in", String.valueOf(i));
                launchPart(i);
            }
        });
    }

    public void launchPart(int s) {
        Intent in = new Intent(this, Para.class);
        in.putExtra("PartId", s);
        startActivity(in);
    }
}