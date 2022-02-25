package com.example.esflores_primeraapp;

import android.content.Intent;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class EjemploProximidad extends AppCompatActivity {


    SensorManager sensorManager;

    Sensor sensor;

    SensorEventListener sensorEventListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejemplo_proximidad);
        Button bAnte = (Button)findViewById(R.id.bPagAnte);

        bAnte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent an = new Intent(EjemploProximidad.this,EjemploAcelerometro.class);
                startActivity(an);

            }
        });

        final TextView texto;
        texto = (TextView)findViewById(R.id.tvSensor);

        sensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);

        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);

        if(sensor==null)finish();

        sensorEventListener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {
                if(sensorEvent.values[0] < sensor.getMaximumRange()){
                    getWindow().getDecorView().setBackgroundColor(Color.BLUE);
                    texto.setText("CAMBIANDO A COLOR AZUL");
                }else{
                    getWindow().getDecorView().setBackgroundColor(Color.YELLOW);
                    texto.setText("SENSOR DE PROXIMIDAD");

                }
            }
            @Override
            public void onAccuracyChanged(Sensor sensor, int i) {
            }
        };

        start();
    }

    public void start(){
        sensorManager.registerListener(sensorEventListener,sensor,2000*1000);
    }
    public void stop(){
        sensorManager.unregisterListener(sensorEventListener);
    }
    @Override
    protected void onPause() {
        stop();
        super.onPause();
    }
    @Override
    protected void onResume() {
        start();
        super.onResume();
    }
}