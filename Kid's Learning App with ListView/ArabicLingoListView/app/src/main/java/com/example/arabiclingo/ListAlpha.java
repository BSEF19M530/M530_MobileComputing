package com.example.arabiclingo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ListAlpha extends AppCompatActivity {

    ListView listAlphaLV;
    String selectedFromList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_alpha);

        listAlphaLV = (ListView)findViewById(R.id.listAlphaLV);

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("ا");
        arrayList.add("ب");
        arrayList.add("ت");
        arrayList.add("ث");
        arrayList.add("ج");
        arrayList.add("ح");
        arrayList.add("خ");
        arrayList.add("د");
        arrayList.add("ذ");
        arrayList.add("ر");
        arrayList.add("ر");
        arrayList.add("س");
        arrayList.add("ش");
        arrayList.add("ص");
        arrayList.add("ض");
        arrayList.add("ط");
        arrayList.add("ظ");
        arrayList.add("ع");
        arrayList.add("غ");
        arrayList.add("ف");
        arrayList.add("ق");
        arrayList.add("ك");
        arrayList.add("ل");
        arrayList.add("م");
        arrayList.add("ن");
        arrayList.add("و");
        arrayList.add("ه");
        arrayList.add("ء");
        arrayList.add("ي");

        ArrayAdapter arrayAdap = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList);

        listAlphaLV.setAdapter(arrayAdap);

        listAlphaLV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                selectedFromList = (String) (listAlphaLV.getItemAtPosition(i));
                launchAlphaPage(selectedFromList);
            }
        });

    }

    public void launchAlphaPage(String s)
    {
        Intent in = new Intent(this, alphaPage.class);
        in.putExtra("Alphabet", s);
        startActivity(in);
    }
}