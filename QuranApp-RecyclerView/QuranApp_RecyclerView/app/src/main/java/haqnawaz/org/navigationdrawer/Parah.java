package haqnawaz.org.navigationdrawer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

import haqnawaz.org.navigationdrawer.databinding.ActivityParahBinding;
import haqnawaz.org.navigationdrawer.databinding.ActivityPartBinding;

public class Parah extends AppCompatActivity {

    ActivityParahBinding binding;
    ListView Parah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityParahBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent i = getIntent();
        int ParahId = i.getIntExtra("ParahId", 0);

        ParahId = ParahId + 1;

        Parah = findViewById(R.id.Parahlv);

        DatabaseAccess dbAccess = DatabaseAccess.getInstance(getApplicationContext());
        dbAccess.open();

        ArrayList<UrduATModel> list = dbAccess.GetUrduParah(ParahId);

        ListAdapter40 listAdapter = new ListAdapter40(this, list);

        //ArrayAdapter<StudentModel> arrayAdapter = new ArrayAdapter<StudentModel>
        //(MainActivity.this, R.layout.list_item, R.id.NameMan, list);
        binding.Parahlv.setAdapter(listAdapter);

        dbAccess.close();
    }
}