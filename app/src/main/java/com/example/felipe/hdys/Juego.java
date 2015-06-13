package com.example.felipe.hdys;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.CountDownTimer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.example.felipe.hdys.Model.Partida;
import com.example.felipe.hdys.Shared.LectorJson;
import org.json.JSONArray;
import org.json.JSONException;

public class Juego extends Activity {

    public final int miliSegundos=8000;
    private ProgressBar progressBar;
    ProgressDialog progress;
    TextView txtPalabra, txtScore;
    CountDownTimer countDownTimer=null;
    Partida partida = null;
    Button leftButton, rightButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego);
        progressBar= (ProgressBar) findViewById(R.id.barraProgreso);
        progressBar.setMax(8);
        txtPalabra = (TextView) findViewById(R.id.txtPalabra);
        txtScore = (TextView) findViewById(R.id.txtScore);
        leftButton= (Button) findViewById(R.id.leftButton);
        rightButton =(Button) findViewById(R.id.rightButton);
        partida= new Partida();
        //llama al json
        new ServicioJson().execute("http://felipeerazo.96.lt/partidas.json");
    }

    public void iniciarPartida(){
        try {
            partida.nuevaPartida();
            txtPalabra.setText(partida.getPalabra());
            leftButton.setText(partida.asinarUnBoton());
            rightButton.setText(partida.asinarOtroBoton());
            txtScore.setText(String.valueOf(partida.getScore()));
            iniciarCountDown();
        } catch (JSONException e) {
            Log.d("JSON", "error iniciarPartida: " + e.toString());
            txtPalabra.setText("- Can't read JSON :( -");
        }

    }

    /**
     * método para animar barra
     */
    public void iniciarCountDown(){
        /**
         * esto es una clase que implementa una
         * interfaz de android
         * recibe los milisegundos maximos
         * y el intervalo de descuento
         */
        countDownTimer=new CountDownTimer(miliSegundos, 1000){

            @Override
            public void onTick(long millisUntilFinished) {
                progressBar.setProgress((int)millisUntilFinished/1000);
            }

            @Override
            public void onFinish() {
                Intent intent = new Intent(Juego.this, GameOver.class);
                intent.putExtra("score", "Your score: "+partida.getScore());
                Juego.this.startActivity(intent);
                finish();
            }
        }.start();
    }

    public void btnIzquierdo(View view){
        countDownTimer.cancel();
        if (leftButton.getText().toString().toLowerCase().equals(partida.getBuena().toLowerCase())) {
            partida.setScore(partida.getScore() +progressBar.getProgress());
            iniciarPartida();
        } else {
            Intent intent = new Intent(Juego.this, GameOver.class);
            intent.putExtra("score", "Your score: "+partida.getScore());
            Juego.this.startActivity(intent);
            finish();
        }
    }

    public void btnDerecho(View view){
        countDownTimer.cancel();
        if (rightButton.getText().toString().toLowerCase().equals(partida.getBuena().toLowerCase())) {
            partida.setScore(partida.getScore() +progressBar.getProgress());
            iniciarPartida();
        }
        else{
            Intent intent = new Intent(Juego.this, GameOver.class);
            intent.putExtra("score", "Your score: "+partida.getScore());
            Juego.this.startActivity(intent);
            finish();
        }
    }

    private class ServicioJson extends AsyncTask<String, Void, Boolean> {
        JSONArray jsonArray=null;

        public ServicioJson(){}

        @Override
        protected Boolean doInBackground(String... params) {
            try {
                jsonArray=LectorJson.readJsonFromUrl(params[0]);
                Log.d("llegó: ", "--: "+jsonArray.toString());
                return true;
            } catch (Exception e){
                Log.d("JSON", "error leer json desde url: "+e.toString());
            }
            return false;
        }

        @Override
        protected void onPostExecute(Boolean resultado) {
            if (!resultado) {
                jsonArray=null;
            }
            else{
                partida.setJsonArray(jsonArray);
                iniciarPartida();
            }
        }

    }

}
