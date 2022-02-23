package com.example.esflores_primeraapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EjemploProximidad extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejemplo_proximidad);
        Button btanterior = (Button)findViewById(R.id.bPagAnte);

        btanterior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ante = new Intent(EjemploProximidad.this,EjemploAcelerometro.class);
                startActivity(ante);

            }
        });



    }
}