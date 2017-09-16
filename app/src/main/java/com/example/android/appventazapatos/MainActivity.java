package com.example.android.appventazapatos;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Spinner tipoCalzadoFemenino;
    private Spinner tipoCalzadoMasculino;
    private Spinner marcaCalzadoFemenino;
    private Spinner marcacalzadoMasculino;
    private String tipoZ[];
    private EditText cantidad;
    private Resources resources;
    private TextView res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        res = (TextView)findViewById(R.id.txtResultado);
        cantidad =(EditText) findViewById(R.id.txtCantidad);
        tipoCalzadoFemenino = (Spinner)findViewById(R.id.SpnTipCalFemenino);
        resources=this.getResources();
        
    }
}
