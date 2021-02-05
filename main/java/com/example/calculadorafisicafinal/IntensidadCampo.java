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

import java.math.BigInteger;

public class IntensidadCampo extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner funciones;
    TextView resultado;
    Button calc;
    EditText ed1;
    EditText ed2;
    EditText ed3;
    ImageView img1;
    ImageView img2;
    String v1;
    String v2;
    String v3;
    boolean vone;
    boolean vtwo;
    boolean vthree;
    BigInteger k;
    Double V1;
    Double V2;
    Double V3;
    double kc;
    String result;
    static final String intcamp = "N/C";
    static final String frz = "N";
    static final String cg= "C";
    static final String m ="m";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intensidad_campo);
        funciones = (Spinner) findViewById(R.id.funcionesIntCamp);
        resultado = (TextView) findViewById(R.id.resultTxt);
        ed1 = (EditText) findViewById(R.id.edt1);
        ed2 = (EditText) findViewById(R.id.edt2);
        ed3 = (EditText) findViewById(R.id.edt3);
        img1 = (ImageView) findViewById(R.id.img1);
        img2 = (ImageView) findViewById(R.id.img2);
        calc = (Button) findViewById(R.id.btnCalc);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.funcionintcamp, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        funciones.setAdapter(adapter);
        funciones.setOnItemSelectedListener(this);
        k = new BigInteger("9000000000");
        kc = k.doubleValue();
    }

    private void ocultarKeyB(){
        InputMethodManager inputMethodManager =  (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String funcion = parent.getItemAtPosition(position).toString();
        ed1.setHint(R.string.HintIntCamp);
        if (funcion.equals("Fuerza")){
            ed2.setHint(R.string.HintIntCampF);
            ed3.setHint(R.string.HintIntCampC);
            img1.setImageResource(R.mipmap.intensidadcampof);
            img2.setImageResource(R.mipmap.intensidadcampod);
            calc.setOnClickListener(v -> {
                v1 = ed1.getText().toString().trim();
                v2 = ed2.getText().toString().trim();
                v3 = ed3.getText().toString().trim();
                vone = v1.isEmpty();
                vtwo = v2.isEmpty();
                vthree = v3.isEmpty();
                if (vone && !vtwo && !vthree){
                    V2 = Double.parseDouble(v2);
                    V3 = Double.parseDouble(v3);
                    V1 = V2/V3;
                    result = V1+intcamp;
                    resultado.setText(result);
                    ocultarKeyB();
                }
                else if (!vone && vtwo && !vthree){
                    V1 = Double.parseDouble(v1);
                    V3 = Double.parseDouble(v3);
                    V2 = V1*V3;
                    result = V2+frz;
                    resultado.setText(result);
                    ocultarKeyB();
                }
                else if (!vone && !vtwo && vthree){
                    V1 = Double.parseDouble(v1);
                    V2 = Double.parseDouble(v2);
                    V3 = V2/V1;
                    result = V3+cg;
                    resultado.setText(result);
                    ocultarKeyB();
                }
            });
        }else{
            ed2.setHint(R.string.HintIntCampC);
            ed3.setHint(R.string.HintIntCamR);
            img1.setImageResource(R.mipmap.intensidadcampo2d);
            img2.setImageResource(R.mipmap.intensidadcampo2f);
            calc.setOnClickListener(v -> {
                v1 = ed1.getText().toString().trim();
                v2 = ed2.getText().toString().trim();
                v3 = ed3.getText().toString().trim();
                vone = v1.isEmpty();
                vtwo = v2.isEmpty();
                vthree = v3.isEmpty();
                if (vone && !vtwo && !vthree){
                    V2 = Double.parseDouble(v2);
                    V3 = Double.parseDouble(v3);
                    V1 = (kc *V2)/(V3*V3);
                    result = V1+intcamp;
                    resultado.setText(result);
                    ocultarKeyB();
                }
                else if (!vone && vtwo && !vthree){
                    V1 = Double.parseDouble(v1);
                    V3 = Double.parseDouble(v3);
                    V2 = (V1*V3*V3)/kc;
                    result = V2+frz;
                    resultado.setText(result);
                    ocultarKeyB();
                }
                else if (!vone && !vtwo && vthree){
                    V1 = Double.parseDouble(v1);
                    V2 = Double.parseDouble(v2);
                    V3 =(V2*kc)/V1;
                    V3 = Math.pow(V3,0.5);
                    result = V3+m;
                    resultado.setText(result);
                    ocultarKeyB();
                }
            });
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }
}