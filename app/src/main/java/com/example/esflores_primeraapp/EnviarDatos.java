package com.example.esflores_primeraapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class EnviarDatos extends AppCompatActivity {
    // declaracion de la variable para controlar el evento del boton
    Button siguiente;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enviar_datos);
        final EditText eNombre =
                (EditText) findViewById(R.id.etNombre2);
        final EditText eEdad = (EditText) findViewById(R.id.etApellido);
        Button bEnviar = (Button) findViewById(R.id.btEnviarDatosfinal);
        bEnviar.setOnClickListener( view -> {
            String nombre = eNombre.getText().toString();
            String edad = eEdad.getText().toString();
            Bundle pasarDatos = new Bundle();
            pasarDatos.putString("pNombre", nombre);
            pasarDatos.putString("pEdad", edad);
            Intent siga = new
                    Intent(EnviarDatos.this, VerificarEdad.class);
            siga.putExtras(pasarDatos);
            startActivity(siga);
        } );

        // Aqui se regresa a la activity anterior
siguiente=(Button)findViewById(R.id.btRegreso1);
        siguiente.setOnClickListener( view -> {
            Intent siguiente = new Intent(EnviarDatos.this,Menu.class);
            startActivity(siguiente);
        } );

    }


}
