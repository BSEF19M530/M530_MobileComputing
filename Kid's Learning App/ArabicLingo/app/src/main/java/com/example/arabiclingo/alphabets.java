package com.example.arabiclingo;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.Button;
import android.widget.ImageView;

public class alphabets extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alphabets);
    }

    public void launchAlphaPage(View v)
    {
        Intent in = new Intent(this, alphaPage.class);

        String alphabet = (String) ((Button)v).getText();
        in.putExtra("Alphabet", alphabet);

        startActivity(in);
    }
}