package com.biguniunibratec.biguniapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Context c = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonhome = (Button)findViewById(R.id.buttonhome);
        Typeface roboto = Typeface.createFromAsset(getResources().getAssets(), "Roboto-Light.ttf");

        buttonhome.setTypeface(roboto);

        buttonhome.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(c,SecondActivity.class);
                startActivity(intent);
            }
        });




    }
}
