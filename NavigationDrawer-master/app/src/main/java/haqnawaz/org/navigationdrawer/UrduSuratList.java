package haqnawaz.org.navigationdrawer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import haqnawaz.org.navigationdrawer.databinding.ActivityEngChapListBinding;
import haqnawaz.org.navigationdrawer.databinding.ActivityUrduSuratListBinding;

public class UrduSuratList extends AppCompatActivity {

    ActivityUrduSuratListBinding binding;
    ListView UrSuratlv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUrduSuratListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        UrSuratlv = findViewById(R.id.UrSuratList);

        QDH qdh = new QDH();
        ArrayList<String> list = (ArrayList<String>) qdh.GetSurahNames();

        ListAdapter31 listAdapter = new ListAdapter31(this, list);

        //ArrayAdapter<StudentModel> arrayAdapter = new ArrayAdapter<StudentModel>
        //(MainActivity.this, R.layout.list_item, R.id.NameMan, list);
        binding.UrSuratList.setAdapter(listAdapter);

        UrSuratlv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //selectedFromList = (String) (ArParalv.getItemAtPosition(i));
                Log.d("in", String.valueOf(i));
                launchSurat(i);
            }
        });
    }
    public void launchSurat(int s) {
        Intent in = new Intent(this, Surat.class);
        in.putExtra("SuratId", s);
        startActivity(in);
    }
}