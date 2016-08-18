package com.udacity.androidjokeslibrary;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class JokesActivity extends AppCompatActivity {

    public static final String INTENT_JOKE = "Jokes";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jokes);
        Toast.makeText(this, getIntent().getStringExtra(INTENT_JOKE), Toast.LENGTH_SHORT).show();
    }


}
//11125