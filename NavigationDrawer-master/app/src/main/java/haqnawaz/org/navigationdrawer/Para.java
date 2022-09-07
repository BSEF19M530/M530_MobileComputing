package haqnawaz.org.navigationdrawer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

import haqnawaz.org.navigationdrawer.databinding.ActivityArParaListBinding;
import haqnawaz.org.navigationdrawer.databinding.ActivityParaBinding;

public class Para extends AppCompatActivity {

    ActivityParaBinding binding;
    ListView ArPara;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityParaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent i = getIntent();
        int ParaId = i.getIntExtra("ParaId", 0);

        ParaId = ParaId + 1;

        ArPara = findViewById(R.id.ArParalv);

        DatabaseAccess dbAccess = DatabaseAccess.getInstance(getApplicationContext());
        dbAccess.open();

        ArrayList<String> list = dbAccess.GetPara(ParaId);

        ListAdapter2 listAdapter = new ListAdapter2(this, list);

        //ArrayAdapter<StudentModel> arrayAdapter = new ArrayAdapter<StudentModel>
        //(MainActivity.this, R.layout.list_item, R.id.NameMan, list);
        binding.ArParalv.setAdapter(listAdapter);

        dbAccess.close();
    }
}