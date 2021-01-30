package com.example.calculadorafisicafinal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Reflexion extends AppCompatActivity {
    Button calc; TextView reslt;
    EditText num_imag;
    EditText anguloEspejos;
    Double num_img;
    Double angulo;
    String numim;
    String angesp;
    String result;
    String ed;
    Double d;
    Button calc2;
    EditText indairET;
    EditText angcritET;
    EditText indmedET;
    Double ia;
    Double ac;
    Double im;
    String indair;
    String angcrit;
    String indmed;
    Boolean angc;
    Boolean inda;
    Boolean indm;
    private static final String medidaN = " Imágenes";
    private static final String medidaA = "°";
    private static final String erro = "ERROR INDICE MAYOR";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reflexion);

        calc = (Button) findViewById(R.id.btnCalc);
        reslt = (TextView) findViewById(R.id.resultTxt);
        num_imag = (EditText) findViewById(R.id.numeroimagenesET);
        anguloEspejos = (EditText) findViewById(R.id.angulosespET);
        calc2 = (Button) findViewById(R.id.btnCalc2);
        angcritET = (EditText) findViewById(R.id.angulocET);
        indairET = (EditText) findViewById(R.id.indiceairET);
        indmedET =(EditText) findViewById(R.id.indicemedET);


        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numim = num_imag.getText().toString();
                angesp = anguloEspejos.getText().toString();
                boolean nimg =numim.isEmpty();
                boolean aesp = angesp.isEmpty();


                if(nimg && !aesp){
                    angesp = angesp.trim();
                    angulo = Double.parseDouble(angesp);
                    d = 360/angulo;
                    d = d-1;
                    result = String.valueOf(d);
                    ed = result.substring(0,result.length()-2);
                    reslt.setText(result+ medidaN);
                    ocultarKeyB();

                }
                else if (!nimg && aesp){
                    numim = numim.trim();
                    num_img = Double.parseDouble(numim);
                    result = String.valueOf((360/(num_img+1)));
                    reslt.setText(result+medidaA);
                    ocultarKeyB();
                }
            }
        });
        calc2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                angcrit = angcritET.getText().toString().trim();
                indair = indairET.getText().toString().trim();
                indmed = indmedET.getText().toString().trim();
                angc = angcrit.isEmpty();
                inda = indair.isEmpty();
                indm = indmed.isEmpty();

                if (angc && !inda && !indm){
                    ia = Double.parseDouble(indair);
                    im = Double.parseDouble(indmed);
                    if (ia>im){
                        Toast.makeText(Reflexion.this,erro,Toast.LENGTH_LONG).show();
                        ocultarKeyB();
                    }
                    ac = Math.asin(ia/im);
                    ac = Math.toDegrees(ac);
                    result = String.valueOf(ac)+medidaA;
                    reslt.setText(result);
                    ocultarKeyB();
                }

                else if (!angc && inda && !indm){
                    ac = Double.parseDouble(angcrit);
                    im = Double.parseDouble(indmed);
                    ac = Math.toRadians(ac);
                    ia = im * Math.sin(ac);
                    result = String.valueOf(ia);
                    reslt.setText(result);
                    ocultarKeyB();
                }

                else if (!angc && !inda && indm){
                    ac = Double.parseDouble(angcrit);
                    ia = Double.parseDouble(indair);
                    ac = Math.toRadians(ac);
                    im = ia/(Math.sin(ac));
                    result = String.valueOf(im);
                    reslt.setText(result);
                    ocultarKeyB();
                }

            }
        });

    }

    private void ocultarKeyB(){
        InputMethodManager inputMethodManager =  (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
    }
}