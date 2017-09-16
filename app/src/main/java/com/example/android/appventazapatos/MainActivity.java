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
    private Spinner marcZap;
    private String marcaZap[];
    private Resources resources;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        res = (TextView) findViewById(R.id.txtResultado);
        cantidad = (EditText) findViewById(R.id.txtCantidad);
        genero = (Spinner) findViewById(R.id.SpnGenero);
        tipoZapatos=(Spinner)findViewById(R.id.SpnTIpoCalzado);
        marcZap=(Spinner)findViewById(R.id.SpnMarCalzado);
        resources = this.getResources();
        genZap=resources.getStringArray(R.array.Genero);
        tipoZap=resources.getStringArray(R.array.tipoZapato);
        marcaZap=resources.getStringArray(R.array.marcaZapatos);
        ArrayAdapter<String>adapterG=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,genZap);
        ArrayAdapter<String>adapterT=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,tipoZap);
        ArrayAdapter<String>adapterM=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,marcaZap);
        genero.setAdapter(adapterG);
        tipoZapatos.setAdapter(adapterT);
        marcZap.setAdapter(adapterM);
    }

    public void calcular(View v){
        if(validad()){
            int opcionG,opcionT,opcionM, resultado=0,cant;
            res.setText("");
            opcionG = genero.getSelectedItemPosition();
            opcionT=tipoZapatos.getSelectedItemPosition();
            opcionM=marcZap.getSelectedItemPosition();
            cant=Integer.parseInt(cantidad.getText().toString());
            switch (opcionG){
                case 0://en caso de que sea para hombre
                    switch (opcionT){
                        case 0:
                            switch (opcionM){
                                case 0:
                                      resultado=cant*120000;
                                    break;
                                case 1:
                                    resultado=cant*140000;
                                    break;
                                case 2:
                                    resultado=cant*130000;
                                    break;
                            }
                            break;
                        case 1:
                            switch (opcionM){
                                case 0:
                                    resultado=cant*50000;
                                    break;
                                case 1:
                                    resultado=cant*80000;
                                    break;
                                case 2:
                                    resultado=cant*100000;
                                    break;
                            }
                            break;
                    }
                    break;
                case 1://en caso de que sea para mujer
                    switch (opcionT){
                        case 0:
                            switch (opcionM){
                                case 0:
                                    resultado=cant*100000;
                                    break;
                                case 1:
                                    resultado=cant*130000;
                                    break;
                                case 2:
                                    resultado=cant*110000;
                                    break;
                            }
                            break;
                        case 1:
                            switch (opcionM){
                                case 0:
                                    resultado=cant*80000;
                                    break;
                                case 1:
                                    resultado=cant*70000;
                                    break;
                                case 2:
                                    resultado=cant*120000;
                                    break;
                            }
                            break;
                    }
                    break;
            }
            res.setText(""+resultado);
        }

    }
    public void borrar(View v){
        cantidad.setText("");
        res.setText("");
        genero.setSelection(0);
        tipoZapatos.setSelection(0);
        marcZap.setSelection(0);
        cantidad.requestFocus();
    }
    private boolean validad(){
        if(cantidad.getText().toString().isEmpty()){
            cantidad.setError(resources.getString(R.string.error));
            cantidad.requestFocus();
            return false;
        }
        return true;
    }
}
