package haqnawaz.org.navigationdrawer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

import haqnawaz.org.navigationdrawer.databinding.ActivityChapterBinding;
import haqnawaz.org.navigationdrawer.databinding.ActivitySuratBinding;

public class Surat extends AppCompatActivity {

    ActivitySuratBinding binding;
    ListView UrSurat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySuratBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent i = getIntent();
        int SuratId = i.getIntExtra("SuratId", 0);

        SuratId = SuratId + 1;

        UrSurat = findViewById(R.id.UrSuratlv);

        DatabaseAccess dbAccess = DatabaseAccess.getInstance(getApplicationContext());
        dbAccess.open();

        ArrayList<UrduATModel> list = dbAccess.GetUrduSurat(SuratId);

        ListAdapter41 listAdapter = new ListAdapter41(this, list);

        //ArrayAdapter<StudentModel> arrayAdapter = new ArrayAdapter<StudentModel>
        //(MainActivity.this, R.layout.list_item, R.id.NameMan, list);
        binding.UrSuratlv.setAdapter(listAdapter);

        dbAccess.close();
    }
}