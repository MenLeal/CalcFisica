package com.example.calculadorafisicafinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
GridLayout mainGrid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainGrid = findViewById(R.id.gridTemas);

        CardView reflexion = (CardView) mainGrid.getChildAt(0);
        reflexion.setOnClickListener(v -> startActivity(new Intent(MainActivity.this,Reflexion.class)));
        CardView refraccion = (CardView) mainGrid.getChildAt(1);
        refraccion.setOnClickListener(v -> startActivity(new Intent(MainActivity.this,Refraccion.class)));
        CardView resistencia = (CardView) mainGrid.getChildAt(2);
        resistencia.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, Resistencia.class));
        });
        CardView intensidad = (CardView) mainGrid.getChildAt(3);
        intensidad.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, IntensidadCampo.class));
        });
        CardView potencial = (CardView) mainGrid.getChildAt(4);
        potencial.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, PotencialElectrico.class));
        });
        CardView leydeohm = (CardView) mainGrid.getChildAt(5);
        leydeohm.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, LeydeOhm.class));
        });

    }
}