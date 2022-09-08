package haqnawaz.org.navigationdrawer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import haqnawaz.org.navigationdrawer.databinding.ActivityArSurahListBinding;
import haqnawaz.org.navigationdrawer.databinding.ActivityEngChapListBinding;

public class EngChapList extends AppCompatActivity {

    ActivityEngChapListBinding binding;
    ListView EngChaplv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEngChapListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        EngChaplv = findViewById(R.id.EngChapList);

        QDH qdh = new QDH();
        ArrayList<String> list = (ArrayList<String>) qdh.GetChapterNames();

        ListAdapter11 listAdapter = new ListAdapter11(this, list);

        //ArrayAdapter<StudentModel> arrayAdapter = new ArrayAdapter<StudentModel>
        //(MainActivity.this, R.layout.list_item, R.id.NameMan, list);
        binding.EngChapList.setAdapter(listAdapter);

        EngChaplv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //selectedFromList = (String) (ArParalv.getItemAtPosition(i));
                Log.d("in", String.valueOf(i));
                launchChapter(i);
            }
        });
    }
    public void launchChapter(int s) {
        Intent in = new Intent(this, Chapter.class);
        in.putExtra("ChapId", s);
        startActivity(in);
    }
}