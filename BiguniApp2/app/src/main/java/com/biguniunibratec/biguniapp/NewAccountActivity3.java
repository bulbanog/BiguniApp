package com.biguniunibratec.biguniapp;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * Created by Rayssa&Thiago on 19/04/2017.
 */

public class NewAccountActivity3 extends AppCompatActivity {
    private Context c = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newaccount3);

        TextView txtcarteiraconta = (TextView) findViewById(R.id.txtcarteiraconta);
        TextView txtmodeloconta = (TextView) findViewById(R.id.txtmodeloconta);
        TextView txtcadastrocontra = (TextView) findViewById(R.id.txtcadastroconta);
        TextView txtcorconta = (TextView) findViewById(R.id.txtcorconta);
        TextView txtplacaconta = (TextView) findViewById(R.id.txtplacaconta);
        Button btncadastrarconta = (Button) findViewById(R.id.btncadastrarconta);

        Typeface roboto = Typeface.createFromAsset(getResources().getAssets(), "Roboto-Light.ttf");

        txtcarteiraconta.setTypeface(roboto);
        txtmodeloconta.setTypeface(roboto);
        txtcadastrocontra.setTypeface(roboto);
        txtcorconta.setTypeface(roboto);
        txtplacaconta.setTypeface(roboto);
        btncadastrarconta.setTypeface(roboto);

    }
}