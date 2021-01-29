package com.example.calculadorafisicafinal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Refraccion extends AppCompatActivity {
    Button calc;
    TextView reslt;
    EditText indairET;
    EditText angcritET;
    EditText indmedET;
    Double ia;
    Double ac;
    Double im;
    String indair;
    String angcrit;
    String indmed;
    String result;
    Boolean angc;
    Boolean inda;
    Boolean indm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refraccion);
        calc = (Button) findViewById(R.id.btnCalc);
        reslt = (TextView) findViewById(R.id.resultTxt);
        angcritET = (EditText) findViewById(R.id.angulocET);
        indairET = (EditText) findViewById(R.id.indiceairET);
        indmedET =(EditText) findViewById(R.id.indicemedET);

        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                angcrit = angcritET.getText().toString();
                indair = indairET.getText().toString();
                indmed = indmedET.getText().toString();
                angc = angcrit.isEmpty();
                inda = indair.isEmpty();
                indm = indmed.isEmpty();

                if (angc && !inda && !indm){
                    ia = Double.parseDouble(indair);
                    im = Double.parseDouble(indmed);
                    ac = Math.asin(ia/im);
                    result = String.valueOf(ac);
                    Toast.makeText(Refraccion.this, result, Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}