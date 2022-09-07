package haqnawaz.org.navigationdrawer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class EnglishActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_english);
    }
    public void listPart(View v)
    {
        Intent intent = new Intent(this, EngPartList.class);
        startActivity(intent);
    }
    public void listChapter(View v)
    {
        Intent intent = new Intent(this, EngChapList.class);
        startActivity(intent);
    }
}