package com.example.felipe.hdys.Model;

import android.annotation.TargetApi;
import android.os.Build;
import android.util.Log;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.Random;

/**
 * Created by Felipe on 10/05/2015.
 */
public class Partida {

    private String palabra;
    private String buena;
    private String mala;
    private int score;
    private JSONArray jsonArray;
    private String faltante;

    public Partida(){
        score=0;
    }

    public void nuevaPartida() throws JSONException {
        JSONObject jsonObject=getValoresJson();
        if(jsonObject!=null){
            //asigna palabra
            palabra=jsonObject.getString("palabra");
            // asgina buena
            buena=jsonObject.getString("buena");
            //asigna mala
            mala=jsonObject.getString("mala");
        }
    }

    public String asinarUnBoton(){
        //al azar elegir retornar entre buena o mala
        if(new Random().nextBoolean()){
            faltante=mala;
            return buena;
        }
        faltante=buena;
        return mala;
    }

    public String asinarOtroBoton(){
        //asignar la faltante
        return faltante;
    }

    //trae un elemento aleatorio de una lista
    @TargetApi(Build.VERSION_CODES.KITKAT)
    private JSONObject getValoresJson(){
        if(jsonArray!=null) {
            int aleatorio = (int) Math.floor(Math.random() * jsonArray.length());
            Log.d("JSON", "aleatorio: "+aleatorio);
            return (JSONObject) jsonArray.remove(aleatorio);
        }
        else return null;
    }

    //setter y getter

    public String getPalabra(){
        return palabra;
    }

    public String getBuena(){
        return buena;
    }

    public String getMala(){
        return mala;
    }

    public int getScore(){
        return score;
    }

    public void setScore(int i){
        score=i;
    }

    public void setJsonArray(JSONArray jsonArray){
        this.jsonArray=jsonArray;
    }

}
