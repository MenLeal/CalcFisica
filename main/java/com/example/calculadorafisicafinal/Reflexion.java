package com.example.calculadorafisicafinal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Reflexion extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Button calc;
    TextView reslt;
    Spinner funciones;
    ImageView img1;
    ImageView img2;
    EditText et1;
    EditText et2;
    EditText et3;
    Double num_img;
    Double angulo;
    String numim;
    String angesp;
    String result;
    String ed;
    Double d;
    Double ia;
    Double ac;
    Double im;
    String indair;
    String angcrit;
    String indmed;
    boolean angc;
    boolean inda;
    boolean indm;
    private static final String medidaN = " Imágenes";
    private static final String medidaA = "°";
    private static final String erro = "ERROR INDICE MAYOR";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reflexion);
        funciones = (Spinner) findViewById(R.id.funcionesReflex);
        calc = (Button) findViewById(R.id.btnCalc);
        reslt = (TextView) findViewById(R.id.resultTxt);
        et1 = (EditText) findViewById(R.id.numeroimagenesET);
        et2 = (EditText) findViewById(R.id.angulosespET);
        et3 = (EditText) findViewById(R.id.angulocET);
        img1 = (ImageView) findViewById(R.id.img1);
        img2 = (ImageView) findViewById(R.id.img2);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.funcionesreflex, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        funciones.setAdapter(adapter);
        funciones.setOnItemSelectedListener(this);



    }

    private void ocultarKeyB(){
        InputMethodManager inputMethodManager =  (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String funcion = parent.getItemAtPosition(position).toString();
        if (funcion.equals("Ángulo Crítico")) {
            et3.setVisibility(View.VISIBLE);
            et1.setHint(R.string.HintReflexA);
            et2.setHint(R.string.HintReflexionNa);
            et3.setHint(R.string.HintReflexionNm);
            img1.setImageResource(R.mipmap.reflexionf);
            img2.setImageResource(R.mipmap.reflexiond);
            calc.setOnClickListener(v -> {
                angcrit = et1.getText().toString().trim();
                indair = et2.getText().toString().trim();
                indmed = et3.getText().toString().trim();
                angc = angcrit.isEmpty();
                inda = indair.isEmpty();
                indm = indmed.isEmpty();

                if (angc && !inda && !indm) {
                    ia = Double.parseDouble(indair);
                    im = Double.parseDouble(indmed);
                    if (ia > im) {
                        Toast.makeText(Reflexion.this, erro, Toast.LENGTH_LONG).show();
                        ocultarKeyB();
                    }
                    ac = Math.asin(ia / im);
                    ac = Math.toDegrees(ac);
                    result = String.valueOf(ac) + medidaA;
                    reslt.setText(result);
                    ocultarKeyB();
                } else if (!angc && inda && !indm) {
                    ac = Double.parseDouble(angcrit);
                    im = Double.parseDouble(indmed);
                    ac = Math.toRadians(ac);
                    ia = im * Math.sin(ac);
                    result = String.valueOf(ia);
                    reslt.setText(result);
                    ocultarKeyB();
                } else if (!angc && !inda && indm) {
                    ac = Double.parseDouble(angcrit);
                    ia = Double.parseDouble(indair);
                    ac = Math.toRadians(ac);
                    im = ia / (Math.sin(ac));
                    result = String.valueOf(im);
                    reslt.setText(result);
                    ocultarKeyB();
                }

            });
        }
        else {
            et1.setHint(R.string.HintReflexionN);
            et2.setHint(R.string.HintReflexionA);
            et3.setVisibility(View.GONE);
            img1.setImageResource(R.mipmap.reflexion2f);
            img2.setImageResource(R.mipmap.reflexion2d);
            calc.setOnClickListener(v -> {
                numim = et1.getText().toString();
                angesp = et2.getText().toString();
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
            });
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}