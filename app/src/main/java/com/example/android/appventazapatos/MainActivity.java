package com.example.android.appventazapatos;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView res;
    private EditText cantidad;
    private Spinner genero;
    private String genZap[];
    private Spinner tipoZapatos;
    private String tipoZap[];
    private Resources resources;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        res = (TextView) findViewById(R.id.txtResultado);
        cantidad = (EditText) findViewById(R.id.txtCantidad);
        genero = (Spinner) findViewById(R.id.SpnGenero);
        tipoZapatos=(Spinner)findViewById(R.id.SpnTIpoCalzado);
        resources = this.getResources();
        genZap=resources.getStringArray(R.array.Genero);
        tipoZap=resources.getStringArray(R.array.tipoZapato);
        ArrayAdapter<String>adapterG=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,genZap);
        ArrayAdapter<String>adapterT=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,tipoZap);
        genero.setAdapter(adapterG);
        tipoZapatos.setAdapter(adapterT);
    }

    public void calcular(View v){
        int opcion, resultado=0;
        res.setText("");
        opcion = genero.getSelectedItemPosition();

    }
}
