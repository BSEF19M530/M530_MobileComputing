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

public class ArParaList extends AppCompatActivity {

    ActivityArParaListBinding binding;
    ListView ArParalv;
    String selectedFromList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityArParaListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArParalv = findViewById(R.id.ArParaList);

        QDH qdh = new QDH();
        ArrayList<String> list = (ArrayList<String>) qdh.GetParaNames();

        ListAdapter listAdapter = new ListAdapter(this, list);

        //ArrayAdapter<StudentModel> arrayAdapter = new ArrayAdapter<StudentModel>
        //(MainActivity.this, R.layout.list_item, R.id.NameMan, list);
        binding.ArParaList.setAdapter(listAdapter);

        ArParalv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //selectedFromList = (String) (ArParalv.getItemAtPosition(i));
                Log.d("in", String.valueOf(i));
                launchPara(i);
            }
        });
    }

    public void launchPara(int s) {
        Intent in = new Intent(this, Para.class);
        in.putExtra("ParaId", s);
        startActivity(in);
    }
}
