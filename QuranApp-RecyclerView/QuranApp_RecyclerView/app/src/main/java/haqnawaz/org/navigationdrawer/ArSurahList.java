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
import haqnawaz.org.navigationdrawer.databinding.ActivityArSurahListBinding;

public class ArSurahList extends AppCompatActivity {

    ActivityArSurahListBinding binding;
    ListView ArSurahlv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityArSurahListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        ArSurahlv = findViewById(R.id.ArSurahList);

        QDH qdh = new QDH();
        ArrayList<String> list = (ArrayList<String>) qdh.GetSurahNames();

        ListAdapter1 listAdapter = new ListAdapter1(this, list);

        //ArrayAdapter<StudentModel> arrayAdapter = new ArrayAdapter<StudentModel>
        //(MainActivity.this, R.layout.list_item, R.id.NameMan, list);
        binding.ArSurahList.setAdapter(listAdapter);

        ArSurahlv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //selectedFromList = (String) (ArParalv.getItemAtPosition(i));
                Log.d("in", String.valueOf(i));
                launchSurah(i);
            }
        });
    }
    public void launchSurah(int s) {
        Intent in = new Intent(this, Surah.class);
        in.putExtra("SurahId", s);
        startActivity(in);
    }
}