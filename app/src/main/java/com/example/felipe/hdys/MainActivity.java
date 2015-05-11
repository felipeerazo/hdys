package com.example.felipe.hdys;

import android.app.Activity;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ProgressBar;


public class MainActivity extends Activity {
    public static final int segundos=8;
    public static final int miliSegundos=segundos*1000;
    private ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar= (ProgressBar) findViewById(R.id.barraProgreso);
        progressBar.setMax(8);
        empezarAnimacion();
    }

    /**
     * método para animar barra
     */
    public void empezarAnimacion(){
        /**
         * esto es una clase que implementa una
         * interfaz de android
         * recibe los milisegundos maximos
         * y el intervalo de descuento
         */
        new CountDownTimer(miliSegundos, 1000){

            @Override
            public void onTick(long millisUntilFinished) {
                progressBar.setProgress((int)millisUntilFinished/1000);
            }

            @Override
            public void onFinish() {
                /*Intent nuevoActivity = new Intent(MainActivity.this, MainActivity.class);
                startActivity(nuevoActivity);
                finish();*/
            }
        }.start();
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
        if (id == R.id.acerca_de) {
            Intent intent = new Intent(this, AcercaDe.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
