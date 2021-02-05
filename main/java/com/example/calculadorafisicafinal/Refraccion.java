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
    private static final String dg= "°";
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

            calc.setOnClickListener(v -> {
                cone = velocidad1ET.getText().toString().trim();
                ctwo = velocidad2ET.getText().toString().trim();
                indice = indiceET.getText().toString().trim();
                cuno = cone.isEmpty();
                cdos = ctwo.isEmpty();
                ind = indice.isEmpty();

                if (ind && !cuno && !cdos){
                    c1 = Double.parseDouble(cone);
                    c2 = Double.parseDouble(ctwo);
                    i = c1/c2;
                    result =String.valueOf(i);
                    reslt.setText(result);
                }
                else if (!ind && cuno && !cdos){
                    i = Double.parseDouble(indice);
                    c2 = Double.parseDouble(ctwo);
                    c1 = i *c2;
                    result = String.valueOf(c1);
                    reslt.setText(result);
                }
                else if (!ind && !cuno && cdos){
                    i = Double.parseDouble(indice);
                    c1 = Double.parseDouble(cone);
                    c2 = c1/i;
                    result = String.valueOf(c2);
                    reslt.setText(result);
                }

            });

        }
        else {
            velocidad1ET.setVisibility(View.GONE);
            velocidad2ET.setVisibility(View.GONE);
            angrefET.setVisibility(View.VISIBLE);
            angincET.setVisibility(View.VISIBLE);

            calc.setOnClickListener(v -> {
                indice = indiceET.getText().toString().trim();
                anginc = angincET.getText().toString().trim();
                angref = angrefET.getText().toString().trim();

                ind = indice.isEmpty();
                angi = anginc.isEmpty();
                angr = angref.isEmpty();

                if (ind && !angi && !angr){
                    ai = Double.parseDouble(anginc);
                    ar = Double.parseDouble(angref);
                    ai = Math.toRadians(ai);
                    ar = Math.toRadians(ar);
                    i = (Math.sin(ai))/(Math.sin(ar));
                    result = String.valueOf(i);
                    reslt.setText(result);
                }
                else if (!ind && angi && !angr){
                    i = Double.parseDouble(indice);
                    ar = Double.parseDouble(angref);
                    ar = Math.toRadians(ar);
                    ai = i*Math.sin(ar);
                    ai = Math.asin(ai);
                    ai = Math.toDegrees(ai);
                    result = String.valueOf(ai);
                    reslt.setText(result+dg);
                }
                else if (!ind && !angi && angr){
                    i = Double.parseDouble(indice);
                    ai = Double.parseDouble(anginc);
                    ai = Math.toRadians(ai);
                    ar = Math.sin(ai)/i;
                    ar = Math.asin(ar);
                    ar = Math.toDegrees(ar);
                    result = String.valueOf(ar);
                    reslt.setText(result+dg);
                }
            });
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }
}