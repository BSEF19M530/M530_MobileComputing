package haqnawaz.org.navigationdrawer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class UrduActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_urdu);
    }
    public void listParah(View v)
    {
        Intent intent = new Intent(this, UrduParahList.class);
        startActivity(intent);
    }
    public void listSurat(View v)
    {
        Intent intent = new Intent(this, UrduSuratList.class);
        startActivity(intent);
    }
}