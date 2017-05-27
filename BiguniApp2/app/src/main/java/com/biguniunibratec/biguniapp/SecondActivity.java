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
 * Created by JOHN on 12/04/2017.
 */

public class SecondActivity extends AppCompatActivity {
    private Context c = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView txtmatriculaacesso = (TextView) findViewById(R.id.txtmatriculaacesso);
        TextView txtsenhaacesso = (TextView) findViewById(R.id.txtsenhaacesso);
        Button btnlogin = (Button) findViewById(R.id.btnlogin);
        TextView txtNaoCadastrou = (TextView) findViewById(R.id.txtops);
        TextView txtCriarConta = (TextView) findViewById(R.id.txtcriarConta);
        Typeface roboto = Typeface.createFromAsset(getResources().getAssets(), "Roboto-Light.ttf");

        txtmatriculaacesso.setTypeface(roboto);
        txtsenhaacesso.setTypeface(roboto);
        txtNaoCadastrou.setTypeface(roboto);
        txtCriarConta.setTypeface(roboto);
        btnlogin.setTypeface(roboto);

        txtCriarConta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(c,NewAccountActivity.class);
                startActivity(intent);
            }
        });


    }
}