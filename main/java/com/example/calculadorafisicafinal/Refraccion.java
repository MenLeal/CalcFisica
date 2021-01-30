package com.example.calculadorafisicafinal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Refraccion extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    TextView reslt;
    Button calc;
    EditText indiceET;
    EditText angrefET;
    EditText angincET;
    EditText velocidad1ET;
    EditText velocidad2ET;
    Double i;
    Double ai;
    Double ar;
    Double c1;
    Double c2;
    String indice;
    String angref;
    String anginc;
    String cone;
    String ctwo;
    String result;
    Boolean angi;
    Boolean angr;
    Boolean ind;
    Boolean cuno;
    Boolean cdos;
    Spinner funcd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refraccion);
        funcd = (Spinner) findViewById(R.id.funciones);
        reslt = (TextView) findViewById(R.id.resultTxt);
        calc = (Button) findViewById(R.id.btnCalc);
        indiceET = (EditText) findViewById(R.id.indrefET);
        angincET = (EditText) findViewById(R.id.sinincET);
        angrefET = (EditText) findViewById(R.id.sinrefET);
        velocidad1ET = (EditText) findViewById(R.id.vel1ET);
        velocidad2ET = (EditText) findViewById(R.id.vel2ET);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.funcionde, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        funcd.setAdapter(adapter);
        funcd.setOnItemSelectedListener(this);


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String funcion = parent.getItemAtPosition(position).toString();
        if (funcion.equals("Velocidad Luz")) {
            angrefET.setVisibility(View.GONE);
            angincET.setVisibility(View.GONE);
            velocidad1ET.setVisibility(View.VISIBLE);
            velocidad2ET.setVisibility(View.VISIBLE);
        }
        else if (funcion.equals("Ángulos")){
            velocidad1ET.setVisibility(View.GONE);
            velocidad2ET.setVisibility(View.GONE);
            angrefET.setVisibility(View.VISIBLE);
            angincET.setVisibility(View.VISIBLE);
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}