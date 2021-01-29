package com.example.calculadorafisicafinal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Reflexion extends AppCompatActivity {
    Button calc;
    TextView reslt;
    EditText num_imag;
    EditText anguloEspejos;
    Double num_img;
    Double angulo;
    String numim;
    String angesp;
    String result;
    String ed;
    Double d;
    private static final String medidaN = " Imágenes";
    private static final String medidaA = "°";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reflexion);

        calc = (Button) findViewById(R.id.btnCalc);
        reslt = (TextView) findViewById(R.id.resultTxt);
        num_imag = (EditText) findViewById(R.id.numeroimagenesET);
        anguloEspejos = (EditText) findViewById(R.id.angulosespET);



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

    }

    private void ocultarKeyB(){
        InputMethodManager inputMethodManager =  (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
    }
}