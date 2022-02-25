package com.example.esflores_primeraapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button siguiente;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        siguiente = (Button)findViewById(R.id.btSiguiente);

        siguiente.setOnClickListener( view -> {

            Intent i = new Intent (MainActivity.this,Menu.class);
            startActivity(i);
        } );
    }
}