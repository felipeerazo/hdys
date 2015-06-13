package com.example.felipe.hdys;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class GameOver extends Activity {

    private TextView txtScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);
        txtScore= (TextView) findViewById(R.id.txtScore);
        txtScore.setText(getIntent().getExtras().getString("score"));
    }

    public void btnPlayAgain(View view){
        Intent intent = new Intent(GameOver.this, Juego.class);
        GameOver.this.startActivity(intent);
        finish();
    }

}
