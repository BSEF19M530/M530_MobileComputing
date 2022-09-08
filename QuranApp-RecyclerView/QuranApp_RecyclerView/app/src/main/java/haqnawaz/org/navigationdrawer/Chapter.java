package haqnawaz.org.navigationdrawer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

import haqnawaz.org.navigationdrawer.databinding.ActivityChapterBinding;
import haqnawaz.org.navigationdrawer.databinding.ActivitySurahBinding;

public class Chapter extends AppCompatActivity {

    ActivityChapterBinding binding;
    ListView EngChap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityChapterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent i = getIntent();
        int ChapId = i.getIntExtra("ChapId", 0);

        ChapId = ChapId + 1;

        EngChap = findViewById(R.id.EngChaplv);

        DatabaseAccess dbAccess = DatabaseAccess.getInstance(getApplicationContext());
        dbAccess.open();

        ArrayList<EnglishATModel> list = dbAccess.GetEngChap(ChapId);

        ListAdapter21 listAdapter = new ListAdapter21(this, list);

        //ArrayAdapter<StudentModel> arrayAdapter = new ArrayAdapter<StudentModel>
        //(MainActivity.this, R.layout.list_item, R.id.NameMan, list);
        binding.EngChaplv.setAdapter(listAdapter);

        dbAccess.close();
    }
}