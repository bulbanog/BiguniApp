package com.biguniunibratec.biguniapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * Created by Rayssa&Thiago on 19/04/2017.
 */

public class NewAccountActivity2 extends AppCompatActivity {
    private Context c = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newaccount2);

        TextView txtcursoconta = (TextView) findViewById(R.id.txtcursoconta);
        TextView txtturmaconta = (TextView) findViewById(R.id.txtturmaconta);
        Spinner spinnercurso = (Spinner)findViewById(R.id.spinnercurso);
        Spinner spinnerturma = (Spinner)findViewById(R.id.spinnerturma);
        Button btnconta2 = (Button) findViewById(R.id.btnconta2);

        Typeface roboto = Typeface.createFromAsset(getResources().getAssets(), "Roboto-Light.ttf");

        txtcursoconta.setTypeface(roboto);
        txtturmaconta.setTypeface(roboto);
        btnconta2.setTypeface(roboto);

        btnconta2.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(c,NewAccountActivity3.class);
                startActivity(intent);
            }
        });

    }
}
