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

public class Resistencia extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner funciones;
    TextView result;
    Button calc;
    EditText resistenciaET;
    EditText resistividadET;
    EditText longitudET;
    EditText areaET;
    EditText resistencinitET;
    EditText resistenciafinET;
    EditText resistenciaAET;
    EditText temInitET;
    EditText temFinET;
    ImageView formulaAL;
    ImageView descripAL;
    ImageView formulaRT;
    ImageView descripRT;
    String resistenciaS;
    String resistividadS;
    String longitudS;
    String areaS;
    String resistenciaInitS;
    String resistenciaFinS;
    String resistenciaAlpS;
    String tempInitS;
    String tempFinS;
    String resultado;
    Double resistencia;
    Double resistividad;
    Double longitud;
    Double area;
    Double resistencinit;
    Double resistenciafin;
    Double resistenciaAlp;
    Double temInit;
    Double temFin;
    Boolean r;
    Boolean rst;
    Boolean l;
    Boolean a;
    Boolean ri;
    Boolean rf;
    Boolean ra;
    Boolean ti;
    Boolean tf;
    private static final String al ="Longitud/Área";
    private static final String ohms = " Ω";
    private static final String ohms_m=" Ω-m";
    private static final String m = " m";
    private static final String m2 = " m^2";
    private static final String dg = "°C";
    private static final String alp = "1/°C";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resistencia);
        calc = (Button) findViewById(R.id.btnCalc);
        funciones = (Spinner) findViewById(R.id.funcionesResist);
        result = (TextView) findViewById(R.id.resultTxt);
        resistenciaET = (EditText) findViewById(R.id.resistenciaET);
        resistividadET = (EditText) findViewById(R.id.resistividadET);
        longitudET = (EditText) findViewById(R.id.longitudET);
        areaET = (EditText) findViewById(R.id.areaET);
        resistencinitET = (EditText) findViewById(R.id.resistencia0ET);
        resistenciafinET = (EditText) findViewById(R.id.resistenciaFET);
        resistenciaAET =(EditText) findViewById(R.id.resistenciaAlpha);
        temInitET = (EditText) findViewById(R.id.resistenciaTempIn);
        temFinET = (EditText) findViewById(R.id.resistenciaTempFin);
        formulaAL = (ImageView) findViewById(R.id.imgRA);
        descripAL = (ImageView) findViewById(R.id.imgRA2);
        formulaRT = (ImageView) findViewById(R.id.RT);
        descripRT = (ImageView) findViewById(R.id.RT2);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.funcionrResit, android.R.layout.simple_spinner_item);
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
        if (funcion.equals(al)){
            formulaAL.setVisibility(View.VISIBLE);
            descripAL.setVisibility(View.VISIBLE);
            formulaRT.setVisibility(View.GONE);
            descripRT.setVisibility(View.GONE);
            resistenciaET.setVisibility(View.VISIBLE);
            resistividadET.setVisibility(View.VISIBLE);
            longitudET.setVisibility(View.VISIBLE);
            areaET.setVisibility(View.VISIBLE);
            resistencinitET.setVisibility(View.GONE);
            resistenciafinET.setVisibility(View.GONE);
            resistenciaAET.setVisibility(View.GONE);
            temInitET.setVisibility(View.GONE);
            temFinET.setVisibility(View.GONE);
            calc.setOnClickListener(v -> {
                resistenciaS = resistenciaET.getText().toString().trim();
                resistividadS = resistividadET.getText().toString().trim();
                longitudS = longitudET.getText().toString().trim();
                areaS = areaET.getText().toString().trim();
                r = resistenciaS.isEmpty();
                rst = resistividadS.isEmpty();
                l = longitudS.isEmpty();
                a = areaS.isEmpty();
                if (r && !rst && !l && !a){
                    resistividad = Double.parseDouble(resistividadS);
                    longitud = Double.parseDouble(longitudS);
                    area = Double.parseDouble(areaS);
                    resistencia = resistividad * (longitud/area);
                    resultado = resistencia + ohms;
                    result.setText(resultado);
                    ocultarKeyB();
                }
                else if (!r && rst && !l && !a){
                    resistencia = Double.parseDouble(resistenciaS);
                    longitud = Double.parseDouble(longitudS);
                    area = Double.parseDouble(areaS);
                    resistividad = (resistencia * area)/longitud;
                    resultado = resistividad + ohms_m;
                    result.setText(resultado);
                    ocultarKeyB();
                }
                else if (!r && !rst && l && !a){
                    resistencia = Double.parseDouble(resistenciaS);
                    resistividad = Double.parseDouble(resistividadS);
                    area = Double.parseDouble(areaS);
                    longitud = (resistencia * area)/resistividad;
                    resultado = longitud + m;
                    result.setText(resultado);
                    ocultarKeyB();
                }
                else if (!r && !rst && !l && a){
                    resistencia = Double.parseDouble(resistenciaS);
                    resistividad = Double.parseDouble(resistividadS);
                    longitud = Double.parseDouble(longitudS);
                    area = (resistividad * longitud)/resistencia;
                    resultado = area + m2;
                    result.setText(resultado);
                    ocultarKeyB();
                }
            });
        }else{
            formulaRT.setVisibility(View.VISIBLE);
            descripRT.setVisibility(View.VISIBLE);
            formulaAL.setVisibility(View.GONE);
            descripAL.setVisibility(View.GONE);
            resistencinitET.setVisibility(View.VISIBLE);
            resistenciafinET.setVisibility(View.VISIBLE);
            resistenciaAET.setVisibility(View.VISIBLE);
            temInitET.setVisibility(View.VISIBLE);
            temFinET.setVisibility(View.VISIBLE);
            resistenciaET.setVisibility(View.GONE);
            resistividadET.setVisibility(View.GONE);
            longitudET.setVisibility(View.GONE);
            areaET.setVisibility(View.GONE);
            calc.setOnClickListener(v -> {
                resistenciaInitS = resistencinitET.getText().toString().trim();
                resistenciaFinS = resistenciafinET.getText().toString().trim();
                resistenciaAlpS = resistenciaAET.getText().toString().trim();
                tempInitS = temInitET.getText().toString().trim();
                tempFinS = temFinET.getText().toString().trim();
                ri = resistenciaInitS.isEmpty();
                rf = resistenciaFinS.isEmpty();
                ra = resistenciaAlpS.isEmpty();
                ti = tempInitS.isEmpty();
                tf = tempFinS.isEmpty();

                if (rf & !ri && !ra && !ti && !tf){
                   resistencinit = Double.parseDouble(resistenciaInitS);
                   resistenciaAlp = Double.parseDouble(resistenciaAlpS);
                   temInit = Double.parseDouble(tempInitS);
                   temFin = Double.parseDouble(tempFinS);
                   resistenciafin = resistencinit * (1+resistenciaAlp*(temFin-temInit));
                   resultado = resistenciafin + ohms;
                   result.setText(resultado);
                   ocultarKeyB();
                }
                else if (!rf && ri && !ra && !ti && !tf){
                    resistenciafin = Double.parseDouble(resistenciaFinS);
                    resistenciaAlp = Double.parseDouble(resistenciaAlpS);
                    temInit = Double.parseDouble(tempInitS);
                    temFin = Double.parseDouble(tempFinS);
                    resistencinit = resistenciafin/(1+(resistenciaAlp * (temFin-temInit)));
                    resultado = resistencinit + ohms;
                    result.setText(resultado);
                    ocultarKeyB();
                }
                else if (!rf && !ri && ra && !ti && !tf){
                    resistencinit = Double.parseDouble(resistenciaInitS);
                    resistenciafin = Double.parseDouble(resistenciaFinS);
                    temInit = Double.parseDouble(tempInitS);
                    temFin = Double.parseDouble(tempFinS);
                    resistenciaAlp = ((resistenciafin/resistencinit) - 1)/(temFin-temInit);
                    resultado = resistenciaAlp + alp;
                    result.setText(resultado);
                    ocultarKeyB();
                }
                else if (!rf && !ri && !ra && ti && !tf){
                    resistencinit = Double.parseDouble(resistenciaInitS);
                    resistenciafin = Double.parseDouble(resistenciaFinS);
                    resistenciaAlp = Double.parseDouble(resistenciaAlpS);
                    temFin = Double.parseDouble(tempFinS);
                    temInit = ((resistenciafin-resistencinit)/(resistenciaAlp*resistencinit))-temFin;
                    temInit = temInit*(-1);
                    resultado = temInit+dg;
                    result.setText(resultado);
                    ocultarKeyB();
                }
                else if (!ri && !rf && !ra && !ti && tf){
                    resistencinit = Double.parseDouble(resistenciaInitS);
                    resistenciafin = Double.parseDouble(resistenciaFinS);
                    resistenciaAlp = Double.parseDouble(resistenciaAlpS);
                    temInit = Double.parseDouble(tempInitS);
                    temFin = ((resistenciafin-resistencinit)/(resistenciaAlp*resistencinit))+temInit;
                    resultado = temFin + dg;
                    result.setText(resultado);
                    ocultarKeyB();
                }
            });
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}

