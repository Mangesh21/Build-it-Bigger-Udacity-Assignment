package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.udacity.androidjokeslibrary.JokesActivity;


public class MainActivity extends AppCompatActivity implements Callback {


    private ProgressBar spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = (ProgressBar) findViewById(R.id.progressBar1);
        spinner.setVisibility(View.GONE);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view) {
        spinner.setVisibility(View.VISIBLE);
        new EndPointAsyncTask(MainActivity.this).execute();
    }


    @Override
    public void onComplete(String result, Exception e) {
        spinner.setVisibility(View.GONE);
        if (e != null) {
            Toast.makeText(MainActivity.this, result, Toast.LENGTH_SHORT).show();//failed to get Joke
        } else {
            Intent intent = new Intent(this, JokesActivity.class);
            intent.putExtra(JokesActivity.INTENT_JOKE, result);
            startActivity(intent);
        }
    }
}
