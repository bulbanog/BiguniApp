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


        Button btnlogin = (Button) findViewById(R.id.btnlogin);
        TextView txtNaoCadastrou = (TextView) findViewById(R.id.textView2);
        TextView txtCriarConta = (TextView) findViewById(R.id.criarConta);
        Typeface roboto = Typeface.createFromAsset(getResources().getAssets(), "Roboto-Light.ttf");

        txtNaoCadastrou.setTypeface(roboto);
        txtCriarConta.setTypeface(roboto);

        txtCriarConta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(c,NewAccountActivity.class);
                startActivity(intent);
            }
        });


    }
}