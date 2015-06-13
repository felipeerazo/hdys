package com.example.felipe.hdys;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void doPlay(View view){
        Intent intent = new Intent(MainActivity.this, Juego.class);
        MainActivity.this.startActivity(intent);
        finish();
    }

    public void doAbout(View view){
        Intent intent = new Intent(MainActivity.this, AcercaDe2.class);
        MainActivity.this.startActivity(intent);
        finish();
    }

    }
