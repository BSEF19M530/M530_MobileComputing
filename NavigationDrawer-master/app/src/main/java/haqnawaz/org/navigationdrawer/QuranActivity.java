package haqnawaz.org.navigationdrawer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class QuranActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quran);
    }
    public void listPara(View v)
    {
        Intent intent = new Intent(this, ArParaList.class);
        startActivity(intent);
    }
    public void listSurah(View v)
    {
        Intent intent = new Intent(this, ArSurahList.class);
        startActivity(intent);
    }

}