package haqnawaz.org.navigationdrawer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

import haqnawaz.org.navigationdrawer.databinding.ActivityParaBinding;
import haqnawaz.org.navigationdrawer.databinding.ActivitySurahBinding;

public class Surah extends AppCompatActivity {

    ActivitySurahBinding binding;
    ListView ArSurah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySurahBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent i = getIntent();
        int SurahId = i.getIntExtra("SurahId", 0);

        SurahId = SurahId + 1;

        ArSurah = findViewById(R.id.ArSurahlv);

        DatabaseAccess dbAccess = DatabaseAccess.getInstance(getApplicationContext());
        dbAccess.open();

        ArrayList<String> list = dbAccess.GetSurah(SurahId);

        ListAdapter3 listAdapter = new ListAdapter3(this, list);

        //ArrayAdapter<StudentModel> arrayAdapter = new ArrayAdapter<StudentModel>
        //(MainActivity.this, R.layout.list_item, R.id.NameMan, list);
        binding.ArSurahlv.setAdapter(listAdapter);

        dbAccess.close();
    }
}