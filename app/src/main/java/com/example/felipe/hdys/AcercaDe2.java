package com.example.felipe.hdys;

import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;


public class AcercaDe2 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acerca_de2);
        TextView textView =(TextView)findViewById(R.id.textView2);
        textView.setClickable(true);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        String text = "<a href='http://felipeerazo.96.lt'>Visit my web page!</a>";
        textView.setText(Html.fromHtml(text));
    }

}
