package com.example.calculadorafisicafinal;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.media.Image;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class LeydeOhm extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Button calc;
    Spinner funciones;
    TextView resultado;
    ImageView img1;
    ImageView img2;
    EditText et1;
    EditText et2;
    EditText et3;
    Double v1;
    Double v2;
    Double v3;
    String val1;
    String val2;
    String val3;
    String result;
    ArrayList<Double> listResist;
    boolean V1;
    boolean V2;
    boolean V3;
    static final String amp = "A";
    static final String volt = "V";
    static final String ohm = "Ω";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leyde_ohm);
        calc = (Button) findViewById(R.id.btnCalc);
        resultado = (TextView) findViewById(R.id.resultTxt);
        funciones = (Spinner) findViewById(R.id.funciones);
        img1 = (ImageView) findViewById(R.id.img1);
        img2 = (ImageView) findViewById(R.id.img2);
        et1 = (EditText) findViewById(R.id.et1);
        et2 = (EditText) findViewById(R.id.et2);
        et3 = (EditText) findViewById(R.id.et3);
        listResist = new ArrayList<>();
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.funcionleydeohm,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        funciones.setAdapter(adapter);
        funciones.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String funcion = parent.getItemAtPosition(position).toString();
        if (funcion.equals("Formula")){
            et1.setHint(R.string.HintIntensidad);
            et2.setHint(R.string.HintPotencia);
            et3.setHint(R.string.HintResistenciaResult);
            img1.setImageResource(R.mipmap.leydeohmf);
            img2.setImageResource(R.mipmap.leydeohmd);
            calc.setOnClickListener(v -> {
                obtenciondatos();
                if (V1 && !V2 && !V3) {
                    v2 = Double.parseDouble(val2);
                    v3 = Double.parseDouble(val3);
                    v1 = v2 / v3;
                    result = v1 + amp;
                    resultado.setText(result);
                }
                else if (!V1 && V2 && !V3){
                    v1 = Double.parseDouble(val1);
                    v3 = Double.parseDouble(val3);
                    v2 = v1 * v3;
                    result = v2 + volt;
                    resultado.setText(result);
                }
                else if (!V1 && !V2 && V3){
                    v1 = Double.parseDouble(val1);
                    v2 = Double.parseDouble(val2);
                    v3 = v2 / v1;
                    result = v3 + ohm;
                    resultado.setText(result);
                }
            });
        }
        else{
            et1.setHint(R.string.HintCircuitosN);
            et2.setHint(R.string.HintCircuitos);
            et2.setInputType(InputType.TYPE_CLASS_TEXT);
            et3.setVisibility(View.GONE);
            img2.setImageResource(R.mipmap.leydeohm3d);
             if(funcion.equals("Circuito en Serie")){
                 img1.setImageResource(R.mipmap.leydeohm2f);
                calc.setOnClickListener(v -> {
                    obtenciondatos();
                    if(!V1 && !V2){
                        v1 = Double.parseDouble(val1);
                        String [] resistn = val2.split(" ");
                        double resistenciaT = 0.0;
                        if (resistn.length> v1 || resistn.length<v1) {
                            Toast.makeText(this, "Ingrese el número correcto de resistencias", Toast.LENGTH_LONG).show();
                            resultado.setText(" ");
                        }
                        else {
                            for (String s : resistn) {
                                try {
                                    double resistencia = Double.parseDouble(s);
                                    resistenciaT+=resistencia;
                                }catch (Exception exception){
                                    Toast.makeText(this,"Ingrese Datos VÁLIDOS",Toast.LENGTH_SHORT).show();
                                }
                            }
                            result = resistenciaT+ohm;
                            resultado.setText(result);
                        }
                    }
                    else {
                        Toast.makeText(this,"Ingrese Datos",Toast.LENGTH_SHORT).show();
                    }
                });
            }
            else if(funcion.equals("Circuito en Paralelo")){
                 img1.setImageResource(R.mipmap.leydeohm3f);
                calc.setOnClickListener(v -> {
                    obtenciondatos();
                    if(!V1 && !V2){
                        v1 = Double.parseDouble(val1);
                        String [] resistn = val2.split(" ");
                        double resistenciaT = 0.0;
                        if (resistn.length> v1 || resistn.length<v1) {
                            Toast.makeText(this, "Ingrese el número correcto de resistencias", Toast.LENGTH_LONG).show();
                            resultado.setText(" ");
                        }
                        else {
                            for (String s : resistn) {
                                try {
                                    double resistencia = Double.parseDouble(s);
                                    resistencia = 1/resistencia;
                                    resistenciaT+=resistencia;
                                }catch (Exception exception){
                                    Toast.makeText(this,"Ingrese Datos VÁLIDOS",Toast.LENGTH_SHORT).show();
                                }
                            }
                            double a = 1/resistenciaT;
                            result = a+ohm;
                            resultado.setText(result);
                        }
                    }
                    else {
                        Toast.makeText(this,"Ingrese Datos",Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }

    }

    private void obtenciondatos() {
        val1 = et1.getText().toString();
        val2 = et2.getText().toString();
        val3 = et3.getText().toString();
        V1 = val1.isEmpty();
        V2 = val2.isEmpty();
        V3 = val3.isEmpty();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }

}