package com.biguniunibratec.biguniapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Rayssa&Thiago on 12/04/2017.
 */

public class NewAccountActivity extends AppCompatActivity {
    private Context c = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newaccount);


        TextView txtnomeconta = (TextView) findViewById(R.id.txtnomeconta);
        TextView txtmatriculaconta =(TextView) findViewById(R.id.txtmatriculaconta);
        TextView txtcpfconta = (TextView) findViewById(R.id.txtcpfconta);
        TextView txttelefoneconta = (TextView) findViewById(R.id.txttelefoneconta);
        TextView txtemailconta = (TextView) findViewById(R.id.txtmailconta);
        TextView txtenderecoconta = (TextView) findViewById(R.id.txtenderecoconta);
        Button btnconta1 = (Button) findViewById(R.id.btnconta1);

        Typeface roboto = Typeface.createFromAsset(getResources().getAssets(), "Roboto-Light.ttf");

        txtnomeconta.setTypeface(roboto);
        txtcpfconta.setTypeface(roboto);
        txtmatriculaconta.setTypeface(roboto);
        txttelefoneconta.setTypeface(roboto);
        txtemailconta.setTypeface(roboto);
        txtenderecoconta.setTypeface(roboto);
        btnconta1.setTypeface(roboto);

        btnconta1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(c,NewAccountActivity2.class);
                startActivity(intent);
            }
        });


    }
}

