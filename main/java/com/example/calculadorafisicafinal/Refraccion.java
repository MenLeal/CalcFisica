package com.example.calculadorafisicafinal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refraccion);
    }
}