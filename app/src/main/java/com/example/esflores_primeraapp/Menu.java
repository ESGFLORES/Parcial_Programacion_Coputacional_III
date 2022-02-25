package com.example.esflores_primeraapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);


        Button ControlesBasicos = (Button) findViewById(R.id.btControlesBasicos);

        ControlesBasicos.setOnClickListener( view -> {

            Intent i = new Intent (Menu.this,EnviarDatos.class);
            startActivity(i);
        } );

        Button ace = (Button) findViewById(R.id.bSensores);

        ace.setOnClickListener( view -> {

            Intent j = new Intent (Menu.this,EjemploAcelerometro.class);
            startActivity(j);
        } );



    }
}