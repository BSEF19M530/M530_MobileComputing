package haqnawaz.org.navigationdrawer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import haqnawaz.org.navigationdrawer.databinding.ActivityArParaListBinding;
import haqnawaz.org.navigationdrawer.databinding.ActivityArSurahListBinding;
import haqnawaz.org.navigationdrawer.databinding.ActivityParaBinding;

public class Para extends AppCompatActivity {

    ActivityParaBinding binding;
    RecyclerView rv;

    DatabaseAccess dbAccess;
    ArrayList<String> ArabicText, EngText, UrduText;
    CustomAdapter ca;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityParaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent i = getIntent();
        int ParaId = i.getIntExtra("ParaId", 0);

        ParaId = ParaId + 1;

        rv = findViewById(R.id.rv);

        dbAccess = DatabaseAccess.getInstance(getApplicationContext());

        dbAccess.open();

        ArabicText = new ArrayList<>();
        EngText = new ArrayList<>();
        UrduText = new ArrayList<>();

        //ArrayList<String> list = dbAccess.GetPara(ParaId);

        //ListAdapter2 listAdapter = new ListAdapter2(this, list);

        //ArrayAdapter<StudentModel> arrayAdapter = new ArrayAdapter<StudentModel>
        //(MainActivity.this, R.layout.list_item, R.id.NameMan, list);
        //binding.ArParalv.setAdapter(listAdapter);

        storeDataInArrays(ParaId);

        Log.d("in", "hello");
        ca = new CustomAdapter(this, ArabicText, EngText, UrduText);
        Log.d("in", ca.toString());
        binding.rv.setAdapter(ca);
        binding.rv.setLayoutManager(new LinearLayoutManager(Para.this));

        dbAccess.close();
    }

    void storeDataInArrays(int pId)
    {
        Cursor c = dbAccess.readParaforRV(pId);
        if(c.getCount() == 0)
        {
            Toast.makeText(this, "No Data", Toast.LENGTH_SHORT).show();
        }
        else
        {
            while(c.moveToNext())
            {
                ArabicText.add(c.getString(0));
                EngText.add(c.getString(1));
                UrduText.add(c.getString(2));
            }
        }
    }
}