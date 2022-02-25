package com.example.esflores_primeraapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class VerificarEdad extends AppCompatActivity {

    Integer estado;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verificar_edad);
        TextView Nombre = (TextView)findViewById(R.id.tvNombreReci);
        TextView Edad = (TextView)findViewById(R.id.tvEdadReci);
        TextView Estado = (TextView)findViewById(R.id.tvEstado);
        Button bVolver = (Button)findViewById(R.id.btVolverVerificarEdad);
        Bundle datosRecibidos = this.getIntent().getExtras();
        String nombre = datosRecibidos.getString("pNombre");
        String edad = datosRecibidos.getString("pEdad");
        Nombre.setText("Tu nombre es: "+nombre);
        Edad.setText("Tu edad es: "+edad);
        estado = Integer.parseInt(edad);
        if(estado < 18){
            Estado.setText("Eres menor de edad");
        }else{
            Estado.setText("Eres mayor de edad");
        }
        bVolver.setOnClickListener( view -> {
            Intent vuelva = new
                    Intent(VerificarEdad.this,EnviarDatos.class);
            startActivity(vuelva);
        } );
    }
}
