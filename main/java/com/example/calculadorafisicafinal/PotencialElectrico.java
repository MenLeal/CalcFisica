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

import java.math.BigInteger;

public class PotencialElectrico extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner funciones;
    TextView resultado;
    EditText et1;
    EditText et2;
    EditText et3;
    ImageView img1;
    ImageView img2;
    Button calc;
    String val1;
    String val2;
    String val3;
    String result;
    Double v1;
    Double v2;
    Double v3;
    BigInteger a;
    boolean va1;
    boolean va2;
    boolean va3;
    double k;
    static final String volt = "V";
    static final String joule = "J";
    static final String coul = "C";
    static final String m = "m";
    static final String e = "V/m";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_potencial_electrico);
        funciones = (Spinner) findViewById(R.id.funcionesPotElec);
        resultado = (TextView) findViewById(R.id.resultTxt);
        et1 = (EditText) findViewById(R.id.edt1);
        et2 = (EditText) findViewById(R.id.edt2);
        et3 = (EditText) findViewById(R.id.edt3);
        img1 = (ImageView) findViewById(R.id.img1);
        img2 = (ImageView) findViewById(R.id.img2);
        calc = (Button) findViewById(R.id.btnCalc);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.funcionpot, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        funciones.setAdapter(adapter);
        funciones.setOnItemSelectedListener(this);
        a = new BigInteger("9000000000");
        k = a.doubleValue();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String funcion = parent.getItemAtPosition(position).toString();
        if (funcion.equals("Energía Potencial")){
            et1.setHint(R.string.HintPotencia);
            et2.setHint(R.string.HintPotencialEng);
            et3.setHint(R.string.HintIntCampC);
            img1.setImageResource(R.mipmap.potencialf);
            img2.setImageResource(R.mipmap.potenciald);
            calc.setOnClickListener(v -> {
                val1 = et1.getText().toString().trim();
                val2 = et2.getText().toString().trim();
                val3 = et3.getText().toString().trim();
                va1 = val1.isEmpty();
                va2 = val2.isEmpty();
                va3 = val3.isEmpty();
                if (va1 && !va2 && !va3){
                    v2 = Double.parseDouble(val2);
                    v3 = Double.parseDouble(val3);
                    v1 = v2 / v3;
                    result = v1 + volt;
                    resultado.setText(result);
                    ocultarKeyB();
                }
                else if (!va1 && va2 && !va3){
                    v1 = Double.parseDouble(val1);
                    v3 = Double.parseDouble(val3);
                    v2 = v1 * v3;
                    result = v2 + joule;
                    resultado.setText(result);
                    ocultarKeyB();
                }
                else if (!va1 && !va2 && va3){
                    v1 = Double.parseDouble(val1);
                    v2 = Double.parseDouble(val2);
                    v3 = v2 / v1;
                    result = v3 + coul;
                    resultado.setText(result);
                    ocultarKeyB();
                }
            });
        }
        else if (funcion.equals("Carga Eléctrica")){
            et1.setHint(R.string.HintPotencia);
            et2.setHint(R.string.HintIntCampC);
            et3.setHint(R.string.HintIntCamR);
            img1.setImageResource(R.mipmap.potencial2f);
            img2.setImageResource(R.mipmap.potencial2d);
            calc.setOnClickListener(v -> {
                val1 = et1.getText().toString().trim();
                val2 = et2.getText().toString().trim();
                val3 = et3.getText().toString().trim();
                va1 = val1.isEmpty();
                va2 = val2.isEmpty();
                va3 = val3.isEmpty();
                if(va1 && !va2 && !va3){
                    v2 = Double.parseDouble(val2);
                    v3 = Double.parseDouble(val3);
                    v1 = (k * v2)/v3;
                    result = v1+volt;
                    resultado.setText(result);
                    ocultarKeyB();
                }
                else if (!va1 && va2 && !va3){
                    v1 = Double.parseDouble(val1);
                    v3 = Double.parseDouble(val3);
                    v2 = (v1 * v3)/k;
                    result = v2+coul;
                    resultado.setText(result);
                    ocultarKeyB();
                }
                else if (!va1 && !va2 && va3){
                    v1 = Double.parseDouble(val1);
                    v2 = Double.parseDouble(val2);
                    v3 = (k * v2)/v1;
                    result = v3 +m;
                    resultado.setText(result);
                    ocultarKeyB();
                }
            });
        }else{
            et1.setHint(R.string.HintPotencia);
            et2.setHint(R.string.HintPotencialE);
            et3.setHint(R.string.HintPotenciaD);
            img1.setImageResource(R.mipmap.potencial3f);
            img2.setImageResource(R.mipmap.potencial3d);
            calc.setOnClickListener(v -> {
                val1 = et1.getText().toString().trim();
                val2 = et2.getText().toString().trim();
                val3 = et3.getText().toString().trim();
                va1 = val1.isEmpty();
                va2 = val2.isEmpty();
                va3 = val3.isEmpty();
                if(va1 && !va2 && !va3){
                    v2 = Double.parseDouble(val2);
                    v3 = Double.parseDouble(val3);
                    v1 = v2*v3;
                    result = v1+volt;
                    resultado.setText(result);
                    ocultarKeyB();
                }
                else if (!va1 && va2 && !va3){
                    v1 = Double.parseDouble(val1);
                    v3 = Double.parseDouble(val3);
                    v2 = v1 / v3;
                    result = v2+e;
                    resultado.setText(result);
                    ocultarKeyB();
                }
                else if (!va1 && !va2 && va3){
                    v1 = Double.parseDouble(val1);
                    v2 = Double.parseDouble(val2);
                    v3 = v1/v2;
                    result = v3 +m;
                    resultado.setText(result);
                    ocultarKeyB();
                }
            });
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }
    private void ocultarKeyB(){
        InputMethodManager inputMethodManager =  (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
    }
}